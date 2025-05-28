import java.util.Random;
import java.util.Scanner;

public class Global {

    static Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static int inteiroAleatorio(int minimo, int maximo) {
        return random.nextInt(maximo-minimo) + minimo;
    }

}
