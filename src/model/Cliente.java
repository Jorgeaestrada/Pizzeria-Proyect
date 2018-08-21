package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//FULL TESTED CLASS
public class Cliente {

    private final SimpleIntegerProperty idCliente;
    private final SimpleStringProperty name;
    private final SimpleStringProperty phoneNumber;
    private Direccion direccion;

    public Cliente() {
        this.idCliente = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
        this.direccion = new Direccion();
    }

    public Cliente(int idCliente, String name, String phoneNumber, int idDireccion) {
        this.idCliente = new SimpleIntegerProperty(idCliente);
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.direccion = new Direccion();
    }

    public void setIdCliente(int idCliente) {
        this.idCliente.set(idCliente);

    }

    public int getIdCliente() {
        return idCliente.get();
    }

    public void setName(String name) {
        this.name.set(name);

    }

    public String getName() {
        return name.get();
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);

    }

    public String getphoneNumber() {
        return phoneNumber.get();
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

}
