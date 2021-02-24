package reskillAssignmentOne;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String path = "C:\\Reskill\\salesrecords.txt";
        Menu menu = new Menu(path, scanner);
        menu.menuStart();
    }

}
