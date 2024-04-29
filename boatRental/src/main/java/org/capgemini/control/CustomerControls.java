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
        System.out.println("========\u26F4 CUSTOMER LIST \u26F4=======");
        System.out.println("______________________________");
        System.out.println("Customer ID\tCustomer Name\tCustomer Mail\tCustomer Phone\tcustomerRoomNumber`" );
        for (Customer c : model.getCustomers().getCustomers()) {
            System.out.println(c.getCustomerID()+"\t"+c.getCustomerName()+"\t"+c.getCustomerEmail()
                    +"\t"+c.getCustomerPhone()+"\t"+c.getCustomerRoomNumber());

        }
        System.out.println("....End of customer list....");
    }

    public static void removeCustomer(Customer customer) {
        Model model = Model.getInstance();
        model.getCustomers().getCustomers().remove(customer);
        model.getCustomers().store();
    }
}
