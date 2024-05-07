package org.capgemini.view;

import org.capgemini.control.BoatControls;
import org.capgemini.model.Boat;


import java.util.Scanner;

public class DeleteBoatView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("======== DELETE BOAT =======");
        System.out.println("Please enter the boatName of the boat that will delete");
        while(true){
        System.out.print("BoatName: ");
        String boatName = scanner.nextLine();
        Boat oldBoat= BoatControls.findBoat(boatName);
        if(oldBoat!=null) {
            System.out.print("Do you want to delete the boat? (Y/N) ");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Deleting the boat...");
                BoatControls.removeBoat(oldBoat);
                System.out.println("The Boat is deleted successfully !!!");
            } else if (response == 'N' || response == 'n') {
                System.out.println("Boat deletion is cancelled.");
            } else {
                System.out.println("Invalid response. Please respond with 'Y' or 'N'.");
            }
            break;
        }
        }

    }
}
