package Heranca.Animal;

public class Animal {
    public void andar(){
        System.out.println("Andando");
    }

    public void emiteSom(){
        System.out.println("Eu sou um Animal");
    }
}

class Gato extends Animal {
    public void arranhar(){
        System.out.println("Eu sou um gato e Arranhei");
    }

    public void emiteSom(){
        System.out.println("Eu sou um Gato Miau");
    }

    public void emiteSomAnimal(){
        super.emiteSom();
    }
}

class Cachorro extends Animal {
    public void emiteSom(){
        System.out.println("Eu sou um Cachorro Au Au");
    }
}

class Main{
    public static void main(String[] args) {
        Animal animal = new Animal();
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();
        animal.emiteSom();
        gato.emiteSom();
        gato.emiteSomAnimal();
        cachorro.emiteSom();

    }
}