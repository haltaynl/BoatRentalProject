package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddBoatView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("======== NEW BOAT =======");
        System.out.println("Enter all details of the new boat");
        System.out.print("BoatName: ");
        String boatName = scanner.nextLine();
        System.out.print("BoatType: ");
        String boatType = scanner.nextLine();
        int seats = 1;
        try {
            System.out.print("Seats: ");
            seats = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            scanner.next();
        }
        int chargingTime = 30;
        try {
            System.out.print("Charging Time: ");
            chargingTime = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            scanner.next();
        }
        double price=17.5;
        try {
            System.out.print("Price: ");
            price = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            scanner.next();
        }
        boolean availability = true;
        Boat boat = new Boat(boatName, boatType, seats, chargingTime, price, availability);
        BoatControls.addBoat(boat);
        System.out.println("New Boat is successfully added !!");
    }
}
