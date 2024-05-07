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
        System.out.println("\t\t=================================== RESERVATION LIST ===================================");
        System.out.println(String.format("%-15s %-20s %-25s %-30s %-25s %-10s",
                "ID", "Boat Name", "Customer Name",
                "Begin Date Time", "End Date Time", "Cost"));
        System.out.println("-------------------------------------------------" +
                "------------------------------------------------------------------------------");
        for(Reservation r : model.getReservations().getReservations()) {
            System.out.println(String.format("%-15s %-20s %-25s %-30s %-20s %10.2f",
                    r.getReservationID(),r.getBoatName(), r.getCustomerName(),
                    r.getBeginDateTime().toString(), r.getEndDateTime(), r.getCost()));

        }
        System.out.println(" ");
        System.out.println(".................................End of The Reservation List.................................");
        System.out.println();
    }

    public static void removeReservation(Reservation oldReservation) {
        model.getReservations().getReservations().remove(oldReservation);
        model.getReservations().store();
    }

    public static void printReservation(Reservation r){
        System.out.println();
        System.out.println("----------------Reservation Details-------------------");
        System.out.print(String.format("%-30s","Reservation Number: "));
        System.out.println(r.getReservationID());
        System.out.print(String.format("%-30s","Customer Name : "));
        System.out.println(r.getCustomerName());
        System.out.print(String.format("%-30s","Customer Roomnumber: "));
        System.out.println(CustomerControls.findCustomer(r.getCustomerName()).getCustomerRoomNumber());
        System.out.print(String.format("%-30s","Reserved Boat Name: "));
        System.out.println(r.getBoatName());
        System.out.print(String.format("%-30s","Start Date Time: "));
        System.out.println(r.getBeginDateTime());
        System.out.print(String.format("%-30s","End Date Time: "));
        System.out.println(r.getEndDateTime());
        System.out.print(String.format("%-30s","Reservation Cost: "));
        System.out.println(r.getCost());
        System.out.println("Your reservation fee is going to be added to your hotel receipt!!");
        System.out.println("----------------Reservation Details-------------------");
        System.out.println();
    }


}



