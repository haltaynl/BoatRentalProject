package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.User;

import java.util.Scanner;

public class UpdateUserView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 UPDATE USER \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the userID of the user that will update");
        System.out.print("UserID: ");
        String userID = scanner.next();
        User old_user=UserControls.findUser(userID);
        if(old_user!=null) {
            System.out.println("Please enter all details of the user that will update");
            System.out.print("UserName: ");
            String userName = scanner.next();
            System.out.print("UserPassword: ");
            String userPassword = scanner.next();
            System.out.print("UserRole: ");
            String userRole = scanner.next();
            UserControls.removeUser(old_user);
            User updated_user = new User(userID, userName, userPassword, userRole);
            UserControls.addUser(updated_user);
            //System.out.println("The User is successfully updated!");

            // checking of wrong data

        }

    }
}
