package proyecto.bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    Connection cx;
    public Connection conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            //cx = (Connection) DriverManager.getConnection("jdbc:mariadb://192.168.1.241/surtifiestas", "root", "bases1");
            cx = (Connection) DriverManager.getConnection("jdbc:mariadb://192.168.1.171/surtifiestas", "root", "Fercho.21");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar " + ex);
        }
        return cx;
    }
    public Connection desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexixon " + ex);
        }
        return cx;
    }
}