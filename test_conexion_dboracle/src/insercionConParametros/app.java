package insercionConParametros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class app {

    private String nombre;
    private String apellido;

    public void entradaDatos() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite su nombre");
        nombre = sc.nextLine();
        System.out.println("Digite su apellido");
        apellido = sc.nextLine();

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void registrarBD(String nom, String ape) {

        final String jdbcOracle = "oracle.jdbc.OracleDriver";
        final String urlOracle = "jdbc:oracle:thin:@localhost:1521:XE";
        final String Usuario = "USUARIO_LAB";
        final String Clave = "root";

        Connection con = null;

        try {

            Class.forName(jdbcOracle);
            con = DriverManager.getConnection(urlOracle, Usuario, Clave);
            PreparedStatement ps = con.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,?,?)");
            ps.setString(1, nom);
            ps.setString(2, ape);
            //ps.setString(3, valor);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public static void main(String... fragozo) {

        app app = new app();

        app.entradaDatos();

        String nombre = app.getNombre();
        String apellido = app.getApellido();

        if (nombre != null && apellido != null) {

            app.registrarBD(nombre, apellido);

        }

    }

}
