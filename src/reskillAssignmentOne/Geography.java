package reskillAssignmentOne;
/*
Tenkte på ditt forslag om å lage flere klasser
Denne kan være nyttig hvis vil ha informasjon om f.eks. total antall av soldte produkter per region eller noe sånt
 */

public class Geography {
    private String region;
    private String country;
    private Order order;

    public Geography(String region, String country, Order order) {
        this.region = region;
        this.country = country;
        this.order = order;
    }
}
