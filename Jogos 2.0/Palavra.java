import java.util.Scanner;

public class Palavra {

    Global global = new Global();

    int dificuldade = 4;
    String[] vetorPalavras = {"salve","casa","faca","gato","trilho"};
    String[] palavrasEscolhidas = new String[2];
    String resposta;
    Boolean[] palavrasAcertadas = {false,false};
    int acertouQuantas = 0;

    public void palavraReset() {
        acertouQuantas = 0;
        resposta = "";
        palavrasAcertadas[0] = false;
        palavrasAcertadas[1] = false;
    }

    public void sorteiaPalavra(String[] vetorPalavras) {
        for (int i = 0; i < palavrasEscolhidas.length; i++) {
            palavrasEscolhidas[i] = "";
            while(palavrasEscolhidas[i].length() != dificuldade) {
                palavrasEscolhidas[i] = vetorPalavras[global.inteiroAleatorio(0, vetorPalavras.length)];
            }
        }
    }





    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }


    public int getDificuldade() {
        return dificuldade;
    }
}
