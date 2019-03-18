
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
    int id, idv;
    String fecha = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH+1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
    public void realizarventa(int id, JTable datos, double total){
        venta(total, fecha, "1", id);
        generaridv();
        leerlimpiartabla(datos);
    }
    private void generaridv(){
        Statement s;
        try {
            s = cn.createStatement();
            ResultSet r = s.executeQuery("select id from venta");
                 while(r.next()){
                    idv = r.getInt("id");
                }
        } catch (SQLException ex) {
            Logger.getLogger(VentaRealizada.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    private void descripcionv(int idp, int idv, double precio){
        try {
             Statement s = cn.createStatement();
             ResultSet r = s.executeQuery("select * from descripcionv");
             boolean encontrado = true;
             
                 while(r.next()){
                    if(r.getInt("producto_id") == idp && r.getInt("venta_id")== idv){
                            PreparedStatement pps = s.getConnection().prepareStatement("update descripcionv set cantidad ='" + (r.getInt("cantidad")+1) +
                            "'where producto_id = '" + r.getInt("producto_id") + "'");
                            pps.executeUpdate();
                            encontrado = false;
                            break;
                        }
                    }
                if(encontrado){
                     PreparedStatement stm;
                            stm = cn.prepareStatement("insert into descripcionv(producto_id, venta_id, cantidad, precio) values(?,?,?,?)");
                            stm.setInt(1, idp);
                            stm.setInt(2, idv);
                            stm.setDouble(4, precio);
                            stm.setInt(3, 1);
                            stm.executeUpdate();
                            stm.close();
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void venta(Double total, String fecha, String nofactura,int id){
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
    private void restarbd(String nombre){
        try {
            Statement s = cn.createStatement();
            ResultSet r = s.executeQuery("select * from producto");
                while(r.next()){
                    if(r.getString("nombre").equals(nombre)){
                        descripcionv(r.getInt("id"), idv, r.getDouble("precio"));
                        PreparedStatement pps = s.getConnection().prepareStatement("update producto set cantidad ='" + (r.getInt("cantidad")-1) +
                        "'where id = '" + r.getInt("id") + "'");
                        pps.executeUpdate();
                        break;
                    }
                }
        } catch (SQLException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void leerlimpiartabla(JTable datos){
        DefaultTableModel dtm = (DefaultTableModel) datos.getModel();
          int a = 0, filas = dtm.getRowCount();
          Object valor = new Object();
          String nombre;
                        while(a < filas){
                            valor = dtm.getValueAt(a, 1);
                            nombre = String.valueOf(valor);
                            restarbd(nombre);
                            a++;
                        }
                        for (int i = filas; i >= 1; i--) {  
                            dtm.removeRow(dtm.getRowCount()-1);
                        }
    }
    public void mostrardatos(JTable mostar, JLabel nomvendedor, int idvendedor){
        DefaultTableModel model = (DefaultTableModel) mostar.getModel();
        int filas = model.getRowCount();
        leerlimpiartabla(mostar);
        try {
            Statement st = cn.createStatement();
            ResultSet r = st.executeQuery("select v.nombre,vt.id, vt.fecha, vt.total "
                    + "from vendedor v "
                    + "inner join login l "
                    + "on v.id = l.vendedor_id  "
                    + "inner join venta vt "
                    + "on vt.login_id = l.id "
                    + " where l.id = "+ idvendedor + ""
                    + " order by vt.id desc ");
            //DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                while(r.next()){
                        Object[] producto = new Object[]{r.getInt("vt.id"),r.getDouble("vt.total"),r.getDate("vt.fecha"),0};
                        model.addRow(producto);
                        nomvendedor.setText(r.getString("v.nombre"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(VentaRealizada.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    public void mostrardescripcion(JTable datosmos, JLabel ttotal, int idvendedor){
       try {
           leerlimpiartabla(datosmos);
           double precio = 0, total = 0;
            Statement st = cn.createStatement();
            ResultSet r = st.executeQuery("select p.nombre, p.precio, des.cantidad, vt.total "
                    + "from venta vt "
                    + "inner join descripcionv des "
                    + "on vt.id = des.venta_id  "
                    + "inner join producto p "
                    + "on des.producto_id = p.id "
                    + " where des.venta_id = " + idvendedor );
            DefaultTableModel model = (DefaultTableModel) datosmos.getModel();
                while(r.next()){
                        precio = r.getInt("des.cantidad")*r.getDouble("p.precio");
                        Object[] producto = new Object[]{r.getInt("des.cantidad"),r.getString("p.nombre"),precio};
                        model.addRow(producto);
                        total = r.getDouble("vt.total");
                        ttotal.setText(String.valueOf(total));
                        
                }           
        
        } catch (SQLException ex) {
            Logger.getLogger(VentaRealizada.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
