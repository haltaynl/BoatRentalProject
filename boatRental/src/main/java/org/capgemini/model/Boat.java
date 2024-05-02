package org.capgemini.model;

public class Boat {
    private String boatID;
    private String boatName;
    private String boatType;
    private int seats;
    private int chargingTime;
    private double price;
    private boolean availability;


    public Boat() {
    }

    public Boat(String boatName, String boatType, int seats, int chargingTime, double price, boolean availability) {
        Model model = Model.getInstance();
        this.boatID = "Boat" + model.getBoats().getBoats().size();
        this.boatName = boatName;
        this.boatType=boatType;
        this.seats = seats;
        this.chargingTime = chargingTime;
        this.price = price;
        this.availability = availability;
    }

    public Boat(String boatID, String boatName, String boatType, int seats, int chargingTime, double price, boolean availability) {
        this.boatID = boatID;
        this.boatName = boatName;
        this.seats = seats;
        this.boatType=boatType;
        this.chargingTime = chargingTime;
        this.price = price;
        this.availability = availability;
    }

    public String getBoatType() {
        return boatType;
    }

    public void setBoatType(String boatType) {
        this.boatType = boatType;
    }

    public String getBoatID() {
        return boatID;
    }

    public void setBoatID(String boatID) {
        this.boatID = boatID;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getChargingTime() {
        return chargingTime;
    }

    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
