package app;
import global.Util;

public class Main {

   static public Util input = new Util();
   static public String palavras[] = {"copo","jogo","adaga","café","trena","quadro","trampo"};
   static public int dificuldadeAtual = 5;

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {

        Boolean jogando = true;
        while (jogando) {

            System.out.printf("Decida: [1] Caça-Palavras, [2] Anagrama, [3] Mudar Dificuldade, [4] Parar.\n");

            int decisao = input.inputInt();

            if(decisao == 1) {

                CacaPalavras cacaPalavras = new CacaPalavras();
                cacaPalavras.jogo();

            } else if (decisao == 2) {

                Anagrama anagrama = new Anagrama();
                anagrama.jogo();

            } else if (decisao == 3) {

                System.out.println("Digite a quantidade de letras da palavra de 4 a 6: ");
                int escolha = input.inputInt();

                while (escolha < 4 || escolha > 6) {
                    System.out.println("Denovo: ");
                    escolha = input.inputInt();
                }

                dificuldadeAtual = escolha;

            } else if (decisao == 4) {
                
                jogando = false;

            } else {

                System.out.println("\nValor inválido. Digite novamente: ");

            }

        }

    }

}