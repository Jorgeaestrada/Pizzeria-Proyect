package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.Customer;
import model.Direccion;
import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *PENDIENTE DE REVISIÓN!!
 */


public class EmployeeDao implements CRUDInterface<Employee> {

    private static final String SQL_READ_ALL = "SELECT * FROM Empleado";

    private static final Conexion conexion = Conexion.getInstance();
    @Override
    public boolean create(Employee c) {
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


        List<Employee> employee = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_empleado = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password= resultSet.getString(3);
                String employee_name = resultSet.getString(4);
                String cellphone = resultSet.getString(5);
                Employee employeeList = new Employee(id_empleado, username, password, employee_name, cellphone);
                employee.add(employeeList);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return employee;
    }
}
