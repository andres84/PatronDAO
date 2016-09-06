package test_conexion_dboracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class test2 {

    public static void main(String[] args) {

        //primero se debe tener las variables del jdbc, url de la db, user y pass
        final String driverOra = "oracle.jdbc.OracleDriver";
        final String urlDB = "jdbc:oracle:thin:@localhost:1521:XE";
        final String usuario = "USUARIO_LAB";
        final String clave = "root";

        //crear bloque try catch
        Connection cn = null;//crear variable de conexion

        try {

            Class.forName(driverOra);//contiene nombre del driver jdbc
            
            //convocar DriverManager para abrir la conexion a la db
            
            cn = DriverManager.getConnection(urlDB, usuario, clave);

            //crear PreparedStatement para crear un query
            PreparedStatement ps = cn.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,'SARA', 'FRAGOZO')");
            //convocar metodo de ejecucion update hecia la bd
            ps.executeUpdate();
            //cerrar conexion
            ps.close();
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

}
