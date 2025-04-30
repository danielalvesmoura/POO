import java.util.Scanner;

public class CacaPalavras {

    Global global = new Global();
    Tabuleiro tabuleiro = new Tabuleiro();

    int tamanhoTabuleiro;

    public void jogo(Palavra palavra, Pontuacao pontuacao, Dica dica) {

        tamanhoTabuleiro = palavra.getDificuldade()+2;

        palavra.sorteiaPalavra(palavra.vetorPalavras);

        char[][] tabuleiro1 = tabuleiro.gerarTabuleiro(tamanhoTabuleiro);

        int orientacaoPalavra = global.inteiroAleatorio(0, 2);  // Decide se a palavra estará na vertical ou horizontal

        int[] posicaoYPalavras = tabuleiro.geraPosicaoYPalavras(tamanhoTabuleiro, palavra.palavrasEscolhidas, orientacaoPalavra);
        int[] posicaoXPalavras = tabuleiro.geraPosicaoXPalavras(tamanhoTabuleiro, palavra.palavrasEscolhidas, orientacaoPalavra);

        tabuleiro1 = tabuleiro.ocultarPalavraTabuleiro(tabuleiro1,palavra.palavrasEscolhidas,posicaoXPalavras, posicaoYPalavras, orientacaoPalavra);

        tabuleiro.mostrarTabuleiro(tabuleiro1);

        tentativa(palavra, pontuacao, dica);

    }

    private void tentativa(Palavra palavra, Pontuacao pontuacao, Dica dica) {
        palavra.acertouQuantas = 0;
        while (palavra.acertouQuantas != 2) {
            System.out.println("Digiter a palavra que encontrar");

            global.scanner = new Scanner(System.in);
            palavra.resposta = global.scanner.nextLine();

            checaResposta(palavra, pontuacao, dica);
        }
    }

    private void checaResposta(Palavra palavra, Pontuacao pontuacao, Dica dica) {
        Boolean encontrou = false;

        for (int i = 0; i < palavra.palavrasEscolhidas.length; i++) {
            if (palavra.resposta.equals(palavra.palavrasEscolhidas[i])) {
                encontrou = true;
                palavra.palavrasAcertadas[i] = true;
            }
        }

        if (encontrou) {

            palavra.acertouQuantas++;

            System.out.println("\nVocê acertou uma palavra!");
            System.out.println("Você ganhou 1 ponto!\n");
            pontuacao.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", pontuacao.pontos);

        } else if (palavra.resposta.equals("dica")) {

            System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
            int qualPalavraDica = global.scanner.nextInt();
            dica.dica(qualPalavraDica, palavra);

        } else if (palavra.resposta.equals("desisto")) {
            palavra.acertouQuantas = 2;

        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
        }
    }
}
