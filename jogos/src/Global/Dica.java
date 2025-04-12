package Global;

public class Dica {

    public int dicas = 0;
    String gerar(String escolhida) {
        dicas++;

        char[] escolhidaArray = escolhida.toCharArray();

        String dica = "A primeira letra é " + escolhidaArray[0] + " e a última é " + escolhidaArray[escolhidaArray.length-1] + ".\n";

        return dica;

    }
}
