package datos;

import domain.Persona;
import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES(?, ?) ";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ? ";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ? ";

    public static List<Usuario> seleccionar() {
        List<Usuario> usuarios = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = construirUsuario(rs);
                if (Objects.nonNull(usuario)) {
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }
        return usuarios;

    }
    public static int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            usuario.usuarioToStmt(stmt);
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }
        return registros;
    }

    public static int borrar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }

        return registros;
    }

    public static int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            usuario.usuarioToStmt(stmt);
            stmt.setInt(3, usuario.getIdUsuario());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
            }
        }
        return registros;
    }



    private static Usuario construirUsuario(ResultSet rs) {
        try {
            return new Usuario(rs);
        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        }
        return null;
    }

}
