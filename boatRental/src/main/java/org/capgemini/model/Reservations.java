package org.capgemini.model;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservations {
    ArrayList<Reservation> reservations=new ArrayList<Reservation>();
    public static String csvFile = "boatRental/src/main/resources/Reservations.csv";

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void store() {
        Model model=Model.getInstance();

        try (FileWriter writer = new FileWriter(csvFile)) {
            StringBuilder sb = new StringBuilder();
            for (Reservation oneReservation : model.getReservations().getReservations()) {
                sb.append(oneReservation.getReservationID());
                sb.append(";");
                sb.append(oneReservation.getBoatName());
                sb.append(";");
                sb.append(oneReservation.getCustomerName());
                sb.append(";");
                sb.append(oneReservation.getBeginDateTime());
                sb.append(";");
                sb.append(oneReservation.getEndDateTime());
                sb.append(";");
                sb.append(oneReservation.getCost());
                sb.append("\n");
            }

            writer.write(sb.toString());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

    public void load() {
        Scanner scanIn = null;
        String inputLine = "";
        try {
            scanIn=new Scanner(new BufferedReader(new FileReader(csvFile)));
            while(scanIn.hasNextLine()){
                inputLine=scanIn.nextLine();
                String[] inputArray=inputLine.split(";");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d'T'HH:mm");
                LocalDateTime beginDateTime = LocalDateTime.parse(inputArray[3], formatter);
                LocalDateTime endDateTime = LocalDateTime.parse(inputArray[4], formatter);
                Reservation reservation1=new Reservation(inputArray[0],inputArray[1],inputArray[2],beginDateTime,endDateTime, Double.parseDouble(inputArray[5]));
                reservations.add(reservation1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
