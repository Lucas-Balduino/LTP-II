package Lista1.Funcionario;

public class Funcionario {
    public String nome;
    public double salario;
    public String cargo;


    public Funcionario() {
        nome = "Anônimo";
        salario = 1300;
        cargo = "Estagiário";
    }

    public Funcionario(String nome, double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public double calcularBonus(){
        if (this.cargo == "Gerente"){
            return this.salario * 0.20;
        } else if (this.cargo == "Analista"){
            return this.salario * 0.10;
        }else if (this.cargo == "Estagiário"){
            return this.salario * 0.05;
        } else {
            return this.salario;
        }
    }
}

