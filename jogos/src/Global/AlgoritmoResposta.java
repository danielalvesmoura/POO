package Global;

public class AlgoritmoResposta {
    
    Basico basico = new Basico();
    Dica dica = new Dica();
    public static int pontos = 0;
    public Boolean acertou = false;

    public void obterResposta(String resposta) {

        acertou = false;
        while(acertou.equals(false)) {

            String palpite = basico.input.nextLine();

            if (palpite.equals("desisto")) {

                System.out.println("Pena.");

                break;

            } else if (palpite.equals("dica")) {

                System.out.println(dica.gerar(resposta));

            } else if (palpite.equals(resposta)) {

                acertou = true;
                System.out.println("Acertou!");

            } else {

                System.out.println("Errou! Tente novamente.");

            }

        }

    }

    public void atualizarPontos(int dicas) {

        if (true) {
            if (dicas>0) {
                pontos++;
            } else {
                pontos += 2;
            }
        }

    }
}
