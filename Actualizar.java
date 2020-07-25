package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pimoney.DataBase;
import java.awt.Color;

public class Actualizar extends javax.swing.JFrame {

    /** Creates new form ConsulCliente */
        String usuario;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
    
    public Actualizar(String usu){
        initComponents();
        this.setTitle("Actualizar Cliente");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        try {
        	usuario=usu;
			con=DataBase.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        combo_tipo = new javax.swing.JComboBox<>();
        bt_buscar = new javax.swing.JButton();
        bt_actualizar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_actualizar.setEnabled(false);
        
        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyReleased(evt);
            }
        });        

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_direccionKeyReleased(evt);
            }
        });   
        
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
        });   
        
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyReleased(evt);
            }
        });        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new Color(153, 204, 255));

        jLabel1.setText("NOMBRE:");

        jLabel2.setText("CEDULA:");

        jLabel3.setText("DIRECCION:");

        jLabel4.setText("TELEFONO:");

        jLabel5.setText("TIPO:");

        txt_cedula.setEditable(false);

        combo_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FIADOR", "INVERSIONISTA", "PRESTATARIO" }));

        bt_buscar.setText("BUSCAR");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        bt_actualizar.setText("ACTUALIZAR");
        bt_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualizarActionPerformed(evt);
            }           
        });
           
        
        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(bt_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_actualizar)
                        .addGap(141, 141, 141))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(35, 35, 35))
                                .addGroup(fondoLayout.createSequentialGroup()
                                    .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(20, 20, 20))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_cancelar))
                            .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))
                                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_buscar)
                    .addComponent(bt_actualizar)
                    .addComponent(bt_cancelar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void activar(){
        if(!txt_cedula.getText().isEmpty() && !txt_direccion.getText().isEmpty() && !txt_nombre.getText().isEmpty() && !txt_telefono.getText().isEmpty()){
            bt_actualizar.setEnabled(true);
        }else{bt_actualizar.setEnabled(false);}
    }
    
    private void txt_cedulaKeyReleased(java.awt.event.KeyEvent evt) {                               
            activar();
    }
        
    private void txt_direccionKeyReleased(java.awt.event.KeyEvent evt) {                               
            activar();
    }    
            
    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {                               
            activar();
    } 
             
    private void txt_telefonoKeyReleased(java.awt.event.KeyEvent evt) {                               
            activar();
    }    
               

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
       String sql="select * from clientes where nombre_clie=?";
       String a="";
        try {
             ps=con.prepareStatement(sql);
             ps.setString(1, txt_nombre.getText());
             rs=ps.executeQuery();
             while (rs.next()) {
                txt_direccion.setText(rs.getString(1));
                txt_telefono.setText(rs.getString(2));

                if("I".equals(rs.getString(3))){
                   combo_tipo.setSelectedItem("INVERSIONISTA");
                    a="1";
                }else if("P".equals(rs.getString(3))){
                    combo_tipo.setSelectedItem("PRESTATARIO");
                    a="1";
                }else{combo_tipo.setSelectedItem("FIADOR");
                    a="1";
                     }    
                txt_cedula.setText(rs.getString(4));
                txt_nombre.setText(rs.getString(5));
            }


            if(txt_nombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese un DATO VALIDO!!!");
                txt_direccion.setText(null);
                txt_telefono.setText(null);
                txt_nombre.setText(null);
                txt_cedula.setText(null);
            }else if(a.equals("")){
                JOptionPane.showMessageDialog(null, "Cliente no Existe!!!");
                txt_direccion.setText(null);
                txt_telefono.setText(null);
                txt_nombre.setText(null);
                txt_cedula.setText(null);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        String sql="update clientes set direccion=?, telefono=?, tipo=?, nombre_clie=? where ced_clie=?";
        String a="";
                        try {
                            ps=con.prepareStatement(sql);
                            ps.setString(1, txt_direccion.getText());
                            ps.setString(2, txt_telefono.getText());
                            if("INVERSIONISTA".equals(combo_tipo.getSelectedItem())){
                                a="I";
                            }else if("PRESTATARIO".equals(combo_tipo.getSelectedItem())){
                                a="P";
                            }else{a="F";
                                 }    
                            ps.setString(3, a);
                            ps.setString(4, txt_nombre.getText());
                            ps.setString(5,txt_cedula.getText());
                            int res=ps.executeUpdate();
                            if (txt_nombre.getText().isEmpty()||txt_cedula.getText().isEmpty()||txt_direccion.getText().isEmpty()||txt_telefono.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null,"Todos los campos deben estar diligenciados");
                            } else if(res>0){
                                JOptionPane.showMessageDialog(null,"Cliente Actualizado");
                                 txt_direccion.setText(null);
                                 txt_telefono.setText(null);
                                 txt_nombre.setText(null);
                                 txt_cedula.setText(null);
                            }else if(a.equals("")){
                               JOptionPane.showMessageDialog(null,"Cliente no Existe");
                                 txt_direccion.setText(null);
                                 txt_telefono.setText(null);
                                 txt_nombre.setText(null);
                                 txt_cedula.setText(null);
                            }
                        }catch (SQLException e) {
                        }
    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
                        Ingreso ig=new Ingreso(usuario);
			this.setVisible(false);
			ig.frame.setVisible(true);
    }//GEN-LAST:event_bt_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Actualizar("").setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_actualizar;
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JComboBox<String> combo_tipo;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
