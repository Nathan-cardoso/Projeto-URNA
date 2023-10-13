import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Eleitor extends Pessoa{
    private String matricula;
    private boolean statusDeVoto;
    private String senha;
    
    public Eleitor(String nome, String cpf, String email, String matricula, String senha) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getMatricula() {
        return matricula;
    }


    public boolean isStatusDeVoto() {
        return statusDeVoto;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
       public void cadastrar(){
        try {
            Connection connection = new Conexao().getConnection();
            String query = "INSERT INTO eleitor (matricula, nome, cpf, email, senha) VALUES (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, getMatricula());
            pst.setString(2, getNome());
            pst.setString(3, getCpf());
            pst.setString(4, getEmail());
            pst.setString(5, getSenha());

            int validacaoCadastro = pst.executeUpdate();

            if(validacaoCadastro > 0){

                System.out.printf("Eleitor %s cadastrado com sucesso!\n", getNome());

            }else{

                System.out.println("Erro no cadastro do eleitor");

            }

            pst.close();
            connection.close();


        } catch (java.sql.SQLException e) {

            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    public static void excluir(String matricula){

        PreparedStatement pstm = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            String query = "DELETE FROM eleitor where matricula = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, matricula);

            int validacaoDeExclusao = pstm.executeUpdate();

            if(validacaoDeExclusao > 0){
                System.out.println("eleitor excluido com sucesso...");
            }else{
                System.out.println("------------------------------------------------");
                System.out.println("Não foi encontrado eleitor com o código " + matricula);
                System.out.println("------------------------------------------------");
            }

            pstm.close();
            connection.close();

        } catch ( SQLException e) {
            System.out.println("Erro ao excluir eleitor! erro: " + e.getMessage());
        }
    }
    
    
    public static void listar() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            Connection connection = new Conexao().getConnection(); // obtém a conexão com o banco de dados
            String query = "SELECT * FROM eleitor"; // query para selecionar todos os professores
            pstmt = connection.prepareStatement(query); // prepara a query para ser executada
            rs = pstmt.executeQuery(); // executa a query e obtém os resultados
    
            if (!rs.next()) { // verifica se não há resultados
                System.out.println("Não há nenhum eleitor cadastrado.");
            } else {
                do {

                    String numeroEleicao = rs.getString("matricula");
                    String nome = rs.getString("nome"); 
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email"); 
                    String senha = rs.getString("senha");
                    
                    // cria um objeto eleitor com os dados obtidos
                    Eleitor eleitor = new Eleitor(nome,cpf,email,numeroEleicao,senha ); 

                    System.out.println("-------------------");
                    System.out.println(eleitor.toStringAdm());
                    System.out.println("-------------------");
                } while (rs.next()); 
            }
            // Fecha a concecxão com o Banco de dados.
            pstmt.close();
            connection.close();
    
        } catch (SQLException e) {
            // Em caso de erro, exibe essa mensagem
            System.out.println("Erro ao listar eleitores: " + e.getMessage());
        }
    }

    public String formatacaoVoto(){
        if(isStatusDeVoto()){
            return "Votou";
        }
        else{
            return "Não votou";
        }
    }
    
    public String toStringAdm() {
        return super.toString() + "\nMatrícula:" + matricula + "\nstatus De Voto: " + formatacaoVoto();
    }

    
    
}
