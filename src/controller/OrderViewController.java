package controller;

import dao.CustomerDao;
import dao.OrderDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Customer;
import model.Order;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button addPizzaBtn;

    @FXML
    private JTextField customerField;

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

    @FXML
    void addCustomer(MouseEvent event) throws IOException {
        if (event.getTarget() == addCustomerBtn){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/CustomerSelector.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node)event.getSource()).getScene().getWindow()
            );
            stage.show();
        }
    }

    @FXML
    void addPizza(MouseEvent event) throws IOException {
        if (event.getTarget() == addPizzaBtn){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/PizzaSelector.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
                    ((Node)event.getSource()).getScene().getWindow()
            );
            stage.show();
        }
    }

    @FXML
    void confirm(MouseEvent event) {

    }

}
