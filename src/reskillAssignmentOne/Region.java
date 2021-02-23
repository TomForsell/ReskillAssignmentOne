package reskillAssignmentOne;

import java.util.ArrayList;

public class Region {
    String name;
    ArrayList<Order> ordersPerRegion;

    public Region(String navn){
        this.name = navn;
        ordersPerRegion = new ArrayList<>();
    }

    public void addOrder(Order order){
        ordersPerRegion.add(order);
    }

    public String getName() {
        return name;
    }

    public double getRevenue(){
        double revenuePerOrder = 0;
        for(Order order: ordersPerRegion){
            revenuePerOrder += order.getRevenuePerOrder();
        }
        return revenuePerOrder;
    }
}
