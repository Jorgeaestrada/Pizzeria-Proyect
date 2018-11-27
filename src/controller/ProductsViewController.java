package controller;

import dao.ProductsDao;
import dao.TamanioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Order;
import model.Products;
import model.Tamanio;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsViewController implements Initializable {

    @FXML
    private TableView<Products> productTableView;

    @FXML
    private TableColumn<Products, Integer> idColumn;

    @FXML
    private TableColumn<Products, String> nameColumn;

    @FXML
    private TableColumn<Products, Integer> priceColumn;

    @FXML
    private TableColumn<Products, String> sizeColumn;

    private ObservableList<Products> observableList;

    private ObservableList<String> tamanioList;

    @FXML
    private TextField customerField;

    @FXML
    private TextField prizeField;

    @FXML
    private ChoiceBox<String> sizeMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProductsDao orderDao = new ProductsDao();
        TamanioDao tamanioDao = new TamanioDao();

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id_pizza")
        );
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );
        sizeColumn.setCellValueFactory(
                new PropertyValueFactory<>("size")
        );

        observableList = FXCollections.observableArrayList(orderDao.readAll());
        tamanioList = FXCollections.observableArrayList(tamanioDao.readAll());

        productTableView.setItems(observableList);
        sizeMenu.setItems(tamanioList);

        productTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectedItem(newValue));
    }

    public void selectedItem(Products products){
        customerField.setText(products.getName());
        prizeField.setText(String.valueOf(products.getPrice()));
        sizeMenu.setValue(products.getSize());
    }

    @FXML
    void create(MouseEvent event) {
        prizeField.getText();
        customerField.getText();
        sizeMenu.getSelectionModel().getSelectedItem();
    }

    @FXML
    void delete(MouseEvent event) {
        prizeField.getText();
        customerField.getText();
    }

    @FXML
    void update(MouseEvent event) {
        prizeField.getText();
        customerField.getText();
    }
}
