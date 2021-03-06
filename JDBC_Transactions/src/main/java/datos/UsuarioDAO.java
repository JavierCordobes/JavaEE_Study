package datos;

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

    private Connection connectionTransaction;

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";

    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES(?, ?) ";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ? ";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ? ";

    public UsuarioDAO() {

    }

    // contructor que recibe la conexion externa
    public UsuarioDAO(Connection connectionTransaction) {
        this.connectionTransaction = connectionTransaction;


    }

    public List<Usuario> seleccionar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = construirUsuario(rs);
                if (Objects.nonNull(usuario)) {
                    usuarios.add(usuario);
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
        return usuarios;

    }

    public int insertar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            usuario.usuarioToStmt(stmt);
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

    public int borrar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());
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

    public int actualizar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.connectionTransaction != null ? this.connectionTransaction : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            usuario.usuarioToStmt(stmt);
            stmt.setInt(3, usuario.getIdUsuario());
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


    private static Usuario construirUsuario(ResultSet rs) {
        try {
            return new Usuario(rs);
        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        }
        return null;
    }

}
