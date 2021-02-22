package reskillAssignmentOne;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandlingTest {

    private String filePath= "C:\\Reskill\\salesrecords.txt";
    private CSVFileHandling testCSVReader;
    private List<String[]> testOrderList;
    private String[] line713 = {"Sub-Saharan Africa","Niger","Clothes","Offline","M","1/10/2012","201730287","2/19/2012","5330","109.28","35.84","582462.40","191027.20","391435.20"};;


    @Before
    public void setUp() throws Exception {
         String filePath= "C:\\Reskill\\salesrecords.txt";
         testCSVReader = new CSVFileHandling();
         testOrderList = new ArrayList<>();
    }
    @Test
    public void testNumberofLinesInCSV() throws FileNotFoundException, IOException {
        testOrderList=testCSVReader.readCSVFile(filePath);
        assertEquals(testOrderList.size(),1001);
    }

    @Test(expected = FileNotFoundException.class)
    public void readCSVFileWithWrongFilename() throws FileNotFoundException, IOException{
        testCSVReader.readCSVFile("c:\\wrong");
    }
    @Test
    public void testOneStringArrayInFile() throws FileNotFoundException, IOException{
        testOrderList=testCSVReader.readCSVFile(filePath);
        String[] actualStringArray = testOrderList.get(713);
        assertEquals(line713[5],actualStringArray[5]);
    }


}