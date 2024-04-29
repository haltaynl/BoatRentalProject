package org.capgemini.view;

import org.capgemini.control.CustomerControls;
import org.capgemini.control.UserControls;
import org.capgemini.model.Customer;
import org.capgemini.model.Model;
import org.capgemini.model.User;

import java.util.Scanner;

public class UpdateCustomerView {
    public static void view() {
        Model model=Model.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 UPDATE CUSTOMER \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the CustomerID of the customer that will update");
        System.out.print("Customer ID: ");
        String customerID = scanner.next();
        Customer oldCustomer= CustomerControls.findCustomer(customerID);
        if(oldCustomer!=null) {
            System.out.println("Please enter all details of the customer that will update");
            System.out.print("Customer Name: ");
            String customerName = scanner.next();
            System.out.print("Customer Phone: ");
            String customerPhone = scanner.next();
            System.out.print("Customer Email: ");
            String customerEmail = scanner.next();
            System.out.print("Customer Roomnumber: ");
            String customerRoomNumber = scanner.next();
            CustomerControls.removeCustomer(oldCustomer);
            Customer customer = new Customer(customerID,customerName, customerPhone, customerEmail, customerRoomNumber);
            CustomerControls.addCustomer(customer);
            System.out.println("The User is successfully updated!");

            // checking of wrong data

        }

    }
}
