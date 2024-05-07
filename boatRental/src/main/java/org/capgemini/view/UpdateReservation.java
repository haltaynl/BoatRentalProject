package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.CustomerControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.control.UserControls;
import org.capgemini.model.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

import static org.capgemini.control.ReservationControls.model;

public class UpdateReservation {
    static Scanner scanner = new Scanner(System.in);

    public static void view() {

        System.out.println();
        System.out.println("========⛴ UPDATE RESERVATION ⛴=======");
        System.out.println("Please enter the Reservation Id of the boat that will update");
        System.out.print("Reservation Id: ");
        String reservationId = scanner.nextLine();
        Reservation update_reservation = ReservationControls.findReservation(reservationId);
        if (update_reservation != null) {
            System.out.println();
            System.out.println("1. Update Boat Type");
            System.out.println("2. Update Customer Name");
            System.out.println("3. Update Begin Date and Time");
            System.out.println("4. Update End Date and Time");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");
            switch (scanner.next()) {
                case "1":
                    scanner.nextLine();
                    System.out.print("Please enter new boat type: ");
                    String newBoatType = scanner.nextLine();
                    String freeBoatName = model.findFreeBoat(newBoatType, update_reservation.getBeginDateTime(), update_reservation.getEndDateTime());
                    update_reservation.setBoatName(freeBoatName);
                    double price = Objects.requireNonNull(BoatControls.findBoat(freeBoatName)).getPrice() / 4;
                    double totalCost = calculateRentalCost(update_reservation, price);
                    update_reservation.setBoatName(freeBoatName);
                    update_reservation.setCost(totalCost);
                    ReservationControls.printReservation(update_reservation);
                    break;
                case "2":
                    scanner.nextLine();
                    System.out.print("Please enter new Customer Name: ");
                    String newCustomerName = scanner.nextLine();
                    update_reservation.setCustomerName(newCustomerName);
                    ReservationControls.printReservation(update_reservation);
                    break;
                case "3":
                    updateBeginDateTime(update_reservation);
                    String BoatType = BoatControls.findBoat(update_reservation.getBoatName()).getBoatType();
                    freeBoatName = model.findFreeBoat(BoatType, update_reservation.getBeginDateTime(), update_reservation.getEndDateTime());
                    update_reservation.setBoatName(freeBoatName);
                    price = Objects.requireNonNull(BoatControls.findBoat(freeBoatName)).getPrice() / 4;
                    totalCost = calculateRentalCost(update_reservation, price);
                    update_reservation.setCost(totalCost);
                    ReservationControls.printReservation(update_reservation);
                    break;
                case "4":
                    updateEndDateTime(update_reservation);
                    BoatType = BoatControls.findBoat(update_reservation.getBoatName()).getBoatType();
                    freeBoatName = model.findFreeBoat(BoatType, update_reservation.getBeginDateTime(), update_reservation.getEndDateTime());
                    update_reservation.setBoatName(freeBoatName);
                    price = Objects.requireNonNull(BoatControls.findBoat(freeBoatName)).getPrice() / 4;
                    totalCost = calculateRentalCost(update_reservation, price);
                    update_reservation.setCost(totalCost);
                    ReservationControls.printReservation(update_reservation);
                    break;
                case "9":
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            Model model = Model.getInstance();
            model.getReservations().store();
        }
    }

    public static double calculateRentalCost(Reservation update_reservation, double rate) {
        Duration duration = Duration.between(update_reservation.getBeginDateTime(), update_reservation.getEndDateTime());
        long minutes = duration.toMinutes();
        if (update_reservation.getBoatName().contains("Electrical boat")){
            duration.plusMinutes(30);
        }
        long halfHourBlocks = (minutes + 14) / 15;
        return halfHourBlocks * rate;
    }


    public static void updateBeginDateTime(Reservation update_reservation) {
        scanner.nextLine();
        while (true) {
            System.out.print("Begin Date Time (yyyy-mm-dd hh:mm) : ");
            String newBeginDateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
            if (newBeginDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                if(LocalDateTime.parse(newBeginDateString,formatter).isAfter(LocalDateTime.now())){
                LocalDateTime newBeginDateTime = LocalDateTime.parse(newBeginDateString, formatter);
                update_reservation.setBeginDateTime(newBeginDateTime);
                break;
            } }else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }
        }
    }

    public static void updateEndDateTime(Reservation update_reservation) {
        scanner.nextLine();
        while (true) {
            System.out.print("End Date Time (yyyy-mm-dd hh:mm) : ");
            String newEndDateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
            if (newEndDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                LocalDateTime newEndDateTime = LocalDateTime.parse(newEndDateString, formatter);
                update_reservation.setEndDateTime(newEndDateTime);
                break;
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }

        }

    }
}