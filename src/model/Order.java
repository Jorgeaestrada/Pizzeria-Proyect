package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {

    private SimpleStringProperty customer;
    private SimpleStringProperty deliver;
    private SimpleIntegerProperty price;
    private SimpleStringProperty date;

    public Order(String customer, String deliver, int price, String date) {
        this.customer = new SimpleStringProperty(customer);
        this.deliver = new SimpleStringProperty(deliver);
        this.price = new SimpleIntegerProperty(price);
        this.date = new SimpleStringProperty(date);
    }

    public String getCustomer() {
        return customer.get();
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

    public String getDeliver() {
        return deliver.get();
    }

    public void setDeliver(String deliver) {
        this.deliver.set(deliver);
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
