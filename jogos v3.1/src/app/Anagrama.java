package app;

import global.Dica;
import global.Pontuacao;
import global.Util;

public class Anagrama {

    Util util = new Util();
    Pontuacao pontuacao = new Pontuacao();
    Dica dica = new Dica();

    public void jogo() {

        String escolhida = "";

        Boolean dicaTemp = false;

        int continuar = 1;
        while(continuar == 1) {

            if (dicaTemp == false) {
                dica.dica = false;
                escolhida = Main.palavras[util.gerar(0,Main.palavras.length-1)];
            }

            System.out.printf("Acerte: %s, ou digite dica, ou digite desisto.\n", embaralhar(escolhida));

            String resposta = util.inputString();

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

    public String embaralhar(String escolhida) {

        char[] escolhidaArray = escolhida.toCharArray();
        Util numeroAleatorio = new Util();

        for (int i = 0; i < escolhida.length()-1; i++) {

            int charSorteado = numeroAleatorio.gerar(0, escolhida.length()-1);

            char charTemporario = escolhidaArray[i];
            escolhidaArray[i] = escolhidaArray[charSorteado];
            escolhidaArray[charSorteado] = charTemporario;

        }

        return new String(escolhidaArray);
    }

}
