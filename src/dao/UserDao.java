package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements CRUDInterface<User> {

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_READ_ALL = "SELECT * FROM Empleado; ";

    @Override
    public boolean create(User c) {
        return false;
    }

    @Override
    public User read(Object key) {
        return null;
    }

    @Override
    public boolean update(User c) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

    @Override
    public List<User> readAll() {

        List<User> userList = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idUser = resultSet.getInt(1);
                //String username = resultSet.getString(2);
                //String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String phoneNumber = resultSet.getString(5);
                //int userStatus = resultSet.getInt(6);

                User user = new User(idUser, name, phoneNumber);

                userList.add(user);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return userList;

    }
}
