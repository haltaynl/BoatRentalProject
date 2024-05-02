package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;


import java.util.Scanner;

public class DeleteBoatView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 DELETE BOAT \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the boatName of the boat that will delete");
        System.out.print("BoatName: ");
        String boatName = scanner.nextLine();
        Boat oldBoat= BoatControls.findBoat(boatName);
        if(oldBoat!=null) {
            System.out.print("Do you want to delete the bot? (Y/N)");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Deleting the bot...");
                BoatControls.removeBoat(oldBoat);
            } else if (response == 'N' || response == 'n') {
                System.out.println("Bot deletion cancelled.");
            } else {
                System.out.println("Invalid response. Please respond with 'Y' or 'N'.");
            }
            System.out.println("The Boat is deleted successfully !!!");
        }

    }
}
