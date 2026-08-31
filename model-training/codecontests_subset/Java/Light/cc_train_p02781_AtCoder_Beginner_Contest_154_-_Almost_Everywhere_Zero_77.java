import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EAlmostEverywhereZero solver = new EAlmostEverywhereZero();
        solver.solve(1, in, out);
        out.close();
    }

    static class EAlmostEverywhereZero {
        int k;
        char[] arr;
        long[][][] memo;

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            arr = sc.next().toCharArray();
            k = sc.nextInt();
            memo = new long[2][k + 1][arr.length];
            for (long[][] x : memo)
                for (long[] y : x)
                    Arrays.fill(y, -1);
            pw.println(dp(0, k, 0));
        }

        private long dp(int idx, int rem, int s) {
            if (rem < 0)
                return 0;
            if (idx == arr.length)
                return rem == 0 ? 1 : 0;
            if (memo[s][rem][idx] != -1)
                return memo[s][rem][idx];
            boolean small = s == 1;
            int end = small ? 9 : arr[idx] - '0';
            long sum = 0;
            for (int i = 0; i <= end; i++) {
                sum += dp(idx + 1, i != 0 ? rem - 1 : rem, i < arr[idx] - '0' ? 1 : s);
            }
            return memo[s][rem][idx] = sum;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

