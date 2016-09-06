package pruebaIsercion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class conexionBD {

    public void con(String nom, String ape) {

        final String jdbcBD = "oracle.jdbc.OracleDriver";
        final String urlBD = "jdbc:oracle:thin:@localhost:1521:XE";
        final String Usuario = "USUARIO_LAB";
        final String Clave = "root";
        
        Connection cn = null;

        try {
            
            Class.forName(jdbcBD);
            cn = DriverManager.getConnection(urlBD, Usuario, Clave);
            PreparedStatement ps = cn.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,?,?)");
            ps.setString(1, nom);
            ps.setString(2, ape);
            
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            
        }

    }

}
