package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.CustomerControls;
import org.capgemini.control.UserControls;
import org.capgemini.model.Customer;
import org.capgemini.model.User;

import java.util.Scanner;

public class DeleteCustomerView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 DELETE CUSTOMER \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the customer Name of the customer that will delete");
        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        Customer oldCustomer = CustomerControls.findCustomer(customerName);
        if(oldCustomer!=null) {
            System.out.print("Do you want to delete the bot? (Y/N)");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Deleting the bot...");
                CustomerControls.removeCustomer(oldCustomer);
            } else if (response == 'N' || response == 'n') {
                System.out.println("Bot deletion cancelled.");
            } else {
                System.out.println("Invalid response. Please respond with 'Y' or 'N'.");
            }

            System.out.println("The Customer is deleted successfully !!!");
        }

    }

}
