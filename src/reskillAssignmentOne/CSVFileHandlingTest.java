package reskillAssignmentOne;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandlingTest {

    private String filePath;
    private String emptyFile;
    private String oneLineCorrectFormat;
    private CSVFileHandling testCSVReader;
    private List<String[]> testOrderList;
    private final String[] line713 = {"Sub-Saharan Africa","Niger","Clothes","Offline","M","1/10/2012","201730287","2/19/2012","5330","109.28","35.84","582462.40","191027.20","391435.20"};;

/*•
•	Try to open a file with 1 record – should report 1 record found
•	Try to open a file with 1 record with correct format – should be able to parse line correctly and return correctly structured object
•	Try to open a file with 1 record with incorrect format (several possibilities here) – should report error
•	Try to open a file with several records, all correct format – should be able to parse lines correctly and return collection of correctly structured objects
•	Try to open a file with several records, some valid, some invalid – you should decide for yourself what you expect to happen here (e.g. total failure, or partial success)

*/
    @Before
    public void setUp() throws Exception {
         filePath= "C:\\Reskill\\salesrecords.txt";
        emptyFile = "C:\\Reskill\\emptyFile.txt";
        oneLineCorrectFormat = "C:\\Reskill\\oneLineCorrectFormat.txt";

         testCSVReader = new CSVFileHandling();
         testOrderList = new ArrayList<>();
    }
    @Test
    public void testEmptyFile() throws FileNotFoundException, IOException
    {
        testOrderList=testCSVReader.readCSVFile(emptyFile);
        assertEquals(0,testOrderList.size());
    }

    @Test
    public void testReportOneRecord()throws FileNotFoundException, IOException
    {
        testOrderList=testCSVReader.readCSVFile(oneLineCorrectFormat);
        assertEquals(1,testOrderList.size());
    }

    @Test
    public void testOneLineCorrectFormat()throws FileNotFoundException, IOException
    {
        testOrderList=testCSVReader.readCSVFile(oneLineCorrectFormat);
        String[] actualStringArray = testOrderList.get(0);
        int n =1;
        for(int i=0;i<actualStringArray.length;i++) {
            assertEquals(actualStringArray[i], "test"+n);
            n++;
        }
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