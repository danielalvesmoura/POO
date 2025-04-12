package Global;

public class Tabuleiro {

    NumeroAleatorio numeroAleatorio = new NumeroAleatorio();

    public void mostrar(String escolhida, int tamanhoTabuleiro) {

        int posicaoPalavra = geraPosicao(escolhida.length(),escolhida);

        char escolhidaArray[] = escolhida.toCharArray();

        for (int linha = 0; linha < tamanhoTabuleiro; linha++) {

            for (int letra = 0; letra < tamanhoTabuleiro; letra++) {

                if (linha == posicaoPalavra && letra < escolhida.length()) {
                    System.out.print(escolhidaArray[letra] + "  ");
                } else {
                    System.out.print((char) numeroAleatorio.gerar(97,123) + "  ");
                }

            }

            System.out.println("");

        }

    }

    int geraPosicao(int tamanho, String escolhida) {
        int posicao = numeroAleatorio.gerar(0, escolhida.length());
        return posicao;
    }
}
