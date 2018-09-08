package controller;

import dao.CustomerDAO;
import dao.OrderDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderViewController implements Initializable {

    @FXML
    private TableView<Order> mainTableView;

    @FXML
    private TableColumn<Order, String> orderTableView;

    @FXML
    private TableColumn<Order, String> customerTableView;

    @FXML
    private TableColumn<Order, Integer> priceTableView;

    @FXML
    private TableColumn<Order, String> dateTableView;

    private ObservableList<Order> observableList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderDao orderDao = new OrderDao();

        orderTableView.setCellValueFactory(
                new PropertyValueFactory<>("deliver")
        );
        customerTableView.setCellValueFactory(
                new PropertyValueFactory<>("customer")
        );
        priceTableView.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );
        dateTableView.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        observableList = FXCollections.observableArrayList(orderDao.readAll());

        mainTableView.setItems(observableList);
    }
}
