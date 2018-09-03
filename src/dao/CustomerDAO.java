package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.Customer;
import model.Direccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PENDIENTE DE REVISIÓN!!
 */

public class CustomerDAO implements CRUDInterface<Customer> {

    private static final String SQL_READ_ALL = "SELECT * FROM Clientes";

    private static final Conexion conexion = Conexion.getInstance();


    @Override
    public boolean create(Customer c) {
        return false;
    }

    @Override
    public Customer read(Object key) {
    return null;
    }

    @Override
    public boolean update(Customer c) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public List<Customer> readAll() {

        List<Customer> customer = new ArrayList<>();

        Direccion direccion = new Direccion();
        DireccionDao direccionDao = new DireccionDao();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_cliente = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String cellphone = resultSet.getString(3);

                //Obtiene la dirección del cliente actual
                direccion = direccionDao.read(id_cliente);

                Customer customerList = new Customer(id_cliente, name, cellphone, direccion);
                customer.add(customerList);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return customer;
    }
}
