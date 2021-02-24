package reskillAssignmentOne;


import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Comparator.comparing;


@Getter

public class ServiceSales {

    Scanner scanner = new Scanner(System.in);
    private final ConsoleIO user;
    private HashMap<String,Region> regionsWithOrders; // vurdere å lage Hashmap
    private HashMap <Long,Order> allOrders;
    private ArrayList<Item> allItems; //
    private HashSet<Item> setOfItems;


    public ServiceSales(){
        regionsWithOrders = new HashMap<>();
        allOrders = new HashMap<>();
        allItems = new ArrayList<>();
        user = new ConsoleIO(scanner);

    }



    public void setItemHashSet(HashSet<Item> set){
        setOfItems = set;
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

    public void addItemToSet(Item itemToAdd){
        setOfItems.add(itemToAdd);
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

    public <T> T mostCommon(List<T> list) {
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

    public void printItems(){
        HashSet <Item> newSet = fromListToSet(allItems);
        for(Item i: newSet){
            user.logMessage(i.toString());
        }

    }

    public void printOrders(){
        Collection<Order> orders = allOrders.values();
        for(Order o: orders){
            user.logMessage(o.toString());
        }

    }
    public void printRegions(){
        Collection<Region> regions = regionsWithOrders.values();
        if(regions.isEmpty()){
            user.logMessage("Empty");
        } else{
            user.logMessage("Have smth but cannot show");
            for(Region r: regions){
                user.logMessage(r.toString());
            }
        }


    }


    public HashSet<Item> fromListToSet(ArrayList<Item> oldList){
        Set <Item> setOfItems = new HashSet<>(oldList);
        return (HashSet<Item>) setOfItems;
    }

    public void displayMostProfitableOrder(){
        Order order = findMaxOrder();
        user.logMessage(order.toString() + " \nProfit for this order: " + order.getProfitForOrder());
    }


    public Order findMaxOrder(){
        Collection<Order> ourValues = allOrders.values();
        return ourValues.stream().max(comparing(Order::getProfitForOrder)).get();


    }

    private HashSet<Item> getSetOfItems(){
        HashSet<Item> items = new HashSet<>();
        Collection <Order> orders = allOrders.values();
        for (Order o: orders){
            items.add(o.getItemType());
        }
        return items;
    }

    public void getItemTypeInfo(){
        for(Item i: setOfItems){
            user.logMessage(i.toString());
        }
    }

    public void getItemIntoSet(Item item){
        setOfItems.add(item);
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
3.1 Order info (tar imot OrederID)
3.2 Most profitable Order

4. Item Type ifo
4.1 Item type info (tar imot type og printer ut info)
4.2 Mest solgt item type in all regions and channels (plukke ut en item type som forekommer flest) OK.

5. Print rapport

     */
