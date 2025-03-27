package AtributosStatics;

public class Usuario {
    static int usuariosOnline = 0; //Atributos statics sao acessados por todas as instancias da classe, é um atributo da classe, nao da instancia
    String nome;

    public Usuario(String nome) {
        this.nome = nome;
        usuariosOnline++;
    }

    public static int getUsuariosOnline() {
        return usuariosOnline;
    }

    public static void logout(String nome){//Metodo static podem ser acessados sem um objeto sem instanciado
        usuariosOnline--;
        System.out.println("O usuário "+nome+" Deslogou.");
    }
}
