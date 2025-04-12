package Global;

public class PalavraAleatoria {

    public String[] palavras = {"sabonete","refri"};

    NumeroAleatorio numeroAleatorio = new NumeroAleatorio();

    public int gerar() {

        return numeroAleatorio.gerar(0, this.palavras.length);
    }
}
