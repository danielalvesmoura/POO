public class Anagrama {
    Global global = new Global();
    String palavraEmbaralhada;

    public void jogo() {
        Main.palavra.palavraEscolhida = Main.palavra.sorteiaPalavra(Main.palavra.vetorPalavras);

        palavraEmbaralhada = embaralhaPalavra(Main.palavra.getPalavraEscolhida());

        System.out.println(palavraEmbaralhada);

        Main.palavra.tentativa();

    }

    private String embaralhaPalavra(String palavra) {
        char[] palavraArray = palavra.toCharArray();

        for (int i = 0; i < palavraArray.length; i++) {
            int posicaoAleatoria = global.inteiroAleatorio(0, palavraArray.length);

            char aux = palavraArray[i];
            palavraArray[i] = palavraArray[posicaoAleatoria];
            palavraArray[posicaoAleatoria] = aux;
        }


        return new String(palavraArray);
    }

}
