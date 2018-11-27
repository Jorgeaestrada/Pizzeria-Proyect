package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * FULL TESTED CLASS!!
 */

public class Customer {

    private SimpleIntegerProperty id_customer;
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private Direccion direccion;

    public Customer (){}

    public Customer(int id_customer, String name, String phoneNumber, Direccion direccion) {
        this.id_customer = new SimpleIntegerProperty(id_customer);
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.direccion = direccion;
    }

    public int getId_customer() {
        return id_customer.get();
    }

    public SimpleIntegerProperty id_customerProperty() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer.set(id_customer);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
