/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class reg_productos extends javax.swing.JFrame {

    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    Conexion conn = new Conexion();
    Connection con = conn.getConexion();
    
    
    public void Conectar() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from PRODUCTO;");
            rs.next();
            llenarDatos();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error 000" + err.getMessage());
        }

    }

    public void llenarDatos() {
        try {
            this.txtid.setText(rs.getString("PRODUCTOID"));
            this.txtnombre.setText(rs.getString("NOMBREP"));
            this.txtcosto.setText(rs.getString("PRECIOVENTA"));
            this.txtventa.setText(rs.getString("PRECIOCOSTO"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 001" + ex.getMessage());
        }
    }

    public void siguienteRegistro() {
        try {
            if (!rs.isLast()) {
                rs.next();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 002" + ex.getMessage());
        }
    }

    public void anteriorRegistro() {
        try {
            if (!rs.isFirst()) {
                rs.previous();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 003" + ex.getMessage());
        }
    }

    public void primerRegistro() {
        try {
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 004" + ex.getMessage());
        }
    }

    public void ultimoRegistro() {
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 005" + ex.getMessage());
        }
    }
    
    public void habilitarCajas(){
        txtnombre.setEditable(true);
        txtcosto.setEditable(true);
        txtventa.setEditable(true);
       
    }
    
    public void insertarRegistro(){
        try {
            String nombre = txtnombre.getText();
            String preciocosto= txtcosto.getText();
            String precioventa = txtventa.getText();
            
            
            String sql = "INSERT INTO producto ( NOMBREP, PRECIOCOSTO, PRECIOVENTA)"
            + " VALUES (?,?,?)";
            
            pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, preciocosto);
            pst.setString(3, precioventa);
            
        
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro guardado");
            seleccionarTodosLosRegistros();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 006" + ex.getMessage());
        }
        
    }
    
    public void seleccionarTodosLosRegistros(){
        try {
            String sql = "SELECT * FROM Producto;";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 007" + ex.getMessage());
        }
        
    }
    public void modificarRegistro(){
        try {
            String nombre = txtnombre.getText();
            String preciocosto= txtcosto.getText();
            String precioventa = txtventa.getText();
            String id = txtid.getText();
            
            String sql = "UPDATE producto SET NOMBREP=?, PRECIOCOSTO=?, PRECIOVENTA=? WHERE PRODUCTOID=?";
            
            pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, preciocosto);
            pst.setString(3, precioventa);
            pst.setString(4, id);
            
        
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro Modificado");
            seleccionarTodosLosRegistros();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 008" + ex.getMessage());
        }
        
    }
    public void eliminarRegistro(){
        try {
            String id = txtid.getText();
            
            String sql = "DELETE FROM  producto  WHERE PRODUCTOID=?";
            
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            
        
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registro Eliminado");
            seleccionarTodosLosRegistros();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error 009" + ex.getMessage());
        }
        
    }
    public reg_productos() {
        initComponents();
        Conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        txtcosto = new javax.swing.JTextField();
        txtventa = new javax.swing.JTextField();
        jbregistrar = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        Nombre1 = new javax.swing.JLabel();
        Nombre2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jbprimero = new javax.swing.JButton();
        jbsiguiente = new javax.swing.JButton();
        jbatras = new javax.swing.JButton();
        jbultimo = new javax.swing.JButton();
        jbnuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jbregistrar.setText("Registar");
        jbregistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbregistrarMouseClicked(evt);
            }
        });

        jb_modificar.setText("Modificar");
        jb_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_modificarMouseClicked(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        Nombre.setBackground(new java.awt.Color(0, 0, 0));
        Nombre.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre");

        Nombre1.setBackground(new java.awt.Color(0, 0, 0));
        Nombre1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        Nombre1.setText("Precio Costo");

        Nombre2.setBackground(new java.awt.Color(0, 0, 0));
        Nombre2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        Nombre2.setText("Precio Venta");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jbprimero.setText("|<");
        jbprimero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbprimeroMouseClicked(evt);
            }
        });

        jbsiguiente.setText(">|");
        jbsiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbsiguienteMouseClicked(evt);
            }
        });

        jbatras.setText("<<");
        jbatras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbatrasMouseClicked(evt);
            }
        });

        jbultimo.setText(">>");
        jbultimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbultimoMouseClicked(evt);
            }
        });

        jbnuevo.setText("Nuevo");
        jbnuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbnuevoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Nombre1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Nombre2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtventa)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbprimero)
                                .addGap(21, 21, 21)
                                .addComponent(jbatras)))
                        .addGap(18, 18, 18)
                        .addComponent(jbsiguiente)
                        .addGap(18, 18, 18)
                        .addComponent(jbultimo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbnuevo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbregistrar)
                                .addGap(18, 18, 18)
                                .addComponent(jb_modificar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))))
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Nombre)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre1)
                    .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombre2)
                    .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbprimero)
                    .addComponent(jbatras)
                    .addComponent(jbsiguiente)
                    .addComponent(jbultimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbregistrar)
                    .addComponent(jb_modificar)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbnuevo)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbregistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbregistrarMouseClicked
       insertarRegistro();
    }//GEN-LAST:event_jbregistrarMouseClicked

    private void jb_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_modificarMouseClicked

          modificarRegistro();
    }//GEN-LAST:event_jb_modificarMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
    eliminarRegistro();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jbprimeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbprimeroMouseClicked
        primerRegistro();
    }//GEN-LAST:event_jbprimeroMouseClicked

    private void jbultimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbultimoMouseClicked
         ultimoRegistro();
    }//GEN-LAST:event_jbultimoMouseClicked

    private void jbsiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbsiguienteMouseClicked
        siguienteRegistro();
    }//GEN-LAST:event_jbsiguienteMouseClicked

    private void jbatrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbatrasMouseClicked
        anteriorRegistro();
    }//GEN-LAST:event_jbatrasMouseClicked

    private void jbnuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbnuevoMouseClicked
      
        txtid.setText("");
        txtnombre.setText("");
        txtcosto.setText("");
        txtventa.setText("");
        
        habilitarCajas();
    }//GEN-LAST:event_jbnuevoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(reg_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reg_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reg_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reg_productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reg_productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Nombre1;
    private javax.swing.JLabel Nombre2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JButton jbatras;
    private javax.swing.JButton jbnuevo;
    private javax.swing.JButton jbprimero;
    private javax.swing.JButton jbregistrar;
    private javax.swing.JButton jbsiguiente;
    private javax.swing.JButton jbultimo;
    private javax.swing.JTextField txtcosto;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
}
