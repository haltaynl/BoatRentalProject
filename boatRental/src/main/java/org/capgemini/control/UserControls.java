package org.capgemini.control;
import org.capgemini.model.Customer;
import org.capgemini.model.Model;
import org.capgemini.model.User;
import org.capgemini.model.Users;

public class UserControls {
    public static User findUser(String username, String password) {
        Model model=Model.getInstance();
        for (User temporaryUser : model.getUsers().getUsers()) {
            if ((temporaryUser.getUserName().equals(username)) && (temporaryUser.getUserPassword().equals(password)))
                return temporaryUser;}
        System.out.println("The user is not found !!!");
        return null;
    }
    public static User findUser(String userID) {
        Model model=Model.getInstance();
        for (User temporaryUser : model.getUsers().getUsers()) {
            if ((temporaryUser.getUserID().equals(userID)))
                return temporaryUser;}
            System.out.println("The user is not found !!!");

        return null;
    }

    public static void addUser(User user) {
        Model model = Model.getInstance();
        model.getUsers().getUsers().add(user);
        model.getUsers().store();
    }

    public static void removeUser(User user) {
        Model model = Model.getInstance();
        model.getUsers().getUsers().remove(user);
        model.getUsers().store();
    }

    public static void listOfUser() {
        Model model=Model.getInstance();
        System.out.println();
        System.out.println("========\u26F4 USER LIST \u26F4=======");
        System.out.println("UserID      User Name     User Role");
        System.out.println("----------------------------------------");
        for(User u: model.getUsers().getUsers()){
            System.out.println(u.getUserID()+"              "+ u.getUserName()+"             "+u.getUserRole());
        }
        System.out.println("....End of user list....");

        }


}

