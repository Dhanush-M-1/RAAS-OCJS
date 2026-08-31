import java.io.*;
import java.util.StringTokenizer;


public class Solution {

    private static boolean TESTS = true;

    private final Input in;
    private final PrintStream out;

    public Solution(final Input in, final PrintStream out) {
        this.in = in;
        this.out = out;
    }

    public void solve() {
        for (int test = 1, tests = TESTS ? in.nextInt() : 1; test <= tests; test++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final long[] a = in.nextLongs(n);

            long max = Long.MIN_VALUE;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += a[i];
                max = Math.max(max, sum);
                a[i] = max;
            }


            for (int i = 0; i < m; i++) {
                long x = in.nextLong();
                long ans = -1;

                if (max >= x || sum > 0) {
                    long hops = 0;

                    if (max < x) {
                        hops = (x - max + sum - 1) / sum;
                        x -= hops * sum;
                    }

                    ans = hops * n + binarySearch(x, a);
                }

                out.print(ans + " ");
            }

            out.println();
        }
    }

    private static int binarySearch(final long x, final long[] array) {
        int l = 0;
        int r = array.length;
        int i = -1;

        while (l <= r) {
            final int m = (r + l) >>> 1;

            if (array[m] >= x) {
                r = m - 1;
                i = m;
            } else {
                l = m + 1;
            }
        }

        return i;
    }


    public static void main(final String[] args) {
        final Input in = new Input();
        final PrintStream out = new PrintStream(new BufferedOutputStream(System.out));

        try {
            new Solution(in, out).solve();
        } finally {
            out.flush();
        }
    }

    private static final class Input {

        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        public String nextString() {
            try {
                while (!tokenizer.hasMoreTokens()) {
                    final String line = reader.readLine();
                    tokenizer = new StringTokenizer(line, " ");
                }

                return tokenizer.nextToken();
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

        public long nextLong() {
            return Long.parseLong(nextString());
        }

        public double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public int[] nextInts(final int size) {
            final int[] array = new int[size];

            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }

            return array;
        }

        public long[] nextLongs(final int size) {
            final long[] array = new long[size];

            for (int i = 0; i < size; i++) {
                array[i] = nextLong();
            }

            return array;
        }

        public double[] nextDoubles(final int size) {
            final double[] array = new double[size];

            for (int i = 0; i < size; i++) {
                array[i] = nextDouble();
            }

            return array;
        }

    }

}