package com.agencia;

import java.sql.Connection;
import java.util.Scanner;

import com.agencia.util.DataBaseConnection;
import com.agencia.service.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService(scanner);
        PacoteService pacoteService = new PacoteService(scanner);
        ServicoService servicoService = new ServicoService(scanner);
        Connection conn = null;

        try {
            conn = DataBaseConnection.getConnection();
            System.out.println("✅ Conexão estabelecida com sucesso!");
            boolean executando = true;

            while (executando) {
                System.out.println("\n===== MENU PRINCIPAL =====");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Remover");
                System.out.println("[3] Listar");
                System.out.println("[4] Buscar");
                System.out.println("[5] Contratar");
                System.out.println("[6] Fechar programa");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        menuSecundario("Cadastrar", clienteService, pacoteService, servicoService, scanner);
                        break;
                    case 2:
                        menuSecundario("Remover", clienteService, pacoteService, servicoService, scanner);
                        break;
                    case 3:
                        menuSecundario("Listar", clienteService, pacoteService, servicoService, scanner);
                        break;
                    case 4:
                        menuSecundario("Buscar", clienteService, pacoteService, servicoService, scanner);
                        break;
                    case 5:
                        menuContratar(scanner); // Passar o scanner existente
                        break;
                    case 6:
                        executando = false;
                        System.out.println("👋 Programa finalizado.");
                        break;
                    default:
                        System.out.println("❌ Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.err.println("❌ Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DataBaseConnection.desconectar(conn);
            scanner.close();
        }
    }

    private static void menuSecundario(String acao, ClienteService clienteService, PacoteService pacoteService, ServicoService servicoService, Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== " + acao.toUpperCase() + " ===");
            System.out.println("[1] Cliente");
            System.out.println("[2] Pacote");
            System.out.println("[3] Serviço");
            System.out.println("[4] Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (escolha) {
                case 1:
                    if (acao.equalsIgnoreCase("Cadastrar")) {
                        clienteService.cadastrarCliente();
                    } else if (acao.equalsIgnoreCase("Buscar")) {
                        clienteService.buscarCliente();
                    }
                    break;
                case 2:
                    if (acao.equalsIgnoreCase("Cadastrar")) {
                        pacoteService.cadastrarPacote();
                    } else {
                        System.out.println("⚙️ Função ainda será implementada.");
                    }
                    break;
                case 3:
                    if (acao.equalsIgnoreCase("Cadastrar")) {
                        servicoService.cadastrarServico();
                    } else {
                        System.out.println("⚙️ Função ainda será implementada.");
                    }
                    break;
	            case 4:
	                voltar = true;
	                break;
	            default:
	                System.out.println("❌ Opção inválida.");
	        }

        }
    }


    private static void menuContratar(Scanner scanner) {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n=== CONTRATAR ===");
            System.out.println("[1] Pacotes");
            System.out.println("[2] Serviços");
            System.out.println("[3] Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("⚙️ Contratar pacote (função ainda será implementada)");
                    break;
                case 2:
                    System.out.println("⚙️ Contratar serviço (função ainda será implementada)");
                    break;
                case 3:
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida.");
            }
        }
    }
}
