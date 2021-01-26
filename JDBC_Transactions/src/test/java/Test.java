import datos.PersonaDAO;
import domain.Persona;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PersonaDAO personaDAO=new PersonaDAO();

//     Persona personaPrueba = new Persona("Prueba","PruebaApellido","prueba@mail","090909");

//        personaDAO.insertar(personaPrueba);
  //      personaDAO.insertar(personaPrueba);


        List<Persona> personas = personaDAO.seleccionar();
        for(Persona p : personas){
            System.out.println(p);
        }
      personaDAO.actualizar(new Persona(4,"1234","1234","1234","1234"));

        List<Persona> personas2 = personaDAO.seleccionar();
        for(Persona p : personas2){
            System.out.println(p);
        }
        int a = 0;

        int b = a!=0 ? 5 : 1;
        System.out.println(b);

    }









}
