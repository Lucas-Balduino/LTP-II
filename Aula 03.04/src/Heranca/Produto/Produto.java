package Heranca.Produto;

public class Produto {
    public String nome;

    public Produto(String nome){
        this.nome = nome;
    }

    public void exibirInformacao(){
        System.out.println("Nome do Produto: " + nome);
    }
}

class Livro extends Produto {
    public String autor;
    public Livro(String nome, String autor){
        super(nome);
        this.autor = autor;
    }

    //Override: Sobreescrita do metodo da superclasse
    public void exibirInformacao(){
        System.out.println("Nome do Produto: "+ nome +", Autor: " + autor);
    }
}

class Main{
    public static void main(String[] args) {
        // Upcasting: utilizar a superclasse para instanciar a subclasse
        Produto livro1 = new Livro("Percy Jackson", "Autor");

        Livro livro2 = new Livro("Harry Potter", "R. J.");

        livro1.exibirInformacao();

        livro2.exibirInformacao();

        Produto produto1 = new Produto("Lapis");

        // Downcasting: Error, nao pode utilizar a subclasse para instanciar uma superclasse
        // Livro livro3 = new Produto("Lapiseira","Autor");

        produto1.exibirInformacao();

    }
}
