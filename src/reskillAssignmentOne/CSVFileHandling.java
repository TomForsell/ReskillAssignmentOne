
package reskillAssignmentOne;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class CSVFileHandling {
    private String filePath= "C:\\Reskill\\salesrecords.txt";
    private  String line="";
    private  String[] csvValues;
    private List<String[]> orderlist = new ArrayList<>();
    private ServiceSales myServiceSales = new ServiceSales();
    private Region newRegion;
    private Order myOrder;

    private long orderId;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private char orderPriority;
    private String country;
    private String channel;
    private String itemType;
    private double unitPrice;
    private double unitCost;
    private int unitsSold;
    private String region;





   // private Item newItem;

    public List readCSVFile (String filePath) throws FileNotFoundException,IOException{
        //int counterForSkippingFirstEntry=0;
        boolean firstEntry = true;
        BufferedReader br;
        {
            try {
                br = new BufferedReader(new FileReader(filePath));
                while ((line = br.readLine()) != null) {
                    csvValues = line.split(",");
                    if(!firstEntry) {
                        parseStrings();
                        populateObjects();
                    }
                    firstEntry=false;
                    //string region = csvValues[0].toString()
                   // System.out.println(csvValues[0].toString();
                    orderlist.add(csvValues);
                    //System.out.println(Arrays.toString(csvValues));
                }
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            } catch (IOException ioe) {
                throw new IOException();
            }
        }
        return orderlist;
    }
    public void populateObjects(){
        Item newItem = new Item(itemType,unitPrice,unitCost);
        Order newOrder = new Order(orderId,orderDate,shipDate,orderPriority,newItem,unitsSold,region,country,channel);

    }
    public void parseStrings(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        region = csvValues[0];
        country = csvValues[1];
        itemType = csvValues[2];
        channel = csvValues[3];
        orderPriority = csvValues[4].charAt(0);
        orderDate = LocalDate.parse(csvValues[5],formatter);
        orderId= parseLong(csvValues[6]);
        shipDate = LocalDate.parse(csvValues[7],formatter);
        unitsSold = parseInt(csvValues[8]);
        unitPrice = parseDouble(csvValues[9]);
        unitCost = parseDouble(csvValues[10]);
    }


}


