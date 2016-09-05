package test_conexion_dboracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test_conexion_dboracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        //JDBC Driver nombre y base de datos url
        final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
        final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        //credenciales DB
        final String USER = "USUARIO_LAB";
        final String PASS = "root";

        Connection conexion = null;

        try {

            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            
            PreparedStatement st = conexion.prepareStatement("INSERT INTO PRUEBA_PERSONA VALUES (2, 'ISABELLA')");
            st.executeUpdate();
            st.close();

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }finally{
            
            if(conexion != null){
                
                if(!conexion.isClosed()){
                    
                    conexion.close();
                }
            }
            
        }

    }

}
