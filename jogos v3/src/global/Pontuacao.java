package global;

public class Pontuacao {

    public int pontos = 0;

    public void atualizaPontos(Boolean dica) {

        if (dica) {
            pontos++;
        } else {
            pontos += 2;
        }

    }


}
