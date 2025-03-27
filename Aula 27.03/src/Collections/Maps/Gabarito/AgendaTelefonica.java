package Collections.Maps.Gabarito;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

class Contato {
    String telefone;
    String nome;
    String endereco;

    public Contato(String telefone, String nome, String endereco) {
        this.telefone = telefone;
        this.nome = nome;
        this.endereco = endereco;
    }
}

public class AgendaTelefonica {
    Map<String, Contato> listaContatos;

    public AgendaTelefonica() {
        listaContatos = new HashMap<String, Contato>();
    }

    public void addContato(Contato contato) {
        if (listaContatos.containsKey(contato.telefone)) {
            JOptionPane.showMessageDialog(null,"Ja Existe um Contato cadastrado com esse telefone", "Erro", JOptionPane.ERROR_MESSAGE);
        }else {
            listaContatos.put(contato.telefone, contato);
        }
    }

    public void removeContato(Contato contato) {
        if (listaContatos.containsKey(contato.telefone)) {
            listaContatos.remove(contato.telefone);
            JOptionPane.showMessageDialog(null,"Contato removido com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        else {
            JOptionPane.showMessageDialog(null,"Contato não existe", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showContatos() {
        for (Map.Entry<String, Contato> contato : listaContatos.entrySet()) {
            System.out.println(contato.getKey() + " - " + contato.getValue().nome);
        }
    }

    public void searchContato(String telefone) {
        Contato contato = listaContatos.get(telefone);
        System.out.println("Contato localizado: " + contato.nome);
    }

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Contato contato1 = new Contato("123456", "Lucas", "215 norte");
        Contato contato2 = new Contato("78910", "Maria", "415 norte");
        agenda.addContato(contato1);
        agenda.addContato(contato2);
        agenda.showContatos();
        agenda.searchContato("123456");
    }

}
