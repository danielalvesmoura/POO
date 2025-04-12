package Global;

import java.util.Random;

public class NumeroAleatorio {

    public Random random = new Random();

    public int gerar(int minimo, int maximo) {

        return random.nextInt(maximo - minimo + 1) + minimo;

    }

}
