import java.util.*;

public class Main {

    Scanner sc = new Scanner(System.in);

    long MOD = (long)1e9 + 7;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {

        long n = sc.nextLong();

        long sum = 1;
        for (long i=1; i<=n; i++) {
            sum *= i;
            sum %= MOD;
        }

        long diff = 1;
        for (int i=0; i<n-1; i++) {
            diff *= 2L;
            diff %= MOD;
        }


        System.out.println((sum - diff + MOD) % MOD);

    }


}

