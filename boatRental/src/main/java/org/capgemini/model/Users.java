package org.capgemini.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import java.io.FileWriter;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Users {
    ArrayList<User> users = new ArrayList<User>();
    public static String csvFile = "boatRental/src/main/resources/Users.csv";

    public void setUsers(ArrayList<User> userList) {
        users = userList;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public static void store() {
        Model model=Model.getInstance();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // ArrayList içindeki verileri CSV dosyasına yazdırma
            StringBuilder sb = new StringBuilder();
            for (User oneUser : model.getUsers().getUsers()) {

                sb.append(oneUser.getUserID());
                sb.append(";");
                sb.append(oneUser.getUserName());
                sb.append(";");
                sb.append(oneUser.getUserPassword());
                sb.append(";");
                sb.append(oneUser.getUserRole());
                sb.append("\n");
                }

                writer.write(sb.toString());

        } catch (IOException e) {
            System.err.println("CSV dosyasına yazma hatası: " + e.getMessage());
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
                User user1=new User(inputArray[0],inputArray[1],inputArray[2],inputArray[3]);
                users.add(user1);
        }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



        }






