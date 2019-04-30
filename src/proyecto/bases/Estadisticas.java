package proyecto.bases;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Estadisticas extends javax.swing.JDialog {
    public Estadisticas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height - 50);
        setLocationRelativeTo(null);
        jButton1.setEnabled(false);
    }
    Conexion n = new Conexion();    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 680));
        setPreferredSize(new java.awt.Dimension(1300, 680));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("   ");
        jPanel2.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel2.setText("          ");
        jPanel2.add(jLabel2, java.awt.BorderLayout.WEST);

        jLabel3.setText("          ");
        jPanel2.add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel4.setText("   ");
        jPanel2.add(jLabel4, java.awt.BorderLayout.SOUTH);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "Mes" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);

        jPanel3.add(jComboBox2);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            Statement c = n.conectar().createStatement();
            if(jComboBox1.getSelectedItem().equals("Año")){
                jComboBox2.removeAllItems();
                ResultSet r = c.executeQuery("select year(fecha) from venta group by year(fecha)");
                while(r.next()){
                    jComboBox2.addItem(r.getString("year(fecha)"));
                }
            }
            else if(jComboBox1.getSelectedItem().equals("Mes")){
                jComboBox2.removeAllItems();
                ResultSet r = c.executeQuery("select month(fecha) from venta group by month(fecha)");
                while(r.next()){
                    jComboBox2.addItem(r.getString("month(fecha)"));
                }
            }
            jButton1.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jPanel4.removeAll();
            ResultSet r = null;
            JFreeChart grafica;    
            DefaultCategoryDataset diseño = new DefaultCategoryDataset();
            Statement c = n.conectar().createStatement();
            if(jComboBox1.getSelectedItem().equals("Año")){
                r = c.executeQuery("select p.nombre, sum(dv.cantidad)\n" +
                                            "from venta v\n" +
                                            "inner join descripcionv dv\n" +
                                            "on v.id = dv.venta_id\n" +
                                            "inner join producto p\n" +
                                            "on dv.producto_id = p.id\n" +
                                            "where year(fecha) = '"+ jComboBox2.getSelectedItem() +
                                            "' group by producto_id");
            }
            else if(jComboBox1.getSelectedItem().equals("Mes")){
                r = c.executeQuery("select p.nombre, sum(dv.cantidad)\n" +
                                            "from venta v\n" +
                                            "inner join descripcionv dv\n" +
                                            "on v.id = dv.venta_id\n" +
                                            "inner join producto p\n" +
                                            "on dv.producto_id = p.id\n" +
                                            "where month(fecha) = '"+ jComboBox2.getSelectedItem() +
                                            "' group by producto_id");
            }
            while(r.next()){
                diseño.addValue(r.getInt("sum(dv.cantidad)"), "estadisticas", r.getString("nombre"));
            }
            grafica = ChartFactory.createBarChart("barras", "cantidad", "producto", diseño, PlotOrientation.VERTICAL, true, true, false);         
            ChartPanel Panel = new ChartPanel(grafica);
            jPanel4.setLayout(new CardLayout());
            jPanel4.add(Panel);
            jPanel4.validate();
        } catch (SQLException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Estadisticas dialog = new Estadisticas(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}