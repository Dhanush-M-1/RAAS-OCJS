import javax.swing.text.Segment;
import java.io.*;
import static java.lang.Math.*;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;

public class Main {
    final static boolean debug = false;
    final static String fileName = "";
    final static boolean useFiles = false;

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(System.out);
        new Task(new InputReader(System.in), writer).solve();
        writer.close();
    }
}

class InputReader {
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

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public byte nextByte() {
        return Byte.parseByte(next());
    }
}

class SumInIntervalAddToElementSegmentTree {
    private int[] t;
    private int n;

    SumInIntervalAddToElementSegmentTree(int n) {
        this.n = n;
        t = new int[Integer.highestOneBit(n) << 2];
    }

    SumInIntervalAddToElementSegmentTree(int[] array) {
        this(array.length);
        build(0, 0, n - 1, array);
    }

    private void build(int v, int tl, int tr, int[] array) {
        if (tr == tl) {
            t[v] = array[tl];
        } else {
            int tm = (tl + tr) >> 1;
            build(2 * v + 1, tl, tm, array);
            build(2 * v + 2, tm + 1, tr, array);
            t[v] = t[2 * v + 1] + t[2 * v + 2];
        }
    }

    int get(int l, int r) {
        if (l > n || r > n || 0 > l || 0 > r)
            throw new IllegalArgumentException("indices: (" + l + ", " + r + ") . Bounds: (0, "+ (n - 1));
        return get(0, 0, n - 1, l, r);
    }

    void set(int index, int value) {
        if (0 > index || index > n)
            throw new IllegalArgumentException("index: " + index + ". Bounds: " + (n - 1));
        set(0, 0, n - 1, index, value);
    }

    int search(int value) {
        return search(0, 0, n - 1, value);
    }

    private int search(int v, int tl, int tr, int value) {
        if (tl == tr)
            return tr;

        int tm = (tl + tr) / 2;
        if (value <= t[2 * v + 1])
            return search(2 * v + 1, tl, tm, value);
        return search(2 * v + 2, tm + 1, tr, value - t[2 * v + 1]);
    }

    private int get(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (tl == l && tr == r)
            return t[v];
        int tm = (tl + tr) >> 1;
        return get(2 * v + 1, tl, tm, l, Math.min(tm, r)) +
                get(2 * v + 2, tm + 1, tr, Math.max(tm + 1, l), r);
    }

    private void set(int v, int tl, int tr, int index, int value) {
        if (tr == tl)
            t[v] = value;
        else {
            int tm = (tl + tr) >> 1;
            if (index <= tm)
                set(2 * v + 1, tl, tm, index, value);
            else
                set(2 * v + 2, tm + 1, tr, index, value);
            t[v] = t[2 * v + 1] + t[2 * v + 2];
        }
    }

    public int[] toArray() {
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = get(i, i);
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < n; i++)
            result += get(i, i) + " ";
        return result;
    }
}

class Task {
    public void solve() {
        int n = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int q = in.nextInt();
        SumInIntervalAddToElementSegmentTree prefix = new SumInIntervalAddToElementSegmentTree(n);
        SumInIntervalAddToElementSegmentTree suffix = new SumInIntervalAddToElementSegmentTree(n);
        for (int i = 0; i < q; i++){
            int t = in.nextInt();
            if (t == 1){
                int day = in.nextInt() - 1;
                int value = in.nextInt();

                int current = prefix.get(day, day);
                current = min(b, current + value);
                prefix.set(day, current);

                current = suffix.get(day, day);
                current = min(a, current + value);
                suffix.set(day, current);
            } else{
                int p = in.nextInt() - 1;
                int result = (p == 0 ? 0 : prefix.get(0, p - 1)) + (p + k > n - 1 ? 0 : suffix.get(p + k, n - 1));
                out.println(result);
            }
        }
    }

    private InputReader in;
    private PrintWriter out;

    Task(InputReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }
}