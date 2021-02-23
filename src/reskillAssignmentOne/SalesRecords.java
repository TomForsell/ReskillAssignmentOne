package reskillAssignmentOne;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesRecords {

    private final ConsoleIO user;
    private HashMap<Long,Order> orders;
    private ArrayList<Geography> ordersPerRegion;
    private ArrayList<Channel> ordersPerChannel;

    public SalesRecords(ConsoleIO user){
        this.user = user;
        orders = new HashMap<>();
        ordersPerRegion = new ArrayList<>();
        ordersPerChannel = new ArrayList<>();
    }

   /* her kan vi lage enten en privat metode for å lese fra fil
   eller lage flere metoder som skal lage objekter og legge dem i beholdere: HashMap, ArrayList osv

    */


}
