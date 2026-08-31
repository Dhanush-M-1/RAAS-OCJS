import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.UnsupportedEncodingException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Stepan Klevleev
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int p = in.nextInt();
            ArrayList<Long> people = in.readLongArrayList(n);
            ArrayList<Long> keys = in.readLongArrayList(k);
            people.sort(Comparator.naturalOrder());
            keys.sort(Comparator.naturalOrder());
            long[][] dp = new long[n + 1][k + 1];
            for (long[] row : dp) {
                Arrays.fill(row, Long.MAX_VALUE / 3);
            }
            dp[0][0] = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < k; ++j) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j]);
                    long cost = Math.abs(people.get(i) - keys.get(j)) + Math.abs(keys.get(j) - p);
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], Math.max(dp[i][j], cost));
                }
            }
            long ans = Long.MAX_VALUE;
            for (int j = 0; j <= k; ++j) {
                ans = Math.min(ans, dp[n][j]);
            }
            out.println(ans);
        }

    }

    static @SuppressWarnings("WeakerAccess")
    class OutputWriter extends PrintWriter {
        public OutputWriter(Writer out) {
            super(out);
        }

        public OutputWriter(Writer out, boolean autoFlush) {
            super(out, autoFlush);
        }

        public OutputWriter(OutputStream out) {
            super(out);
        }

        public OutputWriter(OutputStream out, boolean autoFlush) {
            super(out, autoFlush);
        }

        public OutputWriter(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        public OutputWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
            super(fileName, csn);
        }

        public OutputWriter(File file) throws FileNotFoundException {
            super(file);
        }

        public OutputWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
            super(file, csn);
        }

    }

    static @SuppressWarnings("WeakerAccess")
    class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public Long nextLong() {
            return Long.parseLong(next());
        }

        public ArrayList<Long> readLongArrayList(int n) {
            ArrayList<Long> arr = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                arr.add(nextLong());
            }
            return arr;
        }

    }
}

