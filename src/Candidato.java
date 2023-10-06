import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Candidato extends Pessoa {
    private String numeroDaEleicao;
    private int totalDevotos;

    
    public Candidato(String nome, String email, String cpf, String numeroDaEleicao) {
        super(nome, email, cpf);
        this.numeroDaEleicao = numeroDaEleicao;
    }
    

    public void setNumeroDaEleicao(String numeroDaEleicao) {
        this.numeroDaEleicao = numeroDaEleicao;
    }


    public String getNumeroDaEleicao() {
        return numeroDaEleicao;
    }


    public int getTotalDevotos() {
        return totalDevotos;
    }

    public static void listar() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            Connection connection = new Conexao().getConnection(); // obtém a conexão com o banco de dados
            String query = "SELECT * FROM candidato"; // query para selecionar todos os professores
            pstmt = connection.prepareStatement(query); // prepara a query para ser executada
            rs = pstmt.executeQuery(); // executa a query e obtém os resultados
    
            if (!rs.next()) { // verifica se não há resultados
                System.out.println("Não há nenhum candidato cadastrado.");
            } else {
                do {

                    String numeroEleicao = rs.getString("numero_eleicao");
                    String nome = rs.getString("nome"); 
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email"); 
                    
                    // cria um objeto Candidato com os dados obtidos
                    Candidato candidato = new Candidato(nome, cpf,email, numeroEleicao); 
                    System.out.println(candidato); // exibe o objeto Professor.
                } while (rs.next()); 
            }
            // Fecha a concecxão com o Banco de dados.
            pstmt.close();
            connection.close();
    
        } catch (SQLException e) {
            // Em caso de erro, exibe essa mensagem
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return super.toString() + " numeroDaEleicao =" + numeroDaEleicao + ", totalDevotos =" + totalDevotos ;
    }
    
    
    
    
}