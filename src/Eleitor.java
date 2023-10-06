public class Eleitor extends Pessoa{
    private String matricula;
    private boolean statusDeVoto;
    private String senha;
    
    public Eleitor(String nome, String email, String cpf, String matricula) {
        super(nome, email, cpf);
        this.matricula = matricula;
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
    
    
}
