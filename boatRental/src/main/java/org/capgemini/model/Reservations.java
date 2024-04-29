package org.capgemini.model;

import java.util.ArrayList;

public class Reservations {
    ArrayList<Reservation> reservations=new ArrayList<Reservation>();

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void store() {
        // write the complete booklist to csv

    }

    public static Reservations load() {
        Reservations reservations = new Reservations();

        // load data from disk

        return reservations;
    }
}
