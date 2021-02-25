package reskillAssignmentOne;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;

import static org.junit.Assert.*;

    public class OrderStatisticsTest {

        private ServiceSales testServiceSales;
        private CSVFileHandling testCSVFilehandling;
        @Before
        public void setUp() throws Exception {
            testServiceSales = new ServiceSales();
            testCSVFilehandling = new CSVFileHandling();
            testCSVFilehandling.readFile("/Users/svetlanahaugland/Desktop/SalesRecords.csv");//"C:\\Reskill\\salesrecords.txt");
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
        public void getAveragelUnitPrice() {

            //assertEquals(262.10,testServiceSales.getAverageUnitPrice(),0.10);
        }
        @Test
        public void getTotalUnitsCost(){
            //  assertEquals(184965.11,testServiceSales.getTotalUnitsCost(),0.02);
        }
        @Test
        public void getAverageCostPerOrder(){
            //184,96
        }
        @Test
        public void getTotalProfit(){
            //391202611,56
        }
        @Test
        public void getAverageProfitPerOrder(){
            //391202611,56
        }

        @Test
        public void seeOrderDetails(){
            HashMap<Long,Order> testAllOrders = testServiceSales.getAllOrders();



        }


       @Test
        public void findOrder_orderFound() throws ParseException {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
           DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
           HashMap<Long, Order> testAllOrders = testServiceSales.getAllOrders();
           assertEquals(403961122, testServiceSales.findOrder(403961122).getOrderId());


       }


        @Test
        public void getMostProfitableOrder() throws FileNotFoundException, IOException, ParseException {
            HashMap<Long, Order> testAllOrders = testServiceSales.getAllOrders();
            assertEquals(403961122, testServiceSales.findMaxOrder().getOrderId(), 0.002);
        }
    }
