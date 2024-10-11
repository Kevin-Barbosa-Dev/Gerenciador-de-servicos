package Model;

public class Atendimento {
    private Servico servico;
    private Cliente cliente;
    private String data;
    private String hora;

    public Atendimento (Servico servico, Cliente cliente, String data, String hora) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
    
}
