package reskillAssignmentOne;

//import lombok.Getter;

//@Getter
public class Item {
    private String type; // nummer 2
    private double unitPrice; // nummer 9
    private double unitCost; // nummer 10
    private int id;
    private static int nextId = 0;

    public Item(String type, double unitPrice, double unitCost){
        id = nextId++;
        this.type = type;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
    }
}
