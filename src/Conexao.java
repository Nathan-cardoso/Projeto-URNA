import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://silly.db.elephantsql.com:5432/otycuzte";
    private static final String USER = "otycuzte";
    private static final String PASSWORD = "kyljimQvrPaAF-VuzYrRQYqSo9il8JBj";

    public Connection getConnection() throws SQLException{
        
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        return connection;
    }
}
