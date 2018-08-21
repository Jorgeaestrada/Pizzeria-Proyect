package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

//FLL TESTED CLASS-----------------------------------------------------------------------
public class Conexion {

    public static Conexion instance;
    private Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/pizzeria";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Statement statement;
    private ResultSet resultSet;

    //Clase que conecta la aplicación a una base de datos
    private Conexion() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
    }

    //mejorar método para que esté más optimizado
    public synchronized static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        instance = null;
    }

}
    