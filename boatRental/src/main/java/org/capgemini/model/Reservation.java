package org.capgemini.model;

import java.time.LocalDateTime;

public class Reservation extends Boat {
    private String reservationID;
    private String boatName;
    private String customerName;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private double cost;

   public Reservation(String boatName, String customerName, LocalDateTime beginDateTime, LocalDateTime endDateTime,double cost) {
        this.reservationID=null;
        this.boatName=boatName;
        this.customerName=customerName;
        this.beginDateTime=beginDateTime;
        this.endDateTime=endDateTime;
        this.cost=cost;
   }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
