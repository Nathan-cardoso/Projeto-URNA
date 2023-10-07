import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://silly.db.elephantsql.com:5432/otycuzte";
    private static final String USER = "otycuzte";
    private static final String PASSWORD = "kyljimQvrPaAF-VuzYrRQYqSo9il8JBj";

    public Connection getConnection() throws SQLException{
        Connection connection = null;
        try{

        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        }catch (SQLException e) {

            System.out.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }

    public  void closeConnection(Connection connection) {//Método que desconecta 
        try {

            if (connection != null) {
                connection.close();

            }
        } catch (SQLException e) {
            
            System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }
    }
