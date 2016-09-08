package app;

import Entidad.Persona;
import dao.DAOPersonaImp;
import interfaces.DAOPersona;
import java.util.Scanner;

public class ejecucion {

    public static void main(String... andres) {

        Scanner sc = new Scanner(System.in);
        Persona per = new Persona();
        DAOPersona dao = new DAOPersonaImp();
        int opc = 0;

        do {
            System.out.println("****Bienvenido****");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Modifocar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion");
            opc = sc.nextInt();

            switch (opc) {
                /////////CASO 1/////////
                case 1:
                    System.out.println("Registro de usuarios");
                    System.out.println("Digite nombre");
                    String nombre = sc.next();
                    System.out.println("Digite apellido");
                    String apellido = sc.next();

                    per.setNombre(nombre);
                    per.setApellido(apellido);

                    try {

                        dao.registrar(per);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                /////////////CASO 2/////////////
                case 2:
                    System.out.println("Modificar usuario");
                    System.out.println("Lista de usuarios");

                    try {
                        System.out.println("Codigo Nombres Apellidos");
                        for (Persona p : dao.listar()) {

                            System.out.println(p.getCodigo() + "    " + p.getNombre() + "    " + p.getApellido());
                        }

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    System.out.println("digite el codigo de usuario que desea modificar");
                    int codigo = sc.nextInt();
                    per.setCodigo(codigo);
                    System.out.println("Modificar nombre");
                    String n = sc.next();
                    per.setNombre(n);
                    System.out.println("Modificar apellido");
                    String a = sc.next();
                    per.setApellido(a);

                    try {

                        dao.actualizar(per);
                        System.out.println("Usuario modificado");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;
                ////////////CASO 3 //////////////////
                case 3:
                    System.out.println("Modificar usuario");
                    System.out.println("Lista de usuarios");

                    try {
                        System.out.println("Codigo Nombres Apellidos");
                        for (Persona p : dao.listar()) {

                            System.out.println(p.getCodigo() + "    " + p.getNombre() + "    " + p.getApellido());
                        }

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    System.out.println("digite el codigo de usuario que desea eliminar");
                    int codigo2 = sc.nextInt();
                    per.setCodigo(codigo2);

                    try {

                        dao.eliminar(per);
                        System.out.println("Usuario eliminado");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }
                    break;

                ///////////CASO 4///////
                case 4:

                    System.out.println("Lista de usuarios");

                    try {
                        System.out.println("Codigo Nombres Apellidos");
                        for (Persona p : dao.listar()) {

                            System.out.println(p.getCodigo() + "    " + p.getNombre() + "    " + p.getApellido());
                        }

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                default:
                    System.out.println("Gracias por utilizar la aplicacion");

            }

        } while (opc != 5);

    }

}
