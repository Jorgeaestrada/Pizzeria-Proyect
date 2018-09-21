package dao;

import controller.Conexion;
import interfaces.LoginInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Employee;

/**
 * PENDIENTE DE REVISIÓN!!
 */

public class LoginDao implements LoginInterface {

    private static final String SQL_READ = "SELECT * FROM Empleado WHERE usuario = ?";

    private static final Conexion conexion = Conexion.getInstance();

    @Override
    public boolean authenticate(Employee e) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            preparedStatement.setString(1, e.getUsername());

            resultSet = preparedStatement.executeQuery();
            System.out.println("Prueba");
            if (resultSet.next()) {

                if (e.getPassword().equals(resultSet.getString(3))) {

                    e.setIdEmpleado(resultSet.getInt(1));
                    e.setUsername(resultSet.getString(2));

                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
