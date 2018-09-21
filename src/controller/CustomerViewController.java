package controller;

import dao.CustomerDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FULL TESTED CLASS
 */

public class CustomerViewController implements Initializable {

    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, Integer> phoneColumn;

    @FXML
    private TableColumn<Customer, String> addressColumn;

    private ObservableList<Customer> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CustomerDao customerDAO = new CustomerDao();

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id_customer")
        );
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );
        addressColumn.setCellValueFactory(
                new PropertyValueFactory<>("direccion")
        );

        observableList = FXCollections.observableArrayList(customerDAO.readAll());

        customerTableView.setItems(observableList);
    }
}
