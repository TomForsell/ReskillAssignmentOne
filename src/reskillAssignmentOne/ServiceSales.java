package reskillAssignmentOne;

import java.util.*;

import static java.util.Comparator.comparing;


public class ServiceSales {

    Scanner scanner = new Scanner(System.in);
    private final ConsoleIO user;
    private HashMap<String,ArrayList<Order>> regionsWithOrders; //
    private HashMap <Long,Order> allOrders; // to display order info
    private ArrayList<Item> allItems; // to find the most solgt item type
    private HashMap<String, Item> hashMapItems; // to display info about item types.


    public ServiceSales(){
        regionsWithOrders = new HashMap<>();
        allOrders = new HashMap<>();
        allItems = new ArrayList<>();
        user = new ConsoleIO(scanner);
        hashMapItems = new HashMap<>();

    }


    // Setters
    public void addOrder(Order newOrder){
        allOrders.put(newOrder.getOrderId(), newOrder);
    }

    public void addOrderToRegion(String regionName, Order order){
        List<Order> orderList = regionsWithOrders.get(regionName);

        // if list does not exist create it
        if(orderList == null) {
            orderList = new ArrayList<Order>();
            orderList.add(order);
            regionsWithOrders.put(regionName, (ArrayList<Order>) orderList);
        } else {
            // add if item is not already in list
            if(!orderList.contains(order)) orderList.add(order);
        }

    }

    public void addItem(Item itemToAdd){
        allItems.add(itemToAdd);
    }

    public void setItemIntoHashMap(String type, Item item){
        hashMapItems.put (type, item);
    }

    //Getters


    public HashMap<String, Item> getHashMapItems() {
        return hashMapItems;
    }

    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public HashMap<Long, Order> getAllOrders() {
        return allOrders;
    }

    //Help methods
    public boolean isRegionAdded(Region regionToCheck){
        if (regionsWithOrders.containsKey(regionToCheck.getName())){
            return true;
        }
        return false;
    }




    // Functions from menu

    //3.1 See order details
    public void displayOrder(){
        long orderId = user.getLong("Type an order ID: ");
        Order orderFound = findOrder(orderId);
        if(orderFound == null){
            user.logMessage("This order is not found in the system.");
        } else{
            user.logMessage(orderFound.toString());
        }

    }

    public Order findOrder(long orderId){
        if(allOrders.isEmpty()){
            return null;
        } else{
            return allOrders.get(orderId);
        }

    }
    //3.2 Find the most profitable order
    public void displayMostProfitableOrder(){
        Order order = findMaxOrder();
        user.logMessage(order.toString() + " \nProfit for this order: " + order.getProfitForOrder());
    }

    public Order findMaxOrder(){
        Collection<Order> ourValues = allOrders.values();
        return ourValues.stream().max(comparing(Order::getProfitForOrder)).get();
    }

    public void displayTotalRevenueForOrders(){
        user.logMessage(" \nTotal revenue for all orders " + getTotalOrderRevenue());
    }
    public void displayTotalUnitsSold(){
        user.logMessage(" \nTotal units sold:" + getTotalUnitsSold());
    }
    public void displayAverageUnitsSoldPerOrder(){
        user.logMessage(" \nAverage units sold per order:" + getAverageUnitsSoldPerOrder());
    }
    //Printing all the orders in the system
    public void printOrders(){
        Collection<Order> orders = allOrders.values();
        for(Order o: orders){
            user.logMessage(o.toString());
        }


    }

    // 4.1 See all the item types ordered
    public void getItemTypeInfo(){
        for (Item i : hashMapItems.values()) {
            user.logMessage(i.toString());
        }

    }

    //4.2 Most sold item in all regions
    public HashMap<String, Integer> getCountItemTypes(ArrayList<Item> list){
        Map<String, Integer> hm = new HashMap<>();

        for (Item i : list) {
            String t = i.getType();
            Integer j = hm.get(t);
            hm.put(t, (j == null) ? 1 : j + 1);
        }

        return (HashMap<String, Integer>) hm;
    }

