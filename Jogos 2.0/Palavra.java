public class Palavra {

    Global global = new Global();

    int dificuldade = 4;
    String[] vetorPalavras = {"salve","casa","trilho"};
    String palavraEscolhida = sorteiaPalavra(vetorPalavras);
    String resposta;

    public String sorteiaPalavra(String[] vetorPalavras) {
        String palavraEscolhida = "";
        while(palavraEscolhida.length() != dificuldade) {
            palavraEscolhida = vetorPalavras[global.inteiroAleatorio(0, vetorPalavras.length-1)];
        }

        return palavraEscolhida;
    }

    public void checaResposta() {
        if (resposta.equals(palavraEscolhida)) {
            System.out.println("\nVocê acertou!");
            System.out.println("Você ganhou 1 ponto!\n");
            Main.pontuacao.atualizaPontos();
        } else {
            System.out.println("Seu horrível!");
        }
        System.out.printf("\nSua pontuação atual é %d ponto(s)", Main.pontuacao.pontos);
    }

}
