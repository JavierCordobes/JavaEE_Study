import datos.PersonaDAO;
import domain.Persona;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

//     Persona personaPrueba = new Persona("Prueba","PruebaApellido","prueba@mail","090909");

//        personaDAO.insertar(personaPrueba);
        //      personaDAO.insertar(personaPrueba);


        List<Persona> personas = null;
        try {
            personas = personaDAO.seleccionar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Persona p : personas) {
            System.out.println(p);
        }
        try {
            personaDAO.actualizar(new Persona(4, "1234", "1234", "1234", "1234"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Persona> personas2 = null;
        try {
            personas2 = personaDAO.seleccionar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Persona p : personas2) {
            System.out.println(p);
        }


    }


}
