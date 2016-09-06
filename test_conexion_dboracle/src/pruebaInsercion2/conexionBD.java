package pruebaInsercion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class conexionBD {

    public void conexionOracle(String nombre, String apellido) {

        final String jdbcDriver = "oracle.jdbc.OracleDriver";
        final String UrlBD = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USUARIO = "USUARIO_LAB";
        final String CLAVE = "root";
        
        Connection cn = null;
        
        try{
            
            Class.forName(jdbcDriver);
            cn = DriverManager.getConnection(UrlBD, USUARIO, CLAVE);
            PreparedStatement ps = cn.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,?,?)");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        }

    }

}
