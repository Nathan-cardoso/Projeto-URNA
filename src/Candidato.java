import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Candidato extends Pessoa {
    private String numeroDaEleicao;
    private int totalDevotos;

    
    public Candidato(String nome, String cpf, String email, String numeroDaEleicao) {
        super(nome, cpf, email);
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

    public void cadastrar(){
        try {
            Connection connection = new Conexao().getConnection();
            String query = "INSERT INTO candidato (numero_eleicao, nome, cpf, email) VALUES (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, this.getNumeroDaEleicao());
            pst.setString(2, this.getNome());
            pst.setString(3, this.getCpf());
            pst.setString(4, this.getEmail());

            int validacaoCadastro = pst.executeUpdate();

            if(validacaoCadastro > 0){

                System.out.printf("Candidato(a) %s cadastrado com sucesso!\n", getNome());

            }else{

                System.out.println("Erro no cadastro do candidato");

            }

            pst.close();
            connection.close();


        } catch (java.sql.SQLException e) {

            System.out.println("Erro de conexão: " + e.getMessage());
        }

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
                    Candidato candidato = new Candidato(nome,cpf,email,numeroEleicao); 

                    System.out.println("-------------------");
                    System.out.println(candidato);
                    System.out.println("-------------------");
                } while (rs.next()); 
            }
            // Fecha a concecxão com o Banco de dados.
            pstmt.close();
            connection.close();
    
        } catch (SQLException e) {
            // Em caso de erro, exibe essa mensagem
            System.out.println("Erro ao listar candidatos: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\nNumero da eleicao: " + numeroDaEleicao;
    }
    
    
    
    
}