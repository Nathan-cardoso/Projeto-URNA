import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static Candidato buscar(String numeroEleicao){
        PreparedStatement pstm = null; 
        ResultSet rs = null;

        try {

            Connection connection = new Conexao().getConnection();
            String query = "SELECT * FROM candidato where numero_eleicao = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, numeroEleicao);
            rs = pstm.executeQuery();

            if(!rs.next()){
                return null;

            }else{

                    String numEleicao = rs.getString("numero_eleicao");
                    String nome = rs.getString("nome"); 
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email"); 
                    
                    
                    Candidato candidato = new Candidato(nome,cpf,email,numEleicao); 

                    return candidato;
            }


        } catch (java.sql.SQLException e) {
            System.out.println("Erro na busca do candidato: " + e.getMessage());
        }

        return null;
    }

    public void editar(int codigo, String alteracao){
        PreparedStatement pstm = null;
        String query;
        try {
            Connection connection = new Conexao().getConnection();

            switch(codigo){
                case 1:

                 query = "UPDATE candidato SET nome = ? WHERE numero_eleicao = ?";
                 pstm = connection.prepareStatement(query);
                 pstm.setString(1, alteracao);
                 pstm.setString(2, getNumeroDaEleicao());

                break;
                
                case 2:

                 query = "UPDATE candidato SET cpf = ? WHERE numero_eleicao = ?";
                 pstm = connection.prepareStatement(query);
                 pstm.setString(1, alteracao);
                 pstm.setString(2, getNumeroDaEleicao());

                break;

                 case 3:

                 query = "UPDATE candidato SET email = ? WHERE numero_eleicao = ?";
                 pstm = connection.prepareStatement(query);
                 pstm.setString(1, alteracao);
                 pstm.setString(2, getNumeroDaEleicao());
            
                break;

                case 4:
                 query = "UPDATE candidato SET numero_eleicao = ? WHERE numero_eleicao = ?";
                 pstm = connection.prepareStatement(query);
                 pstm.setString(1, alteracao);
                 pstm.setString(2, getNumeroDaEleicao());

                break;
            }

            int validacaoDaEdit = pstm.executeUpdate();

            if (validacaoDaEdit > 0 ){
                System.out.println("------------------------------------------------");
                System.out.println("Candidato(a) atualizado com sucesso...");
                System.out.println("------------------------------------------------");
            }else{

                System.out.println("Erro na atualização...");

            }

            pstm.close();
            connection.close();


        } catch (java.sql.SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void excluir(String numeroDaEleicao){

        PreparedStatement pstm = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            String query = "DELETE FROM candidato where numero_eleicao = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, numeroDaEleicao);

            int validacaoDeExclusao = pstm.executeUpdate();

            if(validacaoDeExclusao > 0){
                System.out.println("Candidato excluido com sucesso...");
            }else{
                System.out.println("------------------------------------------------");
                System.out.println("Não foi encontrado candidatos com o código " + numeroDaEleicao);
                System.out.println("------------------------------------------------");
            }

            pstm.close();
            connection.close();
        } catch ( SQLException e) {
            System.out.println("Erro ao excluir candidato! erro: " + e.getMessage());
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

        public static List<String> gerarRelatorio() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<String> resultados = new ArrayList<>();

        try {
            connection = new Conexao().getConnection();
            String sql = "SELECT 'Votos Brancos' AS tipo_voto, voto_branco AS total FROM voto " +
                         "UNION ALL " +
                         "SELECT 'Votos Nulos' AS tipo_voto, voto_nulo AS total FROM voto " +
                         "UNION ALL " +
                         "SELECT nome AS candidato, total_votos AS total FROM candidato";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tipoVoto = resultSet.getString("tipo_voto");
                int total = resultSet.getInt("total");
                resultados.add(tipoVoto + ", Total: " + total+"\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return resultados;
    }



    @Override
    public String toString() {
        return super.toString() + "\nNumero da eleicao: " + numeroDaEleicao;
    } 
    
    
}