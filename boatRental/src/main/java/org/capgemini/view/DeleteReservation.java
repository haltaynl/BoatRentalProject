package org.capgemini.view;

import org.capgemini.control.ReservationControls;
import org.capgemini.model.Reservation;
import org.capgemini.model.Reservation;

import java.util.Scanner;

public class DeleteReservation {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 DELETE RESERVATION \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the reservationID of the reservation that will delete");
        System.out.print("ReservationID: ");
        String userID = scanner.next();
        Reservation old_reservation = ReservationControls.findReservation(reservationID);
        if (old_reservation != null) {
            ReservationControls.removeReservation(old_reservation);
            System.out.println("The reservation is deleted successfully !!!");
        }


    }
