import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.List;
import java.util.stream.Stream;
import java.io.Writer;
import java.security.AccessControlException;
import java.util.BitSet;
import java.io.BufferedReader;
import java.util.regex.Pattern;
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
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        public void solve(int testNumber, LightScanner in, LightWriter out) {
            Debug.autoEnable();
            int n = in.ints();
            List<Integer> divisors = new ArrayList<>(60);
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                }
            }
            BitSet[] adj = new BitSet[n];
            for (int i = 1; i < n; i++) {
                BitSet bit = new BitSet(divisors.size());
                for (int j = 0; j < divisors.size(); j++) {
                    if (i % divisors.get(j) == 0) {
                        bit.set(j);
                    }
                }
                adj[i] = bit;
            }
            BitSet ans = new BitSet(divisors.size());
            ans.set(0, divisors.size());

            //System.out.println(divisors);
            //System.out.println(Arrays.toString(adj));

            String[] con = in.string(n);
            boolean[][] m = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 4; j++) {
                    char code = con[i].charAt(j);
                    int num;
                    if ('0' <= code && code <= '9') {
                        num = code - '0';
                    } else {
                        num = code - 'A' + 10;
                    }
                    for (int k = 0; k < 4; k++) {
                        int c = j * 4 + k;
                        m[i][c] = ((num >> (3 - k)) & 1) == 1;
                    }
                }
            }

            //Stream.of(m).map(Arrays::toString).forEach(System.out::println);

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (m[i][j - 1] != m[i][j]) {
                        ans.and(adj[j]);
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (m[i - 1][j] != m[i][j]) {
                        ans.and(adj[i]);
                    }
                }
            }

            for (int i = divisors.size() - 1; i >= 0; i--) {
                if (ans.get(i)) {
                    out.ans(divisors.get(i)).ln();
                    return;
                }
            }
            throw new RuntimeException();
        }

    }

    static class Debug {
        private static final String DEBUG_PROPERTY = "debug";
        private static final String DEBUG_CALL_PATTERN = "^.+\\.debug\\((.+)\\);.*$";
        private static Pattern debugRegex;
        private static boolean enabled = false;
        private static String src;

        public static void enable(String s) {
            enabled = true;
            src = s;
            if (debugRegex == null) {
                debugRegex = Pattern.compile(DEBUG_CALL_PATTERN);
            }
        }

        public static boolean autoEnable() {
            try {
                String s = System.getProperty(DEBUG_PROPERTY);
                if (s != null) {
                    enable(s);
                    return true;
                }
            } catch (AccessControlException ex) {
                src = null;
            }
            return false;
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
            this(new BufferedWriter(new OutputStreamWriter(out, Charset.defaultCharset())));
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

        public LightWriter ans(Object obj) {
            return ans(Objects.toString(obj));
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

        public String[] string(int length) {
            return IntStream.range(0, length).mapToObj(x -> string()).toArray(String[]::new);
        }

        public int ints() {
            return Integer.parseInt(string());
        }

    }
}

