package org.capgemini.view;

import org.capgemini.control.ReservationControls;
import org.capgemini.model.Model;
import org.capgemini.model.Reservation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CancelReservation {

    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 CANCEL RESERVATION \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the reservationID of the reservation that will be canceled");
        System.out.print("ReservationID: ");
        String reservationID = scanner.next();
        Reservation old_reservation = ReservationControls.findReservation(reservationID);
        if (old_reservation != null) {
            LocalDateTime now = LocalDateTime.now();
            long cancelHours = ChronoUnit.HOURS.between(now, old_reservation.getBeginDateTime());
            // Eğer iptal 2 saatten fazla önce ise %50 iade yap
            if (cancelHours >= 2) {
                old_reservation.setCost(old_reservation.getCost() * 0.5);
            } else if (cancelHours >= 1) {
                old_reservation.setCost(old_reservation.getCost() * 0.75);
            } else old_reservation.setCost(old_reservation.getCost());
        }
        System.out.println("The Reservation has been canceled!");
        if (old_reservation.getCost() > 0) {
            System.out.print("Cancellation Fee : ");
            System.out.println(old_reservation.getCost());
            System.out.println("Your reservation fee is going to be added to your hotel receipt!!");
            System.out.println("-------------------------------");
        }
        System.out.println("The Reservation has been canceled!");
        Model model=Model.getInstance();
        model.getReservations().store();
    }

}
