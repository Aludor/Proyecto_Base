
package Clasesbd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.StandardEmitterMBean;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.bases.Conexion;

public class Editarproducto {
    Conexion cx = new Conexion();
    Connection cn = cx.conectar();
public void llenartabla(JTable model){
    DefaultTableModel mode = (DefaultTableModel)model.getModel();
        try {
            Statement st = cn.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM producto "
                    + "order by cantidad asc");
            while (r.next()) {                
                Object[]  producto = new  Object[]{r.getString("codigo"), r.getString("nombre"), r.getInt("cantidad")};
                mode.addRow(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Editarproducto.class.getName()).log(Level.SEVERE, null, ex);
        }
}    
public void agregarnuevoproducto(String codigo, String nombre, double precio){
        try {
            CallableStatement st = cn.prepareCall("{call  agregarproducto (?,?,?)}");
            st.setString(1, codigo);
            st.setString(2, nombre);
            st.setDouble(3, precio);
            st.execute();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Editarproducto.class.getName()).log(Level.SEVERE, null, ex);
        }
                
}
}
