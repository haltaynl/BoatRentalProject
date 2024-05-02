package org.capgemini.view;

import org.capgemini.control.BoatControls;
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
            System.out.print("Do you want to delete the bot? (Y/N)");
            char response = scanner.next().charAt(0);
            if (response == 'Y' || response == 'y') {
                System.out.println("Deleting the bot...");
                UserControls.removeUser(old_user);
            } else if (response == 'N' || response == 'n') {
                System.out.println("Bot deletion cancelled.");
            } else {
                System.out.println("Invalid response. Please respond with 'Y' or 'N'.");
            }
            System.out.println("The User is deleted successfully !!!");

        }

    }
}
