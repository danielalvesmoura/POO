public class Dica {

    Boolean pediuDica = false;

    public void dica(int qualPalavraDica) {
        pediuDica = true;

        char[] palavraArray = Main.palavra.palavrasEscolhidas[qualPalavraDica-1].toCharArray();

        System.out.printf("Primeira letra: %s\nÚltima letra: %s\n", palavraArray[0],palavraArray[palavraArray.length-1]);
    }

}
