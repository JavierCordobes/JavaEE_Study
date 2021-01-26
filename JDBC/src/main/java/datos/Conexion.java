package datos;


import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/home_database?useSSL=false&useTimeZone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }


}

