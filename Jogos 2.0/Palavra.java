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

    public void tentativa() {
        while (acertouQuantas != 2) {
            Boolean jaFoi = false;
            while(jaFoi != false)
            System.out.println("Qual deseja acertar? [1] primeira ou [2] segunda");
            int qualPalavra = global.scanner.nextInt();

            while (palavrasAcertadas[qualPalavra-1] == false) {

                global.scanner = new Scanner(System.in);
                resposta = global.scanner.nextLine();

                palavrasAcertadas[qualPalavra-1] = checaResposta(qualPalavra);
            }
        }
    }

    public Boolean checaResposta(int qualPalavra) {
        if (resposta.equals(palavrasEscolhidas[qualPalavra-1])) {
            acertouQuantas++;
            System.out.println("\nVocê acertou!");
            System.out.println("Você ganhou 1 ponto!\n");
            Main.pontuacao.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", Main.pontuacao.pontos);
            return true;
        } else if (resposta.equals("dica")) {
            System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
            int qualPalavraDica = global.scanner.nextInt();
            Main.dica.dica(qualPalavraDica);
            return false;
        } else if (resposta.equals("desisto")) {
            return true;
        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
            return false;
        }
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }


    public int getDificuldade() {
        return dificuldade;
    }
}
