package org.capgemini.control;

import org.capgemini.model.Boat;
import org.capgemini.model.Customer;
import org.capgemini.model.Model;

public class CustomerControls {

    public static void addCustomer(Customer customer) {
        Model model = Model.getInstance();
        model.getCustomers().getCustomers().add(customer);
        model.getCustomers().store();
    }

    public static Customer findCustomer(String customerName) {
        Model model = Model.getInstance();
        for (Customer temporaryCustomer : model.getCustomers().getCustomers()) {
            if ((temporaryCustomer.getCustomerName().equalsIgnoreCase(customerName)))
                return temporaryCustomer;
        }
        System.out.println("The customer is not found !!!");
        return null;
    }

    public static void listOfCustomers() {
        Model model = Model.getInstance();
        System.out.println();
        System.out.println("\t\t\t\t============ CUSTOMER LIST ===========");
        System.out.println(String.format("%-15s %-30s %-15s %-30s",
                "Room Number", "Name", "Phone", "E-Mail Address "));
        System.out.println("------------------------------------------------------------------------------");
        for (Customer c : model.getCustomers().getCustomers()) {
            System.out.println(String.format("%-15s %-30s %-15s %-30s",
                    c.getCustomerRoomNumber(), c.getCustomerName(),
                    c.getCustomerPhone(),c.getCustomerEmail()));
        }
        System.out.println();
        System.out.println("\t\t\t\t\t\t.....End of customer list....");
    }

    public static void removeCustomer(Customer customer) {
        Model model = Model.getInstance();
        model.getCustomers().getCustomers().remove(customer);
        model.getCustomers().store();
    }
}
