package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.CustomerControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.control.UserControls;
import org.capgemini.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UpdateReservation {
    static Scanner scanner = new Scanner(System.in);

    public static void view() {

        System.out.println();
        System.out.println("========\u26F4 UPDATE RESERVATION \u26F4=======");
        System.out.println("Please enter the Reservation Id of the boat that will update");
        System.out.print("Reservation Id: ");
        String reservationId = scanner.nextLine();
        Reservation update_reservation = ReservationControls.findReservation(reservationId);
        if (update_reservation != null) {
            System.out.println();
            System.out.println("1. Update Boat Name");
            System.out.println("2. Update Customer");
            System.out.println("3. Update Begin Date and Time");
            System.out.println("4. Update End Date and Time");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");
            switch (scanner.next()) {
                case "1":
                    scanner.nextLine();
                    System.out.println("Please enter new boat name");
                    String newBoatName = scanner.nextLine();
                    Boat newBoat = BoatControls.findBoat(newBoatName);
                    update_reservation.setBoat(newBoat);
                    break;
                case "2":
                    scanner.nextLine();
                    System.out.print("Please enter new Customer Name: ");
                    String newCustomerName = scanner.nextLine();
                    Customer newCustomer = CustomerControls.findCustomer(newCustomerName);
                    update_reservation.setCustomer(newCustomer);
                    break;
                case "3":
                    updateBeginDateTime(update_reservation);

                    break;
                case "4":
                    updateEndDateTime(update_reservation);

                    break;
                case "9":

                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            Model model = Model.getInstance();
            model.getBoats().store();

        }
    }

    private static void updateBeginDateTime(Reservation update_reservation) {
        while (true) {
            scanner.nextLine();
            System.out.print("Begin Date Time: ");
            //
            String newBeginDateString = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm   Plesa write like this format ");

            if (newBeginDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                System.out.println("Entered date and time format is correct.");
                break;
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }

            LocalDateTime newBeginDateTime = LocalDateTime.parse(newBeginDateString, formatter);
            update_reservation.setBeginDateTime(newBeginDateTime);
        }

    }
    private static void updateEndDateTime(Reservation update_reservation) {
        while (true) {
            scanner.nextLine();
            System.out.print("End Date Time: ");
            String newBeginDateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm   Plesa write like this format ");
            if (newBeginDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                System.out.println("Entered date and time format is correct.");
                break;
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }
            LocalDateTime newBeginDateTime = LocalDateTime.parse(newBeginDateString, formatter);
            update_reservation.setBeginDateTime(newBeginDateTime);
        }

    }
}