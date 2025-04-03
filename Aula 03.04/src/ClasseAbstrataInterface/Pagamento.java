package ClasseAbstrataInterface;

import java.util.ArrayList;
import java.util.List;

interface Pagavel{
    void pagar();
}

abstract class Pessoa{
    protected String nome;
    protected double valor;

    public Pessoa(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    abstract void exibirValor();
}

class Funcionario extends Pessoa implements Pagavel{
    public Funcionario(String nome, double valor) {
        super(nome, valor);
    }

    public void exibirValor(){
        System.out.println("Salario do Funcionario: " + valor);
    }

    public void pagar(){
        System.out.println("Salario do Funcionario");
    }
}

class Fornecedor extends Pessoa implements Pagavel{
    public Fornecedor(String nome, double valor) {
        super(nome, valor);
    }

    public void exibirValor(){
        System.out.println("Pagamento do Fornecedor: " + valor);
    }

    public void pagar(){
        System.out.println("Pagamento do Fornecedor");
    }
}

public class Pagamento {
    public static void main(String[] args) {
        List<Pagavel> Pagamentos = new ArrayList<Pagavel>();

        Pagamentos.add(new Funcionario("Pedro", 1000.0));
        Pagamentos.add(new Fornecedor("Joao", 5000.0));

        for(Pagavel p : Pagamentos){
            ((Pessoa)p).exibirValor();
        }
    }
}
