package CriaçãoDeExcecao;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try{
            cliente.SacarDinheiro(2000);
            cliente.VerSaldo();
        } catch (SaldoInsuficienteException e) {

        }

    }
}
