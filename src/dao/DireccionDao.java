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
import model.Direccion;

//FULL TESTED CLASS
public class DireccionDao implements CRUDInterface<Direccion> {

    private int generatedId;

    private static final Conexion conexion = Conexion.getInstance();

    //CRUD
    private static final String SQL_CREATE_ADDRESS = "INSERT INTO Direccion ("
            + "calle, numeracion, cruzamiento_1, cruzamiento_2, colonia, id_cliente)"
            + "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_READ_ADDRESS = "SELECT id_direccion, calle,   "
            + "numeracion, cruzamiento_1, cruzamiento_2, colonia   "
            + "FROM Direccion   "
            + "WHERE id_cliente = ?";

    private static final String SQL_UPDATE_ADDRESS = "UPDATE Direccion   "
            + "Set   "
            + "calle = ?,"
            + "numeracion = ?,"
            + "cruzamiento_1 = ?,"
            + "cruzamiento_2 = ?,"
            + "colonia = ?,"
            + "id_cliente = ?   "
            + "WHERE id_direccion = ?";

    private static final String SQL_DELETE_ADDRESS = "DELETE FROM Direccion WHERE id_direccion = ?";

    //EXTRAS
    private static final String SQL_READ_ALL = "SELECT * From Direccion";

    @Override
    public boolean create(Direccion d) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        //INSERTA REGISTROS EN LA TABLA DIRECCION
        try {

            preparedStatement = conexion.getConnection().prepareStatement(
                    SQL_CREATE_ADDRESS, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, d.getStreet());
            preparedStatement.setInt(2, d.getHouseNumber());
            preparedStatement.setInt(3, d.getCrossing1());
            preparedStatement.setInt(4, d.getCrossing2());
            preparedStatement.setString(5, d.getColony());
            preparedStatement.setInt(6, d.getIdCliente());

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
            try {
                resultSet.close();
                preparedStatement.close();
                conexion.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public Direccion read(Object key) {

        Direccion direccion = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ADDRESS);

            preparedStatement.setString(1, key.toString());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                direccion = new Direccion();

                direccion.setIdDireccion(resultSet.getInt(1));
                direccion.setStreet(resultSet.getInt(2));
                direccion.setHouseNumber(resultSet.getInt(3)); //DEVUELVE EL USUARIO
                direccion.setCrossing1(resultSet.getInt(4)); //DEVUELVE LA CONTRASENIA
                direccion.setCrossing2(resultSet.getInt(5));
                direccion.setColony(resultSet.getString(6));
            }
            return direccion;

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
        return direccion;
    }

    @Override
    public List<Direccion> readAll() {

        Direccion direccion;

        ArrayList<Direccion> arrayList = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            arrayList = new ArrayList<>();

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                direccion = new Direccion();

                direccion.setIdDireccion(resultSet.getInt(1));
                direccion.setStreet(resultSet.getInt(2)); //DEVUELVE EL USUARIO
                direccion.setHouseNumber(resultSet.getInt(3)); //DEVUELVE LA CONTRASENIA
                direccion.setCrossing1(resultSet.getInt(4));
                direccion.setCrossing2(resultSet.getInt(5));
                direccion.setColony(resultSet.getString(6));

                arrayList.add(direccion);
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
    public boolean update(Direccion d) {

        PreparedStatement preparedStatement;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE_ADDRESS);

            preparedStatement.setInt(1, d.getStreet());
            preparedStatement.setInt(2, d.getHouseNumber());
            preparedStatement.setInt(3, d.getCrossing1());
            preparedStatement.setInt(4, d.getCrossing2());
            preparedStatement.setString(5, d.getColony());
            preparedStatement.setInt(6, d.getIdCliente());
            preparedStatement.setInt(7, d.getIdDireccion());

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

        System.out.println("la clave de direccion dao es:   " + key.toString());

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexion.getConnection().prepareStatement(
                    SQL_DELETE_ADDRESS);

            preparedStatement.setString(1, key.toString());

            int res = preparedStatement.executeUpdate();

            if (res > 0) {
                System.out.println("Direccion eliminada");
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

