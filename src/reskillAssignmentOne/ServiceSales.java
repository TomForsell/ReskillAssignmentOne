package reskillAssignmentOne;


import lombok.Getter;
import lombok.ToString;

import java.util.*;


@Getter
@ToString
public class ServiceSales {

    Scanner scanner = new Scanner(System.in);
    private final ConsoleIO user;
    private HashMap<String,Region> regionsWithOrders; // vurdere å lage Hashmap
    private HashMap <Long,Order> allOrders;
    private ArrayList<Item> allItems; // vurdere å ha HashSet


    public ServiceSales(){
        regionsWithOrders = new HashMap<>();
        allOrders = new HashMap<>();
        allItems = new ArrayList<>();
       user = new ConsoleIO(scanner);

    }

    public boolean addRegion(Region region){
        if(regionsWithOrders.containsKey(region.getName())){
            regionsWithOrders.put(region.getName(),region);
            return false;

        }
        return true;
    }
    public void addOrder(Order newOrder){
        // sjekk om orderId er allerede lagret
        allOrders.put(newOrder.getOrderId(), newOrder);
    }

    public void addOrderToRegion(Order newOrder, Region region){
        Region regionToChange = regionsWithOrders.get(region.getName());
        regionToChange.addOrder(newOrder);

    }

    public void addItem(Item itemToAdd){
        allItems.add(itemToAdd);
    }

    public Collection<Region> getRegionsWithOrders() {
        Collection<Region> regions = regionsWithOrders.values();
        return regions;
    }



    public boolean isRegionAdded(Region regionToCheck){
        if (regionsWithOrders.containsKey(regionToCheck.getName())){
            return true;
        }
        return false;
    }

    public void createReport(){

    }

    public void totalRevenuePerRegion() {
        double regionRevenue = 0;
        user.logMessage("Chose a region");
        user.logMessage(getRegionsWithOrders().toString());
        String regionToShow = user.getString("Type in region name: ");
        Region regionWithOrders = regionsWithOrders.get(regionToShow);
        if (regionWithOrders == null){
            user.logMessage("Region not found in the system");
        } else {
            regionRevenue = regionWithOrders.getRevenue();
        } 
        user.logMessage("The total revenue for " + regionWithOrders.getName() + " is " + regionRevenue);
    }

    public void mostSoldItem(){
        Item item = mostCommon(allItems);
        user.logMessage(item.toString());
    }

    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }

}
/*
    Functions: vi må ha funksjosjer som returnerer resultat som vi skal sende til consoleIO eller
    til Logger for å bygge fil.
1. Statics per Region
1.1 Revenue (velge en region)
1.2 Cost
1.3 Profit
1.4 Most sold items
1.5 Most used channel

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
