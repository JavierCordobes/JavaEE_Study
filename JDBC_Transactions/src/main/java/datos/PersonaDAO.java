package datos;

import domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonaDAO {

    private Connection connectionTransaction;

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES(?, ?, ?, ?) ";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ? ";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?,email = ?, telefono = ? WHERE id_persona = ? ";

    public PersonaDAO() {

    }

    // contructor que recibe la conexion externa
    public PersonaDAO(Connection connectionTransaction) {
        this.connectionTransaction = connectionTransaction;
    }

    public List<Persona> seleccionar() throws SQLException {
        List<Persona> personas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Persona persona = construirPersona(rs);
                if (Objects.nonNull(persona)) {
                    personas.add(persona);
                }
            }
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.connectionTransaction == null) {
                    Conexion.close(conn);
                }

            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }
        return personas;

    }

    public int insertar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            persona.personaToStmt(stmt);
            registros = stmt.executeUpdate();


        } finally {
            try {
                Conexion.close(stmt);
                if (this.connectionTransaction == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }
        return registros;
    }

    public int borrar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();


        } finally {
            try {
                Conexion.close(stmt);
                if (this.connectionTransaction == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }

        return registros;
    }

    public int actualizar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            persona.personaToStmt(stmt);
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();


        } finally {
            try {
                Conexion.close(stmt);
                if (this.connectionTransaction == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }
        return registros;
    }


    private static Persona construirPersona(ResultSet rs) {
        try {
            return new Persona(rs);
        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        }
        return null;
    }


}
