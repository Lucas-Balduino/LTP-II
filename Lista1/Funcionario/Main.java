package Lista1.Funcionario;

public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("José", 5000,"Gerente");
        System.out.println(f1.salario);
        System.out.println(f1.calcularBonus());
        Funcionario f2 = new Funcionario("Alberto", 3000,"Analista");
        System.out.println(f2.salario);
        System.out.println(f2.calcularBonus());
        Funcionario f3 = new Funcionario("Roberto", 1300,"Estagiário");
        System.out.println(f3.salario);
        System.out.println(f3.calcularBonus());
    }
}
