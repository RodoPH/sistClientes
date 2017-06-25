package Principal;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import metodosSQL.Metodos;

/**
 *
 * @author RodoPH
 */
public class EliminaCliente extends javax.swing.JFrame {

    public EliminaCliente() {
        initComponents();
        cargarDatos("");
    }
    
    Metodos ejecutaSQL = new Metodos();
    
    private void limpiarCampos(){
        txtDato.setText("");
        txtID.setText("");
        txtNombre.setText("");
    }
    private void disenoTabla() {//Diseño de tabla Encabezados
        JTableHeader theader = tablaClientes.getTableHeader();
        theader.setBackground(Color.black);
        theader.setForeground(Color.white);
        theader.setFont(new Font("Tahoma", Font.BOLD, 14));
        ((DefaultTableCellRenderer) theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

     private void cargarDatos(String dt) {

        String[] titulos = {"ID", "IP", "NOMBRE", "TELEFONO", "UBICACIÓN"};
        String[] datos = new String[5];

        String sentencia = "select clientes.id_cliente,clientes.ip, clientes.nombre,"
                + " clientes.telefono, ubicacion.ubicacion as txtUbicacion"
                + " from clientes  "
                + " JOIN ubicacion ON ubicacion.id = clientes.id_ubicacion "
                + "where concat(ip,' ',nombre) like '%" + dt + "%'";
        ejecutaSQL.ejecutaConsulta(sentencia);
        DefaultTableModel modeloTabla = new DefaultTableModel(null, titulos);

        try {

            while (ejecutaSQL.getResultado().next()) {
                datos[0] = ejecutaSQL.getResultado().getString("id_cliente");
                datos[1] = ejecutaSQL.getResultado().getString("ip");
                datos[2] = ejecutaSQL.getResultado().getString("nombre");
                datos[3] = ejecutaSQL.getResultado().getString("telefono");
                datos[4] = ejecutaSQL.getResultado().getString("txtUbicacion");

                modeloTabla.addRow(datos);

            }
            tablaClientes.setModel(modeloTabla);
            disenoTabla();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        txtNombre = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/icons8-Remove User Male-96.png"))); // NOI18N
        jLabel1.setText("   Eliminar Cliente");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("BUSCAR:");

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

        tablaClientes.setBackground(new java.awt.Color(204, 255, 255));
        tablaClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tablaClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaClientes.setRowMargin(2);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Nombre:");

        btnSalir.setFont(new java.awt.Font("Batang", 0, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/icons8-Undo-48.png"))); // NOI18N
        btnSalir.setText("Regresar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregarCliente.setFont(new java.awt.Font("Batang", 0, 18)); // NOI18N
        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Documentos/eliminarUSR.png"))); // NOI18N
        btnAgregarCliente.setText("Eliminar");
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

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtID.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregarCliente)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoActionPerformed

    }//GEN-LAST:event_txtDatoActionPerformed

    private void txtDatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatoKeyReleased
        cargarDatos(txtDato.getText());
    }//GEN-LAST:event_txtDatoKeyReleased

    private void txtDatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatoKeyTyped

    }//GEN-LAST:event_txtDatoKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       controlClientes regresa = new controlClientes();
       regresa.setVisible(true);             
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        String id = txtID.getText();
        int opciones = JOptionPane.YES_NO_OPTION;
       
        String sentencia = "delete from clientes where id_cliente = '"+id+"'";
        JOptionPane.showConfirmDialog(null,"¿Quiere realmente eliminar el registro?","Información",opciones);
        if(opciones== JOptionPane.YES_OPTION){
            ejecutaSQL.ejecutaUpdate(sentencia);
            limpiarCampos();
            cargarDatos("");
            
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnAgregarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarClienteKeyTyped

    }//GEN-LAST:event_btnAgregarClienteKeyTyped

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        int seleccionado = this.tablaClientes.getSelectedRow();
        this.txtID.setText(tablaClientes.getValueAt(seleccionado, 0).toString());
        this.txtNombre.setText(tablaClientes.getValueAt(seleccionado, 2).toString());

        
    }//GEN-LAST:event_tablaClientesMouseClicked

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtDato;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtNombre;
    // End of variables declaration//GEN-END:variables
}
