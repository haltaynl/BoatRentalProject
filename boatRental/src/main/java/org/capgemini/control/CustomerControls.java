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

    public static Customer findCustomer(String customerID) {
        Model model = Model.getInstance();
        for (Customer temporaryCustomer : model.getCustomers().getCustomers()) {
            if ((temporaryCustomer.getCustomerID().equals(customerID)))
                return temporaryCustomer;
        }
        System.out.println("The customer is not found !!!");
        return null;
    }

    public static void listOfCustomers() {
        Model model = Model.getInstance();
        System.out.println();
        System.out.println("\t\t\t\t========\u26F4 CUSTOMER LIST \u26F4=======");
        System.out.println(String.format("%-15s %-20s %-15s %-15s %-25s",
                "Customer ID", "Customer Name", "Customer Mail",
                "Customer Phone", "Customer Room Number"));
        for (Customer c : model.getCustomers().getCustomers()) {
            System.out.println(String.format("%-15s %-20s %-15s %-15s %-25s",
                    c.getCustomerID(), c.getCustomerName(), c.getCustomerEmail(),
                    c.getCustomerPhone(),c.getCustomerRoomNumber()));
        }
        System.out.println("....End of customer list....");
    }

    public static void removeCustomer(Customer customer) {
        Model model = Model.getInstance();
        model.getCustomers().getCustomers().remove(customer);
        model.getCustomers().store();
    }
}
