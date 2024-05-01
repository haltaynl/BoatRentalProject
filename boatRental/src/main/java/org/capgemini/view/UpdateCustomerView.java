package org.capgemini.view;

import org.capgemini.control.CustomerControls;
import org.capgemini.control.UserControls;
import org.capgemini.model.Customer;
import org.capgemini.model.Model;
import org.capgemini.model.User;

import java.util.Scanner;

public class UpdateCustomerView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 UPDATE CUSTOMER \u26F4=======");
        System.out.println("Please enter the customer name that will update");
        System.out.print("customer name: ");
        String customerName = scanner.nextLine();
        Customer update_customer = CustomerControls.findCustomer(customerName);

        if (update_customer != null) {
            System.out.println();
            System.out.println("1. Update Customer Name");
            System.out.println("2. Update Customer Email");
            System.out.println("3. Update Customer Phone");
            System.out.println("4. Update Customer Room Number");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");
            switch (scanner.next()) {
                case "1":
                    System.out.print("New Customer Name : ");
                    scanner.nextLine();
                    String newCustomerName = scanner.nextLine();
                    update_customer.setCustomerName(newCustomerName);
                    System.out.println("The Customer name is successfully updated!");

                    break;
                case "2":
                    System.out.print("Customer Email ");
                    scanner.nextLine();
                    String newEmail = scanner.next();
                    update_customer.setCustomerEmail(newEmail);
                    System.out.println("The Customer Email is successfully updated!");

                    break;
                case "3":
                    System.out.print("Customer Phone: ");
                    scanner.nextLine();
                    String newCustomerPhone = scanner.next();
                    update_customer.setCustomerPhone(newCustomerPhone);
                    System.out.println("The Customer phone is successfully updated!");

                    break ;
                case "4":
                    System.out.print("Customer Room Number: ");
                    scanner.nextLine();
                    String newCustomerRoomNumber= scanner.next();
                    update_customer.setCustomerRoomNumber(newCustomerRoomNumber);
                    System.out.println("The Customer Room Number is successfully updated!");
                    break;

                case "9":

                    break ;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            Model model=Model.getInstance();
            model.getCustomers().store();}

       }
}
