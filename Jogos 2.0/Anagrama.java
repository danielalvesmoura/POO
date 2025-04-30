import java.util.Scanner;

public class Anagrama {
    Global global = new Global();
    String[] palavrasEmbaralhadas;

    public void jogo(Palavra palavra, Pontuacao pontuacao, Dica dica) {
        palavra.sorteiaPalavra(palavra.vetorPalavras);

        palavrasEmbaralhadas = embaralhaPalavras(palavra.palavrasEscolhidas);

        System.out.println(palavrasEmbaralhadas[0]);
        System.out.println(palavrasEmbaralhadas[1]);

        palavra.palavraReset();

        tentativa(palavra, pontuacao, dica);

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

    private void tentativa(Palavra palavra, Pontuacao pontuacao, Dica dica) {
        while (palavra.acertouQuantas != 2) {
            System.out.println("Qual deseja acertar? [1] primeira ou [2] segunda");
            int qualPalavra = global.scanner.nextInt();

            while (palavra.palavrasAcertadas[qualPalavra-1] == false) {

                global.scanner = new Scanner(System.in);
                palavra.resposta = global.scanner.nextLine();

                palavra.palavrasAcertadas[qualPalavra-1] = checaResposta(qualPalavra, pontuacao, palavra, dica);
            }
        }
    }

    private Boolean checaResposta(int qualPalavra, Pontuacao pontuacao, Palavra palavra, Dica dica) {
        if (palavra.resposta.equals(palavra.palavrasEscolhidas[qualPalavra-1])) {
            palavra.acertouQuantas++;
            System.out.println("\nVocê acertou!");
            System.out.println("Você ganhou 1 ponto!\n");
            pontuacao.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", pontuacao.pontos);
            return true;
        } else if (palavra.resposta.equals("dica")) {
            System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
            int qualPalavraDica = global.scanner.nextInt();
            dica.dica(qualPalavraDica, palavra);
            return false;
        } else if (palavra.resposta.equals("desisto")) {
            return true;
        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
            return false;
        }
    }

}
