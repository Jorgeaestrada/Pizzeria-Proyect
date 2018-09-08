package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * FULL TESTED CLASS!!
 */

public class Direccion {

    private SimpleIntegerProperty idAddress;
    private SimpleIntegerProperty street;
    private SimpleIntegerProperty numeration;
    private SimpleIntegerProperty crossing_1;
    private SimpleIntegerProperty crossing_2;
    private SimpleStringProperty colony;
    private SimpleIntegerProperty idClients;

    public Direccion(){};

    public Direccion(int idAddress, int street, int numeration, int crossing_1, int crossing_2,
                     String colony, int idClientes) {
        this.idAddress = new SimpleIntegerProperty(idAddress);
        this.street = new SimpleIntegerProperty(street);
        this.numeration = new SimpleIntegerProperty(numeration);
        this.crossing_1 = new SimpleIntegerProperty(crossing_1);
        this.crossing_2 = new SimpleIntegerProperty(crossing_2);
        this.colony = new SimpleStringProperty(colony);
        this.idClients = new SimpleIntegerProperty(idClientes);
    }

    @Override
    public String toString() {
        return "Calle " + street.get() +
                " #" + numeration.get() +
                " x " + crossing_1.get() +
                " y " + crossing_2.get() +
                " " + colony.get();
    }

    public int getIdAddress() {
        return idAddress.get();
    }

    public SimpleIntegerProperty idAddressProperty() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress.set(idAddress);
    }

    public int getStreet() {
        return street.get();
    }

    public SimpleIntegerProperty streetProperty() {
        return street;
    }

    public void setStreet(int street) {
        this.street.set(street);
    }

    public int getNumeration() {
        return numeration.get();
    }

    public SimpleIntegerProperty numerationProperty() {
        return numeration;
    }

    public void setNumeration(int numeration) {
        this.numeration.set(numeration);
    }

    public int getCrossing_1() {
        return crossing_1.get();
    }

    public SimpleIntegerProperty crossing_1Property() {
        return crossing_1;
    }

    public void setCrossing_1(int crossing_1) {
        this.crossing_1.set(crossing_1);
    }

    public int getCrossing_2() {
        return crossing_2.get();
    }

    public SimpleIntegerProperty crossing_2Property() {
        return crossing_2;
    }

    public void setCrossing_2(int crossing_2) {
        this.crossing_2.set(crossing_2);
    }

    public String getColony() {
        return colony.get();
    }

    public SimpleStringProperty colonyProperty() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony.set(colony);
    }

    public int getIdClients() {
        return idClients.get();
    }

    public SimpleIntegerProperty idClientsProperty() {
        return idClients;
    }

    public void setIdClients(int idClients) {
        this.idClients.set(idClients);
    }
}
