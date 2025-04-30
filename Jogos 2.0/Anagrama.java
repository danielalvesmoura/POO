public class Anagrama {
    Global global = new Global();
    String[] palavrasEmbaralhadas;

    public void jogo() {
        Main.palavra.sorteiaPalavra(Main.palavra.vetorPalavras);

        palavrasEmbaralhadas = embaralhaPalavras(Main.palavra.palavrasEscolhidas);

        System.out.println(palavrasEmbaralhadas[0]);
        System.out.println(palavrasEmbaralhadas[1]);

        Main.palavra.palavraReset();

        Main.palavra.tentativa();

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

}
