package controller;

import dao.EmpleadoDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Empleado;

//FULL TESTED CLASS----------------------------------------------------------------------
public class EmpleadoViewController implements Initializable {

    @FXML
    private TableView<Empleado> tableView;
    @FXML
    private TableColumn<Empleado, Integer> idColumn;
    @FXML
    private TableColumn<Empleado, String> usernameColumn;
    @FXML
    private TableColumn<Empleado, String> passwordColumn;
    @FXML
    private TableColumn<Empleado, String> nameColumn;
    @FXML
    private TableColumn<Empleado, String> phoneColumn;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField nameField;

    private ObservableList<Empleado> observableArrayList;

    private int tableViewIndex;
    private int employeeIndex;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTableView();

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nameField.setText(newSelection.getName());
                passwordField.setText(newSelection.getPassword());
                phoneField.setText(newSelection.getPhoneNumber());
                usernameField.setText(newSelection.getUsername());
            }
        });

    }

    public void initializeTableView() {

        EmpleadoDao empleadoDao = new EmpleadoDao();

        idColumn.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("idEmpleado"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("password"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("phoneNumber"));

        observableArrayList = FXCollections.observableArrayList(empleadoDao.readAll());
        tableView.setItems(observableArrayList);
    }

    @FXML
    void createUser(ActionEvent event) {

        System.out.println("Creando...");
        System.out.println("index empleado:   " + employeeIndex);
        System.out.println("index lista:   " + tableViewIndex);

        Empleado empleado = new Empleado();
        EmpleadoDao empleadoDao = new EmpleadoDao();

        empleado.setName(nameField.getText());
        empleado.setPhoneNumber(phoneField.getText());
        empleado.setUsername(usernameField.getText());
        empleado.setPassword(passwordField.getText());

        empleadoDao.create(empleado);

        empleado.setIdEmpleado(empleadoDao.getGeneratedId());

        observableArrayList.add(empleado);
    }

    @FXML
    void updateUser(ActionEvent event) {

        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = tableView.getSelectionModel().getSelectedItem();
        int tableViewIndex = tableView.getSelectionModel().getSelectedIndex();

        empleado.setIdEmpleado(empleado.getIdEmpleado());
        empleado.setName(nameField.getText());
        empleado.setPassword(passwordField.getText());
        empleado.setPhoneNumber(phoneField.getText());
        empleado.setUsername(usernameField.getText());

        observableArrayList.set(tableViewIndex, empleado);
        empleadoDao.update(empleado);
    }

    @FXML
    void deleteUser(ActionEvent event) {

        EmpleadoDao empleadoDao = new EmpleadoDao();
        Empleado empleado = tableView.getSelectionModel().getSelectedItem();
        int tableViewIndex = tableView.getSelectionModel().getSelectedIndex();

        System.out.println("Borrando...");
        System.out.println("index empleado:   " + empleado.getIdEmpleado());
        System.out.println("index lista:   " + tableViewIndex);

        observableArrayList.remove(empleado);
        empleadoDao.delete(empleado.getIdEmpleado());

    }

    @FXML
    void cleanComponents(ActionEvent event) {
        phoneField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        nameField.setText("");
    }

}
