package Principal;

import java.sql.*;
import javax.swing.JOptionPane;
import Conexion.Conex;
import Metodos.MetodosFull;
import fecha.Fecha;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import metodosSQL.Metodos;

public class controlClientes extends javax.swing.JFrame {

    Conex conectar = new Conex();
    Metodos ejecutaSQL = new Metodos();
    Fecha fecha = new Fecha();
    MetodosFull metFull = new MetodosFull();
    String sentencia = "";
    String ubicacion;
    String[] titulos = {"ID", "IP", "NOMBRE", "TELEFONO", "UBICACIÓN"};

    public controlClientes() {
        initComponents();
        cargarDatos("");

    }

    //Diseño de tabla Encabezados
    private void disenoTabla() {
        JTableHeader theader = tbClientes.getTableHeader();
        theader.setBackground(Color.black);
        theader.setForeground(Color.white);
        theader.setFont(new Font("Tahoma", Font.BOLD, 14));
        ((DefaultTableCellRenderer) theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    public final void cargarDatos(String dt) {

        String[] datos = new String[5];
        DefaultTableModel modeloTabla = new DefaultTableModel(null, titulos);
        sentencia = "select clientes.id_cliente,clientes.ip, clientes.nombre,"
                + " clientes.telefono, ubicacion.ubicacion as txtUbicacion"
                + " from clientes  "
                + " JOIN ubicacion ON ubicacion.id = clientes.id_ubicacion "
                + "where concat(ip,' ',nombre) like '%" + dt + "%'";
        ejecutaSQL.ejecutaConsulta(sentencia);

        try {

            while (ejecutaSQL.getResultado().next()) {
                datos[0] = ejecutaSQL.getResultado().getString("id_cliente");
                datos[1] = ejecutaSQL.getResultado().getString("ip");
                datos[2] = ejecutaSQL.getResultado().getString("nombre");
                datos[3] = ejecutaSQL.getResultado().getString("telefono");
                datos[4] = ejecutaSQL.getResultado().getString("txtUbicacion");

                modeloTabla.addRow(datos);

            }

            tbClientes.setModel(modeloTabla);

            disenoTabla();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDato = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar1 = new javax.swing.JButton();
        btbCobrar = new javax.swing.JButton();
        btnDeudores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        btnAgregarCliente = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE COBRO DE INTERNET");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("DokChampa", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/users.png"))); // NOI18N
        jLabel2.setText("USUARIOS");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("BUSCAR:");

        txtDato.setFont(new java.awt.Font("Batang", 0, 14)); // NOI18N
        txtDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoActionPerformed(evt);
            }
        });
        txtDato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDatoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDatoKeyTyped(evt);
            }
        });

        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete-48.png"))); // NOI18N
        btnEliminar1.setText("Eliminar ");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btbCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/Money.png"))); // NOI18N
        btbCobrar.setText("Cobrar");
        btbCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbCobrarActionPerformed(evt);
            }
        });

        btnDeudores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/deuda.png"))); // NOI18N
        btnDeudores.setText("Deudores");
        btnDeudores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeudoresActionPerformed(evt);
            }
        });

        tbClientes.setBackground(new java.awt.Color(204, 255, 255));
        tbClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tbClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbClientes.setRowMargin(2);
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/agregarClientes.png"))); // NOI18N
        btnAgregarCliente.setText("Nuevo cliente");
        btnAgregarCliente.setToolTipText("Agregar un clientes");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        btnAgregarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnAgregarClienteKeyTyped(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/icons8-Save-48.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeudores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btbCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarCliente)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btbCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDeudores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Realizado por RodOS");

        jLabel4.setText("rodopasth@gmail.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtDato))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        AgregarCliente nuevoCl = new AgregarCliente();
        nuevoCl.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void txtDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoActionPerformed


    }//GEN-LAST:event_txtDatoActionPerformed

    private void txtDatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatoKeyTyped
        cargarDatos("");
    }//GEN-LAST:event_txtDatoKeyTyped

    private void btnAgregarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarClienteKeyTyped


    }//GEN-LAST:event_btnAgregarClienteKeyTyped

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        if (metFull.dameIp() == null) {
            JOptionPane.showMessageDialog(null, "Debe elegir primero al cliente que quiere eliminar", "Información", JOptionPane.WARNING_MESSAGE);
        } else {
            sentencia = "delete from clientes where id_cliente = '" + metFull.dameId() + "'";
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere realmente eliminar el registro \n IP: " + metFull.dameIp() + "\n   Nombre: " + metFull.dameNom() + "? ", "Información", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                ejecutaSQL.ejecutaUpdate(sentencia);
                cargarDatos("");
                txtDato.setText("");
                JOptionPane.showMessageDialog(null, "Ha sido eliminado con éxito", "Infomación", JOptionPane.INFORMATION_MESSAGE);
            }

        }


    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btbCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbCobrarActionPerformed

        try {
            String folio = "";
            int idAnio = metFull.idAnio(fecha.getAno());
            int idMes = metFull.idMes(fecha.getMes());
            int idCliente = Integer.parseInt(metFull.dameId());
            String idUbica = metFull.dameUb();

            int respuesta = JOptionPane.showConfirmDialog(null, "Por favor, verifique si están bien los datos "
                    + "\n\t IP: " + metFull.dameIp()
                    + " \n\t Nombre:  " + metFull.dameNom()
                    + "\n\t Fecha: " + fecha.getFechaHora()
                    + "\n\t Ubicación: " + idUbica + "", "Información", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                folio = JOptionPane.showInputDialog(null, "Escriba el folio del pago");

                if (!folio.equals("")) {
                    sentencia = "insert into cobro (folio_pago, id_anio, id_mes, id_cliente, id_ubicacion) values ('" + folio + "', '" + idAnio + "', '" + idMes + "', '" + idCliente + "', '" + metFull.ub(idUbica)+ "' )";
                    ejecutaSQL.ejecutaUpdate(sentencia);
                    sentencia = "update clientes set pago=1 where id_cliente ='" + idCliente + "'";
                    ejecutaSQL.ejecutaUpdate(sentencia);
                    txtDato.setText("");
                    JOptionPane.showMessageDialog(null, "Pago realizado con éxito", "Cobro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar el FOLIO de PAGO", "Información", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona en la tabla al cliente para realizar el cobro", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException i) {

        }

    }//GEN-LAST:event_btbCobrarActionPerformed

    private void btnDeudoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeudoresActionPerformed
        Deudores abrir = new Deudores();
        abrir.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnDeudoresActionPerformed

    private void txtDatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatoKeyReleased
        cargarDatos(txtDato.getText());
    }//GEN-LAST:event_txtDatoKeyReleased

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked

        int seleccion = tbClientes.getSelectedRow();

        String idDelete = tbClientes.getValueAt(seleccion, 0).toString();
        String ipDelete = tbClientes.getValueAt(seleccion, 1).toString();
        String nombreDelete = tbClientes.getValueAt(seleccion, 2).toString();
        String tel = tbClientes.getValueAt(seleccion, 3).toString();
        String ub = tbClientes.getValueAt(seleccion, 4).toString();
        
       
        metFull.telCl(tel);
        metFull.idCl(idDelete);
        metFull.ipCL(ipDelete);
        metFull.nombreCl(nombreDelete);
        metFull.ubCl(ub);

    }//GEN-LAST:event_tbClientesMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            if (metFull.dameIp() == null || metFull.dameNom() == null || metFull.dameTel() == null || metFull.dameUb() == null) {
                JOptionPane.showMessageDialog(null, "Por favor de seleccionar la fila que quiere actualizar", "Información", JOptionPane.WARNING_MESSAGE);

            } else {
                int eleccion = JOptionPane.showOptionDialog(null, "Seleccione el dato que quiere actualizar",
                        /*Título de ventana*/ "Selección de opciones",
                        /*Opción*/ JOptionPane.YES_NO_CANCEL_OPTION,
                        /*Tipo de JOptionPane*/ JOptionPane.QUESTION_MESSAGE,
                        /*ICONO*/ null,
                        /*Opciones*/ new Object[]{"IP", "Nombre", "Telefono"}, "IP");

                System.out.println("" + eleccion);
                switch (eleccion) {
                    case 0:
                        String ipN = JOptionPane.showInputDialog(null, "Escriba la IP nueva: ", "Actualizando  IP" + metFull.dameIp(), JOptionPane.PLAIN_MESSAGE);
                        if (ipN.equals("")) {
                            JOptionPane.showMessageDialog(null, "No puede haber registros con información NULA", "Información", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            sentencia = "update clientes set ip=" + ipN + "  where id_cliente=" + metFull.dameId() + " ";
                            ejecutaSQL.ejecutaUpdate(sentencia);
                            txtDato.setText("");
                            cargarDatos("");
                            metFull.msjUpdate();

                        }
                        break;
                    case 1:
                        String nom = JOptionPane.showInputDialog(null, "Escriba el nombre : ", "Actualizando el nombre:" + metFull.dameNom(), JOptionPane.PLAIN_MESSAGE);
                        if (nom.equals("")) {
                            JOptionPane.showMessageDialog(null, "No puede haber registros con información NULA", "Información", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            sentencia = "update clientes set nombre='" + nom + "'  where id_cliente= " + metFull.dameId() + " ";
                            ejecutaSQL.ejecutaUpdate(sentencia);
                             txtDato.setText("");
                            cargarDatos("");
                            metFull.msjUpdate();
                        }
                        break;

                    case 2:
                        String tel = JOptionPane.showInputDialog(null, "Escriba el nuevo número de telefono: ", "Actualizando el telefono: " + metFull.dameTel(), JOptionPane.PLAIN_MESSAGE);
                        if (tel.equals("")) {
                            JOptionPane.showMessageDialog(null, "No puede haber registros con información NULA", "Información", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            sentencia = "update clientes set  telefono=" + tel + "  where id_cliente=" + metFull.dameId() + " ";
                            ejecutaSQL.ejecutaUpdate(sentencia);
                             txtDato.setText("");
                            cargarDatos("");
                            metFull.msjUpdate();
                        }
                        break;
                   
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no valida");
                        break;

                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbCobrar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnDeudores;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtDato;
    // End of variables declaration//GEN-END:variables

}
