package org.capgemini.view;

import org.capgemini.control.ReservationControls;
import org.capgemini.model.Model;

import java.util.Scanner;

public class ReservationView {
    public static void view() {
        MAIN_LOOP:
        while (true) {
            System.out.println();
            System.out.println("==== RESERVATION MENU ====");
            System.out.println("1. Add Reservation");
            System.out.println("2. Reservation List");
            System.out.println("3. Update Reservation");
            System.out.println("4. Extend Reservation");
            System.out.println("5. Delete Reservation");
            System.out.println("6. Cancel Reservation");
            System.out.println("7. View All Available Boats");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1":
                    AddReservationView.view();
                    break;
                case "2":
                    ReservationControls.listOfReservation();
                    break;
                case "3":
                    UpdateReservation.view();
                    break;
                case "4":
                    ExtendReservationView.view();
                    break;
                case "5":
                    DeleteReservation.view();
                    break;
                case "6":
                    CancelReservation.view();
                    break;
                case "7":
                    Model.ViewAllAvailableBoats();
                    break;
                case "9":
                    break MAIN_LOOP;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
