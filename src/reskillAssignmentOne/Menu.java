package reskillAssignmentOne;

import java.util.Scanner;

public class Menu {

    public void menuStart() {
        Scanner scanner = new Scanner(System.in);
        ConsoleIO user = new ConsoleIO(scanner);

        //ServiceSales flightSchedule= new ServiceSales(user);
        int userChoice;
        System.out.println("\n WELCOME\n -------------------------");

        do {
            userChoice = user.getInt("\n What do you want to do? \n 1: xxx\n 2: xxx\n 3: xxx \n " +
                    "4: xxx\n 5: xxx \n 6: Exit \n");
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
}
