import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Objects;

public class E {

    boolean ONLINE_JUDGE = (System.getProperty("ONLINE_JUDGE") != null);

    public E() throws IOException {
        InputReader scan;
        if (ONLINE_JUDGE) {
            scan = new InputReader(System.in);
        } else {
            scan = new InputReader(new FileInputStream("input.txt"));
        }
        PrintWriter out = new PrintWriter(System.out);
        int q = scan.nextInt();
        for (int i1 = 0; i1 < q; i1++) {
            int a = scan.nextInt(), b = scan.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < a; i++) {
                set.add(scan.nextInt());
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < b; i++) {
                int val = scan.nextInt();
                if (set.contains(val))
                    ans = val;
            }
            if (ans==Integer.MAX_VALUE)
                System.out.println("NO");
            else
                System.out.println("YES\n1 " + ans);


        }


        out.close();
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }

        public String next() {
            return nextString();
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

        public Long nextLong() {
            return Long.parseLong(nextString());
        }

        public Double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public char nextCharacter() {
            return nextString().charAt(0);
        }

        public int[] nextIntArray(int N) {
            int A[] = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = nextInt();
            }
            return A;
        }

        public long[] nextLongArray(int N) {
            long A[] = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = nextLong();
            }
            return A;
        }

        public double[] nextDoubleArray(int N) {
            double A[] = new double[N];
            for (int i = 0; i < N; i++) {
                A[i] = nextDouble();
            }
            return A;
        }
    }

    int min(int... a) {
        int min = Integer.MAX_VALUE;
        for (int v : a) {
            min = Math.min(min, v);
        }
        return min;
    }

    long min(long... a) {
        long min = Long.MAX_VALUE;
        for (long v : a) {
            min = Math.min(min, v);
        }
        return min;
    }

    double min(double... a) {
        double min = Double.MAX_VALUE;
        for (double v : a) {
            min = Math.min(min, v);
        }
        return min;
    }

    int max(int... a) {
        int max = Integer.MIN_VALUE;
        for (int v : a) {
            max = Math.max(max, v);
        }
        return max;
    }

    long max(long... a) {
        long max = Long.MIN_VALUE;
        for (long v : a) {
            max = Math.max(max, v);
        }
        return max;
    }

    double max(double... a) {
        double max = Double.MIN_VALUE;
        for (double v : a) {
            max = Math.max(max, v);
        }
        return max;
    }

    public <A, B> Pair MP(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    static class Pair<F, S> {
        public final F f;
        public final S s;

        public Pair(F f, S s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(f, pair.f) &&
                    Objects.equals(s, pair.s);
        }

        @Override
        public int hashCode() {

            return Objects.hash(f, s);
        }

        @Override
        public String toString() {
            return f.toString() + " " + s.toString();
        }
    }


    private void debug(Object... o) {
        if (ONLINE_JUDGE) {
            return;
        }
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String args[]) throws IOException {
        new E();
    }
}