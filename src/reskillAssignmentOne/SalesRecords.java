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

    /*
    Functions: vi må ha funksjosjer som returnerer resultat som vi skal sende til consoleIO eller
    til Logger for å bygge fil.

    1.
    2.
    3.
    5.
    6.
    7.
    8.
    9.
    10.
    11.
    12.
    13.
    14.
    15.
    16.
    17.
    18.
    19.
    20. PRINT REPORT (skal lage en fil som viser resultat av alle metodene fra menu.

     */

// read csv file - get list
    //populate Objects



}
