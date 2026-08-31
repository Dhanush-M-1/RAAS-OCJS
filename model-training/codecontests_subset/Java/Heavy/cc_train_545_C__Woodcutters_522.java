
import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 * @author Mojtaba
 */
public class Main {

    public static void main(String[] args) throws IOException {
        MyScanner in = new MyScanner(System.in);
        //PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
        StringBuilder sb = new StringBuilder("");

        int n = in.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        int lastLeft = Integer.MIN_VALUE;
        int answer = n > 1 ? 2 : 1;
        for (int i = 1; i < n - 1; i++) {
            if (lastLeft < (x[i] - h[i]) && (x[i] - h[i]) > x[i - 1]) {
                lastLeft = x[i];
                answer++;
            } else if ((x[i] + h[i]) < x[i + 1]) {
                answer++;
                lastLeft = x[i] + h[i];
            }
        }
        sb.append(answer);

        //writer.println(sb.toString().trim());
        //writer.flush();
        //writer.close();
        System.out.println(sb.toString().trim());
        in.close();
    }
}

class MyScanner {

    BufferedReader reader;
    StringTokenizer tokenizer;

    public MyScanner(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public int[] nextIntegerArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public long[] nextLongArray(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    public int nextInt(int radix) throws IOException {
        return Integer.parseInt(next(), radix);
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public long nextLong(int radix) throws IOException {
        return Long.parseLong(next(), radix);
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    public BigInteger nextBigInteger(int radix) throws IOException {
        return new BigInteger(next(), radix);
    }

    public String next() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
            return this.next();
        }
        return tokenizer.nextToken();
    }

    public void close() throws IOException {
        this.reader.close();
    }
}