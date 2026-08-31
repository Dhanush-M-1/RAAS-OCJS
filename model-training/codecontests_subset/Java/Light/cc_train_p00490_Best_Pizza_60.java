import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < d.length; i++) {
            d[i] = scanner.nextInt();
        }
        Arrays.sort(d);
        int best = c / a;
        for (int i = 1; i <= d.length; i++) {
            int cal = c;
            int price = a + b * i;
            for (int j = 1; j <= i; j++) {
                cal += d[d.length - j];
            }
            if (cal / price > best) {
                best = cal / price;
            }
        }
        System.out.println(best);
    }
}

