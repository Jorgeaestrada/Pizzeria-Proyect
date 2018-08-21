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
import model.Empleado;

//FULL TESTED CLASS----------------------------------------------------------------------
public class EmpleadoDao implements CRUDInterface<Empleado> {

    private int generatedId;

    private static final Conexion conexion = Conexion.getInstance();

    private static final String SQL_CREATE_EMPLOYEE = "INSERT INTO Empleado ("
            + "usuario, contrasenia, nom_empleado, tel_empleado)"
            + "VALUES (?, ?, ?, ?)";

    private static final String SQL_READ_EMPLOYEE = "SELECT id_empleado, usuario, contrasenia, "
            + "nom_empleado, tel_empleado"
            + "FROM Empleado"
            + "WHERE id_empleado = ?";

    private static final String SQL_UPDATE_EMPLOYEE = "UPDATE Empleado SET   "
            + "usuario = ?,"
            + "contrasenia = ?,"
            + "nom_empleado = ?,"
            + "tel_empleado = ?   "
            + "WHERE id_empleado = ?";

    private static final String SQL_DELETE_EMPLOYEE = "DELETE FROM Empleado WHERE id_empleado = ?";

    private static final String SQL_READ_ALL = "SELECT * FROM Empleado";

    @Override
    public boolean create(Empleado e) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        try {
            preparedStatement = conexion.getConnection().prepareStatement(
                    SQL_CREATE_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, e.getUsername());
            preparedStatement.setString(2, e.getPassword());
            preparedStatement.setString(3, e.getName());
            preparedStatement.setString(4, e.getPhoneNumber());
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
    public Empleado read(Object key) {

        Empleado empleado = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_EMPLOYEE);

            preparedStatement.setString(1, key.toString());

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                empleado = new Empleado();

                empleado.setIdEmpleado(resultSet.getInt(1));
                empleado.setUsername(resultSet.getString(2));
                empleado.setPassword(resultSet.getString(3));
                empleado.setName(resultSet.getString(4));
                empleado.setPhoneNumber(resultSet.getString(5));
            }
            return empleado;

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
        return empleado;
    }

    @Override
    public List<Empleado> readAll() {

        Empleado empleado;

        ArrayList<Empleado> arrayList = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            arrayList = new ArrayList<>();

            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                empleado = new Empleado();

                empleado.setIdEmpleado(resultSet.getInt(1));
                empleado.setUsername(resultSet.getString(2));
                empleado.setPassword(resultSet.getString(3));
                empleado.setName(resultSet.getString(4));
                empleado.setPhoneNumber(resultSet.getString(5));

                arrayList.add(empleado);
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
    public boolean update(Empleado e) {

        PreparedStatement preparedStatement;

        try {

            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE_EMPLOYEE);

            preparedStatement.setString(1, e.getUsername());
            preparedStatement.setString(2, e.getPassword());
            preparedStatement.setString(3, e.getName());
            preparedStatement.setString(4, e.getPhoneNumber());
            preparedStatement.setInt(5, e.getIdEmpleado());

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
                    SQL_DELETE_EMPLOYEE);

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

    public void setGeneratedId(int aGeneratedId) {
        generatedId = aGeneratedId;
    }

}
