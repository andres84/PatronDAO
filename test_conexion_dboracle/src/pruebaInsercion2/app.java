package pruebaInsercion2;

import java.util.Scanner;

public class app {

    public static void main(String... andres) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite nombre");
        String nombre = sc.nextLine();
        System.out.println("Digite apellido");
        String apellido = sc.nextLine();
        
        Persona ps = new Persona();
        ps.setNombre(nombre);
        ps.setApellido(apellido);
        
        String capnom = ps.getNombre();
        String capape = ps.getApellido();
        
                
        if(nombre != null && apellido != null){
            
            conexionBD cn = new conexionBD();
            cn.conexionOracle(capnom, capape);
            
            
        }else{
            
            System.out.println("Error no se guardaron los datos");
            
        }
        

    }

}
