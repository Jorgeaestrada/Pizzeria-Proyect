package controller;
//CLASE DEPURADA
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Empleado;
import dao.LoginDao;

//FULL TESTED CLASS
public class LoginViewController implements Initializable {
    

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    public void login(ActionEvent event) throws IOException {

        Empleado empleado = new Empleado();
        
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Panel.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        String username = usernameField.getText();
        String password = passwordField.getText();

        empleado.setUsername(username);
        empleado.setPassword(password);

        //si el formulario esta vacio
        if (!username.equals("") && !password.equals("")) {
            LoginDao loginDao = new LoginDao();

            if (loginDao.authenticate(empleado)) {

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
