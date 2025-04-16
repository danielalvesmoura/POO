package global;

import java.util.Scanner;
import java.util.Random;

public class Util {

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public int gerar(int minimo, int maximo) {

        return random.nextInt(maximo - minimo + 1) + minimo;

    }

    public String inputString() {

        return input.nextLine();

    }

    public int inputInt() {

        return input.nextInt();

    }

}
