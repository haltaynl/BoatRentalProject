package org.capgemini.view;

import org.capgemini.control.UserControls;
import org.capgemini.model.Model;
import org.capgemini.model.User;
import java.util.Scanner;

public class UpdateUserView {
    public static void view() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("========⛴ UPDATE BOAT ⛴=======");
        System.out.println("Please enter the User Name of the boat that will update");
        System.out.print("User Name: ");
        String userName = scanner.nextLine();
        User update_user = UserControls.findUser(userName);
        if (update_user != null) {
            System.out.println();
            System.out.println("1. Update User Name");
            System.out.println("2. Update Password");
            System.out.println("3. Update Role");
            System.out.println("9. Exit");
            System.out.println();
            System.out.print("Please make a choice: ");
            switch (scanner.next()) {
                case "1":
                    scanner.nextLine();
                    System.out.print("New User Name: ");
                    String newUserName = scanner.nextLine();
                    update_user.setUserName(newUserName);
                    System.out.println("The User Name is Updated");
                    break;
                case "2":
                    scanner.nextLine();
                    System.out.print("New Password: ");
                    String newPassword = scanner.nextLine();
                    update_user.setUserPassword(newPassword);
                    System.out.println("The Password is Updated");
                    break;
                case "3":
                    scanner.nextLine();
                    System.out.print("Change Role: ");
                    String newRole = scanner.nextLine();
                    update_user.setUserRole(newRole);
                    System.out.println("The User Role is Updated");
                    break ;
                case "9":
                    Model model= Model.getInstance();
                    model.getUsers().store();
                    break ;

                default:
                    System.out.println("Invalid option");
                    break;
            }


        }
    }
}
