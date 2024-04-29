package org.capgemini.control;

import org.capgemini.model.Model;
import org.capgemini.model.Reservation;

public class ReservationControls {
    public static void addReservation(Reservation reservation) {
        Model model = Model.getInstance();

        // checking of userdata

        model.getReservations().getReservations().add(reservation);

        //Reservations.store();
    }
}
