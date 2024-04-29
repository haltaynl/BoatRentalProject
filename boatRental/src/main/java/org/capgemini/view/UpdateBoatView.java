package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;


import java.util.Scanner;

public class UpdateBoatView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 UPDATE BOAT \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the BoatID of the user that will update");
        System.out.print("BoatID: ");
        String boatID = scanner.next();
        Boat old_boat = BoatControls.findBoat(boatID);
        if (old_boat != null) {
            System.out.println("Please enter all details of the boat that will update");
            System.out.print("BoatName: ");
            String boatName = scanner.next();
            System.out.print("Seats: ");
            int seats = scanner.nextInt();
            System.out.print("Charging Time: ");
            int chargingTime = scanner.nextInt();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            System.out.print("Availability: ");
            boolean availability = scanner.nextBoolean();

            BoatControls.removeBoat(old_boat);
            Boat updatedBoat = new Boat(boatID, boatName, seats, chargingTime, price, availability);
            BoatControls.addBoat(updatedBoat);
            System.out.println("The boat is successfully updated!");

            // checking of wrong data

        }
    }
}
