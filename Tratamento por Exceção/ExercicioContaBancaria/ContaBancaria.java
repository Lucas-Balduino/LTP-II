package ExercicioContaBancaria;

public class ContaBancaria {
    public String numeroConta;
    public String titular;
    public double saldo;

    //Sobrecarga de Construtures, dois contrutores um padrao e um que recebe parametro

    public ContaBancaria() {
        numeroConta = "00000000";
        titular = "Desconhecido";
        saldo = 0;
    }
    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo Insuficiente");
        } else {
            this.saldo -= valor;
        }
    }

    public void exibirSaldo() {
        System.out.println(this.titular);
        System.out.println(this.numeroConta);
        System.out.println(this.saldo);
    }
}
