package com.agencia.service;

import com.agencia.dao.PacoteDao;
import com.agencia.model.Pacote;
import java.util.Scanner;

public class PacoteService {
    private PacoteDao pacoteDao = new PacoteDao();
    private Scanner scanner;

    public PacoteService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cadastrarPacote() {
        System.out.println("\n=== CADASTRAR PACOTE ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Duração (dias): ");
        int duracao = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        try {
            Pacote pacote = new Pacote(nome, destino, duracao, preco);
            pacoteDao.inserir(pacote);
            System.out.println("✅ Pacote cadastrado!");
        } catch (Exception e) {
            System.err.println("❌ Erro ao cadastrar: " + e.getMessage());
        }
    }
}