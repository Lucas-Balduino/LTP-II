package ExercicioContrutores;

public class Retangulo {
    double coordenadaX1;
    double coordenadaY1;
    double coordenadaX2;
    double coordenadaY2;
    double base;
    double altura;

    public double modulo(double input){
        if (input > 0){
            return input;
        }
        else{
            return input * -1;
        }
    }

    public Retangulo(double coordenadaX1, double coordenadaY1, double coordenadaX2, double coordenadaY2) {
        this.coordenadaX1 = coordenadaX1;
        this.coordenadaY1 = coordenadaY1;
        this.coordenadaX2 = coordenadaX2;
        this.coordenadaY2 = coordenadaY2;
        this.base = modulo(coordenadaX2 - coordenadaX1);
        this.altura = modulo(coordenadaY2 - coordenadaY1);
    }

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area(){
        double resultado;
        resultado = this.base * this.altura;
        return modulo(resultado);
    }

    public double perimetro(){
        double resultado;
        System.out.println(this.base);
        resultado = (2 * this.base) + (2 * this.altura);
        return resultado;
    }
}
