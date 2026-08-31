import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MOD = 1000000007;
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        final int[] a = new int[N+1];
        for (int i = 0; i < M; i++) {
            a[scanner.nextInt()] = -1;
        }
        a[0] = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) continue;
            if (i+1 < a.length && a[i+1] != -1)
                a[i + 1] = (a[i] + a[i + 1]) % MOD;
            if (i+2 < a.length && a[i+2] != -1) {
                a[i + 2] = (a[i] + a[i + 2]) % MOD;
            }
        }
        System.out.println(a[N] % MOD);
    }
}
