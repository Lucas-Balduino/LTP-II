package AtributosStatics;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Lucas");
        System.out.println((Usuario.getUsuariosOnline()));
        Usuario usuario2 = new Usuario("Pedro");
        System.out.println((Usuario.getUsuariosOnline()));
        Usuario usuario3 = new Usuario("Matheus");
        System.out.println((Usuario.getUsuariosOnline()));
        usuario3.logout(usuario3.nome);
        System.out.println((Usuario.getUsuariosOnline()));
    }
}
