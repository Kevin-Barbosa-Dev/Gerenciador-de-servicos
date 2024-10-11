package View;

import java.util.List;
import java.util.Scanner;

import Model.Atendimento;
import Model.Cliente;
import Model.Servico;

public class View {
    public int menu(Scanner ler) {
        System.out.println("\n==================== MENU ====================");
        System.out.println("1 - Cadastrar Serviço");
        System.out.println("2 - Cadastrar Cliente");
        System.out.println("3 - Agendar Serviço");
        System.out.println("4 - Sair");
        System.out.println("==============================================");
        System.out.print("Escolha uma opção: ");
        return ler.nextInt();
    }

    public Servico mostrarInputFormServico(Scanner ler) {
        ler.nextLine(); // Consumir nova linha
        System.out.println("\n===== Cadastro de Serviço =====");
        System.out.print("Insira o nome do serviço: ");
        String nomeServico = ler.nextLine();
        System.out.print("Insira a descrição do serviço: ");
        String descricaoServico = ler.nextLine();
        System.out.print("Insira o valor do serviço: ");
        double valorServico = ler.nextDouble();
        System.out.println("Serviço cadastrado com sucesso!");
        System.out.println("================================\n");
        return new Servico(nomeServico, descricaoServico, valorServico);
    }

    public Cliente mostrarInputFormCliente(Scanner ler) {
        ler.nextLine();
        System.out.println("\n===== Cadastro de Cliente =====");
        System.out.print("Insira o nome do cliente: ");
        String nomeCliente = ler.nextLine();
        System.out.print("Insira o email do cliente: ");
        String emailCliente = ler.nextLine();
        System.out.print("Insira o telefone do cliente: ");
        int telefoneCliente = ler.nextInt();
        System.out.print("Insira o endereço do cliente: ");
        ler.nextLine();
        String enderecoCliente = ler.nextLine();
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("================================\n");
        return new Cliente(nomeCliente, emailCliente, telefoneCliente, enderecoCliente);
    }

    public void mostrarServico(List<Servico> servicos) {
        System.out.println("\n===== Serviços Cadastrados =====");
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
        } else {
            int listaNumerica = 1;
            for (Servico servico : servicos) {
                System.out.printf("%d - Nome: %s | Descrição: %s | Valor: R$%.2f\n", 
                                  listaNumerica++, servico.getNome(), servico.getDescricao(), servico.getValor());
            }
        }
        System.out.println("================================\n");
    }

    public void mostrarCliente(List<Cliente> clientes) {
        System.out.println("\n===== Clientes Cadastrados =====");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            int listaNumerica = 1;
            for (Cliente cliente : clientes) {
                System.out.printf("%d - Nome: %s | Email: %s | Telefone: %s | Endereço: %s\n",
                                  listaNumerica++, cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
            }
        }
        System.out.println("================================\n");
    }

    public Atendimento mostrarInputFormAtendimento(Scanner ler, List<Servico> servicos, List<Cliente> clientes) {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return null;
        }

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return null;
        }

        System.out.println("\n===== Agendar Atendimento =====");
        mostrarServico(servicos);
        System.out.print("Selecione o número do serviço: ");
        int numeroServico = ler.nextInt();
        if (numeroServico < 1 || numeroServico > servicos.size()) {
            System.out.println("Serviço inválido.");
            return null;
        }
        Servico servicoSelecionado = servicos.get(numeroServico - 1);

        mostrarCliente(clientes);
        System.out.print("Selecione o número do cliente: ");
        int numeroCliente = ler.nextInt();
        if (numeroCliente < 1 || numeroCliente > clientes.size()) {
            System.out.println("Cliente inválido.");
            return null;
        }
        Cliente clienteSelecionado = clientes.get(numeroCliente - 1);

        ler.nextLine();
        System.out.print("Insira a data do atendimento (dd/MM/yyyy): ");
        String data = ler.nextLine();
        System.out.print("Insira o horário do atendimento (HH:mm): ");
        String hora = ler.nextLine();

        System.out.println("Atendimento agendado com sucesso!");
        System.out.println("================================\n");
        return new Atendimento(servicoSelecionado, clienteSelecionado, data, hora);
    }

    public void sair() {
        System.out.println("Finalizando...");
    }
}
