package proyecto.bases;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Compras extends javax.swing.JDialog {

    public Compras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height - 50);
        setLocationRelativeTo(null);
        proveedor();
    }
    Conexion n = new Conexion();
    double total = 0;
    int idp = 0;
    static int idlogin = 0;
    public void proveedor() {
        try {
            Statement c = n.conectar().createStatement();
            ResultSet r = c.executeQuery("select nombre from proveedor");
            while (r.next()) {
                jComboBox1.addItem(r.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getid(int idlogin) {
        Compras.idlogin = idlogin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jMenuItem1.setText("ELIMINAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 200));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(400, 500));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1300, 680));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.CardLayout());

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "DESCRIPCION", "PRECIO UNIDAD", "PRECIO TOTAL"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, "card2");

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel14.setText("               ");
        jPanel5.add(jLabel14, java.awt.BorderLayout.LINE_START);

        jLabel15.setText("               ");
        jPanel5.add(jLabel15, java.awt.BorderLayout.LINE_END);

        jLabel16.setText("      ");
        jPanel5.add(jLabel16, java.awt.BorderLayout.PAGE_START);

        jLabel17.setText("        ");
        jPanel5.add(jLabel17, java.awt.BorderLayout.PAGE_END);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 5, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("CODIGO");
        jPanel6.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD");
        jPanel6.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("PRECIO");
        jPanel6.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("No. FACTURA");
        jPanel6.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("PROVEEDOR");
        jPanel6.add(jLabel5);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel6.add(jTextField1);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel6.add(jTextField2);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        jPanel6.add(jTextField3);
        jPanel6.add(jTextField4);

        jPanel6.add(jComboBox1);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL");
        jPanel7.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("0.0");
        jPanel7.add(jLabel7);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setText("CONFIRMAR");
        jButton1.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("AGREGAR PROVEEDOR");
        jButton2.setMinimumSize(new java.awt.Dimension(152, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(170, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2);

        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("COMPRA", jPanel1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO VENTA", "TOTAL", "FECHA", "NUMERO FACTURA"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);

        jTabbedPane1.addTab("DETALLE COMPRA", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "DESCRIPCION", "PRECIO"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel8.add(jScrollPane3);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel18.setText("    ");
        jPanel9.add(jLabel18, java.awt.BorderLayout.PAGE_START);

        jLabel19.setText("    ");
        jPanel9.add(jLabel19, java.awt.BorderLayout.PAGE_END);

        jLabel20.setText("               ");
        jPanel9.add(jLabel20, java.awt.BorderLayout.LINE_START);

        jLabel21.setText("               ");
        jPanel9.add(jLabel21, java.awt.BorderLayout.LINE_END);

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PROVEEDOR");
        jPanel10.add(jLabel8);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("No. FACTURA");
        jPanel10.add(jLabel10);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL");
        jPanel10.add(jLabel12);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("____________________");
        jPanel10.add(jLabel9);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("____________________");
        jPanel10.add(jLabel11);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("____________________");
        jPanel10.add(jLabel13);

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("DESCRIPCION COMPRA", jPanel3);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Proveedor p = new Proveedor(null, true);
        p.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "CAMPOS OBLIGATIRIOS");
                }
                else{
                    Statement c = n.conectar().createStatement();
                    ResultSet r = c.executeQuery("select * from producto");
                    double precio = Double.parseDouble(jTextField3.getText()) / Double.parseDouble(jTextField2.getText());
                    DecimalFormat d = new DecimalFormat("#.00");
                    while (r.next()) {
                        if (r.getString("codigo").equals(jTextField1.getText())) {
                            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                            total += Double.parseDouble(jTextField3.getText());
                            Object[] o = new Object[]{Integer.parseInt(jTextField2.getText()), r.getString(3), d.format(precio), jTextField3.getText()};
                            model.addRow(o);
                            jTable1.setModel(model);
                            jLabel7.setText(String.valueOf(d.format(total)));
                        }
                    }
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField1.requestFocus();
                    r.close();
                    c.close();
                }                
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int[] rows = jTable1.getSelectedRows();
        for (int i = rows.length - 1; i > -1; i--) {            
            total -= Double.parseDouble(model.getValueAt(i, 3).toString());
            System.out.println(total);
            model.removeRow(rows[i]);
        }
        jLabel7.setText(String.valueOf(total));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTable1.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "INGRESE PRODUCTOS");
        }
        else if(jTextField4.getText().equals("")){
            JOptionPane.showMessageDialog(this, "INGRESE NUMERO DE FACTURA");
        }
        else if(jComboBox1.getItemCount() == 0){
            JOptionPane.showMessageDialog(this, "INGRESE PROVEEDOR");
        }
        else{
            try {
                boolean encontrado = true;
                Statement c = n.conectar().createStatement();
                ResultSet r = c.executeQuery("select nfactura from compra");
                while(r.next()){
                    if(r.getString("nfactura").equals(jTextField4.getText())){
                        JOptionPane.showMessageDialog(this, "FACTURA REPETIDA");
                        encontrado = false;
                        break;
                    }
                }
                if(encontrado){                    
                    llenarcompra();            
                    llenardetallec();
                }
                jTextField4.setText("");
                jLabel7.setText("0.0");
                total = 0;
                r.close();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        try {
            if(jTabbedPane1.getSelectedIndex() == 1){
                Statement c = n.conectar().createStatement();
                ResultSet r = c.executeQuery("select * from compra where login_id = " + idlogin);
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                for(int i = jTable2.getRowCount() - 1; i > -1; i--){
                    model.removeRow(i);
                }
                while(r.next()){
                    Object[] o = new Object[]{r.getInt("id"), r.getDouble("total"), r.getDate("fecha"), r.getString("nfactura")};
                    model.addRow(o);
                }
                jTable2.setModel(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            if(evt.getClickCount() == 2){
                int idc = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
                Statement c = n.conectar().createStatement();
                ResultSet r = c.executeQuery("select p.nombre, c.nfactura, c.total, pr.nombre, dc.cantidad, dc.precio\n" +
                                                "from proveedor p\n" +
                                                "inner join compra c\n" +
                                                "on p.id = c.proveedor_id\n" +
                                                "inner join descripcionc dc\n" +
                                                "on c.id = dc.compra_id\n" +
                                                "inner join producto pr\n" +
                                                "on dc.producto_id = pr.id\n" +
                                                "where dc.compra_id = " + idc);                
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                for(int i = jTable3.getRowCount() - 1; i > -1; i--){
                    model.removeRow(i);
                }
                while(r.next()){
                    jLabel9.setText(r.getString("p.nombre"));
                    jLabel11.setText(r.getString("c.nfactura"));
                    jLabel13.setText(String.valueOf(r.getDouble("c.total")));
                    Object[] o = new Object[]{r.getInt("dc.cantidad"),r.getString("pr.nombre"),(r.getInt("dc.cantidad") * r.getDouble("dc.precio"))};
                    model.addRow(o);
                }
                jTable3.setModel(model);
                jTabbedPane1.setSelectedIndex(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jTable2MouseClicked
    public void llenarcompra() {
        try {
            Statement c = n.conectar().createStatement();
            ResultSet r = c.executeQuery("select * from proveedor");
            int id = 0;
            while (r.next()) {
                if (r.getString("nombre").equals(jComboBox1.getSelectedItem())) {
                    id = r.getInt("id");
                    break;
                }
            }
            Calendar f = new GregorianCalendar();
            String fecha = String.valueOf(f.get(Calendar.YEAR)) + "-" + String.valueOf(f.get(Calendar.MONTH) + 1) + "-" + String.valueOf(f.get(Calendar.DAY_OF_MONTH));
            c.executeUpdate("insert into compra(fecha,nfactura,total,proveedor_id,login_id) values('" + Date.valueOf(fecha) + "','" + jTextField4.getText() + "'," + Double.parseDouble(jLabel7.getText()) + "," + id + "," + idlogin + ")");
            r.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void llenardetallec(){
        try {
            Statement c = n.conectar().createStatement();
            ResultSet r = c.executeQuery("select id from compra where id = (select max(id) from compra)");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int idc = 0, cantidad;
            double precio;
            System.out.println(idlogin);
            String producto;
            if(r.next()){
                idc = r.getInt("id");
            }
            while(model.getRowCount() != 0){
                producto = model.getValueAt(0, 1).toString();
                precio = Double.parseDouble(model.getValueAt(0, 2).toString());
                cantidad = Integer.parseInt(model.getValueAt(0, 0).toString());
                model.removeRow(0);                
                r = c.executeQuery("select * from producto");
                while(r.next()){
                    if(r.getString("nombre").equals(producto)){
                        idp = r.getInt("id");
                        break;
                    }
                }
                for(int i = 0; i < model.getRowCount(); i++){
                    if(model.getValueAt(i, 1).equals(producto)){
                        cantidad += Integer.parseInt(model.getValueAt(i, 0).toString());
                        model.removeRow(i);
                        i--;                        
                    }
                }
                c.executeUpdate("insert into descripcionc(compra_id,producto_id,precio,cantidad) values("+idc+","+idp+","+precio+","+cantidad+")");
                actualizarinventario(cantidad);
            }
            r.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarinventario(int total){
        try {
            int existencia = 0;
            Statement c = n.conectar().createStatement();
            ResultSet r = c.executeQuery("select * from producto");
            while(r.next()){
                if(r.getInt("id") == idp){
                    existencia = r.getInt("cantidad");
                    existencia += total;
                    break;
                }
            }
            c.executeUpdate("update producto set cantidad = " + existencia + " where id = " + idp);
            r.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Compras dialog = new Compras(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
