package dao;

import controller.Conexion;
import interfaces.CRUDInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

//FULL TESTED CLASS
public class ClienteDao implements CRUDInterface<Cliente> {

    private int generatedId;

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_CREATE_CLIENT = "INSERT INTO Clientes ("
            + "nom_cliente, tel_cliente)"
            + "VALUES (?, ?)";

    private static final String SQL_READ_CLIENT = "SELECT id_cliente, nom_cliente, "
            + "tel_cliente, id_direccion"
            + "FROM Clientes "
            + "WHERE id_cliente = ?";

    private static final String SQL_UPDATE_CLIENT = "UPDATE Clientes   "
            + "Set   "
            + "nom_cliente = ?,"
            + "tel_cliente = ?   "
            + "WHERE id_cliente = ?";

    private static final String SQL_DELETE_CLIENT = "DELETE FROM Clientes WHERE id_cliente = ?";

    private static final String SQL_READ_ALL = "SELECT * From Clientes";

    @Override
    public boolean create(Cliente c) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conexion.getConnection().prepareStatement(
                    SQL_CREATE_CLIENT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2, c.getphoneNumber());

            if (preparedStatement.executeUpdate() > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    
                    generatedId = resultSet.getInt(1);
                    setGeneratedId(generatedId);
                    System.out.println(generatedId);
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.closeConnection();
        }
        return false;
    }

    @Override
    public Cliente read(Object key) {

        Cliente cliente = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_CLIENT);

            preparedStatement.setString(1, key.toString());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                cliente = new Cliente();

                cliente.setIdCliente(resultSet.getInt(1));
                cliente.setName(resultSet.getString(2));
                cliente.setphoneNumber(resultSet.getString(3));
                //cliente.setIdDireccion(resultSet.getInt(4));
            }
            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conexion.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    @Override
    public List<Cliente> readAll() {

        Cliente cliente;
        DireccionDao direccionDao;

        ArrayList<Cliente> arrayList = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            arrayList = new ArrayList<>();

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                cliente = new Cliente();
                direccionDao = new DireccionDao();

                cliente.setIdCliente(resultSet.getInt(1));
                cliente.setName(resultSet.getString(2));
                cliente.setphoneNumber(resultSet.getString(3));
                cliente.setDireccion(direccionDao.read(resultSet.getInt(1)));

                arrayList.add(cliente);
            }

            return arrayList;

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conexion.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayList;
    }

    @Override
    public boolean update(Cliente c) {

        PreparedStatement preparedStatement;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE_CLIENT);

            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2, c.getphoneNumber());
            preparedStatement.setInt(3, c.getIdCliente());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexion.getConnection().prepareStatement(
                    SQL_DELETE_CLIENT);

            preparedStatement.setString(1, key.toString());

            int res = preparedStatement.executeUpdate();

            if (res > 0) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preparedStatement.close();
                conexion.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    public int getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(int generatedId) {
        this.generatedId = generatedId;
    }
}
