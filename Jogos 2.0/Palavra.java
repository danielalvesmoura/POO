public class Palavra {

    Global global = new Global();

    int dificuldade = 4;
    String[] vetorPalavras = {"salve","casa","trilho"};
    String palavraEscolhida;
    String resposta;

    public String sorteiaPalavra(String[] vetorPalavras) {
        String palavraEscolhida = "";
        while(palavraEscolhida.length() != dificuldade) {
            palavraEscolhida = vetorPalavras[global.inteiroAleatorio(0, vetorPalavras.length)];
        }

        return palavraEscolhida;
    }

    public void tentativa() {
        Boolean acertou = false;
        while (!acertou) {

            resposta = global.scanner.nextLine();

            acertou = checaResposta();
        }
    }

    public Boolean checaResposta() {
        if (resposta.equals(palavraEscolhida)) {
            System.out.println("\nVocê acertou!");
            System.out.println("Você ganhou 1 ponto!\n");
            Main.pontuacao.atualizaPontos();
            System.out.printf("Sua pontuação atual é %d ponto(s)\n", Main.pontuacao.pontos);
            return true;
        } else if (resposta.equals("dica")) {
            Main.dica.dica();
            return false;
        } else if (resposta.equals("desisto")) {
            return true;
        } else {
            System.out.println("Seu horrível! Tente novamente:\n");
            return false;
        }
    }

}
