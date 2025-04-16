package app;
import global.Util;

public class Main {

   static public Util input = new Util();
   static public String palavras[] = {"copo","jogo"};

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        Boolean jogando = true;
        while (jogando) {

            System.out.printf("Decida: [1] Caça-Palavras, [2] Anagrama, [3] Parar.\n");

            int decisao = input.inputInt();

            if(decisao == 1) {

                CacaPalavras cacaPalavras = new CacaPalavras();
                cacaPalavras.jogo();

            } else if (decisao == 2) {

                Anagrama anagrama = new Anagrama();
                anagrama.jogo();

            } else if (decisao == 3) {
                
                jogando = false;

            } else {

                System.out.println("\nValor inválido. Digite novamente: ");

            }

        }

        

    }

}