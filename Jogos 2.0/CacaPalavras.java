import java.util.Scanner;

public class CacaPalavras {

    Global global = new Global();
    Tabuleiro tabuleiro = new Tabuleiro();

    int tamanhoTabuleiro;

    public void jogo() {

        tamanhoTabuleiro = Main.palavra.getDificuldade()+2;

        Main.palavra.sorteiaPalavra(Main.palavra.vetorPalavras);

        char[][] tabuleiro1 = tabuleiro.gerarTabuleiro(tamanhoTabuleiro);

        int orientacaoPalavra = global.inteiroAleatorio(0, 2);  // Decide se a palavra estará na vertical ou horizontal

        int[] posicaoYPalavras = tabuleiro.geraPosicaoYPalavras(tamanhoTabuleiro, Main.palavra.palavrasEscolhidas, orientacaoPalavra);
        int[] posicaoXPalavras = tabuleiro.geraPosicaoXPalavras(tamanhoTabuleiro, Main.palavra.palavrasEscolhidas, orientacaoPalavra);

        tabuleiro1 = tabuleiro.ocultarPalavraTabuleiro(tabuleiro1,Main.palavra.palavrasEscolhidas,posicaoXPalavras, posicaoYPalavras, orientacaoPalavra);

        tabuleiro.mostrarTabuleiro(tabuleiro1);

        tentativa();

    }

    private void tentativa() {
        Main.palavra.acertouQuantas = 0;
        while (Main.palavra.acertouQuantas != 2) {
            System.out.println("Digiter a palavra que encontrar");

            global.scanner = new Scanner(System.in);
            Main.palavra.resposta = global.scanner.nextLine();

            checaResposta();
        }
    }

    private void checaResposta() {
        Boolean encontrou = false;

        for (int i = 0; i < Main.palavra.palavrasEscolhidas.length; i++) {
            if (Main.palavra.resposta.equals(Main.palavra.palavrasEscolhidas[i])) {
                encontrou = true;
                Main.palavra.palavrasAcertadas[i] = true;
            }
        }

        if (encontrou) {

            Main.palavra.acertouQuantas++;

            System.out.println("\nVocê acertou uma palavra!");
            System.out.println("Você ganhou 1 ponto!\n");
            Main.pontuacao.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", Main.pontuacao.pontos);

        } else if (Main.palavra.resposta.equals("dica")) {

            System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
            int qualPalavraDica = global.scanner.nextInt();
            Main.dica.dica(qualPalavraDica);

        } else if (Main.palavra.resposta.equals("desisto")) {
            Main.palavra.acertouQuantas = 2;

        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
        }
    }
}
