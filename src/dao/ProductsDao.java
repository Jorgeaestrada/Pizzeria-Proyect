package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductsDao implements CRUDInterface<Products> {

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_CREATE = "SELECT p.id_pizza, p.nombre, p.precio_pizza, t.tamanio " +
            "FROM Pizza p, Tamanio t " +
            "WHERE t.id_tamanio = p.id_tamanio ";

    private static final String SQL_READ_ALL = "SELECT p.id_pizza, p.nombre, p.precio_pizza, t.tamanio " +
            "FROM Pizza p, Tamanio t " +
            "WHERE t.id_tamanio = p.id_tamanio ";

    @Override
    public boolean create(Products c) {
        return false;
    }

    @Override
    public Products read(Object key) {
        return null;
    }

    @Override
    public boolean update(Products c) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public List<Products> readAll() {
        List<Products> productList = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_pizza = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String size = resultSet.getString(4);


                Products products = new Products(id_pizza, name, price, size);

                productList.add(products);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return productList;
    }
}
