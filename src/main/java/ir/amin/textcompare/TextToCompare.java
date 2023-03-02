package ir.amin.textcompare;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextToCompare {

    private String textOne;
    private String textTwo;

}
