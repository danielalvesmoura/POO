package global;

import app.Main;

public class Palavra {

    static public Util util = new Util();

    public String escolherPalavra(int dificuldadeAtual) {
        String palavra = Main.palavras[util.gerar(0,Main.palavras.length-1)];

        while (palavra.length() != dificuldadeAtual) {
            palavra = Main.palavras[util.gerar(0,Main.palavras.length-1)];
        }

        return palavra;
    }

}
