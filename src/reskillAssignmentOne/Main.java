package reskillAssignmentOne;

import java.util.Scanner;
public class Main {

// We use hard coded paths while we are working
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me file path: ");
        String filePath =scanner.next();
        //String filePath ="/Users/svetlanahaugland/Desktop/SalesRecords.csv" ;
        //String filePath ="C:\\Reskill\\salesrecords.txt" ;//scanner.next();

        Menu menu = new Menu(filePath);
        menu.menuStart();


    }

}
