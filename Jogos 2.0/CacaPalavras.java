import java.util.Scanner;

public class CacaPalavras {
    Global global = new Global();
    Tabuleiro tabuleiro = new Tabuleiro();
    String[] palavrasEscolhidas;
    int tamanhoTabuleiro;

    Palavra palavra;
    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }
    public void setPalavrasEscolhidas(String[] palavrasEscolhidas) {
        this.palavrasEscolhidas = palavrasEscolhidas;
    }
    public void setTamanhoTabuleiro(int tamanhoTabuleiro) {
        this.tamanhoTabuleiro = tamanhoTabuleiro;
    }

    public CacaPalavras(Palavra palavra){
        setPalavra(palavra);
        setPalavrasEscolhidas(palavra.palavrasEscolhidas);
        setTamanhoTabuleiro(palavra.dificuldade+2);
    }

    public void jogo() {
        palavra.sorteiaPalavra(palavra.getVetorPalavras());

        char[][] tabuleiro1 = tabuleiro.gerarTabuleiro(tamanhoTabuleiro);

        int orientacaoPalavra1 = global.inteiroAleatorio(0, 2);
        int orientacaoPalavra2 = global.inteiroAleatorio(0, 2);// Decide se a palavra estará na vertical ou horizontal

        int[] coordenadasPalavra1 = tabuleiro.geraPosicaoYPalavras(tamanhoTabuleiro, palavrasEscolhidas, orientacaoPalavra1);
        
        int[] posicaoYPalavras = tabuleiro.geraPosicaoYPalavras(tamanhoTabuleiro, palavrasEscolhidas, orientacaoPalavra);
        int[] posicaoXPalavras = tabuleiro.geraPosicaoXPalavras(tamanhoTabuleiro, palavrasEscolhidas, orientacaoPalavra);

        tabuleiro1 = tabuleiro.ocultarPalavraTabuleiro(tabuleiro1,palavrasEscolhidas,posicaoXPalavras, posicaoYPalavras, orientacaoPalavra);

        tabuleiro.mostrarTabuleiro(tabuleiro1);

        tentativa(palavra);

    }

    private void tentativa(Palavra palavra) {
        palavra.acertouQuantas = 0;
        while (palavra.acertouQuantas != 2) {
            System.out.println("Digiter a palavra que encontrar ou digite dica");

            global.scanner = new Scanner(System.in);
            palavra.resposta = global.scanner.nextLine();

            checaResposta(palavra);
        }
    }

    private void checaResposta(Palavra palavra) {
        boolean encontrou = false;

        for (int i = 0; i < palavrasEscolhidas.length; i++) {
            if (palavra.resposta.equals(palavrasEscolhidas[i])) {
                encontrou = true;
                palavra.palavrasAcertadas[i] = true;
            }
        }

        if (encontrou) {

            palavra.acertouQuantas++;

            System.out.println("\nVocê acertou uma palavra!");
            System.out.println("Você ganhou 1 ponto!\n");
            palavra.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", palavra.pontos);

        } else if (palavra.resposta.equals("dica")) {

            System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
            int qualPalavraDica = global.scanner.nextInt();
            palavra.dica(qualPalavraDica, palavra);

        } else if (palavra.resposta.equals("desisto")) {
            palavra.acertouQuantas = 2;

        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
        }
    }
}
