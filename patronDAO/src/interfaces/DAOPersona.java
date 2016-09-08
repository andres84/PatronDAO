package interfaces;

import Entidad.Persona;
import java.util.List;

public interface DAOPersona {

    public void registrar(Persona per) throws Exception;

    public void eliminar(Persona per) throws Exception;

    public void actualizar(Persona per) throws Exception;
    
    public List<Persona> listar() throws Exception;
            

}
