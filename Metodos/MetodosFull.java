package Metodos;

import Conexion.Conex;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeRegExp.ignoreCase;
import metodosSQL.Metodos;

public class MetodosFull {

    String ubicacion;
    int id;
    String idX;
    String nom;
    String ipD;
    String tel;
    String sentencia;
    String ubCL;
    Conex conecta = new Conex();
    Metodos ejecutaSQL = new Metodos();

    public void msjUpdate() {
        JOptionPane.showMessageDialog(null, "El registro ha sido actualizado", "Actualización con éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void messageErrorSql() {
        JOptionPane.showMessageDialog(null, "**´Error al conectar con la base de datos´**", "Error", JOptionPane.ERROR_MESSAGE);

    }

    public void idCl(String a) {
        idX = a;
    }

    public void nombreCl(String b) {
        nom = b;
    }

    public void ipCL(String txt) {
        ipD = txt;
    }

    public void telCl(String txt) {
        tel = txt;
    }

    public void ubCl(String txt) {
        ubCL = txt;
    }

    /*
    retorna el datos del cliente que se 
    obtiene de la misma consulta 
    que tiene la tablaClientes 
     */
    public String dameUb() {
        return ubCL;
    }

    public String dameTel() {
        return tel;
    }

    public String dameIp() {
        return ipD;
    }

    public String dameId() {
        return idX;
    }

    public String dameNom() {
        return nom;
    }

    //>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<
////////////////// retorna el id de la ubicación //////////////////////////////
    public int ub(String dt) {

        try {
            conecta.conexion();
            sentencia = "select * from ubicacion where ubicacion= '" + dt + "' ";
            ejecutaSQL.ejecutaConsulta(sentencia);

            while (ejecutaSQL.getResultado().next()) {
                id = Integer.parseInt(ejecutaSQL.getResultado().getString("id"));

            }
            conecta.cerrarConexion();

        } catch (Exception e) {
            messageErrorSql();
        }
        return id;
    }

    ////////////////////retorna el id del año///////////////////////
    public int idAnio(String dt) {
        try {
            conecta.conexion();
            sentencia = "select * from anios where anio= '" + dt + "' ";
            ejecutaSQL.ejecutaConsulta(sentencia);

            while (ejecutaSQL.getResultado().next()) {
                id = Integer.parseInt(ejecutaSQL.getResultado().getString("id"));
            }
            conecta.cerrarConexion();
        } catch (Exception e) {
            messageErrorSql();
        }
        return id;
    }
    ///////////////retorna el id del mes///////////////////   

    public int idMes(String mes) {
        try {
            conecta.conexion();
            sentencia = "select * from meses where mes= '" + mes + "' ";
            ejecutaSQL.ejecutaConsulta(sentencia);

            while (ejecutaSQL.getResultado().next()) {
                id = Integer.parseInt(ejecutaSQL.getResultado().getString("id"));
            }
            conecta.cerrarConexion();
        } catch (Exception e) {
            messageErrorSql();
        }
        return id;
    }

    public String nomMes(String mes) {
        String nombre = "";
        try {
            conecta.conexion();
            sentencia = "select * from meses where mes= '" + mes + "' ";
            ejecutaSQL.ejecutaConsulta(sentencia);

            while (ejecutaSQL.getResultado().next()) {
                nombre = ejecutaSQL.getResultado().getString("mes");
            }
            conecta.cerrarConexion();
        } catch (Exception e) {
            messageErrorSql();
        }
        return nombre;
    }

}
