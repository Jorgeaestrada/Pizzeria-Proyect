package model;

import javafx.beans.property.SimpleStringProperty;

public class Tamanio {

    private SimpleStringProperty tamanio;

    public Tamanio(String tamanio) {
        this.tamanio = new SimpleStringProperty(tamanio);
    }

    public String getTamanio() {
        return tamanio.get();
    }

    public SimpleStringProperty tamanioProperty() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio.set(tamanio);
    }
}
