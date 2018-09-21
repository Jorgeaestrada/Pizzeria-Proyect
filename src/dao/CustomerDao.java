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

public class CustomerDao implements CRUDInterface<Customer> {

    private static final String SQL_READ_ALL = "SELECT c.id_cliente, " +
            "c.nom_cliente, " +
            "c.tel_cliente, " +
            "d.id_direccion, " +
            "d.calle, d.numeracion, " +
            "d.cruzamiento_1, " +
            "d.cruzamiento_2, " +
            "d.colonia, " +
            "d.id_cliente " +
            "FROM Clientes c " +
            "JOIN Direccion d " +
            "USING (id_cliente)";

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

        List<Customer> customerList = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_customer = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String cellphone = resultSet.getString(3);
                int id_address = resultSet.getInt(4);
                int street = resultSet.getInt(5);
                int numeration = resultSet.getInt(6);
                int crossing_1 = resultSet.getInt(7);
                int crossing_2 = resultSet.getInt(8);
                String colony = resultSet.getString(9);

                Direccion direccion =  new Direccion(id_address, street, numeration,
                        crossing_1, crossing_2, colony, id_customer);

                Customer customer = new Customer(id_customer, name, cellphone, direccion.toString());

                customerList.add(customer);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return customerList;
    }
}
