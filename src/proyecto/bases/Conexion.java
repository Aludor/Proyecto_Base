package proyecto.bases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection cx;
    String db = "surtifiestas";
    String url = "jdbc:mariadb://localhost:3306/" + db;
    String user = "root";
    String pass = "bases1";

    public Connection conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cx = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3306/surtifiestas", "root", "Fercho.21");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo conectar " + ex);
        }
        return cx;
    }

    public Connection desconectar() {
        try {
            cx.close();
            System.out.println("Conexion terminada");
        } catch (SQLException ex) {
            System.out.println("No se pude cerrar la conexion");
        }
        return cx;
    }
}
