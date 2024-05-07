package org.capgemini.view;

import org.capgemini.control.CustomerControls;
import java.util.Scanner;

public class CustomerView {
    public static void view() {
        MAIN_LOOP:
        while (true) {
            System.out.println();
            System.out.println("======= CUSTOMER MENU ======== ");
            System.out.println("1. Add Customer");
            System.out.println("2. Customer list ");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");

            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1":
                    AddCustomerView.view();
                    break;
                case "2":
                    CustomerControls.listOfCustomers();
                    break;
                case "3":
                    UpdateCustomerView.view();
                    break;
                case "4":
                    DeleteCustomerView.view();
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
