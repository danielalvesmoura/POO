package Global;

public class Pontuacao {

    public int pontos = 0;
    AlgoritmoResposta algoritmoResposta = new AlgoritmoResposta();

    public int atualizarPontos(int dicas) {

        if (algoritmoResposta.acertou) {
            if (dicas>0) {
                pontos++;
            } else {
                pontos += 2;
            }
        }

        return pontos;
    }

}
