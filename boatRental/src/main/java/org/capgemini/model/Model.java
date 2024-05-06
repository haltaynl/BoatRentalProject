package org.capgemini.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Model {
    private Users users = new Users();
    private Boats boats = new Boats();
    private Customers customers = new Customers();
    private Reservations reservations = new Reservations();

    private static Model model;

    public Users getUsers() {
        return users;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Boats getBoats() {
        return boats;
    }

    public void setBoats(Boats boats) {
        this.boats = boats;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
    public String findFreeBoat(String boatType, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        String freeBoatName = null;
        OUTER_LOOP:
        for (Boat boat : model.getBoats().getBoats()) {
            if (boat.isAvailability() && boat.getBoatType().equalsIgnoreCase(boatType)) {
                freeBoatName = boat.getBoatName();
                for (Reservation reservation : model.getReservations().getReservations()) {
                    if (freeBoatName.equals(reservation.getBoatName())) {
                        if ((reservation.getEndDateTime().isAfter(startDateTime) ||
                                reservation.getBeginDateTime().isBefore(endDateTime))) {
                            continue OUTER_LOOP;
                        } else return freeBoatName;
                    }
                }
                return freeBoatName;
            }
        }
        return "";
    }
    public static void ViewAllAvailableBoats() {
        System.out.println(String.format("%-20s %-15s %-15s %-15s %-25s %-15s",
                "Boat Name", "Boat Type","Seats",
                "Availability", "Price", "Charging Time"));
        OUTER_LOOP:
        for(Boat b : model.getBoats().getBoats()){
            if(b.isAvailability()){
                for(Reservation r : model.getReservations().getReservations()){
                    if(b.getBoatName().equalsIgnoreCase(r.getBoatName())) {
                         if(r.getBeginDateTime().isBefore(LocalDateTime.now()) &&
                            r.getEndDateTime().isAfter(LocalDateTime.now())){
                             continue OUTER_LOOP;
                        }
                    }
                }
            System.out.println(String.format("%-20s %-15s %-15s %-15b %-25.2f %-15s",
                        b.getBoatName(), b.getBoatType(), b.getSeats(), b.isAvailability(),
                        b.getPrice(), b.getChargingTime()));
            }
        }
    }

    private Model() {
        users.load();
        boats.load();
        customers.load();
        reservations.load();
    }


}
