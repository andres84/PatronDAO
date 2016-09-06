package pruebaIsercion;

import java.util.Scanner;

public class app {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite su nombre");
        String nombre = sc.nextLine();
        System.out.println("Digite su apellido");
        String apellido = sc.nextLine();
        
        Persona per = new Persona();
        per.setNombre(nombre);
        per.setApellido(apellido);
        
        String capnom = per.getNombre();
        String capape = per.getApellido();
        
        
        
        if(capnom != null && capape != null){
            
            conexionBD cn = new conexionBD();
            cn.con(capnom, capape);
            
        }else{
            
            System.out.println("Error al guardar datos");
        }
        
    }
    
}
