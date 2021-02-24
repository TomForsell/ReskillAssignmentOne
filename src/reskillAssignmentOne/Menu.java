package reskillAssignmentOne;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    CSVFileHandling newFile;
    String filePath;
    Scanner scanner = new Scanner(System.in);
    ConsoleIO user = new ConsoleIO(scanner);

    ServiceSales service;

    public Menu(String path) {
        newFile = new CSVFileHandling();
        this.filePath = path;
        //this.scanner = scanner;
        try{
            newFile.readFile(filePath);
        } catch (FileNotFoundException e){
            user.logMessage("File not found!");
            return;
        } catch (IOException e){
            user.logMessage("Something went wrong!");
            return;
        } catch (ParseException e){
            user.logMessage("Parsing error.");
            return;
        }
        service = newFile.getMyServiceSales();

    }



    public void menuStart() {

        int userChoice;
        System.out.println("\n WELCOME\n -------------------------");

        do {
            userChoice = user.getInt("\n What do you want to do? \n 1: Statics per Region \n 2: Statistics per Country\n 3: Order info \n " +
                    "4: Item Type info\n 5: Create a report \n 6: Exit \n");
            switch (userChoice) {

                case 1:
                    submenuRegion();
                    break;

                case 2:
                    submenuCountry();
                    break;

                case 3:
                    submenuOrder();

                    break;

                case 4:
                    submenuItem();

                    break;

                case 5:
                    service.printItems();


                    break;
            }
        }
        while (userChoice != 6);
    }

    private void submenuRegion(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: Total revenue for a region \n 2: Total cost for a region\n 3: Total profit for a region \n " +
                    "4: Most sold items in a region \n 5: Most used sale channel in a region \n 6: Exit \n");
            switch (userChoice) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:


                    break;

                case 4:


                    break;

                case 5:


                    break;
            }
        }
        while (userChoice != 6);
    }

    private void submenuCountry(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: Total revenue for a country \n 2: Total cost for a country\n 3: Total profit for a country \n " +
                    "4: Most sold items in a country \n 5: Most used sale channel in a country \n 6: Exit \n");
            switch (userChoice) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:


                    break;

                case 4:


                    break;

                case 5:


                    break;
            }
        }
        while (userChoice != 6);

    }

    private void submenuOrder(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: See order details \n 2: Find the most profitable order \n 3: Exit \n");
            switch (userChoice) {

                case 1:
                    service.displayOrder();

                    break;

                case 2:

                    service.displayMostProfitableOrder();
                    break;

            }
        }
        while (userChoice != 3);
    }

    private void submenuItem(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: Item type info \n 2: Most sold item in all regions \n 3: Exit \n");
            switch (userChoice) {

                case 1:

                    break;

                case 2:
                    service.mostSoldItem();

                    break;
            }
        }
        while (userChoice != 3);
    }

}


