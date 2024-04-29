package org.capgemini.model;

public class Model {
    private Users users = new Users();
    private Boats boats = new Boats();
    private Customers customers = new Customers();
    private Reservations reservations = new Reservations();

    private static Model model;

    public Users getUsers() {
        return users;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Boats getBoats() {
        return boats;
    }

    public void setBoats(Boats boats) {
        this.boats = boats;
    }

    public Reservations getReservations() {
        return reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }

    public static Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    private Model() {
        users.load();
        boats.load();
        customers.load();
    }
}
