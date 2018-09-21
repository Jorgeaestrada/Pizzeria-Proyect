package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Products {

    private SimpleIntegerProperty id_pizza;
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleStringProperty size;

    public Products(int id_pizza, String name, int price, String size) {
        this.id_pizza = new SimpleIntegerProperty(id_pizza);
        this.name= new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.size = new SimpleStringProperty(size);
    }

    public int getId_pizza() {
        return id_pizza.get();
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza.set(id_pizza);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }
}
