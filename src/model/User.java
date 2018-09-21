package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

    private SimpleIntegerProperty idUser;
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private SimpleIntegerProperty status;

    public User(int idUser, String username, String password, String name,
                String phoneNumber, int status) {
        this.idUser = new SimpleIntegerProperty(idUser);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty(name) ;
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.status = new SimpleIntegerProperty(status);
    }

    public User(int idUser, String name, String phoneNumber){
        this.idUser = new SimpleIntegerProperty(idUser);
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public int getIdUser() {
        return idUser.get();
    }

    public void setIdUser(int idUser) {
        this.idUser.set(idUser);
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
}
