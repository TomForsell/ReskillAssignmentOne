package reskillAssignmentOne;



/*
Tenkte på ditt forslag om å lage flere klasser
Denne kan være nyttig hvis vil ha informasjon om f.eks. total antall av soldte produkter per region eller noe sånt
 */


import java.util.ArrayList;

public class Geography {
    private String region;
    private String country;
    private ArrayList<Order> ordersPerGeography = new ArrayList<>();

    public Geography(String region, String country, Order order) {
        this.region = region;
        this.country = country;
        ;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }
}
