package Model;

public class Cliente {
    private String nome;
    private String email;
    private int telefone;
    private String endereco;
    public Cliente(String nome, String email, int telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }


}
