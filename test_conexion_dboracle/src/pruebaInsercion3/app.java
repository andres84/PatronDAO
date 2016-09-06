package pruebaInsercion3;

import java.util.List;
import java.util.Scanner;

public class app {
    
    
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. guardar datos de usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("Seleccione una opcion:");
        int opc = sc.nextInt();

        conexionOracle cn;

        switch (opc) {

            case 1:

                System.out.println("Digite su nombre");
                String nombre = sc.next();
                System.out.println("Digite su apellido");
                String apellido = sc.next();

                Persona p = new Persona();
                p.setNombre(nombre);
                p.setApellido(apellido);

                String capnom = p.getNombre();
                String capape = p.getApellido();

                cn = new conexionOracle();
                cn.connexion(capnom, capape);

                break;

            case 2:

                cn = new conexionOracle();
                
                for (Persona s : cn.listar()) {

                    System.out.println(s.getCodigo() + "-" + s.getNombre() + "-" + s.getApellido());

                }

                break;

            default:
                System.out.println("Presiona 1 o 2 Gracias");

        }

    }

}
