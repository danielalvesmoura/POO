package global;

public class Pontuacao {

    public int pontos = 0;
    public Boolean acertou = true;

    public void atualizaPontos(String escolhida, String resposta, Boolean dica) {

        if (resposta.equals(escolhida)) {

            System.out.println("\nVocê acertou!\n");
            acertou = true;

            if (dica) {
                pontos++;
            } else {
                pontos += 2;
            }

            System.out.printf("%d pontos.\n\n", pontos);

        } else if (resposta.equals("desisto")) {

        } else {
            System.out.println("\nVocê errou.\n");
            acertou = false;
        }

    }


}
