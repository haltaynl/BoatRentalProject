package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.control.CustomerControls;
import org.capgemini.model.Customer;
import org.capgemini.model.Model;
import org.capgemini.model.Reservation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddReservationView {
    public static Scanner scanner = new Scanner(System.in);

    public static void view() {
        Model model = Model.getInstance();
        System.out.println("======== NEW RESERVATION =======");
        System.out.println("Enter all details of the new reservation");
        String customerName = null;
        while (true) {
            System.out.print("Customer Name: ");
            customerName = scanner.nextLine();
            Customer temp = CustomerControls.findCustomer(customerName);
            if (temp != null) break;
            else System.out.println("Customer must be in the Customer List!");
        }
        String boatType = null;
        while (true) {
            System.out.print("Boat Type: ");
            boatType = scanner.nextLine();
            if (BoatControls.findBoatType(boatType)) {
                break;
            } else System.out.println("Please write correct boat type !!");
        }
        //start date time of reservation
        LocalDateTime beginDateTime = validBeginDateTime();
        //end date time of reservation
        LocalDateTime endDateTime = validEndDateTime();
        if (boatType.equalsIgnoreCase("Electrical boat")) {
            endDateTime = endDateTime.plusMinutes(30);
        }
        String freeBoatName = model.findFreeBoat(boatType, beginDateTime, endDateTime);
        Duration duration = Duration.between(beginDateTime, endDateTime);
        long minutes = duration.toMinutes();
        while (minutes < 30) {
            System.out.println("Reservation time must be more than 30 minutes !!");
            endDateTime = validEndDateTime();
            duration = Duration.between(beginDateTime, endDateTime);
            minutes = duration.toMinutes();
        }
        double price = BoatControls.findBoat(freeBoatName).getPrice() / 4;
        double totalCost = calculateRentalCost(minutes, price);

        Reservation reservation = new Reservation(freeBoatName, customerName, beginDateTime, endDateTime, totalCost);
        ReservationControls.addReservation(reservation);
        System.out.println("The new reservation is added successfully !!!");
        ReservationControls.printReservation(reservation);
        model.getReservations().store();

    }

    public static LocalDateTime validBeginDateTime() {
        while (true) {
            System.out.print("Begin Date Time (yyyy-mm-dd hh:mm) : ");
            String newBeginDateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
            if (newBeginDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}") &&
                    LocalDateTime.parse(newBeginDateString, formatter).isAfter(LocalDateTime.now())) {
                {
                    return LocalDateTime.parse(newBeginDateString, formatter);
                }
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }

        }

    }

    public static LocalDateTime validEndDateTime() {
        do {
            System.out.print("End Date Time (yyyy-mm-dd hh:mm) : ");
            String newEndDateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
            if (newEndDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}") &&
                    (LocalDateTime.parse(newEndDateString, formatter).isAfter(LocalDateTime.now()))) {
                return LocalDateTime.parse(newEndDateString, formatter);
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }
            return null;
        } while (true);
    }

    private static double calculateRentalCost(long minutes, double rate) {
        long halfHourBlocks = (minutes + 14) / 15;
        return halfHourBlocks * rate;
    }

}
