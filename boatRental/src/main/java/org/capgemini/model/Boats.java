package org.capgemini.model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Boats {
    ArrayList<Boat> boats=new ArrayList<Boat>();
    public static String csvFile = "boatRental/src/main/resources/Boats.csv";

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public void setBoats(ArrayList<Boat> boats) {
        boats = boats;
    }

    public void store() {
        Model model=Model.getInstance();

        try (FileWriter writer = new FileWriter(csvFile)) {
            StringBuilder sb = new StringBuilder();
            for (Boat oneBoat : model.getBoats().getBoats()) {
                sb.append(oneBoat.getBoatID());
                sb.append(";");
                sb.append(oneBoat.getBoatName());
                sb.append(";");
                sb.append(oneBoat.getBoatType());
                sb.append(";");
                sb.append(oneBoat.getSeats());
                sb.append(";");
                sb.append(oneBoat.getChargingTime());
                sb.append(";");
                sb.append(oneBoat.getPrice());
                sb.append(";");
                sb.append(oneBoat.isAvailability());
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
        // Model model=Model.getInstance();
        try {
            scanIn=new Scanner(new BufferedReader(new FileReader(csvFile)));
            while(scanIn.hasNextLine()){
                inputLine=scanIn.nextLine();
                String[] inputArray=inputLine.split(";");
                Boat boat1=new Boat(inputArray[0],inputArray[1],inputArray[2],Integer.parseInt(inputArray[3]),
                        Integer.parseInt(inputArray[4]), Double.parseDouble(inputArray[5]), Boolean.parseBoolean(inputArray[6]));
                boats.add(boat1);
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public String findFreeBoat(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        String boatID = "";
        for (Boat boat : boats) {
            if (boat.isAvailability() && boat.getChargingTime() >= startDateTime.getHour() && boat.getChargingTime() <= endDateTime.getHour()) {
                boatID = boat.getBoatID();
                break;
            }
        }
        return boatID;
    }

}
