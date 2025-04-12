package Estrutura;

import Global.Basico;
import Global.AlgoritmoResposta;

public class Main {

    static Basico basico = new Basico();

    public static void main(String[] args) {
        
        int continuarJogando = 1;
        while (continuarJogando == 1) {
            System.out.println("O que quer fazer? [1] Anagrama, [2] Caça-Palavras, [3] Parar.");
            int escolha = basico.input.nextInt();

            if (escolha == 1) {
                MainDescoberta mainDescoberta = new MainDescoberta();
                mainDescoberta.jogar();
            } else if (escolha == 2) {
                MainCacaPalavras mainCacaPalavras = new MainCacaPalavras();
                mainCacaPalavras.jogar();
            } else if (escolha == 3) {
                System.out.printf("\nSua pontuação final foi %d pontos.\n\n", AlgoritmoResposta.pontos);
            }

            System.out.println("Quer continuar jogando? [1] Sim ou [2] Não");
            continuarJogando = basico.input.nextInt();
        } 
    }
}
