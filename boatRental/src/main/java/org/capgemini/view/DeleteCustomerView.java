package org.capgemini.view;

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
            CustomerControls.removeCustomer(oldCustomer);
            System.out.println("The Customer is deleted successfully !!!");
        }

    }

}
