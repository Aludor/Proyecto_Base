package proyecto.bases;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        setTitle("Login");
        imagenes("src"+File.separator+"imagenes"+File.separator+"user.png",jLabel3);
        setLocationRelativeTo(null);
    }
    Conexion cx = new Conexion();
    Connection cn = cx.conectar();
    public final void imagenes(String ruta, JLabel uno) {
        ImageIcon sonic = new ImageIcon(ruta);
        sonic = new ImageIcon(sonic.getImage().getScaledInstance(uno.getWidth(), uno.getHeight(), Image.SCALE_DEFAULT));
        uno.setIcon(sonic);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(425, 450));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 150));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USUARIO");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 20));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 100, 30));

        jTextField1.setMinimumSize(new java.awt.Dimension(0, 0));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 180, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CONTRASEÑA");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 140, 40));

        jPasswordField1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPasswordField1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 180, 40));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 170, 40));

        getContentPane().add(jPanel1);

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
                    Ventas ven1 = new Ventas(this, true);
                    ven1.dvendedor(id, vendedor,0);
                    ven1.setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}