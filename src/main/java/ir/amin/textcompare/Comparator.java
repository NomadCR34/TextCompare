package ir.amin.textcompare;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comparator implements IComparator{

    private final Hash hash;

    public Comparator(Hash hash) {
        this.hash = hash;
    }

    @Override
    public CompareResult compare(String textOne, String textTwo)  {
        CompareResult compareResult = new CompareResult();
        try {
            List<ComparedText> comparedTexts = isTextSame(textOne,textTwo);
            for(ComparedText comparedText:comparedTexts){
                compareText(comparedText);
            }
            compareResult.setComparedTexts(comparedTexts);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return compareResult;
    }

    private List<ComparedText> isTextSame(String textOne, String textTwo) throws NoSuchAlgorithmException {
        List<ComparedText> comparedTexts = new ArrayList<>();
        Map<String,Integer> secondTextMap = getHashText(textTwo);
        String [] mainTextLines = getTextLines(textOne);
        for(int i=0;i< mainTextLines.length;i++){
            ComparedText comparedText = new ComparedText();
            comparedText.setMainLineNumber(i);
            comparedText.setMainLine(mainTextLines[i]);
            Integer lineNumber = secondTextMap.get(hash.hash(mainTextLines[i]));
            if(lineNumber == null){
                lineNumber = i;
            }
            comparedText.setSameLineNumber(lineNumber);
            comparedText.setSameLine(getTextLines(textTwo)[lineNumber]);
            comparedTexts.add(comparedText);
        }
        return comparedTexts;
    }

    private void compareText(ComparedText comparedText){
        int startIndex = 0;
        int endIndex = 0;
        while(endIndex < comparedText.getMainLine().length()){
            if(comparedText
                    .getMainLine()
                    .substring(startIndex,endIndex)
                    .equals(
                            comparedText
                                    .getSameLine()
                                    .substring(startIndex,endIndex)
                    )
            ){
                endIndex++;
            }else{
                endIndex++;
                startIndex++;
            }
        }
    }

    private Map<String,Integer> getHashText(String text) throws NoSuchAlgorithmException {
        Map<String,Integer> hashLines = new HashMap<>();
        String[] lines = getTextLines(text);
        for(int i = 0;i<lines.length;i++){
            hashLines.put(hash.hash(lines[i]),i);
        }
        return hashLines;
    }

    private String[] getTextLines(String text) {
        return text.split(System.getProperty("\n"));
    }

}
