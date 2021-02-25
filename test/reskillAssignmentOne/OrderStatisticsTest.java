package reskillAssignmentOne;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class OrderStatisticsTest {

        private ServiceSales testServiceSales;
        private CSVFileIO testCSVFilehandling;
        @Before
        public void setUp() throws Exception {
            testServiceSales = new ServiceSales();
            testCSVFilehandling = new CSVFileIO();
            testCSVFilehandling.readFile( "C:\\Reskill\\salesrecords.txt");
            //testCSVFilehandling.readFile("/Users/svetlanahaugland/Desktop/SalesRecords.csv");
            testServiceSales = testCSVFilehandling.getMyServiceSales();
        }
        @Test
        public void getTotalOrderRevenue() throws FileNotFoundException, IOException, ParseException {
            HashMap<Long, Order> testAllOrders = testServiceSales.getAllOrders();
            assertEquals(1327321840.33, testServiceSales.getTotalOrderRevenue(), 0.002);
        }

        @Test
        public void getTotalUnitsSold() throws FileNotFoundException, IOException, ParseException{
            HashMap<Long,Order> testAllOrders = testServiceSales.getAllOrders();
            assertEquals(5053988,testServiceSales.getTotalUnitsSold());
        }
        @Test
        public void getAveragelUnitsSoldPerOrder() {
            HashMap<Long,Order> testAllOrders = testServiceSales.getAllOrders();
            assertEquals(5053.00,testServiceSales.getAverageUnitsSoldPerOrder(),0.02);

        }
        @Test
        @Ignore
        public void getAveragelUnitPrice() {

            //assertEquals(262.10,testServiceSales.getAverageUnitPrice(),0.10);
        }
        @Test
        @Ignore
        public void getTotalUnitsCost(){
            //  assertEquals(184965.11,testServiceSales.getTotalUnitsCost(),0.02);
        }
        @Test
        @Ignore
        public void getAverageCostPerOrder(){
            //184,96
        }
        @Test
        @Ignore
        public void getTotalProfit(){
            //391202611,56
        }
        @Test
        @Ignore
        public void getAverageProfitPerOrder(){
            //391202611,56
        }

        @Test
        public void fidOrder_OrderFound(){
            HashMap<Long, Order> testAllOrders = testServiceSales.getAllOrders();
            assertEquals(686800706, testServiceSales.findOrder(686800706).getOrderId());
        }

        @Test
        public void findMaxOrder_OrderFound() {
             HashMap<Long, Order> testAllOrders = testServiceSales.getAllOrders();
             assertEquals(403961122, testServiceSales.findMaxOrder().getOrderId());
        }




    }

