import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Comparator;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nguyen Trung Hieu - vuondenthanhcong11@yahoo.com
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int maxx = in.readInt();
        int maxy = in.readInt();
        int w = in.readInt();
        Map<Rational, List<Integer>> map = new HashMap<Rational, List<Integer>>();
        for (int i = 1; i <= maxy; i++) {
            Rational ratio = new Rational(i, reverse(i));
            List<Integer> current = map.get(ratio);
            if (current == null)
                map.put(ratio, current = new ArrayList<Integer>());
            current.add(i);
        }
        long bestResult = Long.MAX_VALUE;
        int bestX = -1;
        int bestY = -1;
        IntervalTree tree = new IntervalTree(maxy + 1);
        for (int x = 1; x <= maxx; x++) {
            List<Integer> ys = map.get(new Rational(reverse(x), x));
            if (ys != null) {
                for (int y : ys)
                    tree.putValue(y, 1);
            }
            if (tree.value[0] < w)
                continue;
            long y = tree.lowerBound(w);
            if (x * y < bestResult) {
                bestResult = x * y;
                bestX = x;
                bestY = (int) y;
            }
        }
        if (bestResult == Long.MAX_VALUE) {
            out.printLine(-1);
            return;
        }
        out.printLine(bestX + " " + bestY);
    }

    private int reverse(int v) {
        int result = 0;
        while (v != 0) {
            result *= 10;
            result += v % 10;
            v /= 10;
        }
        return result;
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    }

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}

class Rational implements Comparable<Rational> {

    public final long numerator;
    public final long denominator;

    public Rational(long numerator, long denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException();
        long gcd = IntegerUtils.gcd(Math.abs(numerator), Math.abs(denominator));
        if (denominator > 0) {
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        } else {
            this.numerator = -numerator / gcd;
            this.denominator = -denominator / gcd;
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public int compareTo(Rational other) {
        return IntegerUtils.longCompare(numerator * other.denominator, denominator * other.numerator);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rational rational = (Rational) o;

        if (denominator != rational.denominator) return false;
        if (numerator != rational.numerator) return false;

        return true;
    }

    public int hashCode() {
        int result = (int) (numerator ^ (numerator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }
}

class IntervalTree {
    protected int size;
    public int[] value;

    private int[] left;
    private int[] right;

    protected IntervalTree(int[] array) {
        this.size = array.length;
        int nodeCount = Math.max(1, Integer.highestOneBit(size) << 2);
        value = new int[nodeCount];
        init(array);
    }

    public void init(int[] array) {
        init(0, 0, size - 1, array);
    }

    private void init(int root, int left, int right, int[] array) {
        if (left == right)
            value[root] = array[left];
        else {
            int middle = (left + right) >> 1;
            init(2 * root + 1, left, middle, array);
            init(2 * root + 2, middle + 1, right, array);
            value[root] = Math.max(value[2 * root + 1], value[2 * root + 2]);
        }
    }



    public IntervalTree(int size) {
        left = new int[4 * size];
        right = new int[4 * size];
        value = new int[4 * size];
        init(0, size, 0);
    }

    private void init(int left, int right, int root) {
        this.left[root] = left;
        this.right[root] = right;
        if (right - left > 1) {
            init(left, (left + right) / 2, 2 * root + 1);
            init((left + right) / 2, right, 2 * root + 2);
        }
    }
    public int lowerBound(int value) {
        return lowerBound(value, 0);
    }

    private int lowerBound(int value, int root) {
        if (right[root] - left[root] == 1)
            return left[root];
        if (this.value[2 * root + 1] >= value)
            return lowerBound(value, 2 * root + 1);
        return lowerBound(value - this.value[2 * root + 1], 2 * root + 2);
    }

    public void putValue(int position, int value) {
        putValue(position, value, 0);
    }

    private void putValue(int position, int value, int root) {
        if (left[root] > position || right[root] <= position)
            return;
        this.value[root] += value;
        if (right[root] - left[root] > 1) {
            putValue(position, value, 2 * root + 1);
            putValue(position, value, 2 * root + 2);
        }
    }
}

class IntegerUtils {

    public static int longCompare(long a, long b) {
        if (a < b)
            return -1;
        if (a > b)
            return 1;
        return 0;
    }

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
