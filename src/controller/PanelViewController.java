package controller;

import dao.EmployeeDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Employee;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelViewController implements Initializable {

    /**
     * Intentar modularizar vistas.. de manera que sean independientes entre ellas..
     * permitiendo editarlas de manera separada y con codificación más limpia
     */

    @FXML
    private AnchorPane sales;

    @FXML
    private AnchorPane user;

    @FXML
    private AnchorPane customer;

    @FXML
    private Button salesBtn;

    @FXML
    private Button userBtn;

    @FXML
    private Button customerBtn;

    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> phoneColumn;

    private ObservableList<Employee> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        user.setVisible(false);
        chargeAllData();
    }

    public void chargeAllData () {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("idEmpleado")
        );

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );

        EmployeeDao employeeDao = new EmployeeDao();
        observableList = FXCollections.observableArrayList(employeeDao.readAll());
        employeeTableView.setItems(observableList);
    }

    @FXML
    void setSalesView(MouseEvent event) {
        if (event.getTarget() == salesBtn){
            sales.setVisible(true);
            user.setVisible(false);
            customer.setVisible(false);
        }
    }

    @FXML
    void setUserView(MouseEvent event) {

        if (event.getTarget() == userBtn){
            user.setVisible(true);
            sales.setVisible(false);
            customer.setVisible(false);
        }
    }

    @FXML
    void setCustomerView(MouseEvent event) {

        if (event.getTarget() == customerBtn){
            customer.setVisible(true);
            user.setVisible(false);
            sales.setVisible(false);

        }
    }

}
