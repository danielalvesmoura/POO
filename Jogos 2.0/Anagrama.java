public class Anagrama {

    Global global = new Global();


    public void jogo() {
        String palavraEmbaralhada = embaralhaPalavra(Main.palavra.palavraEscolhida);

        System.out.println(palavraEmbaralhada);

        Main.palavra.resposta = global.scanner.nextLine();

        Main.palavra.checaResposta();

    }

    public String embaralhaPalavra(String palavra) {
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
