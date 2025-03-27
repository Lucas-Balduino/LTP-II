package Collections.Lista;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefa listaDeTarefa = new ListaDeTarefa();
        listaDeTarefa.addTarefa();
        listaDeTarefa.addTarefa();
        listaDeTarefa.addTarefa();
        listaDeTarefa.addTarefa();
        listaDeTarefa.listarTarefas();
        listaDeTarefa.numeroDeTarefas();
        listaDeTarefa.removeTarefa();
        listaDeTarefa.listarTarefas();
        listaDeTarefa.numeroDeTarefas();
    }
}
