import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P572D {
    public static long solve(int n, int k, long[] A) {
        Arrays.sort(A);
        int q = n / k;
        int r = n % k;
        long[] M = {0L};
        // System.err.println(Arrays.toString(M));
        for (int i = 0; i < k; i++) {
            final long[] N = new long[Math.min(M.length + 1, r+1)];
            N[0] = M[0] + A[q*i + q - 1] - A[q*i];
            for (int j = 1; j < M.length; j++) {
                N[j] = Math.min(
                    M[j-1] + A[q*i + q - 1 + j] - A[q*i + j - 1],
                    M[j] + A[q*i + q - 1 + j] - A[q*i + j]);
            }
            if (i < r) {
                N[i+1] = M[i] + A[q*i + q + i] - A[q*i + i];
            }
            M = N;
            // System.err.println(Arrays.toString(M));
        }
        return M[r];
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
        String[] ss = in.readLine().split(" ", 2);
        final int n = Integer.parseInt(ss[0]);
        final int k = Integer.parseInt(ss[1]);
        ss = in.readLine().split(" ", n);
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(ss[i]);
        }
        System.out.println(solve(n, k, A));
    }
}
