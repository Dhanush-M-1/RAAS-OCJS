import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Abhas Jain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DNastyaIsBuyingLunch solver = new DNastyaIsBuyingLunch();
        solver.solve(1, in, out);
        out.close();
    }

    static class DNastyaIsBuyingLunch {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.ni();
            int m = in.ni();
            int[] ar = new int[n];
            for (int i = 0; i < n; ++i) ar[i] = in.ni();
            HashSet<Integer>[] hs = new HashSet[n + 1];
            for (int i = 1; i <= n; ++i) hs[i] = new HashSet<>();
            for (int i = 0; i < m; ++i) {
                int a = in.ni();
                int b = in.ni();
                hs[b].add(a);
            }
            Set<Integer> st = new HashSet<>();
            int ans = 0;
            outer:
            for (int i = n - 2; i >= 0; --i) {
                int cur = ar[i];
                for (int g : st) {
                    if (!hs[g].contains(cur)) {
                        st.add(cur);
                        continue outer;
                    }
                }
                if (hs[ar[n - 1]].contains(cur)) ans++;
                else st.add(cur);
            }
            out.print(ans);
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

        public int ni() {
            return Integer.parseInt(next());
        }

    }
}

