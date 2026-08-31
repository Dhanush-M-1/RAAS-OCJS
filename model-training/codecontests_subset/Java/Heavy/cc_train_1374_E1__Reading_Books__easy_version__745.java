import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        E1ReadingBooksEasyVersion solver = new E1ReadingBooksEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class E1ReadingBooksEasyVersion {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            ArrayList<Integer> a[] = new ArrayList[4];
            for (int i = 0; i < 4; i++) {
                a[i] = new ArrayList<>();
                a[i].add(0);
            }
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                a[2 * x + y].add(t);
            }
            for (int i = 0; i < 4; i++) Collections.sort(a[i]);
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < a[i].size(); j++) {
                    a[i].set(j, a[i].get(j) + a[i].get(j - 1));
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= k; i++) {
                if (a[3].size() >= i + 1 && a[1].size() >= k - i + 1 && a[2].size() >= k - i + 1) {
                    ans = Math.min(a[3].get(i) + a[1].get(k - i) + a[2].get(k - i), ans);
                }
            }
            if (a[1].size() >= k + 1 && a[2].size() >= k + 1)
                ans = Math.min(ans, a[1].get(k) + a[2].get(k));
            out.println(ans != Integer.MAX_VALUE ? ans : -1);

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

    }
}

