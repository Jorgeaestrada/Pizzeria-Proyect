package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Employee;
import dao.LoginDao;

/**
 * PENDIENTE DE REVISIÓN!!
 */

public class LoginViewController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    public void login(MouseEvent event) throws IOException {

        Employee employee = new Employee();

        Parent parent = FXMLLoader.load(getClass().getResource("/view/Panel.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        String username = usernameField.getText();
        String password = passwordField.getText();

        //si el formulario esta vacio
        if (!username.equals("") && !password.equals("")) {
            LoginDao loginDao = new LoginDao();

            employee.setUsername(username);
            employee.setPassword(password);

            if (loginDao.authenticate(employee)) {

                //Si el usuario existe
                //Cargar vista principal
                stage.hide(); //optional
                stage.setScene(scene);
                stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Inicio de sesión fallido");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public String getUsernameField() {
        return usernameField.getText();
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
