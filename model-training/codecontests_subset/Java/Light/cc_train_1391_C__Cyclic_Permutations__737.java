import java.util.Scanner;

public final class CodeForces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long MOD = 1000000007;
        long ans = 1;
        for(int i=1; i<=n; i++)
            ans = (ans % MOD * i % MOD) % MOD;
        long sub = calcPower(2, n-1, MOD) % MOD;
        ans = ans - sub;
        if(ans < 0)
            ans += MOD;
        System.out.println(ans);
        in.close();
    }

    private static long calcPower(long x, long y, long MOD) {
        long temp;
        if(y == 0)
            return 1;
        temp = calcPower(x, y/2, MOD) % MOD;
        if(y % 2 == 0)
            return (temp % MOD * temp % MOD) % MOD;
        else
            return ((x % MOD * temp % MOD) % MOD * temp % MOD) % MOD;
    }
}