package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.model.Boat;
import org.capgemini.model.Reservation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AddReservationView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Reservation Details");
        System.out.print("Customer ID: ");
        String customerID = scanner.next();
        System.out.print("Boat Type: ");
        String boatType = scanner.next();
        System.out.print("Begin Date Time yyyy-MM-dd'T'HH:mm: ");
        LocalDateTime beginDateTime = LocalDateTime.parse(scanner.next());
        System.out.print("End Date Time yyyy-MM-dd'T'HH:mm: ");
        LocalDateTime endDateTime = LocalDateTime.parse(scanner.next());
        Duration duration = Duration.between(beginDateTime, endDateTime);

        // Get the number of hours and minutes in the duration
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;


        Boat freeboat = BoatControls.findBoat(boatType);
        double price = duration.toHours() * freeboat.getPrice() *2;




        // Output the period
        System.out.println("Duration: " + hours + " hours " + minutes + " minutes");

        // checking of wrong data

//         Reservation reservation = new Reservation(boatname, customerID, beginDateTime, endDateTime);
//         ReservationControls.addReservation(reservation);
    }
}
