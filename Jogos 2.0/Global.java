import java.util.Random;
import java.util.Scanner;

public class Global {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public int inteiroAleatorio(int minimo, int maximo) {
        return random.nextInt(maximo-minimo) + minimo;
    }

}
