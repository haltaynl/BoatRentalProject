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
            BoatControls.removeBoat(oldBoat);
            System.out.println("The boat is deleted succesfully !!!");
        }

    }
}
