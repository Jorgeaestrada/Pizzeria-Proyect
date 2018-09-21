package controller;

import dao.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> phoneColumn;

    private ObservableList<User> observableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        UserDao userDao = new UserDao();

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("idUser")
        );
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );

        observableList = FXCollections.observableArrayList(userDao.readAll());

        userTableView.setItems(observableList);

    }
}
