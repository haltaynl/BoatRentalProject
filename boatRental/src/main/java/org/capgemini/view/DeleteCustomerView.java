package org.capgemini.view;

import org.capgemini.control.CustomerControls;
import org.capgemini.model.Customer;
import java.util.Scanner;

public class DeleteCustomerView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========  DELETE CUSTOMER  =======");
        System.out.println("Please enter the Customer Name of the customer that will delete");
        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        Customer oldCustomer = CustomerControls.findCustomer(customerName);
        if (oldCustomer != null) {
            System.out.print("Do you want to delete " + customerName + "?  (Y/N)");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Deleting the customer...");
                CustomerControls.removeCustomer(oldCustomer);
                System.out.println("The Customer is deleted successfully !!!");
            } else if (response == 'N' || response == 'n') {
                System.out.println("Customer deletion cancelled.");
            } else {
                System.out.println("Invalid response. Please respond with 'Y' or 'N'.");
            }
        }
    }
}
