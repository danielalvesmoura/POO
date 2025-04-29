public class CacaPalavras {

    Global global = new Global();
    Tabuleiro tabuleiro = new Tabuleiro();

    int tamanhoTabuleiro;

    public void jogo() {

        tamanhoTabuleiro = Main.palavra.getDificuldade()+2;

        Main.palavra.setPalavraEscolhida(Main.palavra.sorteiaPalavra(Main.palavra.vetorPalavras));

        char[][] tabuleiro1 = tabuleiro.gerarTabuleiro(tamanhoTabuleiro);

        int orientacaoPalavra = global.inteiroAleatorio(0, 2);  // Decide se a palavra estará na vertical ou horizontal

        int posicaoYPalavra = tabuleiro.geraPosicaoYPalavra(tamanhoTabuleiro, Main.palavra.palavraEscolhida, orientacaoPalavra);
        int posicaoXPalavra = tabuleiro.geraPosicaoXPalavra(tamanhoTabuleiro, Main.palavra.palavraEscolhida, orientacaoPalavra);

        tabuleiro1 = tabuleiro.ocultarPalavraTabuleiro(tabuleiro1,Main.palavra.palavraEscolhida,posicaoXPalavra, posicaoYPalavra, orientacaoPalavra);

        tabuleiro.mostrarTabuleiro(tabuleiro1);

        Main.palavra.tentativa();

    }



}
