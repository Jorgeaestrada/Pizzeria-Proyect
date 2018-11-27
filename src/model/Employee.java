package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * FULL TESTED CLASS!!
 */

public class Employee {

    private SimpleIntegerProperty idEmpleado;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private SimpleIntegerProperty status;

    public Employee(int idUser, String username, String password, String name,
                String phoneNumber, int status) {
        this.idEmpleado = new SimpleIntegerProperty(idUser);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty(name) ;
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.status = new SimpleIntegerProperty(status);
    }

    public Employee() {
        this.idEmpleado = new SimpleIntegerProperty(0);
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
    }


    public int getIdUser() {
        return idEmpleado.get();
    }

    public void setIdUser(int idUser) {
        this.idEmpleado.set(idUser);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public int getStatus() {
        return status.get();
    }

    public void setStatus(int status) {
        this.status.set(status);
    }

    @Override
    public String toString() {
        return "model.Empleado{" + "idEmpleado=" + idEmpleado + ", username=" + username + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }

}
