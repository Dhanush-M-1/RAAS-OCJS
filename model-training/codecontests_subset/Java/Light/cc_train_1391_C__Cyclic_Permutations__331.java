import java.util.*;

public class A {

    public static final long MOD = (long) 1e9+7;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long p = power(n-1);
        long f = fact(n);
        System.out.println((f-p+MOD)%MOD);
    }

    public static long fact(int n) {
        long ans = 1;
        for(int i=2;i<=n;i++) {
            ans = ans * i % MOD;
        }
        return ans;
    }

    public static long power(int n) {
        long ans = 1;
        for(int i=0;i<n;i++) {
            ans = ans * 2 % MOD;
        }
        return ans;
    }
}
