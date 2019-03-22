package Clasesbd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.bases.Conexion;
import proyecto.bases.Ventas;

public class VentaRealizada {
    Conexion cx = new Conexion();
    Connection cn = cx.conectar();
    Calendar cal = new GregorianCalendar();
    int id, idventa;
    String fecha = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
    public void realizarventa(int idpersona, JTable datos1, double total) {
        id = idpersona;
        venta(total, fecha, "1");
        generaridv();
        contartabla(datos1);
    }
    private void generaridv() {
        Statement s;
        try {
            s = cn.createStatement();
            ResultSet r = s.executeQuery("select id from venta "
                    + "where id = (select max(id) from venta) ");
            if (r.next()) {
                idventa = r.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaRealizada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void descripcionv(int idp, int cantidad, double precio) {
        try {
            PreparedStatement stm;
            stm = cn.prepareStatement("insert into descripcionv(producto_id, venta_id, cantidad, precio) values(?,?,?,?)");
            stm.setInt(1, idp);
            stm.setInt(2, idventa);
            stm.setDouble(4, precio);
            stm.setInt(3, cantidad);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void venta(Double total, String fecha, String nofactura) {
        try {
            PreparedStatement stm;
            stm = cn.prepareStatement("insert into venta(total, fecha, nfactura, login_id) values(?,?,?,?)");
            stm.setDouble(1, total);
            stm.setDate(2, Date.valueOf(fecha));
            stm.setString(3, nofactura);
            stm.setInt(4, id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void restarbd(String nombre, int cantidad) {
        try {
            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("select * from producto");
            while (r.next()) {
                if (r.getString("nombre").equals(nombre)) {
                    PreparedStatement pps = s.getConnection().prepareStatement("update producto set cantidad ='" + (r.getInt("cantidad") - cantidad)
                            + "'where id = '" + r.getInt("id") + "'");
                    pps.executeUpdate();
                    descripcionv(r.getInt("id"), cantidad, r.getDouble("precio"));
                    System.out.println("dato = " + r.getInt("id"));
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void contartabla(JTable datoscontados) {
        DefaultTableModel model = (DefaultTableModel) datoscontados.getModel();
        int total = 1;
        String producto = "";
        while (model.getRowCount() != 0) {
            producto = model.getValueAt(0, 1).toString();
            model.removeRow(0);
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 1).equals(producto)) {
                    total++;
                    model.removeRow(i);
                    i--;
                }
            }
            System.out.println(total + " " + producto);
            restarbd(producto, total);
            total = 1;
        }
    }
    private void limpiartabla(JTable datos) {
        DefaultTableModel dtm = (DefaultTableModel) datos.getModel();
        int a = 0, filas = dtm.getRowCount();
        for (int i = filas; i >= 1; i--) {
            dtm.removeRow(dtm.getRowCount() - 1);
        }
    }
    public void mostrardatos(JTable mostar, JLabel nomvendedor, int idvendedor) {
        DefaultTableModel model = (DefaultTableModel) mostar.getModel();
        int filas = model.getRowCount();
        limpiartabla(mostar);
        try {
            Statement st = cn.createStatement();
            ResultSet r = st.executeQuery("select v.nombre,vt.id, vt.fecha, vt.total "
                    + "from vendedor v "
                    + "inner join login l "
                    + "on v.id = l.vendedor_id  "
                    + "inner join venta vt "
                    + "on vt.login_id = l.id "
                    + " where l.id = " + idvendedor + ""
                    + " order by vt.id desc ");
            while (r.next()) {
                Object[] producto = new Object[]{r.getInt("vt.id"), r.getDouble("vt.total"), r.getDate("vt.fecha"), 0};
                model.addRow(producto);
                nomvendedor.setText(r.getString("v.nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaRealizada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void mostrardescripcion(JTable datosmos, JLabel ttotal, int idnumeroventa) {
        try {
            DefaultTableModel model = (DefaultTableModel) datosmos.getModel();
            limpiartabla(datosmos);
            double precio = 0, total = 0;
            Statement st = cn.createStatement();
            ResultSet r = st.executeQuery("select p.nombre, p.precio, des.cantidad, vt.total "
                    + "from venta vt "
                    + "inner join descripcionv des "
                    + "on vt.id = des.venta_id  "
                    + "inner join producto p "
                    + "on des.producto_id = p.id "
                    + "where vt.id = " + idnumeroventa);
            while (r.next()) {
                precio = r.getInt("des.cantidad") * r.getDouble("p.precio");
                Object[] producto = new Object[]{r.getInt("des.cantidad"), r.getString("p.nombre"), precio};
                model.addRow(producto);
                total = r.getDouble("vt.total");
                ttotal.setText(String.valueOf(total));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaRealizada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}