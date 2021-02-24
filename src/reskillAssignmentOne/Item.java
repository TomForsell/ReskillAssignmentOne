package reskillAssignmentOne;



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

    public String getType() {
        return type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getUnitCost() {
        return unitCost;
    }


    public double getProfitPerItemType(){
        return unitPrice - unitCost;
    }

    public boolean equals(Item other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return type.equals(other.getType());
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitCost=" + unitCost +
                '}';
    }
}
