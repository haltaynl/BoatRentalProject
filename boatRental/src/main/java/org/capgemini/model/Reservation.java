package org.capgemini.model;

import java.time.LocalDateTime;

public class Reservation {
    private String reservationID;
    private Boat boat;
    private Customer customer;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private double cost;

    public Reservation() {
    }

    public Reservation(String reservationID, Boat boat, Customer customer, LocalDateTime beginDateTime, LocalDateTime endDateTime) {
        this.reservationID = reservationID;
        this.boat = boat;
        this.customer = customer;
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.cost = cost;
    }

    public Reservation(String boatname, String customerID, LocalDateTime beginDateTime, LocalDateTime endDateTime, double cost) {

    }

    public Reservation(String boatname, String customerID, LocalDateTime beginDateTime, LocalDateTime endDateTime) {

    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(LocalDateTime beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
