import java.util.Scanner;

public class Anagrama {
    Global global = new Global();
    String[] palavrasEmbaralhadas;

    public void jogo() {
        Main.palavra.sorteiaPalavra(Main.palavra.vetorPalavras);

        palavrasEmbaralhadas = embaralhaPalavras(Main.palavra.palavrasEscolhidas);

        System.out.println(palavrasEmbaralhadas[0]);
        System.out.println(palavrasEmbaralhadas[1]);

        Main.palavra.palavraReset();

        tentativa();

    }

    private String[] embaralhaPalavras(String[] palavrasEscolhidas) {
        String[] novasPalavras = new String[2];
        for (int iPalavra = 0; iPalavra < palavrasEscolhidas.length; iPalavra++) {
            char[] palavraArray = palavrasEscolhidas[iPalavra].toCharArray();

            for (int i = 0; i < palavraArray.length; i++) {
                int posicaoAleatoria = global.inteiroAleatorio(0, palavraArray.length);

                char aux = palavraArray[i];
                palavraArray[i] = palavraArray[posicaoAleatoria];
                palavraArray[posicaoAleatoria] = aux;
            }

            novasPalavras[iPalavra] = new String(palavraArray);

        }

        return novasPalavras;
    }

    private void tentativa() {
        while (Main.palavra.acertouQuantas != 2) {
            System.out.println("Qual deseja acertar? [1] primeira ou [2] segunda");
            int qualPalavra = global.scanner.nextInt();

            while (Main.palavra.palavrasAcertadas[qualPalavra-1] == false) {

                global.scanner = new Scanner(System.in);
                Main.palavra.resposta = global.scanner.nextLine();

                Main.palavra.palavrasAcertadas[qualPalavra-1] = checaResposta(qualPalavra);
            }
        }
    }

    private Boolean checaResposta(int qualPalavra) {
        if (Main.palavra.resposta.equals(Main.palavra.palavrasEscolhidas[qualPalavra-1])) {
            Main.palavra.acertouQuantas++;
            System.out.println("\nVocê acertou!");
            System.out.println("Você ganhou 1 ponto!\n");
            Main.pontuacao.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", Main.pontuacao.pontos);
            return true;
        } else if (Main.palavra.resposta.equals("dica")) {
            System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
            int qualPalavraDica = global.scanner.nextInt();
            Main.dica.dica(qualPalavraDica);
            return false;
        } else if (Main.palavra.resposta.equals("desisto")) {
            return true;
        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
            return false;
        }
    }

}
