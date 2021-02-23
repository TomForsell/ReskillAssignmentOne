package reskillAssignmentOne;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ServiceSales {

    private final ConsoleIO user;
    private ArrayList<Region> regionsWithOrders;


    public ServiceSales(ConsoleIO user){
        this.user = user;
        regionsWithOrders = new ArrayList<>();

    }

    public void addRegion(Region region){
        regionsWithOrders.add(region);
    }

   /* her kan vi lage enten en privat metode for å lese fra fil
   eller lage flere metoder som skal lage objekter og legge dem i beholdere: HashMap, ArrayList osv

    */

    /*
    Functions: vi må ha funksjosjer som returnerer resultat som vi skal sende til consoleIO eller
    til Logger for å bygge fil.
1. Statics per Region
1.1 Revenue (velge en region)
1.2 Cost
1.3 Profit
1.4 Mest solgt items
1.5 Mest brukt kanal

2. Statistics per Country
1.1 Revenue
1.2 Cost
1.3 Profit
1.4 Mest solgt items
1.5 Mest brukt kanal

3. Order Statics
3.1 Order infor (tar imot OrederID)

4. Item Type ifo
4.1 Item type info (tar imot type og printer ut info)
4.2 Mest solgt item type in all regions and channels (plukke ut en item type som forekommer flest)

5. Print rapport









     */

    public double getRevenueperRegion(String navn){
        double reveunue;
        for(Region region: regionsWithOrders){
            if navn.equals(region.getName()){
                reveunue = region.getRevenue;
            }
        }




    }




}
