import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;

public class TestUsuarioDAO {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit() == true) {
                conexion.setAutoCommit(false);
            }
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);


            System.out.println(usuarioDAO.borrar(new Usuario(1)));
            System.out.println(usuarioDAO.seleccionar());


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
}
