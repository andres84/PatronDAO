package insercionConParametros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class app {
    
    
    public String entradaDatos(){
        
        Scanner sc = new Scanner(System.in);
            System.out.println("Digite su nombre");
            String nombre = sc.nextLine();
            //System.out.println("Digite su apellido");
            //String apellido = sc.nextLine();
          
            
            return nombre;
            
        
    }
    
    
    public void registrarBD(String valor){
        
        final String jdbcOracle = "oracle.jdbc.OracleDriver";
        final String urlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
        final String Usuario = "USUARIO_LAB";
        final String Clave = "root";

        Connection con = null;
        
        try {
            
            Class.forName(jdbcOracle);
            con = DriverManager.getConnection(urlOracle, Usuario, Clave);
            PreparedStatement ps = con.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,?)");
            ps.setString(1, valor);
           
            //ps.setString(2, valor);
            //ps.setString(3, valor);
            
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }

        
        
    }
    

    public static void main(String... fragozo) {

        
        app app = new app();
        String valor = app.entradaDatos();
        if(valor != null){
        
            app.registrarBD(valor);
            
        }
        
        
        
    }

}
