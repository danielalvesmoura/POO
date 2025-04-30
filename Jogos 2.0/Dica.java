public class Dica {

    Boolean pediuDica = false;

    public void dica(int qualPalavraDica, Palavra palavra) {
        pediuDica = true;

        char[] palavraArray = palavra.palavrasEscolhidas[qualPalavraDica-1].toCharArray();

        System.out.printf("Primeira letra: %s\nÚltima letra: %s\n", palavraArray[0],palavraArray[palavraArray.length-1]);
    }

}
