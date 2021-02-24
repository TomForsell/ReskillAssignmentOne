
package reskillAssignmentOne;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class CSVFileHandling implements FileHandling {
    private  String[] csvValues;
    private List<String[]> orderlist = new ArrayList<>();
    private ServiceSales myServiceSales = new ServiceSales();

    private long orderId;
    private Date orderDate;
    private Date shipDate;
    private char orderPriority;
    private String country;
    private String channel;
    private String itemType;
    private double unitPrice;
    private double unitCost;
    private int unitsSold;
    private String region;
    private double revenue;


    public List readFile(String filePath) throws FileNotFoundException,IOException,ParseException{
        //int counterForSkippingFirstEntry=0;
        boolean firstEntry = true;
        BufferedReader br;
        {
            readBuffer(filePath, firstEntry);
        }
        return orderlist;
    }

    private void readBuffer(String filePath, boolean firstEntry) throws ParseException, IOException {
        String line="";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                csvValues = line.split(",");
                if(!firstEntry) {
                    parseStrings();
                    populateObjects();
                }
                firstEntry =false;
                 orderlist.add(csvValues);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException ioe) {
            throw new IOException();
        }
    }

    public void populateObjects(){
        Item newItem = new Item(itemType,unitPrice,unitCost);
        Order newOrder = new Order(orderId,orderDate,shipDate,orderPriority,newItem,unitsSold,region,country,channel, revenue);
        myServiceSales.addItem(newItem);
        myServiceSales.addOrder(newOrder);
        myServiceSales.setItemIntoHashMap(itemType, newItem);
        myServiceSales.addOrderToRegion(region, newOrder);

    }
    public void parseStrings() throws ParseException{
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
       DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
       region = csvValues[0];
       country = csvValues[1];
       itemType = csvValues[2];
       channel = csvValues[3];
       orderPriority = csvValues[4].charAt(0);
       orderDate = format.parse(csvValues[5]);
       orderId = parseLong(csvValues[6]);
       shipDate = format.parse(csvValues[7]);
       unitsSold = parseInt(csvValues[8]);
       unitPrice = parseDouble(csvValues[9]);
       unitCost = parseDouble(csvValues[10]);
       revenue = parseDouble(csvValues[11]);
  }

    public ServiceSales getMyServiceSales() {
        return myServiceSales;
    }



}


