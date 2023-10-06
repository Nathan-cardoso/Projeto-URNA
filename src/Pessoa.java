public class Pessoa {
    private String nome;
    private String email;
    private String cpf;


    public Pessoa(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public String getCpf() {
        return cpf;
    }


    @Override
    public String toString() {
        return "nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", ";
    }

    

    
}
