import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ChemistryInBerland solver = new ChemistryInBerland();
        solver.solve(1, in, out);
        out.close();
    }

    static class ChemistryInBerland {
        ArrayList<Integer>[] tree = new ArrayList[(int) (1e5)];
        long[] mult = new long[(int) (1e5)];
        long[] need = new long[(int) (1e5)];

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
//        N = 100000;
            long[] b = new long[N];
            long[] a = new long[N];
            for (int i = 0; i < N; i++) {
                b[i] = in.nextLong();
//            b[i] = (long)(Math.random() * 1e12);
            }
            for (int i = 0; i < N; i++) {
                a[i] = in.nextLong();
//            a[i] = (long)(Math.random() * 1e12);
                need[i] = b[i] - a[i];
            }
            for (int i = 0; i < N - 1; i++) {
                int x = in.nextInt() - 1;
//            int x = (int)(Math.random() * i);
                long k = in.nextLong();
//            long k = (long)(Math.random() * 1e9);
                mult[i + 1] = k;
                tree[i] = new ArrayList<>();
                tree[x].add(i + 1);
            }
            tree[N - 1] = new ArrayList<>();
            if (dfs(0) >= 0) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

        long dfs(int n) {
            long have = need[n];
            for (int e : tree[n]) {
                long a = dfs(e);
                if (a >= 0) {
                    have += a;
                } else {
                    if (mult[e] > (long) (1e17) / Math.abs(a)) {
                        have = -(long) (1e17);
                    } else {
                        have += a * mult[e];
                    }
                }
                have = Math.min(have, (long) (1e17));
                have = Math.max(-(long) (1e17), have);
            }
            return have;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
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

