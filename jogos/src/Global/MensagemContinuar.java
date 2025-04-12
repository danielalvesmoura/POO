package Global;

public class MensagemContinuar {

    Basico basico = new Basico();

    public Boolean exibir() {

        Boolean continuar = true;

        System.out.println("Quer continuar? [s]Sim ou [n]Não\n");
        String resposta = basico.input.nextLine();
        if (resposta.equals("n")) {
            continuar = false;
        }

        return continuar;
    }

}
