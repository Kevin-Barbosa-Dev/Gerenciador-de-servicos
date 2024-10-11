package Controller;

import Model.Servico;
import Model.Cliente;
import Model.Atendimento;
import Model.BancoDeDados;
import View.View;
import java.util.Scanner;

public class Controller {
    private BancoDeDados bancoDeDados;
    private View view;
    private Scanner ler;

    public Controller() {
        this.bancoDeDados = new BancoDeDados();
        this.view = new View();
        this.ler = new Scanner(System.in);
    }

    public void adcionarServico() {
        Servico servico = view.mostrarInputFormServico(ler);
        bancoDeDados.cadastrarServico(servico);
    }

    public void adcionarCliente() {
        Cliente cliente = view.mostrarInputFormCliente(ler);
        bancoDeDados.cadastrarCliente(cliente);
    }


    public void agedarServico() {
        Atendimento agendar = view.mostrarInputFormAtendimento(ler, bancoDeDados.getArmazernarServico(), bancoDeDados.getArmazenarCliente());
        bancoDeDados.agendarServico(agendar);
    }

    

    public void start() {
        int opcao = 0;
        while (opcao != 4) {
            opcao = view.menu(ler);
            switch (opcao) {
                case 1:
                    adcionarServico();
                    break;
                case 2:
                    adcionarCliente();
                    break;
                case 3:
                    agedarServico();
                    break;
                case 4:
                    view.sair();
                    break;
                default:
                    break;
            }
        }
    }
}