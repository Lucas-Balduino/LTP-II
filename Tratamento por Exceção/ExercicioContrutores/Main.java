package ExercicioContrutores;

public class Main{
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(0, 1,2,4);
        System.out.println(retangulo.area());
        System.out.println(retangulo.perimetro());
    }
}