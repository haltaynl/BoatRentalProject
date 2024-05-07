package org.capgemini.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customers {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    public static String csvFile = "boatRental/src/main/resources/Customers.csv";

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Reservation> reservations) {
        this.customers = customers;
    }

    public void store() {
        Model model=Model.getInstance();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            StringBuilder sb = new StringBuilder();
            for (Customer oneUser : model.getCustomers().getCustomers()) {

                sb.append(oneUser.getCustomerID());
                sb.append(";");
                sb.append(oneUser.getCustomerName());
                sb.append(";");
                sb.append(oneUser.getCustomerPhone());
                sb.append(";");
                sb.append(oneUser.getCustomerEmail());
                sb.append(";");
                sb.append(oneUser.getCustomerRoomNumber());
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void load() {
        Scanner scanIn = null;
        String inputLine = "";

        try {
            scanIn=new Scanner(new BufferedReader(new FileReader(csvFile)));
            while(scanIn.hasNextLine()){
                inputLine=scanIn.nextLine();
                String[] inputArray=inputLine.split(";");
                Customer c1=new Customer(inputArray[0],inputArray[1],inputArray[2],inputArray[3],inputArray[4]);
                customers.add(c1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
