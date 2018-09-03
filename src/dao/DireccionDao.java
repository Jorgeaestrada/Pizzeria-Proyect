package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.Direccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * PENDIENTE DE REVISION!!
 */

public class DireccionDao implements CRUDInterface<Direccion> {

    private static final String SQL_READ = "SELECT * FROM Direccion WHERE id_cliente = ?";

    private final String SQL_READ_ALL = "SELECT * FROM Direccion";

    private static final Conexion conexion = Conexion.getInstance();

    @Override
    public boolean create(Direccion c) {
        return false;
    }

    @Override
    public Direccion read(Object key) {

        Direccion direccion = new Direccion();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_direccion = resultSet.getInt(1);
                int street = resultSet.getInt(2);
                int  numeration = resultSet.getInt(3);
                int  crossing_1 = resultSet.getInt(4);
                int  crossing_2 = resultSet.getInt(5);
                String  colonia = resultSet.getString(6);
                int id_cliente = resultSet.getInt(7);
                direccion = new Direccion(id_direccion, street, numeration,
                        crossing_1, crossing_2, colonia, id_cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return direccion;
    }

    @Override
    public boolean update(Direccion c) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public List<Direccion> readAll() {
        List<Direccion> direccions = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_direccion = resultSet.getInt(1);
                int street = resultSet.getInt(2);
                int  numeration = resultSet.getInt(3);
                int  crossing_1 = resultSet.getInt(4);
                int  crossing_2 = resultSet.getInt(5);
                String  colonia = resultSet.getString(6);
                int id_cliente = resultSet.getInt(7);
                Direccion direccionList = new Direccion(id_direccion, street, numeration,
                        crossing_1, crossing_2, colonia, id_cliente);
                direccions.add(direccionList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return direccions;
    }
}
