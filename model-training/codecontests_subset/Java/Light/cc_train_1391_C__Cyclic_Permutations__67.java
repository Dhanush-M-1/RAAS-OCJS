
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static final long MOD = (long) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long fact = 1;
        for (long i = 2; i <= n; i++) {
            fact = ((fact % MOD) * (i % MOD)) % MOD;
        }
        long part2 = 2;
        for (long i = n - 2; i >= 1; i--) {
            part2 = (part2 % MOD + part2 % MOD) % MOD;
        }
        long res = ((fact % MOD) - (part2 % MOD)) % MOD;
        if (res < 0)
            res += MOD;
        System.out.println(res);
    }
}
