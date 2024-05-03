package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.control.ReservationControls;
import org.capgemini.control.CustomerControls;
import org.capgemini.model.Model;
import org.capgemini.model.Reservation;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Scanner;

public class AddReservationView {
    public static Scanner scanner = new Scanner(System.in);
    public static void view() {
        Model model = Model.getInstance();
        System.out.println("Enter Reservation Details");
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Boat Type: ");
        String boatType = scanner.nextLine();
        //start date time of reservation
        LocalDateTime beginDateTime=validBeginDateTime();
        //end date time of reservation
        LocalDateTime endDateTime=validEndDateTime();
        String freeBoatName=model.findFreeBoat(boatType,beginDateTime,endDateTime);
        Duration duration = Duration.between(beginDateTime, endDateTime);
        long minutes = duration.toMinutes();

        double price= Objects.requireNonNull(BoatControls.findBoat(freeBoatName)).getPrice()/4;
        double totalCost = calculateRentalCost(minutes, price);

        Reservation reservation = new Reservation(freeBoatName, customerName, beginDateTime, endDateTime,totalCost);
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
            if (newBeginDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                return LocalDateTime.parse(newBeginDateString, formatter);
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }
           return null;
        }
    }

    public static LocalDateTime validEndDateTime() {
        do {
            System.out.print("End Date Time (yyyy-mm-dd hh:mm) : ");
            String newBeginDateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
            if (newBeginDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                return LocalDateTime.parse(newBeginDateString, formatter);
            } else {
                System.out.println("Entered date and time format is incorrect.Try Again");
            }
            return null;
        }while (true);
    }

    private static double calculateRentalCost(long minutes, double rate) {
        long halfHourBlocks = (minutes + 14) / 15;
        return halfHourBlocks * rate;
    }

}
