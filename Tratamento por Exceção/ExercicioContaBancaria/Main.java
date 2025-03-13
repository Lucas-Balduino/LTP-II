package ExercicioContaBancaria;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("1231412","Lucas", 1000);
        ContaBancaria conta2 = new ContaBancaria();
        conta.exibirSaldo();
        conta2.exibirSaldo();
        conta.depositar(1000);
        conta.exibirSaldo();
        conta.sacar(2000);
        conta.exibirSaldo();
    }
}
