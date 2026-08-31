
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            long v = 1;
            long mod = 1_000_000_007;
            long w1 = 1;
            for (int i = 1; i <= n; i++) {
                v = v * i % mod;
                if (i <= n - 1) w1 = w1 * 2 % mod;
            }
            long ret = (v - w1 + mod + mod) % mod;
            System.out.println(ret);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
