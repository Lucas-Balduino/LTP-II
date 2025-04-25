package com.agencia.service;

import com.agencia.dao.ServicoDao;
import com.agencia.model.Servico;
import java.util.Scanner;

public class ServicoService {
    private ServicoDao servicoDao = new ServicoDao();
    private Scanner scanner;

    public ServicoService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void cadastrarServico() {
        System.out.println("\n=== CADASTRAR SERVIÇO ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Duração (horas): ");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        try {
            Servico servico = new Servico(nome, duracao, descricao);
            servicoDao.inserir(servico);
            System.out.println("✅ Serviço cadastrado!");
        } catch (Exception e) {
            System.err.println("❌ Erro ao cadastrar: " + e.getMessage());
        }
    }
}