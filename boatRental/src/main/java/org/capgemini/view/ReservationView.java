package org.capgemini.view;
import java.util.Scanner;
public class ReservationView {
    public static void view() {
        System.out.println("RESERVATION MENU");
        System.out.println("==========");
        System.out.println("1. New Reservation");
        System.out.println("2. Reservation List");
        System.out.println("3. Update Reservation");
        System.out.println("4. Delete Reservation");
        System.out.println("5. Cancel Reservation");
        System.out.println("9. Exit");
        System.out.println();

        MAIN_LOOP:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1":
                    AddReservationView.view();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    //ListAllBooksView.view();
                case "9":
                    break MAIN_LOOP;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
