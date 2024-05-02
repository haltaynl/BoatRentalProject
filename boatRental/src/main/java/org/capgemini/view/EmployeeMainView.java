package org.capgemini.view;

import java.util.Scanner;

public class EmployeeMainView {
    public static void view() {
        MAIN_LOOP:
        while (true) {
        System.out.println("Employee Main View");
        System.out.println("=============");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage  Reservations");
        System.out.println("9. Exit");
        System.out.println();
        System.out.print("Please make a choice: ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()) {
            case "1":
                CustomerView.view();
                break;
            case "2":
                ReservationView.view();
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
