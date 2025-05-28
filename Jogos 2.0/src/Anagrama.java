import java.util.Scanner;

public class Anagrama {
    private Global global = new Global();
    private String[] palavrasEmbaralhadas;
    public Palavra palavra;

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    public Anagrama(Palavra palavra) {
        setPalavra(palavra);
    }

    public void jogo() {

        palavra.sorteiaPalavra(palavra.getVetorPalavras());

        palavrasEmbaralhadas = embaralhaPalavras(palavra.palavrasEscolhidas);

        System.out.printf("Palavra 1: %s\n", palavrasEmbaralhadas[0]);
        System.out.printf("Palavra 2: %s\n", palavrasEmbaralhadas[1]);

        palavra.palavraReset();

        tentativa();

    }

    private String[] embaralhaPalavras(String[] palavrasEscolhidas) {
        String[] novasPalavras = new String[2];
        for (int iPalavra = 0; iPalavra < palavrasEscolhidas.length; iPalavra++) {
            char[] palavraArray = palavrasEscolhidas[iPalavra].toCharArray();

            for (int i = 0; i < palavraArray.length; i++) {
                int posicaoAleatoria = Global.inteiroAleatorio(0, palavraArray.length);

                char aux = palavraArray[i];
                palavraArray[i] = palavraArray[posicaoAleatoria];
                palavraArray[posicaoAleatoria] = aux;
            }

            novasPalavras[iPalavra] = new String(palavraArray);

        }

        return novasPalavras;
    }

    private void tentativa() {
        while (palavra.acertouQuantas != 2) {
            System.out.println("Qual deseja acertar? [1] primeira, [2] segunda ou [3] dica");
            int qualPalavra = global.scanner.nextInt();

            if(qualPalavra == 3) {
                System.out.println("De qual palavra deseja dica? [1] primeira ou [2] segunda");
                int qualPalavraDica = global.scanner.nextInt();
                palavra.dica(qualPalavraDica, palavra);
            } else {
                while (palavra.palavrasAcertadas[qualPalavra-1] == false) {

                    System.out.println("Digite a resposta: ");
                    global.scanner = new Scanner(System.in);
                    palavra.resposta = global.scanner.nextLine();

                    palavra.palavrasAcertadas[qualPalavra-1] = checaResposta(qualPalavra);
                }
            }

        }
    }

    private Boolean checaResposta(int qualPalavra) {

        if (palavra.resposta.equals(palavra.palavrasEscolhidas[qualPalavra-1])) {

            palavra.acertouQuantas++;

            System.out.println("\nVocê acertou!");
            System.out.println("Você ganhou 1 ponto!\n");
            palavra.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", palavra.pontos);

            return true;
        } else if (palavra.resposta.equals("desisto")) {
            return true;
        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
            return false;
        }
    }
}