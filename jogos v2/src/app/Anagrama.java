package app;

import global.Dica;
import global.Pontuacao;
import global.Util;

public class Anagrama {

    Util util = new Util();
    Pontuacao pontuacao = new Pontuacao();
    Dica dica = new Dica();

    public void jogo() {

        String escolhida = Main.palavras[util.gerar(0,Main.palavras.length-1)];

        int continuar = 1;
        while(continuar == 1) {

            System.out.printf("Acerte: %s, ou digite dica, ou digite desisto.\n", embaralhar(escolhida));

            String resposta = util.inputString();

            pontuacao.atualizaPontos(escolhida, resposta, dica.dica);

            if (resposta.equals("desisto")) {
                break;
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
