package ir.amin.textcompare;

import lombok.Data;

import java.util.List;

@Data
public class CompareResult {
    private List<ComparedText> comparedTexts;
}
