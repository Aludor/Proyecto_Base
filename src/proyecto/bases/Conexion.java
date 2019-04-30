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
<<<<<<< HEAD
            cx = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/surtifiestas", "root", "bases1");
=======
            cx = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/surtifiestas", "root", "Fercho.21");
            System.out.println("Conexion exitosa");
>>>>>>> 64c1d4f63ac5680351251e0888c588a7c13eb60e
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