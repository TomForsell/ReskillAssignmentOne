package reskillAssignmentOne;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        Menu menu = new Menu(filePath, scanner);
        menu.menuStart();
    }

}
