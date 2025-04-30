import java.util.Scanner;

public class Main {

    private Global global = new Global();
    public Palavra palavra = new Palavra();
    public Pontuacao pontuacao = new Pontuacao();
    public Dica dica = new Dica();

    private Boolean jogando = true;

    public static void main(String[] args) {

        Main main = new Main();

        while(main.jogando) {
            main.acao();
        }

    }

    private void acao() {
        System.out.println("\n[1] Anagrama, [2] Caça Palavras, [3] Mudar Dificuldade, [4] Parar");
        global.scanner = new Scanner(System.in);
        int respostaAcao = global.scanner.nextInt();

        if (respostaAcao == 1) {
            Anagrama anagrama = new Anagrama();
            anagrama.jogo(palavra, pontuacao, dica);
        }  else if (respostaAcao == 2) {
            CacaPalavras cacaPalavras = new CacaPalavras();
            cacaPalavras.jogo(palavra, pontuacao, dica);
        }  else if (respostaAcao == 3) {
            mudarDificuldade(palavra);
        } else if (respostaAcao == 4) {
            jogando = false;
        }


    }

    private void mudarDificuldade(Palavra palavra) {

        System.out.println("Digite a quantidade desejada de letras [4-6]:");

        global.scanner = new Scanner(System.in);
        palavra.setDificuldade(global.scanner.nextInt());

    }



}
