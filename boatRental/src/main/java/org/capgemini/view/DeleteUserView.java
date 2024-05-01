package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.User;

import java.util.Scanner;

public class DeleteUserView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========\u26F4 DELETE USER \u26F4=======");
        System.out.println("________________________________");
        System.out.println("Please enter the UserName of the user that will delete");
        System.out.print("User Name: ");
        String userName = scanner.nextLine();
        User old_user= UserControls.findUser(userName);
        if(old_user!=null) {
            UserControls.removeUser(old_user);
            System.out.println("The User is deleted! ");
        }

    }
}
