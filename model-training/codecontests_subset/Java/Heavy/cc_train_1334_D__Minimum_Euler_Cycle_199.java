import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;


public class D {

    private static final FastReader in = new FastReader();
    private static final FastWriter out = new FastWriter();

    public static void main(String[] args) {
        new D().run();
    }

    private void run() {
        var t = in.nextInt();
        while (t-- > 0) {
            solve();
        }

        out.flush();
    }

    int n;
    long[] sum;

    private void solve() {
        n = in.nextInt();
        var l = in.nextLong();
        var r = in.nextLong();

        sum = new long[n];
        for (var i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + (n - i) * 2;
        }

        var ans = new long[(int) (r - l + 1)];
        for (var i = l; i <= r; i++) {
            ans[(int) (i - l)] = euler(i);
        }

        out.println(ans);
    }

    long euler(long i) {
        if (i > sum[n - 1]) return 1;

        var x = Misc.lowerBound(sum, i);
        var s = sum[x - 1];
        var d = i - s;
        return d % 2 == 1 ? x : x + d / 2;
    }

}


class FastReader {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer in;

    public String next() {
        while (in == null || !in.hasMoreTokens()) {
            try {
                in = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                return null;
            }
        }
        return in.nextToken();
    }

    public BigDecimal nextBigDecimal() {
        return new BigDecimal(next());
    }

    public BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    public boolean nextBoolean() {
        return Boolean.valueOf(next());
    }

    public byte nextByte() {
        return Byte.valueOf(next());
    }

    public double nextDouble() {
        return Double.valueOf(next());
    }

    public double[] nextDoubleArray(int length) {
        var a = new double[length];
        for (var i = 0; i < length; i++) {
            a[i] = nextDouble();
        }
        return a;
    }

    public int nextInt() {
        return Integer.valueOf(next());
    }

    public int[] nextIntArray(int length) {
        var a = new int[length];
        for (var i = 0; i < length; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public long nextLong() {
        return Long.valueOf(next());
    }

    public long[] nextLongArray(int length) {
        var a = new long[length];
        for (var i = 0; i < length; i++) {
            a[i] = nextLong();
        }
        return a;
    }

}


class FastWriter extends PrintWriter {

    public FastWriter() {
        super(System.out);
    }

    public void println(double[] a) {
        for (var i = 0; i < a.length; i++) {
            print(a[i]);
            print(i + 1 < a.length ? ' ' : '\n');
        }
    }

    public void println(int[] a) {
        for (var i = 0; i < a.length; i++) {
            print(a[i]);
            print(i + 1 < a.length ? ' ' : '\n');
        }
    }

    public void println(long[] a) {
        for (var i = 0; i < a.length; i++) {
            print(a[i]);
            print(i + 1 < a.length ? ' ' : '\n');
        }
    }

    public void println(Object... a) {
        for (var i = 0; i < a.length; i++) {
            print(a[i]);
            print(i + 1 < a.length ? ' ' : '\n');
        }
    }

    public <T> void println(List<T> l) {
        println(l.toArray());
    }

    public void debug(String name, Object o) {
        String value = Arrays.deepToString(new Object[] { o });
        value = value.substring(1, value.length() - 1);
        System.err.println(name + " => " + value);
    }

}


class Misc {

    public static final double EPS = 1e-12;

    public static final Comparator<Double> EPS_COMPARATOR = (x, y) -> {
        if (x + EPS < y) {
            return -1;
        } else if (x - EPS > y) {
            return 1;
        } else {
            return 0;
        }
    };

    public static int compare(double x, double y) {
        return EPS_COMPARATOR.compare(x, y);
    }

    /**
     * Returns the index of the first element in the range <b>[left, right)</b> which <i>leftShouldAdvance</i> tested to
     * be <i>false</i>.
     */
    public static int binarySearch(int left, int right, Predicate<Integer> leftShouldAdvance) {
        while (left < right) {
            var mid = left + (right - left) / 2;
            if (leftShouldAdvance.test(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * Returns the index of the first element in <i>a</i> which >= <i>x</i>.
     */
    public static int lowerBound(int[] a, int x) {
        return binarySearch(0, a.length, mid -> a[mid] < x);
    }

    public static int lowerBound(long[] a, long x) {
        return binarySearch(0, a.length, mid -> a[mid] < x);
    }

    /**
     * Returns the index of the first element in <i>a</i> which > <i>x</i>.
     */
    public static int upperBound(int[] a, int x) {
        return binarySearch(0, a.length, mid -> a[mid] <= x);
    }

    public static int upperBound(long[] a, long x) {
        return binarySearch(0, a.length, mid -> a[mid] <= x);
    }

    /**
     * Searches for the maximum value of a unimodal function f(x).
     * <p>
     * A function f(x) is a <b>unimodal function</b> if for some value m, it is <b>monotonically increasing</b> for x ≤
     * m and <b>monotonically decreasing</b> for x ≥ m. In that case, the maximum value of f(x) is f(m) and there are no
     * other local maxima.
     */
    public static int ternarySearch(int left, int right, Function<Integer, Integer> f) {
        return binarySearch(left, right, mid -> f.apply(mid) < f.apply(Math.min(mid + 1, right - 1)));
    }

}
