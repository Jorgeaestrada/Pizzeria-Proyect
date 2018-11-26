package controller;

import dao.CustomerDao;
import dao.OrderDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerSelectorController implements Initializable {

    @FXML
    private TableView<Customer> tableViewCustomer;

    @FXML
    private TableColumn<Customer, String> nameTableView;

    @FXML
    private TableColumn<Customer, Integer> phoneTableView;

    @FXML
    private TableColumn<Customer, String> addressTableView;

    private ObservableList<Customer> observableList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CustomerDao customerDao = new CustomerDao();

        nameTableView.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        phoneTableView.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );
        addressTableView.setCellValueFactory(
                new PropertyValueFactory<>("direccion")
        );

        observableList = FXCollections.observableArrayList(customerDao.readAll());

        tableViewCustomer.setItems(observableList);

        tableViewCustomer.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectedItem(newValue));
    }
    public void selectedItem(Customer customer){
    }
}
