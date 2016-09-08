package dao;

import Entidad.Persona;
import interfaces.DAOPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOPersonaImp extends conexion implements DAOPersona {

    @Override
    public void registrar(Persona per) throws Exception {

        try {

            this.conectarBD();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO PERSONA VALUES (incremento_id_persona.NextVal,?,?)");
            st.setString(1, per.getNombre());
            st.setString(2, per.getApellido());
            st.executeUpdate();

        } catch (Exception e) {

            throw e;

        } finally {
            this.cerrarBD();
        }

    }

    @Override
    public void eliminar(Persona per) throws Exception {

        try {

            this.conectarBD();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM PERSONA WHERE CODIGO = ?");
            st.setInt(1, per.getCodigo());
            st.executeUpdate();

        } catch (Exception e) {
            throw e;

        } finally {
            this.cerrarBD();
        }

    }

    @Override
    public void actualizar(Persona per) throws Exception {

        try {

            this.conectarBD();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE PERSONA SET NOMBRE = ?, APELLIDO = ? WHERE CODIGO = ?");
            st.setString(1, per.getNombre());
            st.setString(2, per.getApellido());
            st.setInt(3, per.getCodigo());
            st.executeUpdate();

        } catch (Exception e) {

            throw e;
        } finally {
            this.cerrarBD();
        }

    }

    @Override
    public List<Persona> listar() throws Exception {

        List<Persona> lista = null;

        try {

            this.conectarBD();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM PERSONA");

            lista = new ArrayList();

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Persona p = new Persona();
                p.setCodigo(rs.getInt("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                lista.add(p);

            }
            rs.close();
            st.close();

        } catch (Exception e) {

            throw e;
        } finally {
            this.cerrarBD();
        }

        return lista;

    }

}
