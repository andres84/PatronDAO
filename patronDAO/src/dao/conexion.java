package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    protected Connection conexion;

    private final String JDBCDriver = "oracle.jdbc.OracleDriver";
    private final String UrlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String Usuario = "USUARIO_LAB";
    private final String Clave = "root";

    public void conectarBD() throws Exception {

        try {
            
            
            conexion = DriverManager.getConnection(UrlOracle, Usuario, Clave);
            Class.forName(JDBCDriver);

        } catch (Exception e) {

            throw e;

        }

    }

    public void cerrarBD() throws SQLException {

        if (conexion != null) {
            if (!conexion.isClosed()) {

                conexion.close();

            }
        }

    }

}
