// package cf_;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.lang.Math.min;
import static java.util.Arrays.stream;

public class CFA {
    static FastScanner sc;
    static int[] a;

    public static void main(String[] args) {
        sc = new FastScanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = 100;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (k%a == 0) {
                res = min(res, k / a);
            }
        }
        System.out.println(res);
    }

    //********************************************************************************************
    //********************************************************************************************
    //********************************************************************************************

    private static int ceil(double d) {
        int ret = (int) d;
        return ret == d ? ret : ret + 1;
    }

    private static int round(double d) {
        return (int) (d + 0.5);
    }

    private static <T> T elvis(T obj, Supplier<T> defValue) {
        return obj == null ? defValue.get() : obj;
    }

    @SuppressWarnings("SameParameterValue")
    private static <T> T elvis(T obj, T defValue) {
        return obj == null ? defValue : obj;
    }

    private static int gcd(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    private static int[] readIntArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }

    private static long[] readLongArray(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextLong();
        }
        return res;
    }

    @SuppressWarnings("unused")
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}