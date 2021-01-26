import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSqlJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        var url = "jdbc:mysql://localhost:3306/home_database?useSSL=false&useTimeZone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
        ColeccionPersonas coleccionPersonas = new ColeccionPersonas();
        try {

            Connection conexion = DriverManager.getConnection(url, "root", "root");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);

            coleccionPersonas.converterPersona(resultado);
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}

