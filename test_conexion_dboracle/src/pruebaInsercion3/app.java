package pruebaInsercion3;

import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite su nombre");
        String nombre = sc.nextLine();
        System.out.println("Digite su apellido");
        String apellido = sc.nextLine();

        Persona p = new Persona();
        p.setNombre(nombre);
        p.setApellido(apellido);

        String capnom = p.getNombre();
        String capape = p.getApellido();

        conexionOracle cn = new conexionOracle();
        cn.connexion(capnom, capape);

    }

}
