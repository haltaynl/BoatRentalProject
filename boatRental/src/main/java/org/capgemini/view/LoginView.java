package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.User;

import java.util.Scanner;

public class LoginView {
    static Scanner scan = new Scanner(System.in);

    public static void view() {
        System.out.println("***************************************************");
        System.out.println(" \u26F4 Welcome to MOLVENO HOTEL Boat Rental App \u26F4");
        System.out.println("***************************************************");
        String username = null;
        String password = null;
        boolean isAuthenticated = false;

        while (!isAuthenticated) {

            System.out.print("User Name: ");
            username = scan.next();
            System.out.print("Password: ");
            password = scan.next();

            User temp = UserControls.findUser(username, password);
            if (temp != null) {
                if (temp.getUserRole().equals("Admin")) {
                    AdminMainView.view();
                    isAuthenticated = true;
                } else if (temp.getUserRole().equals("Employee")) {
                    EmployeeMainView.view();
                    isAuthenticated = true;
                }
            }
        }


    }
}
