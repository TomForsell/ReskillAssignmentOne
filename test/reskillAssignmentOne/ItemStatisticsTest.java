package reskillAssignmentOne;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ItemStatisticsTest {

        private ServiceSales testServiceSales;
        private CSVFileIO testCSVFilehandling;
        @Before
        public void setUp() throws Exception {
            testServiceSales = new ServiceSales();
            testCSVFilehandling = new CSVFileIO();
            //testCSVFilehandling.readFile( "C:\\Reskill\\salesrecords.txt");
            testCSVFilehandling.readFile("/Users/svetlanahaugland/Desktop/SalesRecords.csv");
            testServiceSales = testCSVFilehandling.getMyServiceSales();
        }
        @Test
        public void getAmountOfUniqueItems() throws FileNotFoundException, IOException, ParseException {
            HashMap<String, Item> uniqueItems = testServiceSales.getHashMapItems();
            assertEquals(12, uniqueItems.size());
        }


    }

