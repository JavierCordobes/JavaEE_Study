package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

public class Usuario {
    private int idUsuario;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(ResultSet rs) throws SQLException {
        this.idUsuario = rs.getInt("id_usuario");
        this.usuario = rs.getString("usuario");
        this.password = rs.getString("password");
    }

    public void usuarioToStmt(PreparedStatement stmt) {
        try {
            stmt.setString(1, this.getUsuario());
            stmt.setString(2, this.getPassword());


        } catch (SQLException ex) {
            System.out.println(MessageFormat.format("Error: {0} - Message: {1} - Cause: {2}", ex.getErrorCode(), ex.getMessage(), ex.getCause()));
        }
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
