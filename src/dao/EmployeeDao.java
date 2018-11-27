package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.Customer;
import model.Employee;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements CRUDInterface<Employee> {

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_CREATE = "INSERT INTO Empleado " +
            "(usuario, contrasenia, nom_empleado, tel_empleado, estado)" +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_READ_ALL = "SELECT * FROM Empleado; ";

    @Override
    public boolean create(Employee c) {
        try {
            PreparedStatement statement = conexion.getConnection().prepareStatement(SQL_CREATE);
            //statement.setInt(1, 3);
            statement.setString(1, "admin");
            statement.setString(2, "admin");
            statement.setString(3, c.getName());
            statement.setString(4, c.getPhoneNumber());
            statement.setInt(5, 1);

            if (statement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Ha habido un problema," +
                        " contacte al administrador");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee read(Object key) {
        return null;
    }

    @Override
    public boolean update(Employee c) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public List<Employee> readAll() {

        List<Employee> employeeList = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //int idUser = resultSet.getInt(1);
                //String username = resultSet.getString(2);
                //String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String phoneNumber = resultSet.getString(5);
                //int userStatus = resultSet.getInt(6);

                Employee employee = new Employee();
                employee.setName(name);
                employee.setPhoneNumber(phoneNumber);

                employeeList.add(employee);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return employeeList;

    }
}
