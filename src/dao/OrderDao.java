package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements CRUDInterface<Order> {

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_READ_ALL = "SELECT  c.nom_cliente AS cliente, " +
            "CONCAT(p.nombre, ' ', t.tamanio) AS pedido, " +
            "p.precio_pizza AS precio, " +
            "CONCAT(v.fecha, ' ', v.hora) AS fecha " +
            "FROM Clientes c, Pizza p, Tamanio t, Ventas v, Orden o " +
            "WHERE   c.id_cliente = v.id_cliente AND " +
            "v.id_ventas = o.id_ventas AND " +
            "p.id_pizza = o.id_pizza AND " +
            "t.id_tamanio = p.id_tamanio;";


    @Override
    public boolean create(Order c) {
        return false;
    }

    @Override
    public Order read(Object key) {
        return null;
    }

    @Override
    public boolean update(Order c) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public List<Order> readAll() {

        List<Order> orderList = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String customer = resultSet.getString(1);
                String deliver = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String date = resultSet.getString(4);


                Order order= new Order(customer, deliver, price, date);

                orderList.add(order);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return orderList;
    }
}

