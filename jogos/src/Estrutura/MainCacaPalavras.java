package Estrutura;

import Global.*;

public class MainCacaPalavras {

    int tamanhoTabuleiro = 8;

    PalavraAleatoria palavraAleatoria = new PalavraAleatoria();
    Tabuleiro tabuleiro = new Tabuleiro();
    AlgoritmoResposta algoritmoResposta = new AlgoritmoResposta();
    MensagemContinuar mensagemContinuar = new MensagemContinuar();
    Dica dica = new Dica();

    public void jogar() {

        Boolean continuar = true;
        while(continuar) {

            int indicePalavraAleatoria = palavraAleatoria.gerar();

            String escolhida = palavraAleatoria.palavras[indicePalavraAleatoria];

            tabuleiro.mostrar(escolhida, tamanhoTabuleiro);

            System.out.println("Digite a palavra escondida ou digite dica ou digite desisto parar.");

            algoritmoResposta.obterResposta(escolhida);

            System.out.printf("A pontuação é %d ponto(s).\n", AlgoritmoResposta.pontos);

            continuar = mensagemContinuar.exibir();

        }
    }

}
