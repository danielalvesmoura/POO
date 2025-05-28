import java.util.Scanner;

public class Palavra {

    Global global = new Global();

    public int dificuldade = 4;
    private String[] vetorPalavras = {"salve","casa","faca","gato","trilho"};
    public String[] palavrasEscolhidas = new String[2];
    public String resposta;
    public Boolean[] palavrasAcertadas = {false,false};
    public int acertouQuantas = 0;

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

    public String[] getVetorPalavras() {
        return vetorPalavras;
    }

    Boolean pediuDica = false;
    public void dica(int qualPalavraDica, Palavra palavra) {
        pediuDica = true;

        char[] palavraArray = palavra.palavrasEscolhidas[qualPalavraDica-1].toCharArray();

        System.out.printf("Primeira letra: %s\nÚltima letra: %s\n", palavraArray[0],palavraArray[palavraArray.length-1]);
    }

    int pontos = 0;
    public void atualizaPontos() {
        pontos++;
    }
}