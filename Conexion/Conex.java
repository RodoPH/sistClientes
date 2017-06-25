package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RodoPh
 */
public class Conex {

    private static Connection conectar;

    //Hacer conexión a la base de datos
    public void conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/servclientes", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al hacer conexión a la Base de datos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
    }

    //Método para cerrar conexión
    public void cerrarConexion() {
        try {
            conectar.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cerrar la conexión a la Base de datos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConectar() {
        return conectar;
    }

}
