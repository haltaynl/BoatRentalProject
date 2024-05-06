package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.model.Model;
import org.capgemini.model.Reservation;
import org.capgemini.model.Reservation;

import java.util.Scanner;

public class DeleteReservation {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 DELETE RESERVATION \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the reservationID of the reservation that will delete");
        System.out.print("ReservationID: ");
        String reservationID = scanner.next();
        Reservation oldReservation = ReservationControls.findReservation(reservationID);
        if(oldReservation!=null) {
            System.out.print("Do you want to delete the bot? (Y/N)");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Deleting the bot...");
                ReservationControls.removeReservation(oldReservation);
                System.out.println("The Boat is deleted successfully !!!");
            } else if (response == 'N' || response == 'n') {
                System.out.println("Boat deletion is cancelled.");
            } else {
                System.out.println("Invalid response. Please respond with 'Y' or 'N'.");
            }
        }
        Model model=Model.getInstance();
        model.getReservations().store();


    }
}