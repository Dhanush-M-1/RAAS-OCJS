import java.util.Scanner;

/**
 * @author artyom
 */
public class Mafia {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long sum = 0;
            int aMax = 0;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if (a > aMax) {
                    aMax = a;
                }
                sum += a;
            }
            int x = (int) Math.ceil((double) sum / (n - 1));
            System.out.println(Math.max(x, aMax));
        }
    }
}