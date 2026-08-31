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
 *
 * @author llamaoo7
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            boolean[][] b = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                char[] c = in.next().toCharArray();
                for (int j = 0; j < n / 4; j++) {
                    int cur = c[j] >= 'A' ? c[j] - 'A' + 10 : c[j] - '0';
                    for (int k = j * 4 + 3; k >= j * 4; k--) {
                        b[i][k] = (cur & 1) == 1;
                        cur = cur >> 1;
                    }
                }
            }
            int ret = 1;
            for (int i = 2; i <= n; i++)
                if (n % i == 0) {
                    boolean g = true;
                    for (int j = 0; j < n; j += i) {
                        for (int k = 0; k < n; k += i) {
                            boolean f = b[j][k];
                            for (int l = 0; l < i; l++)
                                for (int m = 0; m < i; m++)
                                    if (b[j + l][k + m] != f) {
                                        g = false;
                                        break;
                                    }
                        }
                        if (!g) break;
                    }
                    if (g) ret = i;
                }
            out.println(ret);
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

