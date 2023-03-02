package ir.amin.textcompare;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class CompareService {

    private final IComparator comparator;

    @Autowired
    public CompareService(IComparator comparator) {
        this.comparator = comparator;
    }

    public CompareResult compare(TextToCompare textsToCompare){
        return comparator.compare(textsToCompare.getTextOne(),textsToCompare.getTextTwo());
    }

}
