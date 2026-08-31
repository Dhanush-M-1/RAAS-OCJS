import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long f = 1, x = 1;
        long mod = (long) 1e9+7;
        for(int i = 2; i <= n; i++) {
            f = (f * i) % mod;
            x = (x * 2) % mod;
        }
        System.out.println((f - x + mod) % mod);
    }
}
