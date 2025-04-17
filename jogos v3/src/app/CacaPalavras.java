package app;

import global.Dica;
import global.Pontuacao;
import global.Tabuleiro;
import global.Util;

public class CacaPalavras {

    Util util = new Util();
    Pontuacao pontuacao = new Pontuacao();
    Tabuleiro tabu = new Tabuleiro();
    Dica dica = new Dica();

    public void jogo() {

        int tamanhoTabuleiro = 5;  // Define o tamanho do tabuleiro

        Boolean dicaTemp = false;
        String resposta = "";
        String escolhida = "";

        int continuar = 1;
        while(continuar == 1) {  // Permite partidas consecutivas

            if (dicaTemp == false) {  // Impede que inicie outra partida em caso de dica

                dica.dica = false;  // Reseta a dica

                escolhida = Main.palavras[util.gerar(0,Main.palavras.length-1)];  // Escolhe a palavra

                int orientacaoPalavra = util.gerar(0, 1);  // Decide se a palavra estará na vertical ou horizontal

                int posicaoYPalavra = geraPosicaoYPalavra(tamanhoTabuleiro, escolhida, orientacaoPalavra);
                int posicaoXPalavra = geraPosicaoXPalavra(tamanhoTabuleiro, escolhida, orientacaoPalavra);

                char tabuleiro[][] = tabu.gerarTabuleiro(tamanhoTabuleiro);

                tabuleiro = tabu.ocultarPalavraTabuleiro(tabuleiro, escolhida, posicaoXPalavra, posicaoYPalavra, orientacaoPalavra);

                tabu.mostrarTabuleiro(tabuleiro);

            }

            System.out.printf("Digite a palavra, ou digite dica, ou digite desisto.\n");

            resposta = util.inputString();  // Pega o palpite do jogador


            if (resposta.equals("desisto")) {
                break;
            } else if (resposta.equals(escolhida)) {
                System.out.println("\nVocê acertou!\n");

                pontuacao.atualizaPontos(dica.dica);

                System.out.printf("%d pontos.\n\n", pontuacao.pontos);

                dicaTemp = false;
            } else if (resposta.equals("dica")) {
                System.out.println(dica.dica(escolhida));
                dicaTemp = true;
            } else {
                System.out.println("Você errou!");
                dicaTemp = false;
            }

        }

    }

    public int geraPosicaoXPalavra(int tamanhoTabuleiro, String escolhida, int orientacaoPalavra) {
        int posicaoXPalavra = util.gerar(0, tamanhoTabuleiro-1);

        if (orientacaoPalavra == 0) {

            while (posicaoXPalavra + escolhida.length() > tamanhoTabuleiro) {
                posicaoXPalavra = util.gerar(0, escolhida.length());
            }
        }

        return posicaoXPalavra;
    }

    public int geraPosicaoYPalavra(int tamanhoTabuleiro, String escolhida, int orientacaoPalavra) {
        int posicaoYPalavra = util.gerar(0, tamanhoTabuleiro-1);

        if (orientacaoPalavra == 1) {

            while (posicaoYPalavra + escolhida.length() > tamanhoTabuleiro) {
                posicaoYPalavra = util.gerar(0, escolhida.length());
            }
        }

        return posicaoYPalavra;
    }

}
