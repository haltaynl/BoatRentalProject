package org.capgemini.view;

import org.capgemini.control.ReservationControls;
import org.capgemini.model.Reservation;

import java.util.Scanner;

public class CancelReservation {

    public class CancelReservation {
        public static void view() {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("========\u26F4 CANCEL RESERVATION \u26F4=======");
            System.out.println("________________________________");
            System.out.println("Please enter the reservationID of the reservation that will be canceled");
            System.out.print("ReservationID: ");
            String userID = scanner.next();
            Reservation old_reservation = ReservationControls.findReservation(reservationID);
            if (old_reservation != null) {
                ReservationControls.removeReservation(old_reservation);
                System.out.println("Reservation has been canceled!");

            }
