package app;
import global.Dificuldade;
import global.Util;

public class Main {

   static public Util input = new Util();
   static public String palavras[] = {"copo","jogo","adaga","café","trena"};

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        Boolean jogando = true;
        while (jogando) {

            int dificuldadeAtual = 4;

            System.out.printf("Decida: [1] Caça-Palavras, [2] Anagrama, [3] Mudar Dificuldade [4] Parar.\n");

            int decisao = input.inputInt();

            if(decisao == 1) {

                CacaPalavras cacaPalavras = new CacaPalavras();
                cacaPalavras.jogo();

            } else if (decisao == 2) {

                Anagrama anagrama = new Anagrama();
                anagrama.jogo();

            } else if (decisao == 4) {
                
                jogando = false;

            } else if (decisao == 3) {

                System.out.printf("A dificuldade atual é %d. Digite a quantidade letras da palavra de 4 a 6: ");
                dificuldadeAtual = input.inputInt();

                mudarDificuldade(dificuldadeAtual);

            } else {

                System.out.println("\nValor inválido. Digite novamente: ");

            }

        }

    }

    public static void mudarDificuldade(int dificuldadeAtual) {

        

    }

}