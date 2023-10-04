public class Eleitor extends Pessoa{
    private String matricula;
    private boolean statusDeVoto;
    
    public Eleitor(String nome, String email, String cpf, String matricula, boolean statusDeVoto) {
        super(nome, email, cpf);
        this.matricula = matricula;
        this.statusDeVoto = statusDeVoto;
    }

    public String getMatricula() {
        return matricula;
    }


    public boolean isStatusDeVoto() {
        return statusDeVoto;
    }
    
    
}
