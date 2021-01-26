import domain.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ColeccionPersonas {
    ArrayList<Persona> personas;

    public ColeccionPersonas() {
        personas = new ArrayList<>();
    }

    public ArrayList<Persona> converterPersona(ResultSet resultado) throws SQLException {
        while (resultado.next()) {

            Persona persona = new Persona(resultado.getInt("id_persona"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"), "Email:  " +
                    resultado.getString("email"),
                    resultado.getString("telefono"));
            personas.add(persona);


        }
        return personas;
    }

    public void addPersona(Persona persona) {
        personas.add(persona);


    }


}
