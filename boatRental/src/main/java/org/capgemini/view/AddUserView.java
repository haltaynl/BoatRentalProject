package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.User;

import java.util.Scanner;

public class AddUserView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 NEW USER \u26F4=======");
        System.out.println("Please enter the details of the user");
        System.out.print("UserRole: ");
        String userRole = scanner.nextLine();
        System.out.print("UserName: ");
        String userName = scanner.nextLine();
        while (true) {
            System.out.println("Please type a strong password " +
                    "(at least 1 number, 1 upper-case letter, 1 lower-case letter and " +
                    "1 special character ! @ # $ % &)");
            System.out.print("UserPassword: ");
            String userPassword = scanner.nextLine();
            if (isStrongPassword(userPassword)) {
                System.out.println("Your password is valid!");
                User user = new User(userName, userPassword, userRole);
                UserControls.addUser(user);
                System.out.println("New User is successfully added!");
                break;
            } else {
                System.out.println("Invalid password ! ");
            }
        }


    }

    public static boolean isStrongPassword(String password) {
        if (password.length() < 6) {
            return false;
        } else if (!password.matches(".*[A-Z].*")) {
            return false;
        } else if (!password.matches(".*[!@#$%&].*")) {
            return false;
        } else if (!password.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
}
