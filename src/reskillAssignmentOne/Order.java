package reskillAssignmentOne;

import java.time.LocalDate;
import java.util.HashMap;

public class Order {
    private long orderId;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private char orderPriority;
    private HashMap<Item, Integer> itemsOnOrder;

    public Order(long orderId, LocalDate orderDate, LocalDate shipDate, char orderPriority, Item item, int amountOfItems) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderPriority = orderPriority;
        itemsOnOrder = new HashMap<>();
        itemsOnOrder.put(item, amountOfItems);

    }
}
