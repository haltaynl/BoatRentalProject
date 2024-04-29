package org.capgemini.control;

import org.capgemini.model.*;

public class BoatControls {


    public static void addBoat(Boat boat) {
        Model model = Model.getInstance();
        model.getBoats().getBoats().add(boat);
        model.getBoats().store();
    }

    public static Boat findBoat(String boatID) {
        Model model = Model.getInstance();
        for (Boat temporaryBoat : model.getBoats().getBoats()) {
            if ((temporaryBoat.getBoatID().equals(boatID)))
                return temporaryBoat;
        }
        System.out.println("The boat is not found !!!");
        return null;
    }

    public static void listOfBoats() {
        Model model = Model.getInstance();
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t========\u26F4 BOAT LIST \u26F4=======");
        System.out.println(String.format("%-15s %-20s %-15s %-15s %-25s %-15s",
                "Boat ID", "Boat Name", "Seats",
                "Availability", "Price", "Charging Time"));
        for (Boat b : model.getBoats().getBoats()) {
            System.out.println(String.format("%-15s %-20s %-15s %-15b %-25.2f %-15s",
                    b.getBoatID(), b.getBoatName(),
                    b.getSeats(),b.isAvailability(), b.getPrice(),
                    b.getChargingTime()));
        }
        System.out.println("....End of boat list....");
    }

    public static void removeBoat(Boat oldBoat) {
        Model model = Model.getInstance();
        model.getBoats().getBoats().remove(oldBoat);
        model.getBoats().store();
    }
}
