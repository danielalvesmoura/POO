package app;

import global.Dica;
import global.Pontuacao;
import global.Util;

public class CacaPalavras {

    Util util = new Util();
    Pontuacao pontuacao = new Pontuacao();
    Dica dica = new Dica();

    public void jogo() {

        int tamanhoTabuleiro = 7;

        int continuar = 1;
        while(continuar == 1) {

            String escolhida = Main.palavras[util.gerar(0,Main.palavras.length-1)];

            int posicaoPalavra = tamanhoTabuleiro+1;
            while (posicaoPalavra + escolhida.length() > tamanhoTabuleiro) {
                posicaoPalavra = util.gerar(0, escolhida.length());
            }

            mostrarTabuleiro(tamanhoTabuleiro, posicaoPalavra);

            System.out.printf("Digite a palavra, ou digite dica, ou digite desisto.\n");

            String resposta = util.inputString();

            pontuacao.atualizaPontos(escolhida, resposta, dica.dica);

            if (resposta.equals("desisto")) {
                break;
            } 

        }

    }

    public void mostrarTabuleiro(int tamanhoTabuleiro) {
        System.out.println("");

        for (int x = 0; x < tamanhoTabuleiro; x++) {
 
            for (int y = 0; y < tamanhoTabuleiro; y++) {

                System.out.print((char) util.gerar(97,122) + "  ");
 
            }
 
            System.out.println("");
        }
        System.out.println("");
 
    }
 

}
