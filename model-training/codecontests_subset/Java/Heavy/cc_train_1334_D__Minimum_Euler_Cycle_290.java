import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.*;
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

    long[] ans = new long[3000000];

    private void solve() {
        var n = in.nextLong();
        var l = in.nextLong();
        var r = in.nextLong();

        if (l == n * (n - 1) + 1) {
            out.println(1);
            return ;
        }

        var start = 1;
        long sum = 0l;
        while (sum + (n - start) * 2 < l) {
            sum += (n - start) * 2;
            start++;
        }

        boolean last1 = false;
        if (r == n * (n - 1) + 1) {
            last1 = true;
            r--;
        }

        var x = start;
        var idx = 0;
        var idxl = 0;
        var idxr = 0;
        for (var i = sum + 1; i <= r; ) {
            for (var y = x + 1; y <= n && i <= r; y++) {
                if (i == l) idxl = idx;
                if (i == r) idxr = idx;
                ans[idx] = x;
                idx++;
                i++;
                if (i == l) idxl = idx;
                if (i == r) idxr = idx;
                ans[idx] = y;
                idx++;
                i++;
            }
            x++;
        }

        if (last1) {
            idxr++;
            ans[idxr] = 1;
        }
        out.println(Arrays.copyOfRange(ans, idxl, idxr + 1));
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