    public String mostSoldItemType(HashMap<String,Integer> countMap){
        return countMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
    }

    public void displayMostSoldItemType(){
        String itemToDisplay = mostSoldItemType(getCountItemTypes(allItems));
        user.logMessage("The most sold item type: " + itemToDisplay);

    }
    public String getMostSoldItemToDisplay(){
        return mostSoldItemType(getCountItemTypes(allItems));

    }

    // 4.3 Display sales for Item types
    public void displaySoldItems(){
        HashMap<String,Integer> map = getCountItemTypes(allItems);
            for (Map.Entry<String, Integer> val : map.entrySet()) {
                user.logMessage(val.getKey() + " "
                        + "sold"
                        + ": " + val.getValue() + " times");
            }

    }

    public void displayRegionInfo(){
        Set <String> regions = (Set<String>) regionsWithOrders.keySet();
        for(String s: regions){
            user.logMessage(s);
        }

    }
    public long getTotalOrderRevenue(){
        long totalRevenue=0;
        Order testOrder;
        allOrders = getAllOrders();
        ArrayList<Order> orderCollection = new ArrayList<>(allOrders.values());

        for (int i = 0;i<orderCollection.size();i++){
            testOrder = orderCollection.get(i);
            totalRevenue  = (long) (totalRevenue+testOrder.revenue);

        }
        return totalRevenue;
    }/*
    public double getTotalOrderRevenue(){
        double totalRevenue=0;
        Order testOrder;
        allOrders = getAllOrders();
        ArrayList<Order> orderCollection = new ArrayList<>(allOrders.values());

        for (int i = 0;i<orderCollection.size();i++){
            testOrder = orderCollection.get(i);
            totalRevenue  = totalRevenue+testOrder.revenue;
        }
        return totalRevenue;
    }
    */

    public int getTotalUnitsSold(){
        int totalUnitsSold=0;
        Order testOrder;
        allOrders = getAllOrders();
        ArrayList<Order> orderCollection = new ArrayList<>(allOrders.values());

        for (int i = 0;i<orderCollection.size();i++){
            testOrder = orderCollection.get(i);
            totalUnitsSold  = totalUnitsSold+testOrder.getUnitsSold();
        }
        return totalUnitsSold;
    }
    public double getAverageUnitsSoldPerOrder(){
        double totalAverageSoldPerOrder=0;
        Order testOrder;
        allOrders = getAllOrders();
        ArrayList<Order> orderCollection = new ArrayList<>(allOrders.values());
        totalAverageSoldPerOrder=(getTotalUnitsSold()/allOrders.size());
        return totalAverageSoldPerOrder;
    }

  /*  public int getAverageUnitPrice(){
        double averageUnitsPrice=0;
        double totalUnitsPrice=0;
        Order testOrder;
        allOrders = getAllOrders();
        ArrayList<Order> orderCollection = new ArrayList<>(allOrders.values());

        for (int i = 0;i<orderCollection.size();i++){
            testOrder = orderCollection.get(i);
            totalUnitsPrice  = totalUnitsPrice+testOrder.getO
        }
        return totalUnitsSold;
    }*/

    /*
    public double getTotalUnitsCost(){
        double totalUnitsCost=0;

        Order testOrder;
        allOrders = getAllOrders();
        ArrayList<Order> orderCollection = new ArrayList<>(allOrders.values());

        for (int i = 0;i<orderCollection.size();i++){
            testOrder = orderCollection.get(i);
            totalUnitsCost  = totalUnitsCost+testOrder.getUnitsCost();
        }
        return totalUnitsCost;
    }*/











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

3. Order Statics OK Ferdig
3.1 Order info (tar imot OrederID)
3.2 Most profitable Order

4. Item Type ifo  OK Ferdig
4.1 Item type info (tar imot type og printer ut info)
4.2 Mest solgt item type in all regions and channels (plukke ut en item type som forekommer flest) OK.

5. Print rapport

     */
