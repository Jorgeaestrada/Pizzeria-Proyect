package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//FULL TESTED CLASS
public class Direccion {

    private final SimpleIntegerProperty idDireccion;
    private final SimpleIntegerProperty street;
    private final SimpleIntegerProperty houseNumber;
    private final SimpleIntegerProperty crossing_1;
    private final SimpleIntegerProperty crossing_2;
    private final SimpleStringProperty colony;
    private final SimpleIntegerProperty idCliente;

    public Direccion() {
        this.idDireccion = new SimpleIntegerProperty(0);
        this.street = new SimpleIntegerProperty(0);
        this.houseNumber = new SimpleIntegerProperty(0);
        this.crossing_1 = new SimpleIntegerProperty(0);
        this.crossing_2 = new SimpleIntegerProperty(0);
        this.colony = new SimpleStringProperty("");
        this.idCliente = new SimpleIntegerProperty(0);
    }

    public Direccion(int idDireccion, int street, int houseNumber, int crossing_1, int crossing_2, String colony, int idCliente) {
        this.idDireccion = new SimpleIntegerProperty(idDireccion);
        this.street = new SimpleIntegerProperty(street);
        this.houseNumber = new SimpleIntegerProperty(houseNumber);
        this.crossing_1 = new SimpleIntegerProperty(crossing_1);
        this.crossing_2 = new SimpleIntegerProperty(crossing_2);
        this.colony = new SimpleStringProperty(colony);
        this.idCliente = new SimpleIntegerProperty(idCliente);
    }

    @Override
    public String toString() {
        return "Calle   " + getStreet() + "   #" + getHouseNumber() + "   x   " + getCrossing1() + "   y   "
                + getCrossing2() + "  " + getColony();
    }

    public int getIdDireccion() {
        return idDireccion.get();
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion.set(idDireccion);
    }

    public int getStreet() {
        return street.get();
    }

    public void setStreet(int street) {
        this.street.set(street);
    }

    public int getHouseNumber() {
        return houseNumber.get();
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public int getCrossing1() {
        return crossing_1.get();
    }

    public void setCrossing1(int crossing_1) {
        this.crossing_1.set(crossing_1);
    }

    public int getCrossing2() {
        return crossing_2.get();
    }

    public void setCrossing2(int crossing_2) {
        this.crossing_2.set(crossing_2);
    }

    public String getColony() {
        return colony.get();
    }

    public void setColony(String colony) {
        this.colony.set(colony);
    }
    
    public int getIdCliente() {
        return idCliente.get();
    }

    public void setIdCliente(int idCliente) {
        this.idCliente.set(idCliente);
    }

}
