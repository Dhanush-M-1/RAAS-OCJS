import java.io.*;
import java.rmi.MarshalledObject;
import java.util.*;

public class Main {
    static final long MOD = 1000000007;

    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        long N;
        N = sc.nextLong();
        long M;
        M = sc.nextLong();
        Set<Long> a = new HashSet<>();
        for(int i = 0 ; i < M ; i++){
            a.add(sc.nextLong());
        }

        final Solver solver = new Solver();
        System.out.println(solver.solve(N, a));
    }
}

class Solver {
    final Map<Long, Long> memo = new HashMap<>();

    public long solve(long N, Set<Long> a) {

        long[] dp = new long[(int) (N + 1)];
        dp[0] = 1;
        for (long now = 0; now < N; now++) {
            for (long next = now + 1; next <= Math.min(now + 2, N); next++) {
                if (!a.contains(next)) {
                    dp[(int) next] += dp[(int) now];
                    dp[(int) next] %= Main.MOD;
                }
            }
        }
        return dp[(int) N];
    }

}

