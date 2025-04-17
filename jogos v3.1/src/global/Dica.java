package global;

public class Dica {

    public Boolean dica = false;

    public String dica(String escolhida) {

        char escolhidaArray[] = escolhida.toCharArray();

        dica = true;

        return "Primeira letra: " + escolhidaArray[0] + ", Última letra: " + escolhidaArray[escolhidaArray.length-1];

    }

}
