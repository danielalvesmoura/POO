package Estrutura;

import Global.*;

public class MainDescoberta {

    PalavraAleatoria palavraAleatoria = new PalavraAleatoria();
    Embaralhador embaralhador = new Embaralhador();
    AlgoritmoResposta algoritmoResposta = new AlgoritmoResposta();
    MensagemContinuar mensagemContinuar = new MensagemContinuar();
    Dica dica = new Dica();

    public int indicePalavraAleatoria;

    public void jogar() {

        Boolean continuar = true;
        while(continuar) {

            indicePalavraAleatoria = palavraAleatoria.gerar();

            String escolhida = palavraAleatoria.palavras[indicePalavraAleatoria];

            String palavraEmbaralhada = embaralhador.embaralhar(escolhida);

            System.out.printf("Acerte o anagrama %s ou digite dica para receber ajuda ou digite desisto para finalizar o jogo.\n", palavraEmbaralhada);

            algoritmoResposta.obterResposta(escolhida);

            System.out.printf("A pontuação é %s ponto(s).\n", AlgoritmoResposta.pontos);

            continuar = mensagemContinuar.exibir();

        }

    }

}
