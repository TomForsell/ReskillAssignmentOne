package reskillAssignmentOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private long orderId;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private char orderPriority;
    private String country;
    private String channel; // vurdere å gjøre det som enum
    private HashMap<Item, Integer> itemsOnOrder;
    private ArrayList<Item> itemsonOrder;

    public Order(long orderId, LocalDate orderDate, LocalDate shipDate, char orderPriority, String itemType, int amountOfItems, String region, String country) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderPriority = orderPriority;
        this.region = region;
        this.country = country;
        itemsOnOrder = new HashMap<>();
        itemsOnOrder.put(itemType, amountOfItems);

    }

    public double getRevenuePerOrder(){


    }
}
