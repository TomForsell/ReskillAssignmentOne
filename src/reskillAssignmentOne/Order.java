package reskillAssignmentOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Order {
    private long orderId;
    private Date orderDate;
    private Date shipDate;
    private char orderPriority;
    private String country;
    private String channel; // vurdere å gjøre det som enum
    private HashMap<Item, Integer> itemsOnOrder; //((HashMap (Item, Unitssolgt)))
    private ArrayList<Item> itemsonOrder;

    double revenue;

    public Order(Long orderId, double revenue){
        this.orderId = orderId;
        this.revenue=revenue;
    }
    public Order(long orderId, Date orderDate, Date shipDate, char orderPriority, Item itemType, int unitsSold, String region, String country, String channel) {
        this.orderId = orderId; //
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderPriority = orderPriority;
        this.country = country;
        itemsOnOrder = new HashMap<>();
        itemsOnOrder.put(itemType,unitsSold);
        this.channel = channel;

    }

    public double getRevenuePerOrder(){
        return revenue;


    }
}
