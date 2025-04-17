package global;

public class Tabuleiro {

    Util util = new Util();

    public void mostrarTabuleiro(char[][] tabuleiro) {
        System.out.println("");

        for (int y = 0; y < tabuleiro.length; y++) {

            for (int x = 0; x < tabuleiro.length; x++) {

                System.out.printf("%s  ", tabuleiro[y][x]);

            }

            System.out.println("");
        }
        System.out.println("");

    }

    public char[][] gerarTabuleiro(int tamanhoTabuleiro) {

        char tabuleiroTemporario[][] = new char[tamanhoTabuleiro][tamanhoTabuleiro];

        for (int y = 0; y < tamanhoTabuleiro; y++) {

            for (int x = 0; x < tamanhoTabuleiro; x++) {

                tabuleiroTemporario[y][x] = (char) util.gerar(97,122);

            }

        }

        return tabuleiroTemporario;
    };

    public char[][] ocultarPalavraTabuleiro(char[][] tabuleiro, String escolhida, int posicaoXPalavra, int posicaoYPalavra, int orientacaoPalavra) {

        char escolhidaArray[] = escolhida.toCharArray();

        if (orientacaoPalavra == 0) {

            for (int i = 0; i < escolhida.length(); i++) {

                tabuleiro[posicaoYPalavra][posicaoXPalavra+i] = escolhidaArray[i];

            }

        } else {

            for (int i = 0; i < escolhida.length(); i++) {

                tabuleiro[posicaoYPalavra+i][posicaoXPalavra] = escolhidaArray[i];

            }

        }

        return tabuleiro;
    }

}
