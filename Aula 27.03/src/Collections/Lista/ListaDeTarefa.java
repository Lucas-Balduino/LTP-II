package Collections.Lista;

import javax.swing.*;
import java.util.ArrayList;

public class ListaDeTarefa {
    ArrayList<String> Tarefas = new ArrayList<>();

    public void addTarefa(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do Tarefa:");
        Tarefas.add(nome);
    }

    public void removeTarefa(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do Tarefa que voce deseja remover:");
        Tarefas.remove(nome);
    }

    public void listarTarefas(){
        //Tarefas.forEach(System.out::println);
        for(String t: Tarefas){
            JOptionPane.showMessageDialog(null, t);
        }
    }

    public void numeroDeTarefas(){
        JOptionPane.showMessageDialog(null, Tarefas.size());
    }
}
