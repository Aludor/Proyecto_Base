package proyecto.bases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        setTitle("Login");
        setLocationRelativeTo(null);
    }
    Conexion cx = new Conexion();
    Connection cn = cx.conectar();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void buscarusuario(){
        String sql = "SELECT * FROM login", vendedor = "";
        int id = 0;
        boolean adm = false, tra = false;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql), rv;
            while (rs.next()) {
                if (rs.getString("usuario").equals(jTextField1.getText()) && rs.getString("contraseña").equals(jPasswordField1.getText()) && rs.getBoolean("admin")) {
                    System.out.println("administrador");
                    adm = true;
                    this.dispose();
                    Principal p = new Principal();
                    p.setVisible(true);
                    break;
                }
                if (rs.getString("usuario").equals(jTextField1.getText()) && rs.getString("contraseña").equals(jPasswordField1.getText()) && !rs.getBoolean("admin")) {
                    System.out.println("trabajador");
                    rs.close();
                    System.out.println(rs.getInt("id"));
                    rv = st.executeQuery("SELECT v.nombre, lo.id FROM vendedor v \n "
                        + "INNER JOIN  login lo "
                        + "ON v.id = lo.vendedor_id "
                        + "WHERE lo.id = " + rs.getInt("id") + ";");
                    if (rv.next()) {
                        vendedor = rv.getString("nombre");
                        id = rv.getInt("id");
                    }
                    tra = true;
                    rv.close();
                    Ventas ven1 = new Ventas(null, false);
                    ven1.dvendedor(id, vendedor);
                    ven1.setVisible(true);
                    this.setVisible(false);
                    break;
                }
            }
            if (tra == adm) {
                JOptionPane.showMessageDialog(rootPane, "Datos Incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            jTextField1.setText(null);
            jPasswordField1.setText(null);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        buscarusuario();
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == 10){
            buscarusuario();
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}