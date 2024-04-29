package org.capgemini.view;

import org.capgemini.control.BoatControls;

import java.util.Scanner;

public class BoatView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        MAIN_LOOP:
        while (true) {
            System.out.println();
            System.out.println("========\u26F4 BOAT MENU \u26F4=======");
            System.out.println("1. Add Boat");
            System.out.println("2. Boats List");
            System.out.println("3. Update Boat");
            System.out.println("4. Delete Boat");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");

            switch (scanner.next()) {
                case "1":
                    AddBoatView.view();
                    break;
                case "2":
                    BoatControls.listOfBoats();
                    break;
                case "3":
                    UpdateBoatView.view();
                    break;
                case "4":
                    DeleteBoatView.view();
                    break;
                case "9":
                    break MAIN_LOOP;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}

