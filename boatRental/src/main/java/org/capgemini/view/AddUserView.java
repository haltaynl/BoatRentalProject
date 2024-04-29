package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.User;

import java.util.Scanner;

public class AddUserView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 NEW USER \u26F4=======");
        System.out.println("Please enter all details of the user");
        System.out.print("UserID: ");
        String userID = scanner.next();
        scanner.nextLine();
        System.out.print("UserName: ");
        String userName = scanner.nextLine();
        System.out.print("UserPassword: ");
        String userPassword = scanner.next();
        System.out.print("UserRole: ");
        String userRole = scanner.next();
        // checking of wrong data

        User user = new User(userID, userName, userPassword, userRole);
        UserControls.addUser(user);
        System.out.println("New User is successfully added!");


    }
}
