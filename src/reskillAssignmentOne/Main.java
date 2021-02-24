package reskillAssignmentOne;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Give me file path: ");
        String filePath = "C:\\Desktop\\salesrecords.csv";; //= scanner.next();

        Menu menu = new Menu(filePath);
        menu.menuStart();
    }

}
