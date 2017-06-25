package metodosSQL;

import Conexion.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public final class Metodos {

    Conex conectar = new Conex();
    ResultSet resultado;

    public void ejecutaUpdate(String sentSQL) {

        try {
            conectar.conexion();
            Connection estaConex = conectar.getConectar();
            PreparedStatement sta = estaConex.prepareStatement(sentSQL);
            sta.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + ex);
        }
    }

    public void ejecutaConsulta(String sentSQL) {
        try {
            conectar.conexion();
            Connection con = conectar.getConectar();
            if(con != null){
            Statement st = con.createStatement();
             resultado = st.executeQuery(sentSQL);
            }else
                System.out.println("Vacío");
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e);
        }

    }
   
    public ResultSet getResultado() {
        return resultado;
    }
}
