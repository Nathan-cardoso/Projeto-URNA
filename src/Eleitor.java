import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Eleitor extends Pessoa {
    private String matricula;
    private boolean statusDeVoto;
    private String senha;

    public Eleitor(String nome, String cpf, String email, String matricula, String senha) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.senha = senha;
    }

    public Eleitor(String nome, String cpf, String email, String matricula, String senha, boolean statusDeVoto) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.senha = senha;
        this.statusDeVoto = statusDeVoto;
    }

    // Método para cadastro de eleitores no banco de dados.
    public void cadastrar() {
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

            if (validacaoCadastro > 0) {

                System.out.printf("Eleitor %s cadastrado com sucesso!\n", getNome());

            } else {

                System.out.println("Erro no cadastro do eleitor");

            }

            pst.close();
            connection.close();

        } catch (java.sql.SQLException e) {

            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    /**
     * Esse método faz uma busca no banco de dados a partir da matícula passada como
     * parâmetro. Caso não seja encontrado a matícula será retornado null. Porém, se
     * a matrícula for existente ira retorna um objeto eleitor.
     * 
     * @param matricula
     * @return
     */
    public static Eleitor buscar(String matricula) {
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            Connection connection = new Conexao().getConnection();
            String query = "SELECT * FROM eleitor where matricula = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, matricula);
            rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;

            } else {

                String mat = rs.getString("matricula");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Eleitor eleitor = new Eleitor(nome, cpf, email, mat, senha);

                return eleitor;
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Erro na busca do eleitor: " + e.getMessage());
        }

        return null;
    }

    /**
     * Esse método recebe um inteiro que é o código para saber qual alteração se
     * trata vai ser feita e uma string sendo a alteração.
     * 
     * @param codigoEdicao
     * @param alteracao
     */
    public void editar(int codigoEdicao, String alteracao) {
        PreparedStatement pstm = null;
        String query;
        try {
            Connection connection = new Conexao().getConnection();

            switch (codigoEdicao) {
                case 1:

                    query = "UPDATE eleitor SET nome = ? WHERE matricula = ?";
                    pstm = connection.prepareStatement(query);
                    pstm.setString(1, alteracao);
                    pstm.setString(2, getMatricula());

                    break;

                case 2:

                    query = "UPDATE eleitor SET cpf = ? WHERE matricula = ?";
                    pstm = connection.prepareStatement(query);
                    pstm.setString(1, alteracao);
                    pstm.setString(2, getMatricula());

                    break;

                case 3:

                    query = "UPDATE eleitor SET email = ? WHERE matricula = ?";
                    pstm = connection.prepareStatement(query);
                    pstm.setString(1, alteracao);
                    pstm.setString(2, getMatricula());

                    break;

                case 4:
                    query = "UPDATE eleitor SET senha = ? WHERE matricula = ?";
                    pstm = connection.prepareStatement(query);
                    pstm.setString(1, alteracao);
                    pstm.setString(2, getMatricula());

                    break;
            }

            int validacaoDaEdit = pstm.executeUpdate();

            if (validacaoDaEdit > 0) {
                System.out.println("------------------------------------------------");
                System.out.println("Eleitor(a) atualizado com sucesso...");
                System.out.println("------------------------------------------------");
            } else {

                System.out.println("Erro na atualização...");

            }

            pstm.close();
            connection.close();

        } catch (java.sql.SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Esse método excluí um aluno do banco de dados a partir da matrícula passada
     * como parâmetro para o método
     * 
     * @param matricula
     */
    public static void excluir(String matricula) {

        PreparedStatement pstm = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            String query = "DELETE FROM eleitor where matricula = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, matricula);

            int validacaoDeExclusao = pstm.executeUpdate();

            if (validacaoDeExclusao > 0) {
                System.out.println("eleitor excluido com sucesso...");
            } else {
                System.out.println("------------------------------------------------");
                System.out.println("Não foi encontrado eleitor com o código " + matricula);
                System.out.println("------------------------------------------------");
            }

            pstm.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao excluir eleitor! erro: " + e.getMessage());
        }
    }

    // método para listar todos os usuários do banco de dados
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

                    String matricula = rs.getString("matricula");
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    boolean statusVoto = rs.getBoolean("status_voto");

                    // cria um objeto eleitor com os dados obtidos
                    Eleitor eleitor = new Eleitor(nome, cpf, email, matricula, senha, statusVoto);

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

    public static Eleitor login(String email, String senha) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            Connection connection = new Conexao().getConnection();
            String query = "SELECT * From eleitor where email = ? AND senha = ?";
            pstm = connection.prepareStatement(query);

            pstm.setString(1, email);
            pstm.setString(2, senha);

            rs = pstm.executeQuery();

            if (rs.next()) {
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                boolean statusVoto = rs.getBoolean("status_voto");
                Eleitor eleitor = new Eleitor(nome, cpf, email, matricula, senha, statusVoto);

                return eleitor;
            }

        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }

        return null;
    }

    public void votar(String voto) {

        setStatusDeVoto(true);

        PreparedStatement pstm = null;
        String query;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();

            if (voto.equals("00000")) {
                query = "UPDATE voto SET voto_branco = voto_branco + 1";
                pstm = connection.prepareStatement(query);
                pstm.executeUpdate();
            }

            Candidato candVotado = Candidato.buscar(voto);

            if (candVotado == null) {
                query = "UPDATE voto SET voto_nulo = voto_nulo + 1";
                pstm = connection.prepareStatement(query);
                pstm.executeUpdate();
            }

            query = "UPDATE candidato SET total_votos = total_votos + 1 WHERE numero_eleicao = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, voto);
            pstm.executeUpdate();

            // Se a atualização anterior for bem-sucedida, atualize o status de voto do
            // eleitor
            query = "UPDATE eleitor SET status_voto = true WHERE matricula = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, getMatricula());
            pstm.executeUpdate();

            System.out.println("Voto concluído");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Sessão de getters
    public String getSenha() {
        return senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean isStatusDeVoto() {
        return statusDeVoto;
    }
    // Sessão de setters

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setStatusDeVoto(boolean statusDeVoto) {
        this.statusDeVoto = statusDeVoto;
    }

    // Exibição e formatação de dados.
    public String formatacaoVoto() {
        if (isStatusDeVoto()) {
            return "Votou";
        } else {
            return "Não votou";
        }
    }

    public String toStringAdm() {
        return super.toString() + "\nMatrícula:" + matricula + "\nstatus De Voto: " + formatacaoVoto();
    }

    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nE-mail: " + getEmail() + "\nMatrícula:" + getMatricula()
                + "\nStatus de voto: " + formatacaoVoto();
    }

}
