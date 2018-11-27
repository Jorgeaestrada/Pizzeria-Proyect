package controller;

import dao.EmployeeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeViewController implements Initializable {

    @FXML
    private TableView<Employee> userTableView;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> phoneColumn;

    private ObservableList<Employee> observableList;

    @FXML
    private TextField userField;

    @FXML
    private TextField phoneField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        EmployeeDao employeeDao = new EmployeeDao();

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );

        observableList = FXCollections.observableArrayList(employeeDao.readAll());

        userTableView.setItems(observableList);

        userTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectedItem(newValue));

    }

    public void selectedItem(Employee employee){
        userField.setText(employee.getName());
        phoneField.setText(employee.getPhoneNumber());
    }

    @FXML
    void create(MouseEvent event) {
    }

    @FXML
    void delete(MouseEvent event) {

    }

    @FXML
    void update(MouseEvent event) {

    }
}
