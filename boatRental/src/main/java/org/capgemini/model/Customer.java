package org.capgemini.model;

public class Customer {
    private String customerID;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerRoomNumber;

    public Customer(String customerName, String customerPhone, String customerEmail,  String customerRoomNumber) {
        long timestamp = System.currentTimeMillis() % 10000;
        this.customerID ="MHC-" + String.format("%04d", timestamp);
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerRoomNumber = customerRoomNumber;
    }
    public Customer(String customerID, String customerName, String customerPhone, String customerEmail, String customerRoomNumber) {
        this.customerID =customerID;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerRoomNumber = customerRoomNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerRoomNumber() {
        return customerRoomNumber;
    }

    public void setCustomerRoomNumber(String customerRoomNumber) {
        this.customerRoomNumber = customerRoomNumber;
    }
}
