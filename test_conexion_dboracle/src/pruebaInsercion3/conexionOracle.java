package pruebaInsercion3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class conexionOracle {

    public void connexion(String nom, String ape) {

    
        
        if(nom != null && ape != null){
            
                final String DJDBC = "oracle.jdbc.OracleDriver";
        final String UrlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USUARIO = "USUARIO_LAB";
        final String CLAVE = "root";

        Connection cn = null;

        try {

            Class.forName(DJDBC);
            cn = DriverManager.getConnection(UrlOracle, USUARIO, CLAVE);
            PreparedStatement ps = cn.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,?,?)");
            ps.setString(1, nom);
            ps.setString(2, ape);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
            
            
        }else{
            
            
            System.out.println("Error al guardar datos");
            
        }
        

    }

}
