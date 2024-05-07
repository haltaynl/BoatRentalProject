package org.capgemini.control;

import org.capgemini.model.*;

public class BoatControls {

    public static void addBoat(Boat boat) {
        Model model = Model.getInstance();
        model.getBoats().getBoats().add(boat);
        model.getBoats().store();
    }

    public static Boat findBoat(String boatName) {
        Model model = Model.getInstance();
        for (Boat temporaryBoat : model.getBoats().getBoats()) {
            if ((temporaryBoat.getBoatName().equalsIgnoreCase(boatName)))
                return temporaryBoat;
        }
        System.out.println("The boat is not found !!!");
        return null;
    }
    public static boolean findBoatType(String boatType) {
        Model model = Model.getInstance();
        for (Boat temporaryBoat : model.getBoats().getBoats()) {
            if ((temporaryBoat.getBoatType().equalsIgnoreCase(boatType)))
                return true;
        }
        System.out.println("The boat type is not found !!!");
        return false;
    }

    public static void listOfBoats() {
        Model model = Model.getInstance();
        System.out.println();
        System.out.println("\t\t\t\t\t=========================  BOAT LIST  ========================");

        System.out.println(String.format("%-20s %-20s %-15s %-15s %-15s %-15s",
                "Name", "Type","Seats",
                "Availability", "Price", "Charging Time"));
        System.out.println("---------------------------------------------------------" +
                "-----------------------------------------------");
        for (Boat b : model.getBoats().getBoats()) {
            System.out.println(String.format("%-20s %-20s %-15s %-15b %-15.2f %-15s",
                    b.getBoatName(), b.getBoatType(), b.getSeats(), b.isAvailability(),
                    b.getPrice(), b.getChargingTime()));
        }
        System.out.println();
        System.out.println("\t..................................End of boat list" +
                "..................................");
    }

    public static void removeBoat(Boat oldBoat) {
        Model model = Model.getInstance();
        model.getBoats().getBoats().remove(oldBoat);
        model.getBoats().store();
    }

}
