package com.estudante.service;

import com.estudante.dao.AlunoDAO;
import com.estudante.model.Aluno;
import com.estudante.model.Disciplina;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoService {
    private static final AlunoDAO alunoDAO = new AlunoDAO();

    public static void cadastrarAluno() throws SQLException {
        JOptionPane.showMessageDialog(null, "=== Cadastro de Novo Aluno ===", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        
        String nome = JOptionPane.showInputDialog("Nome:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String telefone = JOptionPane.showInputDialog("Telefone:");
        if (telefone == null || telefone.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Telefone é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String cpf = JOptionPane.showInputDialog("CPF:");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String endereco = JOptionPane.showInputDialog("Endereço:");
        if (endereco == null || endereco.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Endereço é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aluno aluno = new Aluno(nome, telefone, cpf, endereco);
        alunoDAO.inserir(aluno);

        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        // Matricular em 5 disciplinas
        JOptionPane.showMessageDialog(null, "Agora vamos matricular o aluno em 5 disciplinas.", "Matrícula", JOptionPane.INFORMATION_MESSAGE);
        
        List<Long> disciplinaIds = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String disciplinaIdStr = JOptionPane.showInputDialog("Digite o ID da disciplina " + (i + 1) + ":");
            if (disciplinaIdStr == null || disciplinaIdStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID da disciplina é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                Long disciplinaId = Long.parseLong(disciplinaIdStr);
                disciplinaIds.add(disciplinaId);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID da disciplina deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        alunoDAO.matricularEmDisciplinas(aluno.getId(), disciplinaIds);
        JOptionPane.showMessageDialog(null, "Matrícula nas disciplinas realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void alterarAluno() throws SQLException {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Aluno aluno = alunoDAO.buscarPorCpf(cpf);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado com o CPF informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Mostrar dados atuais
        StringBuilder dadosAtuais = new StringBuilder();
        dadosAtuais.append("Dados atuais do aluno:\n");
        dadosAtuais.append("Nome: ").append(aluno.getNome()).append("\n");
        dadosAtuais.append("Telefone: ").append(aluno.getTelefone()).append("\n");
        dadosAtuais.append("CPF: ").append(aluno.getCpf()).append("\n");
        dadosAtuais.append("Endereço: ").append(aluno.getEndereco());
        
        JOptionPane.showMessageDialog(null, dadosAtuais.toString(), "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
        
        // Solicitar novos dados
        String nome = JOptionPane.showInputDialog("Novo nome (ou deixe em branco para manter):", aluno.getNome());
        if (nome != null && !nome.trim().isEmpty()) {
            aluno.setNome(nome);
        }
        
        String telefone = JOptionPane.showInputDialog("Novo telefone (ou deixe em branco para manter):", aluno.getTelefone());
        if (telefone != null && !telefone.trim().isEmpty()) {
            aluno.setTelefone(telefone);
        }
        
        String endereco = JOptionPane.showInputDialog("Novo endereço (ou deixe em branco para manter):", aluno.getEndereco());
        if (endereco != null && !endereco.trim().isEmpty()) {
            aluno.setEndereco(endereco);
        }
        
        alunoDAO.atualizar(aluno);
        JOptionPane.showMessageDialog(null, "Dados do aluno atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exibirAluno() throws SQLException {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Aluno aluno = alunoDAO.buscarPorCpf(cpf);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado com o CPF informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Construir mensagem com dados do aluno
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Dados do aluno:\n");
        mensagem.append("Nome: ").append(aluno.getNome()).append("\n");
        mensagem.append("Telefone: ").append(aluno.getTelefone()).append("\n");
        mensagem.append("CPF: ").append(aluno.getCpf()).append("\n");
        mensagem.append("Endereço: ").append(aluno.getEndereco()).append("\n\n");
        
        // Adicionar disciplinas
        List<Disciplina> disciplinas = alunoDAO.getDisciplinasDoAluno(aluno.getId());
        mensagem.append("Disciplinas matriculadas:\n");
        if (disciplinas.isEmpty()) {
            mensagem.append("Nenhuma disciplina matriculada.");
        } else {
            for (Disciplina disciplina : disciplinas) {
                mensagem.append("- ").append(disciplina.getNome()).append(" (").append(disciplina.getCodigo()).append(")\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, mensagem.toString(), "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void removerAluno() throws SQLException {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Aluno aluno = alunoDAO.buscarPorCpf(cpf);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado com o CPF informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Mostrar dados do aluno a ser removido
        StringBuilder dadosAluno = new StringBuilder();
        dadosAluno.append("Dados do aluno a ser removido:\n");
        dadosAluno.append("Nome: ").append(aluno.getNome()).append("\n");
        dadosAluno.append("Telefone: ").append(aluno.getTelefone()).append("\n");
        dadosAluno.append("CPF: ").append(aluno.getCpf()).append("\n");
        dadosAluno.append("Endereço: ").append(aluno.getEndereco());
        
        int confirmacao = JOptionPane.showConfirmDialog(null, 
                dadosAluno.toString() + "\n\nTem certeza que deseja remover este aluno?", 
                "Confirmar Remoção", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            alunoDAO.deletar(aluno.getId());
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void matricularAluno() throws SQLException {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Aluno aluno = alunoDAO.buscarPorCpf(cpf);
        if (aluno == null) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado com o CPF informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Mostrar disciplinas disponíveis
        List<Disciplina> disciplinasDisponiveis = alunoDAO.listarTodasDisciplinas();
        StringBuilder disciplinasMsg = new StringBuilder();
        disciplinasMsg.append("Disciplinas disponíveis:\n\n");
        
        for (Disciplina disciplina : disciplinasDisponiveis) {
            disciplinasMsg.append(disciplina.getCodigo()).append(" - ").append(disciplina.getNome()).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, disciplinasMsg.toString(), "Disciplinas Disponíveis", JOptionPane.INFORMATION_MESSAGE);
        
        String codigoDisciplina = JOptionPane.showInputDialog("Digite o código da disciplina para matricular:");
        if (codigoDisciplina == null || codigoDisciplina.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Código da disciplina é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Disciplina disciplina = alunoDAO.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada com o código informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verificar se o aluno já está matriculado nesta disciplina
        List<Disciplina> disciplinasDoAluno = alunoDAO.getDisciplinasDoAluno(aluno.getId());
        for (Disciplina d : disciplinasDoAluno) {
            if (d.getId().equals(disciplina.getId())) {
                JOptionPane.showMessageDialog(null, "O aluno já está matriculado nesta disciplina.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        // Matricular o aluno na disciplina
        List<Long> disciplinaIds = new ArrayList<>();
        disciplinaIds.add(disciplina.getId());
        alunoDAO.matricularEmDisciplinas(aluno.getId(), disciplinaIds);
        
        JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso na disciplina " + disciplina.getNome() + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void listarTodosAlunos() throws SQLException {
        List<Aluno> alunos = alunoDAO.listarTodos();
        StringBuilder mensagem = new StringBuilder();
        for (Aluno aluno : alunos) {
            mensagem.append("\nDados do aluno:\n");
            mensagem.append("Nome: ").append(aluno.getNome()).append("\n");
            mensagem.append("Telefone: ").append(aluno.getTelefone()).append("\n");
            mensagem.append("CPF: ").append(aluno.getCpf()).append("\n");
            mensagem.append("Endereço: ").append(aluno.getEndereco()).append("\n\n");

            // Adicionar disciplinas
            List<Disciplina> disciplinas = alunoDAO.getDisciplinasDoAluno(aluno.getId());
            mensagem.append("Disciplinas matriculadas:\n");
            if (disciplinas.isEmpty()) {
                mensagem.append("Nenhuma disciplina matriculada.");
            } else {
                for (Disciplina disciplina : disciplinas) {
                    mensagem.append("- ").append(disciplina.getNome()).append(" (").append(disciplina.getCodigo()).append(")\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Lista de Alunos:" +
                mensagem);


    }
}
