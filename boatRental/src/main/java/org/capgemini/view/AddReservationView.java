package org.capgemini.view;

import org.capgemini.control.ReservationControls;
import org.capgemini.model.Reservation;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AddReservationView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Reservation Details");
        System.out.print("Customer ID: ");
        String customerID = scanner.next();
        System.out.print("Boat Name: ");
        String boatname = scanner.next();
        System.out.print("Begin Date Time: ");
        LocalDateTime beginDateTime = LocalDateTime.parse(scanner.next());
        System.out.print("End Date Time: ");
        LocalDateTime endDateTime = LocalDateTime.parse(scanner.next());

        // checking of wrong data


    }
}
