import java.util.Scanner;

public class CF1391C {
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact * i) % MOD;
        }

        long pow = 1;
        for (int i = 1; i < n; i++) {
            pow = (pow * 2) % MOD;
        }

        long result = fact - pow;
        if (result < 0) {
            result += MOD;
        }
        System.out.println(result);
    }
}
