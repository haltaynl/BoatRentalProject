package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;
import org.capgemini.model.Model;


import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateBoatView {

    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========⛴ UPDATE BOAT ⛴=======");
        System.out.println("Please enter the Boat Name of the boat that will update");
        System.out.print("Boat Name: ");
        String boatName = scanner.nextLine();
        Boat update_boat = BoatControls.findBoat(boatName);
        if (update_boat != null) {
            System.out.println();
            System.out.println("1. Update Boat Name");
            System.out.println("2. Update Boat Type");
            System.out.println("3. Update Seats");
            System.out.println("4. Update Charging Time");
            System.out.println("5. Update Price");
            System.out.println("6. Update Availability");
            System.out.println("9. Exit");
            System.out.println();
            boolean isValid = false;
            System.out.print("Please make a choice: ");
            switch (scanner.next()) {
                case "1":
                    System.out.print("New Boat Name: ");
                    scanner.nextLine();
                    String newBoatName = scanner.nextLine();
                    update_boat.setBoatName(newBoatName);
                    System.out.println("The Boat Name is updated successfully. ");
                    break;
                case "2":
                    System.out.print("New Boat Type: ");
                    scanner.nextLine();
                    String newBoatType = scanner.nextLine();
                    update_boat.setBoatName(newBoatType);
                    System.out.println("The Boat Type is updated successfully. ");
                    break;
                case "3":
                    int seats = 1;
                    while (!isValid) {
                        try {
                            System.out.print("Seats: ");
                            seats = scanner.nextInt();
                            isValid=true;
                            update_boat.setSeats(seats);
                            System.out.println("The Seats is updated successfully. ");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!");
                            scanner.next();
                        }
                    }
                    break;
                case "4":
                    int chargingTime = 30;
                    while (!isValid) {
                        try {
                            System.out.print("Charging Time: ");
                            chargingTime = scanner.nextInt();
                            isValid=true;
                            update_boat.setChargingTime(chargingTime);
                            System.out.println("The Charging time is updated successfully. ");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!");
                            scanner.next();
                        }
                    }
                    break;
                case "5":
                    double price = 17.5;
                    while (!isValid) {
                        try {
                            System.out.print("Price: ");
                            price = scanner.nextDouble();
                            isValid=true;
                            update_boat.setPrice(price);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input!");
                            scanner.next();
                        }
                    }
                    break;
                case "6":
                    scanner.next();
                    System.out.print("Availability: ");
                    boolean availability = scanner.nextBoolean();
                    update_boat.setAvailability(availability);
                    System.out.println("The Boat Availability is updated successfully. ");
                    break;
                case "9":
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            Model model = Model.getInstance();
            model.getBoats().store();

        }
    }
}
