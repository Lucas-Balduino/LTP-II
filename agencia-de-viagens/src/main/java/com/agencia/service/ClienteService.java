package com.agencia.service;

import com.agencia.dao.ClienteDao;
import com.agencia.model.Cliente;
import com.agencia.model.Estrangeiro;
import com.agencia.model.Nacional;
import java.util.Scanner;

public class ClienteService {
    private ClienteDao clienteDao = new ClienteDao();
    private Scanner scanner;

    public ClienteService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cadastrarCliente() {
        System.out.println("\n=== CADASTRAR CLIENTE ===");
        System.out.print("Tipo (1-Nacional / 2-Estrangeiro): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        try {
            if (tipo == 1) {
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                Nacional nacional = new Nacional(nome, telefone, email, cpf);
                clienteDao.inserir(nacional);
                System.out.println("✅ Cliente nacional cadastrado!");
            } else {
                System.out.print("Passaporte: ");
                String passaporte = scanner.nextLine();
                Estrangeiro estrangeiro = new Estrangeiro(nome, telefone, email, passaporte);
                clienteDao.inserir(estrangeiro);
                System.out.println("✅ Cliente estrangeiro cadastrado!");
            }
        } catch (Exception e) {
            System.err.println("❌ Erro ao cadastrar: " + e.getMessage());
        }
    }

    public void buscarCliente() {
        System.out.println("\n=== BUSCAR CLIENTE ===");
        System.out.print("Tipo (1-Nacional / 2-Estrangeiro): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        try {
            if (tipo == 1) {
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                Nacional nacional = clienteDao.buscarNacionalPorCpf(cpf);
                exibirCliente(nacional);
            } else {
                System.out.print("Passaporte: ");
                String passaporte = scanner.nextLine();
                Estrangeiro estrangeiro = clienteDao.buscarEstrangeiroPorPassaporte(passaporte);
                exibirCliente(estrangeiro);
            }
        } catch (Exception e) {
            System.err.println("❌ Erro na busca: " + e.getMessage());
        }
    }

    private void exibirCliente(Cliente cliente) {
        if (cliente != null) {
            System.out.println("\n" + cliente.toString());
        } else {
            System.out.println("❌ Cliente não encontrado.");
        }
    }
}