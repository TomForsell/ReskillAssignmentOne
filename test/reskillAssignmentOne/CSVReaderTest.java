package reskillAssignmentOne;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidObjectException;

public class CSVReaderTest {

    private String filePath= "C:\\Reskill\\salesrecords.txt";
    private CSVReader testCSVReader;


    @Before
    public void setUp() throws Exception {
         String filePath= "C:\\Reskill\\salesrecords.txt";
         testCSVReader = new CSVReader();

    }

    @Test
    public void readCSVFile() throws FileNotFoundException, IOException {
        String[] testArryay;
        testArryay = testCSVReader.readCSVFile(filePath);
        System.out.println(testArryay);
    }

    @Test(expected = FileNotFoundException.class)
    public void readCSVFileWithWrongFilename() throws FileNotFoundException, IOException{
        testCSVReader.readCSVFile("C:\\Reskill\\salesrddddecords.txt");
    }


}