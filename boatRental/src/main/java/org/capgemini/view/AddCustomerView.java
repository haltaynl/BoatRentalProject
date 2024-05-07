package org.capgemini.view;

import org.capgemini.control.CustomerControls;
import org.capgemini.model.Customer;

import java.util.Scanner;

public class AddCustomerView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======== NEW CUSTOMER =======");
        System.out.println("Enter all details of the customer ");
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Customer Phone: ");
        String customerPhone = scanner.next();
        System.out.print("Customer Email: ");
        String customerEmail = scanner.next();
        System.out.print("Customer RoomNumber: ");
        String customerRoomNumber = scanner.next();

        Customer customer = new Customer(customerName, customerPhone, customerEmail, customerRoomNumber);
        CustomerControls.addCustomer(customer);
        System.out.println("New customer is successfully added!");
        // checking of wrong data
    }
}
