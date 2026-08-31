import java.util.Scanner;

public class CF1391C {
    private static final int MODULO = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = (fact * i) % MODULO;
        }

        long power = 1;
        for (int i = 0; i < n - 1; i++) {
            power = (power * 2) % MODULO;
        }

        long result = fact - power;
        if (result < 0) {
            result += MODULO;
        }
        System.out.println(result);
    }
}
