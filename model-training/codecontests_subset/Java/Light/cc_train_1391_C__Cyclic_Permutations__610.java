import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Long> layer = new ArrayList<>(), mul = new ArrayList<>();
    private static long MOD = 1000000007L;

    private static void preprocess() {

    }

    private static void solve() {
        int n = sc.nextInt();
        long x = 1L, y = 1L;
        for (long i = 2; i <= n; i++) {
            x = x * i % MOD;
            y = y * 2L % MOD;
        }
        System.out.println((  x - y + MOD ) % MOD);
    }

    public static void main(String[] args) {
        preprocess();
        solve();
    }
}
