public class Tabuleiro {

    Global global = new Global();

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
                tabuleiroTemporario[y][x] = (char) global.inteiroAleatorio(97,122);
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

    public int geraPosicaoXPalavra(int tamanhoTabuleiro, String escolhida, int orientacaoPalavra) {
        int posicaoXPalavra = global.inteiroAleatorio(0, tamanhoTabuleiro-1);
        if (orientacaoPalavra == 0) {
            while (posicaoXPalavra + escolhida.length() > tamanhoTabuleiro) {
                posicaoXPalavra = global.inteiroAleatorio(0, escolhida.length());
            }
        }
        return posicaoXPalavra;
    }

    public int geraPosicaoYPalavra(int tamanhoTabuleiro, String escolhida, int orientacaoPalavra) {
        int posicaoYPalavra = global.inteiroAleatorio(0, tamanhoTabuleiro-1);
        if (orientacaoPalavra == 1) {
            while (posicaoYPalavra + escolhida.length() > tamanhoTabuleiro) {
                posicaoYPalavra = global.inteiroAleatorio(0, escolhida.length());
            }
        }
        return posicaoYPalavra;
    }
}
