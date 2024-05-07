package org.capgemini.view;

import org.capgemini.control.UserControls;
import java.util.Scanner;

public class UserView {
    public static void view() {
        MAIN_LOOP:
        while (true) {
            System.out.println();
            System.out.println("===== USER MENU =====");
            System.out.println("1. Add User");
            System.out.println("2. User List");
            System.out.println("3. Update User");
            System.out.println("4. Delete Users");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1":
                    AddUserView.view();
                    break;
                case "2":
                    UserControls.listOfUser();
                    break;
                case "3":
                    UpdateUserView.view();
                    break;
                case "4":
                    DeleteUserView.view();
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
