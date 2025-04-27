public class Main {

    private static Global global = new Global();
    public static Palavra palavra = new Palavra();
    public static Pontuacao pontuacao = new Pontuacao();

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
        } else if (respostaAcao == 4) {
            jogando = false;
        }


    }



}
