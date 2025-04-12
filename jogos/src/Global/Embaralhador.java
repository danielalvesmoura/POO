package Global;

public class Embaralhador {
    public String embaralhar(String escolhida) {

        char[] escolhidaArray = escolhida.toCharArray();
        NumeroAleatorio numeroAleatorio = new NumeroAleatorio();

        for (int i = 0; i < escolhida.length(); i++) {

            int charSorteado = numeroAleatorio.gerar(0, escolhida.length());

            char charTemporario = escolhidaArray[i];
            escolhidaArray[i] = escolhidaArray[charSorteado];
            escolhidaArray[charSorteado] = charTemporario;

        }

        return new String(escolhidaArray);
    }
}
