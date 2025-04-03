package Heranca.HerancaComListaFuncionario;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario(){
        return salarioBase;
    }

    public String getNome() {
        return nome;
    }
}

class Gerente extends Funcionario{
    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    public double calcularSalario(){
        return salarioBase * 1.2;
    }
}

class Desenvolvedor extends Funcionario{
    public Desenvolvedor(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    public double calcularSalario(){
        return salarioBase * 1.1;
    }
}

class Main{
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Gerente gerente = new Gerente("Gerente", 2000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Desenvolvedor", 2000);

        funcionarios.add(gerente);
        funcionarios.add(desenvolvedor);

        for(Funcionario funcionario : funcionarios){
            System.out.println("Nome: "+ funcionario.getNome() + " - Salario: "+ funcionario.calcularSalario());
        }
    }
}