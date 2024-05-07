package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.User;

import java.io.Console;
import java.util.Scanner;

public class LoginView {
    static Scanner scan = new Scanner(System.in);

    public static void view() {
        System.out.println("**********************************************************");
        System.out.println("**** Welcome to MOLVENO HOTEL Boat Rental Application ****");
        System.out.println("**********************************************************");
        String userName = null;
        String password = null;
        boolean isAuthenticated = false;
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
            return;
        }

        while (!isAuthenticated) {
//            System.out.print("User Name: ");
//            username = scan.next();
//            System.out.print("Password: ");
//            password = scan.next();
            userName = console.readLine("Enter username: ");
            char[] passwordArray = console.readPassword("Enter password: ");
            password = new String(passwordArray);
            User temp = UserControls.findUser(userName, password);
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
