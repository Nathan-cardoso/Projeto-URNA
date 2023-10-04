public class Candidato extends Pessoa {
    private int numeroDaEleicao;
    private int totalDevotos;

    
    public Candidato(String nome, String email, String cpf, int numeroDaEleicao, int totalDevotos) {
        super(nome, email, cpf);
        this.numeroDaEleicao = numeroDaEleicao;
        this.totalDevotos = totalDevotos;
    }
    

    public void setNumeroDaEleicao(int numeroDaEleicao) {
        this.numeroDaEleicao = numeroDaEleicao;
    }


    public int getNumeroDaEleicao() {
        return numeroDaEleicao;
    }


    public int getTotalDevotos() {
        return totalDevotos;
    }
  
    
}