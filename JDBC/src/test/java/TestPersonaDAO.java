import datos.PersonaDAO;
import domain.Persona;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestPersonaDAO {

    @Test
    public void testSeleccionar(){
        List<Persona> personas = PersonaDAO.seleccionar();
        Persona persona1 = personas.get(0);
        Persona persona2 = personas.get(1);

        Assert.assertEquals(1,persona1.getIdPersona());
        Assert.assertEquals(2,persona2.getIdPersona());

    }


}
