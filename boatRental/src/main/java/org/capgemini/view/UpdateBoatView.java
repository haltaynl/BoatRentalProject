package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;
import org.capgemini.model.Model;


import java.util.Scanner;

public class UpdateBoatView {
    
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 UPDATE BOAT \u26F4=======");
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
            System.out.print("Please make a choice: ");
            switch (scanner.next()) {
                case "1":
                    scanner.nextLine();
                    System.out.print("New Boat Name: ");
                    String newBoatName = scanner.nextLine();
                    update_boat.setBoatName(newBoatName);
                    System.out.println("The Boat Name is updated. ");
                    break;
                case "2":
                    scanner.nextLine();
                    System.out.print("New Boat Type: ");
                    String newBoatType = scanner.nextLine();
                    update_boat.setBoatName(newBoatType);
                    break;
                case "3":

                    System.out.print("Seats: ");
                    int newSeats = scanner.nextInt();
                    update_boat.setSeats(newSeats);
                    System.out.println("The Boat Seats is updated. ");
                    break;

                case "4":
                    scanner.nextLine();
                    System.out.print("Charging Time: ");
                    int newChargingTime = scanner.nextInt();
                    update_boat.setChargingTime(newChargingTime);
                    System.out.println("The Boat ChargingTime is updated. ");
                    break ;
                case "5":
                    scanner.nextLine();
                    System.out.print("Price: ");
                    double price= scanner.nextDouble();
                    update_boat.setPrice(price);
                    System.out.println("The Price is updated. ");
                    break;
                case "6":
                    scanner.nextLine();
                    System.out.print("Availability: ");
                    boolean availability= scanner.nextBoolean();
                    update_boat.setAvailability(availability);
                    System.out.println("The Boat Availability is updated. ");
                    break;
                case "9":
                    break ;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            Model model=Model.getInstance();
            model.getBoats().store();

            }
        }
    }
