package controller;

import dao.CustomerDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Customer;
import model.Direccion;
import model.Products;

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
    private TableColumn<Direccion, String> addressColumn;

    private ObservableList<Customer> observableList;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField crossField2;

    @FXML
    private TextField crossField1;

    @FXML
    private TextField numField;

    @FXML
    private TextField colField;

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

        customerTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectedItem(newValue));
    }

    public void selectedItem(Customer customer){
        nameField.setText(customer.getName());
        phoneField.setText(String.valueOf(customer.getPhoneNumber()));
        streetField.setText(String.valueOf(customer.getDireccion().getStreet()));
        crossField1.setText(String.valueOf(customer.getDireccion().getCrossing_1()));
        crossField2.setText(String.valueOf(customer.getDireccion().getCrossing_2()));
        numField.setText(String.valueOf(customer.getDireccion().getNumeration()));
        colField.setText(customer.getDireccion().getColony());
    }

    @FXML
    void create(KeyEvent event) {

    }

    @FXML
    void delete(KeyEvent event) {

    }

    @FXML
    void update(KeyEvent event) {

    }
}
