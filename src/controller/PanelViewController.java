package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PanelViewController implements Initializable {

    /**
     * --> CARGAR TODA LA INFORMACIÓN ANTES DE INICIAR LA APP
     */

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button salesBtn;

    @FXML
    private Button userBtn;

    @FXML
    private Button customerBtn;

    @FXML
    private Button productBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Order.fxml"));
        try {
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setSalesView(MouseEvent event) {
        if (event.getTarget() == salesBtn){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Order.fxml"));
            try {
                borderPane.setCenter(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void setUserView(MouseEvent event) {
        if (event.getTarget() == userBtn){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/User.fxml"));
        try {
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    @FXML
    void setCustomerView(MouseEvent event) {
        if (event.getTarget() == customerBtn){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Customer.fxml"));
        try {
            borderPane.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    @FXML
    void setProductView(MouseEvent event) {
        if (event.getTarget() == productBtn){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Products.fxml"));
            try {
                borderPane.setCenter(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
