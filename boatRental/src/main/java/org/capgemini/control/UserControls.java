package org.capgemini.control;

import org.capgemini.model.*;

public class UserControls {
    public static User findUser(String username, String password) {
        Model model=Model.getInstance();
        for (User temporaryUser : model.getUsers().getUsers()) {
            if ((temporaryUser.getUserName().equals(username)) && (temporaryUser.getUserPassword().equals(password)))
                return temporaryUser;}
        System.out.println("The user or the password is wrong !!!");
        System.out.println(" ");
        return null;
    }
    public static User findUser(String userName) {
        Model model=Model.getInstance();
        for (User temporaryUser : model.getUsers().getUsers()) {
            if ((temporaryUser.getUserName().equals(userName)))
                return temporaryUser;}
        return null;
    }

    public static void addUser(User user) {
        Model model = Model.getInstance();
        model.getUsers().getUsers().add(user);
        Users.store();
    }

    public static void removeUser(User user) {
        Model model = Model.getInstance();
        model.getUsers().getUsers().remove(user);
        model.getUsers().store();
    }

    public static void listOfUser() {
        Model model=Model.getInstance();
        System.out.println();
        System.out.println("======== USER LIST =======");
        System.out.println("--------------------------");
        System.out.println(String.format("%-15s %-15s", " Name", " Role"));
        for (User u : model.getUsers().getUsers()) {
            System.out.println(String.format("%-15s %-15s", u.getUserName(), u.getUserRole()));
        }
        System.out.println("......End of user list......");
    }

}

