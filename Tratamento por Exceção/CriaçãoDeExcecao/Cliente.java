package CriaçãoDeExcecao;

public class Cliente {
    public float saldo = 1000;

    public void SacarDinheiro(double valor) throws SaldoInsuficienteException {
        saldo -= valor;

    }
    public void VerSaldo(){
        System.out.println("O saldo do Cliente é: "+ saldo);
    }
}
