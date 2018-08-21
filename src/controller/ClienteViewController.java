package controller;

import dao.ClienteDao;
import dao.DireccionDao;
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
import model.Cliente;
import model.Direccion;

//FULL TESTED CLASS----------------------------------------------------------------------
public class ClienteViewController implements Initializable {

    @FXML
    private TableView<Cliente> tableView;
    @FXML
    private TableColumn<Cliente, Integer> idColumn;
    @FXML
    private TableColumn<Cliente, String> nameColumn;
    @FXML
    private TableColumn<Cliente, String> phoneColumn;
    @FXML
    private TableColumn<Cliente, String> addressColumn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField numField;
    @FXML
    private TextField crossField_1;
    @FXML
    private TextField crossField_2;
    @FXML
    private TextField colonyField;
    @FXML
    private TextField phoneField;

    private ObservableList<Cliente> observableArrayList;

    private int tableViewIndex;

    private int clientId;
    private int addressId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTableView();

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                nameField.setText(newSelection.getName());
                phoneField.setText(newSelection.getphoneNumber());
                streetField.setText(Integer.toString(newSelection.getDireccion().getStreet()));
                numField.setText(Integer.toString(newSelection.getDireccion().getHouseNumber()));
                crossField_1.setText(Integer.toString(newSelection.getDireccion().getCrossing1()));
                crossField_2.setText(Integer.toString(newSelection.getDireccion().getCrossing2()));
                colonyField.setText(newSelection.getDireccion().getColony());

                clientId = newSelection.getIdCliente();
                addressId = newSelection.getDireccion().getIdDireccion();

                System.out.println("" + clientId);
                System.out.println("" + addressId);

            }
        });

    }

    public void initializeTableView() {

        ClienteDao clienteDao = new ClienteDao();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        observableArrayList = FXCollections.observableArrayList(clienteDao.readAll());
        tableView.setItems(observableArrayList);
    }

    @FXML
    void createUser(ActionEvent event) {

        Cliente cliente = new Cliente();
        Direccion direccion = new Direccion();

        ClienteDao clienteDao = new ClienteDao();
        DireccionDao direccionDao = new DireccionDao();

        cliente.setName(nameField.getText());
        cliente.setphoneNumber(phoneField.getText());

        clienteDao.create(cliente);

        clientId = clienteDao.getGeneratedId();

        cliente.setIdCliente(clientId);

        direccion.setStreet(Integer.parseInt(streetField.getText()));
        direccion.setHouseNumber(Integer.parseInt(numField.getText()));
        direccion.setCrossing1(Integer.parseInt(crossField_1.getText()));
        direccion.setCrossing2(Integer.parseInt(crossField_2.getText()));
        direccion.setColony(colonyField.getText());
        direccion.setIdCliente(clientId);

        direccionDao.create(direccion);

        addressId = direccionDao.getGeneratedId();

        direccion.setIdDireccion(addressId);

        cliente.setDireccion(direccion);

        observableArrayList.add(cliente);

        System.out.println("Creando...");
        System.out.println("index empleado:   " + clientId);
        System.out.println("index direccion:   " + addressId);
        System.out.println("index lista:   " + tableViewIndex);

    }

    @FXML
    void updateUser(ActionEvent event) {

        Cliente cliente = tableView.getSelectionModel().getSelectedItem();
        int tableViewIndex = tableView.getSelectionModel().getSelectedIndex();
        
        Direccion direccion = new Direccion();

        ClienteDao clienteDao = new ClienteDao();
        DireccionDao direccionDao = new DireccionDao();

        cliente.setIdCliente(cliente.getIdCliente());
        cliente.setName(nameField.getText());
        cliente.setphoneNumber(phoneField.getText());

        clienteDao.update(cliente);

        direccion.setIdDireccion(cliente.getDireccion().getIdDireccion());
        direccion.setStreet(Integer.parseInt(streetField.getText()));
        direccion.setHouseNumber(Integer.parseInt(numField.getText()));
        direccion.setCrossing1(Integer.parseInt(crossField_1.getText()));
        direccion.setCrossing2(Integer.parseInt(crossField_2.getText()));
        direccion.setColony(colonyField.getText());
        direccion.setIdCliente(cliente.getIdCliente());
        
        cliente.setDireccion(direccion);

        direccionDao.update(direccion);

        observableArrayList.set(tableViewIndex, cliente);

        System.out.println("Creando...");
        System.out.println("index empleado:   " + clientId);
        System.out.println("index direccion:   " + addressId);
        System.out.println("index lista:   " + tableViewIndex);

    }

    @FXML
    void deleteUser(ActionEvent event) {

        ClienteDao clienteDao = new ClienteDao();
        DireccionDao direccionDao = new DireccionDao();

        Cliente cliente = tableView.getSelectionModel().getSelectedItem();
        int tableViewIndex = tableView.getSelectionModel().getSelectedIndex();

        clienteDao.delete(cliente.getIdCliente());
        direccionDao.delete(cliente.getDireccion().getIdDireccion());

        System.out.println("Borrando...");
        System.out.println("index cliente:   " + cliente.getIdCliente());
        System.out.println("index direccion:   " + cliente.getDireccion().getIdDireccion());
        System.out.println("index lista:   " + tableViewIndex);

        observableArrayList.remove(cliente);

    }

    @FXML
    void cleanComponents(ActionEvent event) {
        nameField.setText("");
        streetField.setText("");
        numField.setText("");
        crossField_1.setText("");
        crossField_2.setText("");
        colonyField.setText("");
        phoneField.setText("");
    }
}
