package dao;

import controller.Conexion;
import model.Tamanio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TamanioDao {

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_READ_ALL= "SELECT tamanio FROM Tamanio  ";

    public List<String> readAll() {
        List<String> productList = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String size = resultSet.getString(1);

                String tamanio = new String(size);

                productList.add(tamanio);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return productList;
    }
}
