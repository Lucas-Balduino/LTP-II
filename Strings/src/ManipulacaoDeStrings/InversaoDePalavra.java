package ManipulacaoDeStrings;

import java.util.Scanner;

public class InversaoDePalavra {
    String palavra;
    String palavraInvertida = "";
    char letra;

    public String InverterDePalavra(String palavra) {
        for (int i = palavra.length() - 1; i >= 0; i--) {
            letra = palavra.charAt(i);
            palavraInvertida += letra;
        }
        return palavraInvertida;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InversaoDePalavra inversao = new InversaoDePalavra();
        inversao.palavra = sc.nextLine();
        System.out.println(inversao.InverterDePalavra(inversao.palavra));
    }
}
