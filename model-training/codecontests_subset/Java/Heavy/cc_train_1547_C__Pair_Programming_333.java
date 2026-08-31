import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CParnoeProgrammirovanie solver = new CParnoeProgrammirovanie();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class CParnoeProgrammirovanie {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int k = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }
            int[] ans = new int[n + m];
            int ai = 0;
            int bi = 0;
            int p = 0;
            while (ai < n || bi < m) {
                if (ai < n) {
                    if (a[ai] == 0 || a[ai] <= k) {
                        ans[p++] = a[ai];
                        if (a[ai] == 0) {
                            k++;
                        }
                        ai++;
                        continue;
                    }
                }
                if (bi < m) {
                    if (b[bi] == 0 || b[bi] <= k) {
                        ans[p++] = b[bi];
                        if (b[bi] == 0) {
                            k++;
                        }
                        bi++;
                        continue;
                    }
                }
                out.println(-1);
                return;
            }
            for (int i = 0; i < n + m; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
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

