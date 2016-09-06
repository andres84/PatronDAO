package pruebaInsercion3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class conexionOracle {
    
    
    

    public void connexion(String nom, String ape) {

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

    }
    
    public List<Persona> listar(){
        
        List<Persona> lista = null;
        
        final String DJDBC = "oracle.jdbc.OracleDriver";
        final String UrlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USUARIO = "USUARIO_LAB";
        final String CLAVE = "root";

        Connection cn = null;

        try {

            Class.forName(DJDBC);
            cn = DriverManager.getConnection(UrlOracle, USUARIO, CLAVE);
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM PERSONA");
            
            lista = new ArrayList();
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Persona p = new Persona();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                lista.add(p);
                
            }
            rs.close();
            ps.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
        return lista;
        
    }

}
