import java.io.*;
import java.util.Arrays;
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

                if (i > 0) {
                    a[i] += a[i - 1];
                }
            }

            final SegmentTree tree = new SegmentTree(a);

            for (int i = 0; i < m; i++) {
                long x = in.nextLong();
                long ans = -1;

                if (max >= x || sum > 0) {
                    long hops = 0;

                    if(max < x) {
                        hops = (x - max + sum - 1) / sum;
                        x -= hops * sum;
                    }

                    ans = hops * n + tree.query(x);
                }

                out.print(ans + " ");
            }

            out.println();
        }
    }

    private static class SegmentTree {

        private final long[] array;

        public SegmentTree(final long[] a) {
            final int size = 1<< (32 - Integer.numberOfLeadingZeros(a.length - 1));
            array = new long[size << 1];

            System.arraycopy(a, 0, array, size, a.length);
            Arrays.fill(array, size + a.length, array.length, Long.MIN_VALUE);

            for (int i = size - 1; i > 0; i--) {
                array[i] = Math.max(array[i << 1], array[(i << 1) + 1]);
            }
        }

        public int query(final long x) {
            return query(x, 1, 0, (array.length >>> 1) - 1);
        }

        private int query(final long x, final int segmentIndex, final int segmentLeft, final int segmentRight) {
            if(segmentLeft == segmentRight) {
                return array[segmentIndex] >= x ? segmentLeft : -1;
            }

            final int segmentMid = (segmentRight + segmentLeft) >>> 1;

            final long left = array[segmentIndex << 1];
            final long right = array[(segmentIndex << 1) + 1];

            if(left >= x) {
                return query(x, segmentIndex << 1, segmentLeft, segmentMid);
            } else  if(right >= x) {
                return query(x, (segmentIndex << 1) + 1, segmentMid + 1, segmentRight);
            }

            return -1;
        }

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