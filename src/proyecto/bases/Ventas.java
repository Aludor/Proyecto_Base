package proyecto.bases;

import Clasesbd.VentaRealizada;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JDialog {
    public Ventas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(getToolkit().getScreenSize());
         jTextField1.requestFocus();
    }
    VentaRealizada Vr = new VentaRealizada();
    Conexion cx = new Conexion();
    Connection cn = cx.conectar();
    double total = 0;
    int idv;
    static int id, posc= 0;
    static String Nonbrev;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        Menu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jMenuItem1.setText("       SALIR      ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setForeground(new java.awt.Color(255, 51, 51));
        jMenuItem2.setText("ANULAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        Menu.setBackground(new java.awt.Color(153, 204, 255));
        Menu.setForeground(new java.awt.Color(0, 0, 0));
        Menu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Menu.setOpaque(true);
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {0, 17, 0, 17, 0, 17, 0, 17, 0, 17, 0, 17, 0, 17, 0, 17, 0};
        jPanel3Layout.rowHeights = new int[] {0, 18, 0, 18, 0, 18, 0, 18, 0, 18, 0};
        jPanel3.setLayout(jPanel3Layout);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(jLabel11, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weighty = 15.0;
        gridBagConstraints.insets = new java.awt.Insets(23, 0, 0, 0);
        jPanel3.add(jTextField1, gridBagConstraints);

        jTextField2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 15.0;
        gridBagConstraints.weighty = 15.0;
        jPanel3.add(jTextField2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CAMBIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 2, 21, 2);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        jPanel3.add(jLabel4, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("TOTAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 0, 20, 0);
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("VENDEDOR-----------");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel3.add(jLabel9, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("VENDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.insets = new java.awt.Insets(89, 0, 59, 0);
        jPanel3.add(jButton1, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setBackground(new java.awt.Color(51, 153, 255));

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
        jTable1.setBackground(new java.awt.Color(153, 204, 255));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "PRECIO/UNIDAD"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(51, 153, 255));
        jTable1.setRowHeight(25);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        Menu.addTab("VENTA", jPanel1);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("_______________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        jPanel10.add(jLabel6, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("VENDEDOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 189;
        jPanel10.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel10.add(jLabel14, gridBagConstraints);

        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setText("MOSTRAR FACTURAS ANULADAS");
        jRadioButton1.setBorder(null);
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 66);
        jPanel10.add(jRadioButton1, gridBagConstraints);

        jPanel4.add(jPanel10);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.CardLayout());

        jScrollPane2.setBackground(new java.awt.Color(51, 153, 255));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
        jTable2.setBackground(new java.awt.Color(153, 204, 255));
        jTable2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# VENTA", "ANULADA", "TOTAL", "FECHA", "HORA"
            }
        ));
        jTable2.setComponentPopupMenu(jPopupMenu2);
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setFillsViewportHeight(true);
        jTable2.setRowHeight(25);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel5.add(jScrollPane2, "card4");

        jPanel4.add(jPanel5);

        Menu.addTab("DETALLE VENTA", jPanel4);

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.CardLayout());

        jScrollPane3.setBackground(new java.awt.Color(51, 153, 255));
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
        jTable3.setBackground(new java.awt.Color(153, 204, 255));
        jTable3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "DESCRIPCION", "PRECIO/UNIDAD", "PRECIO TOTAL"
            }
        ));
        jTable3.setFillsViewportHeight(true);
        jTable3.setRowHeight(25);
        jScrollPane3.setViewportView(jTable3);

        jPanel9.add(jScrollPane3, "card2");

        jPanel7.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(1, 0));
        jPanel8.add(jLabel12);
        jPanel8.add(jLabel13);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("TOTAL");
        jPanel8.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("0");
        jPanel8.add(jLabel8);

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        Menu.addTab("DESCRIPCION VENTA", jPanel7);

        getContentPane().add(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void dvendedor(int idvendedor, String nomb, int pos) {
        id = idvendedor;
        Nonbrev = nomb;
        posc = pos;
        jLabel9.setText(Nonbrev);
    }
    public void imagens() {
        ImageIcon imagen = new ImageIcon("src" + File.separator + "imagenes" + File.separator + "salir.jpg");
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(WIDTH, HEIGHT, WIDTH));
    }    public void asignar(String cadena, int cantidad, double precio) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        boolean encontrado = true;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).equals(cadena)) {
                model.setValueAt((int) model.getValueAt(i, 0) + 1, i, 0);
                total += precio;
                encontrado = false;
                break;
            }
        }
        if (encontrado) {
            Object[] producto = new Object[]{cantidad, cadena, precio};
            model.addRow(producto);
            total += precio;
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        if(posc ==0){
              Login lg = new Login();
              lg.setVisible(true);
        }else{
            Menu m = new Menu();
            m.setVisible(true);
        }
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        if (Menu.getSelectedIndex() == 0) {
            setSize(getToolkit().getScreenSize());
            setLocationRelativeTo(null);
        } 
        else if (Menu.getSelectedIndex() == 1) {
            Vr.mostrardatos(jTable2, jLabel6, id, false);
            setSize(1237, 646);
            setLocationRelativeTo(null);
        } 
        else if (Menu.getSelectedIndex() == 2) {
            //Menu.setSelectedIndex(1);
            setSize(1237, 646);
            setLocationRelativeTo(null);
        }
        
    }//GEN-LAST:event_MenuMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 2) {
            Menu.setSelectedIndex(2);
            Object valor = new Object();
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            valor = dtm.getValueAt(jTable2.getSelectedRow(), 0);
            Vr.mostrardescripcion(jTable3, jLabel8, (int) valor);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if(evt.getKeyCode() == evt.VK_BACK_SPACE){
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            total -= (double)model.getValueAt(jTable1.getSelectedRow(), 2);
            model.removeRow(jTable1.getSelectedRow());
            jLabel2.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        int filas = dtm.getRowCount();
        if (filas == 0 ) {
            JOptionPane.showMessageDialog(rootPane, "NO HAY PRODCUTOS", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Vr.realizarventa(id, jTable1, total);
            jLabel2.setText("0");
            total = 0;
        }
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == 10) {
            double cambio = Double.parseDouble(jTextField2.getText());
            cambio -= Double.parseDouble(jLabel2.getText());
            jLabel4.setText(String.valueOf(cambio));
            jTextField2.setText("");
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        Statement s;
        try {
            s = cn.createStatement();
            ResultSet r = s.executeQuery("select * from producto ");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int n = model.getRowCount();
            if (evt.getKeyCode() == 10) {
                while (r.next()) {
                    if (r.getString("codigo").equals(jTextField1.getText())) {
                        Object[] producto = new Object[]{r.getString("codigo"), r.getString("nombre"), r.getDouble("precio")};
                        total += r.getDouble("precio");
                        model.addRow(producto);
                        total = Vr.verificarexistencia(jTable1, r.getString("nombre"),r.getInt("cantidad"),total, jLabel2);
                        break;
                    }
                }
                jTextField1.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton1.isSelected()){
            //System.out.println("mostrar facturas anuladas");
            Vr.mostrardatos(jTable2, jLabel6, id, true);
        }else{
            //System.out.println("mostrar facturas no anuladas");
            Vr.mostrardatos(jTable2, jLabel6, id, false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       //anular facturas
       DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
       int selec = jTable2.getSelectedRow();
       System.out.println(selec);
       if(selec != -1){
       String anulada = model.getValueAt(selec, 1).toString();
            if("NO".equals(anulada)){
               int idvt = (int) model.getValueAt(selec, 0);
                    try {
                        Statement s = cn.createStatement();
                        ResultSet r = s.executeQuery("update venta set anulada = true "
                       + "where id = " + idvt);
                        } catch (SQLException ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                    }    
            }
                Vr.mostrardatos(jTable2, jLabel6, id,false);
          }

       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventas dialog = new Ventas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTabbedPane Menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}