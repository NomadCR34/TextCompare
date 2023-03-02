package ir.amin.textcompare;

import java.security.NoSuchAlgorithmException;

public interface IComparator {
    CompareResult compare(String textOne,String textTwo) throws Exception;
}
