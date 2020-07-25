package interfaz;
import pimoney.DataBase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class ConsulCliente extends javax.swing.JFrame {

    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    


    public ConsulCliente(String usu) throws SQLException, Exception {
    	usuario=usu;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("CONSULTAR CLIENTE");
        con=DataBase.getConnection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        bt_consultar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        lb_nombre = new javax.swing.JLabel();
        lb_direccion = new javax.swing.JLabel();
        lb_telefono = new javax.swing.JLabel();
        lb_tipo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("CEDULA:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("DIRECCION:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("TELEFONO:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("TIPO:");

        bt_consultar.setText("CONSULTAR");
        bt_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_consultarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("CANCELAR");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        lb_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_tipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel2))
                        .addGap(58, 58, 58)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_direccion)
                            .addComponent(lb_nombre)
                            .addComponent(lb_telefono)
                            .addComponent(lb_tipo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_consultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lb_nombre))
                .addGap(41, 41, 41)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_direccion))
                .addGap(47, 47, 47)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb_telefono))
                .addGap(50, 50, 50)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_tipo))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void bt_consultarActionPerformed(java.awt.event.ActionEvent evt) {                                             
                        String sql="select * from clientes where ced_clie=?";
                        String a="";
                        try {
                             ps=con.prepareStatement(sql);
                             ps.setString(1, txt_cedula.getText());
                             rs=ps.executeQuery();
                            while (rs.next()) {
                                lb_direccion.setText(rs.getString(1));
                                lb_telefono.setText(rs.getString(2));

                                if("I".equals(rs.getString(3))){
                                    a += "INVERSIONISTA.   ";
                                }else if("P".equals(rs.getString(3))){
                                    a += "PRESTAMISTA.   ";
                                }else{a += "FIADOR.   ";
                                     }    
                                lb_tipo.setText(a);
                                lb_nombre.setText(rs.getString(5));
                            }
                            if(txt_cedula.getText().isEmpty()){
                                JOptionPane.showMessageDialog(null, "Ingrese un DATO VALIDO!!!");
                                lb_direccion.setText(null);
                                lb_telefono.setText(null);
                                lb_nombre.setText(null);
                                lb_tipo.setText(null);
                            }else if(a==""){
                                 JOptionPane.showMessageDialog(null, "Ciente no Existe!!!");
                                 lb_direccion.setText(null);
                                 lb_telefono.setText(null);
                                 lb_nombre.setText(null);
                                 lb_tipo.setText(null);
                            }
                        }catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
        }
    }                                            

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
            Ingreso ig=new Ingreso(usuario);
			this.setVisible(false);
			ig.frame.setVisible(true);
    }                                           

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
            java.util.logging.Logger.getLogger(ConsulCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConsulCliente("a").setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ConsulCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
/*                            while(rs.next()){
                              
                               if(rs.getString(3)=="I"){
                                   a=a+"INVERSIONISTA.   ";
                                    if(rs.getString(3)=="P"){
                                    a=a+"PRESTAMISTA.   ";
                                        }else{a=a+"FIADOR.   ";}    
                               }
    if(a==""){
                                JOptionPane.showMessageDialog(null, "Ingrese un DATO VALIDO!!");
                                lb_direccion.setText(null);
                                lb_telefono.setText(null);
                                lb_telefono.setText(null);
                                lb_tipo.setText(null);
                            }else{JOptionPane.showMessageDialog(null, "cliente encontrado");}
                            }*/
    // Variables declaration - do not modify                     
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb_direccion;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_telefono;
    private javax.swing.JLabel lb_tipo;
    private javax.swing.JTextField txt_cedula;
    
    private String usuario;
    // End of variables declaration                   
}