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
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(285, 264));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 87;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jTextField1, gridBagConstraints);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 87;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPasswordField1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void buscarusuario(){
        String sql = "SELECT * FROM login", vendedor = "", pass = null;
        int id = 0;
        boolean adm = false, tra = false;
        try {
            Statement st = cn.createStatement(), c = cn.createStatement();
            ResultSet rs = st.executeQuery(sql), rv, rc = c.executeQuery("select sha1('" + jPasswordField1.getText() + "')");
            if(rc.next()){
                pass = rc.getString(1);
            }
            while (rs.next()) {
                if (rs.getString("usuario").equals(jTextField1.getText()) && rs.getString("contraseña").equals(pass) && rs.getBoolean("admin")) {
                    System.out.println("administrador");
                    adm = true;
                    rv = st.executeQuery("SELECT * FROM vendedor "
                        + "WHERE id = " + rs.getInt("vendedor_id") + ";");
                    if (rv.next()) {
                        vendedor = rv.getString("nombre");
                        id = rv.getInt("id");
                    }         
                    this.dispose();
                    Menu p = new Menu();
                    p.datos(id,vendedor,1);
                    p.setVisible(true);
                    break;
                }
                if (rs.getString("usuario").equals(jTextField1.getText()) && rs.getString("contraseña").equals(pass) && !rs.getBoolean("admin")) {
                    rs.close();
                    rv = st.executeQuery("SELECT * FROM vendedor "
                            + "WHERE id = " + rs.getInt("vendedor_id"));
                    if (rv.next()) {
                        vendedor = rv.getString("nombre");
                        id = rv.getInt("id");
                    }
                    tra = true;
                    rv.close();
                    Ventas ven1 = new Ventas(null, false);
                    ven1.dvendedor(id, vendedor,0);
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
        buscarusuario();
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
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