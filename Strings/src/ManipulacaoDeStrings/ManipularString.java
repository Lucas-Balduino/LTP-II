package ManipulacaoDeStrings;

import java.util.Scanner;

public class ManipularString {

    public int contadorDeVogais(String palavra){
        int contador = 0;
        for (int i = 0; i < palavra.length(); i++) {
            palavra = palavra.toLowerCase(); //palavra = palavra.toLowerCase().charAt(); -Possibilidade de Combinar metodos
            if (palavra.charAt(i) == 'a' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'u'  ) {
                contador++;
            };
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();

        ManipularString ms = new ManipularString();
        System.out.println(ms.contadorDeVogais(palavra));
    }
}
