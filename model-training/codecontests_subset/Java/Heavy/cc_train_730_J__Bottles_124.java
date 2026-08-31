
/**
 *
 * @author meashish
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class Main {

    InputReader in;
    Printer out;

    long mod = 1000000007;

    boolean dp[][];
    int dp2[][];
    int dp3[][];
    boolean mark[][];
    int a[], b[];
    int INF = 10000000;

    private void start() throws Exception {
        int n = in.nextInt();

        a = new int[n];
        b = new int[n];

        int sum = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();

            sum += a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();

            sum2 += b[i];
        }

        dp = new boolean[n + 1][sum2 + 1];
        dp2 = new int[n + 1][sum2 + 1];
        dp3 = new int[n + 1][sum2 + 1];
        mark = new boolean[n + 1][sum2 + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum2 + 1; j++) {
                dp2[i][j] = INF;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum2 + 1; j++) {
                foo(i, j);
            }
        }

        int mini = -1, minj = -1;
        int a2 = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j <= sum2; j++) {
                if (!dp[i][j]) {
                    continue;
                }

                if (mini == -1) {
                    mini = i;
                    minj = j;

                    a2 = Math.max(a2, dp3[mini][minj]);
                    continue;
                }

                if (dp2[mini][minj] > dp2[i][j]) {
                    mini = i;
                    minj = j;

                    a2 = dp3[mini][minj];
                } else if (dp2[mini][minj] == dp2[i][j]) {
                    a2 = Math.max(a2, dp3[i][j]);
                }
            }
        }

        int a1 = dp2[mini][minj];
        a2 = sum - a2;

        out.println(a1 + " " + a2);
    }

    boolean foo(int n, int sum) {
        if (sum < 0) {
            return false;
        }
        if (sum == 0) {
            dp[n][sum] = true;
            dp2[n][sum] = 0;
            return true;
        }
        if (n == 0 && sum != 0) {
            dp[n][sum] = false;
            dp2[n][sum] = INF;
            return false;
        }

        if (mark[n][sum]) {
            return dp[n][sum];
        }

        boolean b1 = foo(n - 1, sum);
        boolean b2 = foo(n - 1, sum - b[n - 1]);

        dp[n][sum] = b1 || b2;

        if (b1 && n - 1 >= 0 && sum >= 0) {
            if (dp2[n][sum] > dp2[n - 1][sum]) {
                dp2[n][sum] = dp2[n - 1][sum];
                dp3[n][sum] = dp3[n - 1][sum];
            } else if (dp2[n][sum] == dp2[n - 1][sum]) {
                dp3[n][sum] = Math.max(dp3[n][sum], dp3[n - 1][sum]);
            }
        }
        if (b2 && n - 1 >= 0 && sum - b[n - 1] >= 0) {
            if (dp2[n][sum] > dp2[n - 1][sum - b[n - 1]] + 1) {
                dp2[n][sum] = dp2[n - 1][sum - b[n - 1]] + 1;
                dp3[n][sum] = dp3[n - 1][sum - b[n - 1]] + a[n - 1];
            } else if (dp2[n][sum] == dp2[n - 1][sum - b[n - 1]] + 1) {
                dp3[n][sum] = Math.max(dp3[n][sum], dp3[n - 1][sum - b[n - 1]] + a[n - 1]);
            }
        }

        mark[n][sum] = true;

        return dp[n][sum];
    }

    long power(long x, long n) {
        if (n <= 0) {
            return 1;
        }
        long y = power(x, n / 2);

        if ((n & 1) == 1) {
            return (((y * y) % mod) * x) % mod;
        }

        return (y * y) % mod;
    }

    public long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }

    public Integer[] input(int n) {
        Integer a[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        return a;
    }

    public static void main(String[] args) throws Exception {
        InputReader in;
        PrintStream out;

//        in = new InputReader(new FileInputStream(new File("in.txt")));
//        out = new PrintStream("out.txt");
        in = new InputReader(System.in);
        out = System.out;

        Main main = new Main();

        main.in = in;
        main.out = new Printer(out);

        main.start();
        main.out.flush();
    }

    private static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }
    }

    private static class Printer {

        PrintStream out;
        StringBuilder buffer = new StringBuilder();
        boolean autoFlush;

        public Printer(PrintStream out) {
            this.out = out;
        }

        public Printer(PrintStream out, boolean autoFlush) {
            this.out = out;
            this.autoFlush = autoFlush;
        }

        public void println() {
            buffer.append("\n");

            if (autoFlush) {
                flush();
            }
        }

        public void println(int n) {
            println(Integer.toString(n));
        }

        public void println(long n) {
            println(Long.toString(n));
        }

        public void println(double n) {
            println(Double.toString(n));
        }

        public void println(float n) {
            println(Float.toString(n));
        }

        public void println(boolean n) {
            println(Boolean.toString(n));
        }

        public void println(char n) {
            println(Character.toString(n));
        }

        public void println(byte n) {
            println(Byte.toString(n));
        }

        public void println(short n) {
            println(Short.toString(n));
        }

        public void println(Object o) {
            println(o.toString());
        }

        public void println(Object[] o) {
            println(Arrays.deepToString(o));
        }

        public void println(String s) {
            buffer.append(s).append("\n");

            if (autoFlush) {
                flush();
            }
        }

        public void print(char s) {
            buffer.append(s);

            if (autoFlush) {
                flush();
            }
        }

        public void print(String s) {
            buffer.append(s);

            if (autoFlush) {
                flush();
            }
        }

        public void flush() {
            try {
                BufferedWriter log = new BufferedWriter(new OutputStreamWriter(out));
                log.write(buffer.toString());

                log.flush();
                buffer = new StringBuilder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class Pair<T, U> implements Serializable {

        int index;
        int a, b;

        private T key;

        public T getKey() {
            return key;
        }

        private U value;

        public U getValue() {
            return value;
        }

        public Pair(T key, U value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }

            final Pair other = (Pair) obj;
            if (!this.key.equals(other.key)) {
                return false;
            }

            return this.value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return key.hashCode() + 13 * value.hashCode();
        }
    }

}
