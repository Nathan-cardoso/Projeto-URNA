import java.sql.Connection;
import java.sql.PreparedStatement;

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
    
}
