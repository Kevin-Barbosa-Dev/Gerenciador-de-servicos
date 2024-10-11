package Model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private List<Cliente> armazenarCliente = new ArrayList<>();
    private List<Servico> armazernarServico = new ArrayList<>();
    private List<Atendimento> armazenarAtendimentos = new ArrayList<>();

    public List<Cliente> getArmazenarCliente() {
        return armazenarCliente;
    }

    public List<Servico> getArmazernarServico() {
        return armazernarServico;
    }
    public List<Atendimento> getArmazenarAtendimentos (){
        return armazenarAtendimentos ;
    }

    public void cadastrarCliente(Cliente cliente){
        armazenarCliente.add(cliente);
    }


    public void cadastrarServico(Servico servico){
        armazernarServico.add(servico);
    }

    public void agendarServico(Atendimento agendar){
        armazenarAtendimentos.add(agendar);
    }
}