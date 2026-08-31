import java.io.*;
import java.util.*;

public class D2_SubmarineInTheRybinskSea {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inp = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(inp, out);
        out.close();
    }

    private static class Solver {
        private int length(int i) {
            return ("" + i).length();
        }

        private void solve(InputReader inp, PrintWriter out) {
            int n = inp.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = inp.nextInt();

            long MOD = 998244353;

            // store 10 powers
            long[] pow = new long[11];
            pow[0] = 1;
            for (int i = 1; i < 11; i++) pow[i] = pow[i-1] * 10;

            // store count of each length
            int[] length = new int[11];
            for (int i: a) length[length(i)]++;

            long res = 0;
            for (int val: a) {
                int i = 0;
                while (val > 0) {
                    int digit = val % 10;
                    for (int k = 1; k < 11; k++) {
                        long temp = (digit * pow[i]) % MOD;
                        temp = (temp * length[k]) % MOD;

                        long increase1 = (temp * pow[Math.min(k, i)]) % MOD;
                        long increase2 = (temp * pow[Math.min(k, i + 1)]) % MOD;

                        res = (res + increase1 + increase2) % MOD;
                    }

                    i++;
                    val /= 10;
                }
            }

            out.print(res);

        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}