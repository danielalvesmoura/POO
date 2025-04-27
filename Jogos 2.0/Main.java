public class Main {

    private static Global global = new Global();
    public static Palavra palavra = new Palavra();
    public static Pontuacao pontuacao = new Pontuacao();
    public static Dica dica = new Dica();

    private static Boolean jogando = true;

    public static void main(String[] args) {

        while(jogando) {
            acao();
        }

    }

    private static void acao() {
        System.out.println("\n[1] Anagrama, [2] Caça Palavras, [3] Mudar Dificuldade, [4] Parar");
        int respostaAcao = global.scanner.nextInt();

        if (respostaAcao == 1) {
            Anagrama anagrama = new Anagrama();
            anagrama.jogo();
        }  else if (respostaAcao == 2) {
            CacaPalavras cacaPalavras = new CacaPalavras();
            cacaPalavras.jogo();
        }  else if (respostaAcao == 3) {
            mudarDificuldade();
        } else if (respostaAcao == 4) {
            jogando = false;
        }


    }

    private static void mudarDificuldade() {

        System.out.println("Digite a quantidade desejada de letras [4-6]:");

        Main.palavra.dificuldade = global.scanner.nextInt();

    }



}
