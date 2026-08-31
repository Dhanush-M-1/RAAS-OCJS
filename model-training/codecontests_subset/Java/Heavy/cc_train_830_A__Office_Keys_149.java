import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Atanas
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int[][] dp;

        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int N = in.nextInt();
            int K = in.nextInt();
            int P = in.nextInt();

            dp = new int[N][K];


            int[] A = new int[N];
            for (int i = 0; i < N; ++i) A[i] = in.nextInt();
            int[] B = new int[K];
            for (int i = 0; i < K; ++i) B[i] = in.nextInt();

            Arrays.sort(A);
            Arrays.sort(B);

            int low = 0;
            int high = 2_000_000_002;
            int best = high;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                for (int[] ini : dp) Arrays.fill(ini, -1);
                int ret = go(0, 0, P, A, B, mid);
                if (ret < 10) {
                    best = Math.min(best, mid);
                    high = mid - 1;
                } else low = mid + 1;
            }

            out.println(best);


        }

        private int go(int idPeople, int idKey, int office, int[] people, int[] keys, int limit) {

            if (idPeople == people.length) {
                return 1;
            }
            if (idKey == keys.length) {
                return 2_000_000_002;
            }
            if (dp[idPeople][idKey] != -1) return dp[idPeople][idKey];

            int best = 2_000_000_003;


            best = Math.min(best, go(idPeople, idKey + 1, office, people, keys, limit));
            int val = Math.abs(people[idPeople] - keys[idKey]) + Math.abs(keys[idKey] - office);
            if (val <= limit) best = Math.min(best, go(idPeople + 1, idKey + 1, office, people, keys, limit));

            return dp[idPeople][idKey] = best;
        }

    }
}

