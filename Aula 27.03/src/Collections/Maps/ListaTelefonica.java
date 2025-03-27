package Collections.Maps;

import javax.swing.*;
import java.util.HashMap;

public class ListaTelefonica {
    HashMap<String, String> Contatos = new HashMap<String, String>();

    public void addContato(){
        String numero = JOptionPane.showInputDialog(null, "Insira o Numero do novo Contato","Novo Contato", JOptionPane.PLAIN_MESSAGE);
        String nome = JOptionPane.showInputDialog(null, "Insira o Nome do novo Contato","Novo Contato", JOptionPane.PLAIN_MESSAGE);
        Contatos.put(numero,nome);
    }

    public void removeContato(){
        String numero = JOptionPane.showInputDialog(null, "Insira o Número do Contato que deseja remover","Remover Contato", JOptionPane.PLAIN_MESSAGE);
        Contatos.remove(numero);
    }

    public void showContatos(){

    }

    public void searchContato() {
        try {
            String numeroContato = JOptionPane.showInputDialog(null, "Digite o numero do Contato que voce deseja Buscar", "Buscar Contato", JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
