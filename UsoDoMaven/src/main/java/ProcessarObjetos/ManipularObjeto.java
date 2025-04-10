package ProcessarObjetos;
import com.google.gson.Gson;

class Pessoa{
    String nome;
    int idade;

    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
}

public class ManipularObjeto {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Maria", 20);
        Gson gson = new Gson();

        String json = gson.toJson(p1); //Transformando um objeto em Json
        Pessoa p2 = gson.fromJson(gson.toJson(p1), Pessoa.class); //Transformando Json em objeto
        System.out.println(json);
        System.out.println(p2.nome+" "+p2.idade);

    }
}
