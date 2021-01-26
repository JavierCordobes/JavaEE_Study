import datos.UsuarioDAO;
import domain.Usuario;

public class TestUsuarioDAO {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println( usuarioDAO.seleccionar());


   //    usuarioDAO.insertar(new Usuario("hola","hola"));
        System.out.println( usuarioDAO.seleccionar());
        usuarioDAO.actualizar(new Usuario(4 ,"modficado","modficado"));
        System.out.println( usuarioDAO.seleccionar());

    }
}
