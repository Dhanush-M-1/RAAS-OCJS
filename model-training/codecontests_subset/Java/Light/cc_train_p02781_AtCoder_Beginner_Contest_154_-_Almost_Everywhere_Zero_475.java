import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mikit
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        LightScanner in = new LightScanner(inputStream);
        LightWriter out = new LightWriter(outputStream);
        EAlmostEverywhereZero solver = new EAlmostEverywhereZero();
        solver.solve(1, in, out);
        out.close();
    }

    static class EAlmostEverywhereZero {
        public void solve(int testNumber, LightScanner in, LightWriter out) {
            char[] s = in.chars();
            int nonZero = in.ints(), n = s.length;

            for (int i = 0; i < n; i++) s[i] -= '0';
            long[][][] dp = new long[2][4][n + 1];
            dp[0][0][0] = 1;
            for (int i = 0; i < n; i++) {
                if (s[i] == 0) {
                    for (int j = 0; j < 2; j++) {
                        for (int k = 0; k < 4; k++) {
                            dp[j][k][i + 1] = dp[j][k][i];
                        }
                    }
                    for (int j = 0; j < 3; j++) {
                        dp[1][j + 1][i + 1] += dp[1][j][i] * 9;
                    }
                    continue;
                }
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 4; k++) {
                        dp[1][k][i + 1] += dp[j][k][i];
                    }
                }
                for (int j = 0; j < 3; j++) {
                    dp[0][j + 1][i + 1] += dp[0][j][i];
                }
                for (int j = 0; j < 3; j++) {
                    dp[1][j + 1][i + 1] += 9 * dp[1][j][i] + (s[i] - 1) * dp[0][j][i];
                }
            }
            long ans = dp[0][nonZero][n] + dp[1][nonZero][n];
            out.ans(ans).ln();
        }

    }

    static class LightScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public LightScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public String string() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public char[] chars() {
            return string().toCharArray();
        }

        public int ints() {
            return Integer.parseInt(string());
        }

    }

    static class LightWriter implements AutoCloseable {
        private final Writer out;
        private boolean autoflush = false;
        private boolean breaked = true;

        public LightWriter(Writer out) {
            this.out = out;
        }

        public LightWriter(OutputStream out) {
            this(new OutputStreamWriter(new BufferedOutputStream(out), Charset.defaultCharset()));
        }

        public LightWriter print(char c) {
            try {
                out.write(c);
                breaked = false;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
            return this;
        }

        public LightWriter print(String s) {
            try {
                out.write(s, 0, s.length());
                breaked = false;
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
            return this;
        }

        public LightWriter ans(String s) {
            if (!breaked) {
                print(' ');
            }
            return print(s);
        }

        public LightWriter ans(long l) {
            return ans(Long.toString(l));
        }

        public LightWriter ln() {
            print(System.lineSeparator());
            breaked = true;
            if (autoflush) {
                try {
                    out.flush();
                } catch (IOException ex) {
                    throw new UncheckedIOException(ex);
                }
            }
            return this;
        }

        public void close() {
            try {
                out.close();
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

    }
}

