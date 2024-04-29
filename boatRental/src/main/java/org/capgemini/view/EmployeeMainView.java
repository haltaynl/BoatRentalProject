package view;

import java.util.Scanner;

public class EmployeeMainView {
    public static void view() {
        System.out.println("Employee Main View");
        System.out.println("==========");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage  Resrvations");
        System.out.println("9. Exit");
        System.out.println();

        MAIN_LOOP:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1":
                    break;
                case "2":
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
