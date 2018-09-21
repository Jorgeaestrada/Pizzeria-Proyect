package controller;

import dao.ProductsDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Order;
import model.Products;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProductsDao orderDao = new ProductsDao();

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

        productTableView.setItems(observableList);
    }
}
