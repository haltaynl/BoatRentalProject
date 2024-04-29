package org.capgemini.view;

import java.util.Scanner;

public class AdminMainView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        MAIN_LOOP:
        while (true) {
        System.out.println("========\u26F4 MAIN MENU \u26F4=======");
        System.out.println("__________________________________");
        System.out.println("1. Manage Boats");
        System.out.println("2. Manage Customers");
        System.out.println("3. Manage Reservations");
        System.out.println("4. Manage Users");
        System.out.println("9. Exit");
        System.out.println();
        System.out.print("Please make a choice:");

            switch (scanner.next()) {
                case "1":
                    BoatView.view();
                    break;
                case "2":
                    CustomerView.view();
                    break;
                case "3":
                    ReservationView.view();
                    break;
                case "4":
                    UserView.view();
                    break;
                case "9":
                    break MAIN_LOOP;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
