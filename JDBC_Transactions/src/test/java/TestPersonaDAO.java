import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;


public class TestPersonaDAO {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit() == true) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDAO = new PersonaDAO(conexion);

            personaDAO.insertar(new Persona("Persona1", "persona1", "Persona1", "Persona1"));

            personaDAO.seleccionar();
            personaDAO.actualizar(new Persona(1, "modi", "modi", "modi", "modi"));
            personaDAO.borrar(new Persona(14));
            conexion.commit();


        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            System.out.println("Se entra a rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex1.getErrorCode(), ex1.getMessage(), ex1.getCause()));
            }
        }

    }


    @Test
    public void testSeleccionar() {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = null;
        try {
            personas = personaDAO.seleccionar();
        } catch (SQLException ex1) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex1.getErrorCode(), ex1.getMessage(), ex1.getCause()));
        }
        Persona persona1 = personas.get(0);
        Persona persona2 = personas.get(1);

        Assert.assertEquals(1, persona1.getIdPersona());
        Assert.assertEquals(2, persona2.getIdPersona());

    }


}
