package datos;

import domain.Persona;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDAO {
    public abstract List<Persona> seleccionar() throws SQLException;

    public int insertar(Persona persona) throws SQLException;

    public int actualizar(Persona persona) throws SQLException;

    public int borrar(Persona persona) throws SQLException;

}
