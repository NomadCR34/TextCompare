package ir.amin.textcompare;

import lombok.Data;

@Data
public class ComparedText {
    private int mainLineNumber;
    private int sameLineNumber;
    private String mainLine;
    private String sameLine;
}
