public class Dica {

    Boolean pediuDica = false;

    public void dica() {
        pediuDica = true;

        char[] palavraArray = Main.palavra.palavraEscolhida.toCharArray();

        System.out.printf("Primeira letra: %s\nÚltima letra: %s\n", palavraArray[0],palavraArray[palavraArray.length-1]);
    }

}
