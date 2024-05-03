package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.model.Reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

import static org.capgemini.control.ReservationControls.model;

public class ExtendReservationView {
    public static Scanner scanner = new Scanner(System.in);

    public static void view() {
        System.out.println();
        System.out.println("========\u26F4 EXTEND RESERVATION \u26F4=======");
        System.out.println("Please enter the ReservationID that will be extended");
        System.out.print("ReservationID: ");
        String reservationId = scanner.nextLine();
        Reservation update_reservation = ReservationControls.findReservation(reservationId);
        if (update_reservation != null) {
            UpdateReservation.updateEndDateTime(update_reservation);
            String boatType = BoatControls.findBoat(update_reservation.getBoatName()).getBoatType();
            String freeBoatName = model.findFreeBoat(boatType, update_reservation.getBeginDateTime(), update_reservation.getEndDateTime());
            update_reservation.setBoatName(freeBoatName);
            double price = Objects.requireNonNull(BoatControls.findBoat(freeBoatName)).getPrice() / 4;
            double totalCost = UpdateReservation.calculateRentalCost(update_reservation, price);
            update_reservation.setCost(totalCost);
            ReservationControls.printReservation(update_reservation);
            model.getReservations().store();
        }

    }

}
