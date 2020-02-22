package sample;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmClassTest {

    @Test
    void ComparisonCheckTest(){
        AlgorithmClass test = new AlgorithmClass();
        String[] s = new String[5];
        String[] x = new String[5];

        s[0] = "hello";
        s[1] = "world";
        s[2] = "this";
        s[3] = "is";
        s[4] = "sparta";

        x[0] = "HELLO";
        x[1] = "WORLD";
        x[2] = "THIS";
        x[3] = "SPARTA";

        double y = test.comparison(s,x,5,4);

        assertTrue(y==80);

        double z = test.comparison(x,s,4,5);

        assertTrue(z==100);
    }

    @Test
    void FromMultipleFoldersToSpecificFilesOnlyTest(){
        AlgorithmClass test = new AlgorithmClass();
        int counter = 0, q = 0;
        File[] File = new File[1000];
        File file = new File("C:\\Users\\jmvon\\Desktop\\SoftwareSimilarityDraft\\LBYCP2D");
        test.FileOrFolder(file,counter,File);
        assertTrue(File[q].getName().equalsIgnoreCase("AlgorithmClass.java"));
    }

    @Test
    void FullFunctionalityTest(){
        ArrayList<File> FileNames = new ArrayList<>();
        File file = new File("C:\\Users\\jmvon\\Desktop\\SoftwareSimilarityDraft\\LBYCP2D");
        File file2 = new File("C:\\Users\\jmvon\\Desktop\\SoftwareSimilarityDraft\\NewSubmissions\\co");
        FileNames.add(file);
        FileNames.add(file2);

        AlgorithmClass test = new AlgorithmClass();


        DecimalFormat df = new DecimalFormat("0");

        String x = df.format(test.takeStrings(FileNames,0,1));

        assertTrue(x.equalsIgnoreCase("35"));
    }
}