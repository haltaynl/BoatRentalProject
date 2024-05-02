package org.capgemini.control;
import org.capgemini.model.Model;
import org.capgemini.model.Reservation;


public class ReservationControls {
    public static Model model = Model.getInstance();
    public static void addReservation(Reservation reservation) {
        model.getReservations().getReservations().add(reservation);
        model.getReservations().store();
        }

    public static Reservation findReservation(String ReservationID) {
        for (Reservation temporaryReservation : model.getReservations().getReservations()) {
            if ((temporaryReservation.getReservationID().equals(ReservationID)))
                return temporaryReservation;
        }
        System.out.println("The boat is not found !!!");
        return null;
    }

    public static void listOfReservation() {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t========\u26F4 RESERVATION LIST \u26F4=======");
        System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s %-10s",
                "Reservation ID", "Boat Name", "Customer Name",
                "Begin Date Time", "End Date Time", "Cost"));
        for(Reservation r : model.getReservations().getReservations()) {
            System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s %-10s",
                    r.getReservationID(),r.getBoatName(), r.getCustomerName(),
                    r.getBeginDateTime().toString(), r.getEndDateTime(), String.valueOf(r.getCost())));

        }
        System.out.println(".............................End of The Reservation List.............................");
    }

    public static void removeReservation(Reservation oldReservation) {

        model.getReservations().getReservations().remove(oldReservation);
        model.getReservations().store();
    }

    }



