import java.util.Arrays;
import java.util.Scanner;

public class Main {
    void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double a = sc.nextInt();
            double l = sc.nextInt();
            double x = sc.nextInt();
            double h = Math.sqrt(l * l - (a / 2) * (a / 2));
            double abc = h * a / 2;
            double hd = Math.sqrt(((l + x) / 2) * ((l + x) / 2) - (l / 2)
                    * (l / 2));
            double adc = hd * l / 2;
            System.out.printf("%.8f\n", abc + 2 * adc);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}