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
    public static void view() {
        Model model = Model.getInstance();
        LocalDateTime beginDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.now();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Reservation Details");
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Boat Type: ");
        String boatType = scanner.nextLine();
        LocalDate today = LocalDate.now();
        System.out.print("Begin Date Time yyyy-MM-dd HH:mm: " + today +" ");
        String timeString1 = scanner.nextLine();
        try { // checking the beginDateTime
            LocalTime time = LocalTime.parse(timeString1);
            beginDateTime = LocalDateTime.of(today, time);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        } catch (Exception e) {
            System.out.println("Invalid date time! ");
        }

        System.out.print("End Date Time yyyy-MM-dd HH:mm: " + today +" ");
        String timeString2 = scanner.nextLine();
        try { // checking the endDateTime
            LocalTime time = LocalTime.parse(timeString2);
            endDateTime = LocalDateTime.of(today, time);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        } catch (Exception e) {
            System.out.println("Geçersiz tarih yada saat formatı! ");
        }
        String freeBoatName=model.findFreeBoat(boatType,beginDateTime,endDateTime);
        Duration duration = Duration.between(beginDateTime, endDateTime);
        long minutes = duration.toMinutes();

        double price= Objects.requireNonNull(BoatControls.findBoat(freeBoatName)).getPrice()/4;
        double totalCost = calculateRentalCost(minutes, price);
        System.out.println("Toplam Kiralama Ücreti: " + totalCost);
        Reservation reservation = new Reservation(freeBoatName, customerName, beginDateTime, endDateTime,totalCost);
        ReservationControls.addReservation(reservation);
        System.out.println("---------------------------------");
        System.out.print("Reservation Number: ");
        System.out.println(reservation.getReservationID());
        System.out.print("Customer Name : ");
        System.out.println(reservation.getCustomerName());
        System.out.print("Customer Roomnumber: ");
        System.out.println(CustomerControls.findCustomer(customerName).getCustomerRoomNumber());
        System.out.print("Reserved Boat Name: ");
        System.out.println(freeBoatName);
        System.out.print("Reservation Cost: ");
        System.out.println(totalCost);
        System.out.println("Your reservation fee is going to be added to your hotel receipt!!");
        System.out.println("-------------------------------");
        System.out.println("The new reservation is added successfully !!!");

        model.getReservations().store();

    }

    private static double calculateRentalCost(long minutes, double rate) {
        long halfHourBlocks = (minutes + 14) / 15;
        return halfHourBlocks * rate;
    }

}
