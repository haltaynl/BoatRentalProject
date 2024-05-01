package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;

import java.util.Scanner;

public class AddBoatView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("========\u26F4 NEW BOAT \u26F4=======");
        System.out.println("Enter all details of the boat");
        System.out.print("BoatID: ");
        String boatID = scanner.next();
        System.out.print("BoatName: ");
        scanner.nextLine();
        String boatName = scanner.nextLine();
        System.out.print("BoatType: ");
        String boatType = scanner.nextLine();
        System.out.print("Seats: ");
        int seats = scanner.nextInt();
        System.out.print("Charging Time: ");
        int chargingTime=scanner.nextInt();
        System.out.print("Price: ");
        double price=scanner.nextDouble();
        boolean availability = true;

        Boat boat = new Boat(boatID, boatName, boatType, seats, chargingTime, price, availability);
        BoatControls.addBoat(boat);
        System.out.println("New Boat is successfully added !!");
    }
}
