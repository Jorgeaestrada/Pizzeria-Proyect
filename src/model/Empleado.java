package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//FULL TESTED CLASS
public class Empleado {

    private SimpleIntegerProperty idEmpleado;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;

    public Empleado() {
        this.idEmpleado = new SimpleIntegerProperty(0);
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
    }

    public Empleado(int idEmpleado, String username, String password, String name,
            String phoneNumber) {
        this.idEmpleado = new SimpleIntegerProperty(idEmpleado);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado.set(idEmpleado);
    }

    public int getIdEmpleado() {
        return idEmpleado.get();
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

    public void setName(String name) {
        this.name.set(name); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name.get(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPhoneNumber() {
        return phoneNumber.get(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", username=" + username + ", password=" + password + ", name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }

}
