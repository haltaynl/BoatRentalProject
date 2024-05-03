package org.capgemini.model;

import java.time.LocalDateTime;

public class Reservation {
    private String reservationID;
    private String BoatName;
    private String customerName;
    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private double cost;


   public Reservation(String reservationID, String boatName, String customerName, LocalDateTime beginDateTime, LocalDateTime endDateTime, double cost) {
        this.reservationID=reservationID;
        this.BoatName=boatName;
        this.customerName=customerName;
        this.beginDateTime=beginDateTime;
        this.endDateTime=endDateTime;
        this.cost=cost;
   }
    public Reservation(String boatName, String customerName, LocalDateTime beginDateTime, LocalDateTime endDateTime, double cost) {
        long timestamp = System.currentTimeMillis() % 10000;
        this.reservationID ="MHR-" + String.format("%04d", timestamp);
        this.BoatName=boatName;
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
        return BoatName;
    }

    public void setBoatName(String rBoatName) {
        this.BoatName = rBoatName;
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
