package controller;

import dao.OrderDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import model.Order;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class OrderViewController implements Initializable {

    @FXML
    private TableView<Order> orderTableView;

    @FXML
    private TableColumn<Order, Integer> idTableColumn;

    @FXML
    private TableColumn<Order, String> orderTableColumn;

    @FXML
    private TableColumn<Order, String> customerTableColumn;

    @FXML
    private TableColumn<Order, Integer> priceTableColumn;

    @FXML
    private TableColumn<Order, String> dateTableColumn;

    private ObservableList<Order> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrderDao orderDao = new OrderDao();

        idTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("orderId")
        );

        orderTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("deliver")
        );
        customerTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("customer")
        );
        priceTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );
        dateTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );
        observableList = FXCollections.observableArrayList(orderDao.readAll());

        orderTableView.setItems(observableList);

        orderTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectedItem(newValue));

    }

    public void selectedItem(Order order){
    }

}
