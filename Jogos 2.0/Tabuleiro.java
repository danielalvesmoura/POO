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

    public char[][] ocultarPalavraTabuleiro(char[][] tabuleiro, String[] escolhida, int[] posicaoXPalavra, int[] posicaoYPalavra, int orientacaoPalavra) {
        for (int iPalavra = 0; iPalavra < escolhida.length; iPalavra++) {
            char escolhidaArray[] = escolhida[iPalavra].toCharArray();

            if (orientacaoPalavra == 0) {
                for (int i = 0; i < escolhida[iPalavra].length(); i++) {
                    tabuleiro[posicaoYPalavra[iPalavra]][posicaoXPalavra[iPalavra]+i] = escolhidaArray[i];
                }
            } else {
                for (int i = 0; i < escolhida[iPalavra].length(); i++) {
                    tabuleiro[posicaoYPalavra[iPalavra]+i][posicaoXPalavra[iPalavra]] = escolhidaArray[i];
                }
            }
        }

        return tabuleiro;
    }

    public int[] geraPosicaoXPalavras(int tamanhoTabuleiro, String[] escolhida, int orientacaoPalavra) {
        int[] posicaoXPalavras = new int[2];
        for (int iPalavra = 0; iPalavra < escolhida.length; iPalavra++) {
            posicaoXPalavras[iPalavra] = global.inteiroAleatorio(0, tamanhoTabuleiro);

            if (orientacaoPalavra == 0) {
                while (posicaoXPalavras[iPalavra] + escolhida[iPalavra].length() > tamanhoTabuleiro) {
                    posicaoXPalavras[iPalavra] = global.inteiroAleatorio(0, escolhida[iPalavra].length());
                }
            }
        }

        return posicaoXPalavras;
    }

    public int[] geraPosicaoYPalavras(int tamanhoTabuleiro, String[] escolhida, int orientacaoPalavra) {
        int[] posicaoYPalavras = new int[2];
        for (int iPalavra = 0; iPalavra < escolhida.length; iPalavra++) {
            posicaoYPalavras[iPalavra] = global.inteiroAleatorio(0, tamanhoTabuleiro);

            if (orientacaoPalavra == 1) {
                while (posicaoYPalavras[iPalavra] + escolhida[iPalavra].length() > tamanhoTabuleiro) {
                    posicaoYPalavras[iPalavra] = global.inteiroAleatorio(0, escolhida[iPalavra].length());
                }
            }
        }

        return posicaoYPalavras;
    }
}
