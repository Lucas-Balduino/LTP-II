package PopUps;

import javax.swing.*;

public class Cadastro {
    String nome;
    int idade;

    public void cadastrar() {
        this.nome = JOptionPane.showInputDialog(null, "Insira o seu nome:", "Cadastro", JOptionPane.PLAIN_MESSAGE); //Input
        try {
            this.idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira sua Idade:", "Cadastro", JOptionPane.PLAIN_MESSAGE)); //Input
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O Valor Informado não é numérico!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showConfirmDialog(null, " Nome: " + this.nome + " Idade: "+ this.idade, "Confirme os dados do Cadastro", JOptionPane.PLAIN_MESSAGE);
    }
}
