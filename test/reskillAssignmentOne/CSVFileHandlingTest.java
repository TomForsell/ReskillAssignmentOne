package reskillAssignmentOne;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandlingTest {

    private String filePathCorrectFile;
    private String filePathEmptyFile;
    private  String filePathIncorrectFormat;
    private String filePathOneLineCorrectFormat;
    private CSVFileHandling testCSVReader;
    private List<String[]> testOrderList;
    private final String[] line713 = {"Sub-Saharan Africa","Niger","Clothes","Offline","M","1/10/2012","201730287","2/19/2012","5330","109.28","35.84","582462.40","191027.20","391435.20"};;

    private ServiceSales testServiceSales = new ServiceSales();
    @Before
    public void setUp() throws Exception {
         filePathCorrectFile= "C:\\Reskill\\salesrecords.txt";
        filePathEmptyFile = "C:\\Reskill\\emptyFile.txt";
        filePathOneLineCorrectFormat = "C:\\Reskill\\oneLineCorrectFormat.txt";
        filePathIncorrectFormat = "C:\\Reskill\\inCorrectFormat.txt";

         testCSVReader = new CSVFileHandling();
         testOrderList = new ArrayList<>();
    }
    @Test
    public void CSVFilehandlingTestEmptyFile() throws FileNotFoundException, IOException, ParseException
    {
        testOrderList=testCSVReader.readFile(filePathEmptyFile);
        assertEquals(0,testOrderList.size());
    }

    @Test
    public void CSVFilehandlingTestReportOneRecord()throws FileNotFoundException, IOException,ParseException
    {
        testOrderList=testCSVReader.readFile(filePathOneLineCorrectFormat);
        assertEquals(1,testOrderList.size());
    }

    @Test
    public void CSVFilehandlingTestOneLineCorrectFormat()throws FileNotFoundException, IOException,ParseException {
        testOrderList=testCSVReader.readFile(filePathOneLineCorrectFormat);
        String[] actualStringArray = testOrderList.get(0);
        int n =1;
        for(int i=0;i<actualStringArray.length;i++) {
            assertEquals(actualStringArray[i], "test"+n);
            n++;
        }
    }

    @Test
    @Ignore
    public void CSVFilehandlingTestIncorrectFormat() throws FileNotFoundException, IOException,ParseException{
        testOrderList = testCSVReader.readFile(filePathIncorrectFormat);
        assertEquals(0,testOrderList.size());
    }
    @Test
    public void CSVFilehandlingTestNumberofLinesInCSV() throws FileNotFoundException, IOException,ParseException {
        testOrderList=testCSVReader.readFile(filePathCorrectFile);
        assertEquals(testOrderList.size(),1001);
    }

    @Test(expected = FileNotFoundException.class)
    public void CSVFilehandlingReadCSVFileWithWrongFilename() throws FileNotFoundException, IOException,ParseException{
        testCSVReader.readFile("c:\\wrong");
    }
    @Test
    public void CSVFilehandlingTestOneStringArrayInFile() throws FileNotFoundException, IOException,ParseException{
        testOrderList=testCSVReader.readFile(filePathCorrectFile);
        String[] actualStringArray = testOrderList.get(713);
        for (int i =0; i< actualStringArray.length;i++) {
            assertEquals(line713[i], actualStringArray[i]);
        }
    }

    @Test
    public void CSVFileHandlingTestReadFile()  throws FileNotFoundException, IOException,ParseException{
        testCSVReader.readFile(filePathCorrectFile);
        testServiceSales.getRegionsWithOrders();

    }
}