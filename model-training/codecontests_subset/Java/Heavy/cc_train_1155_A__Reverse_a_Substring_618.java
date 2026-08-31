import java.io.*;
import java.util.*;
import java.util.stream.*;

public class AlarmClocksEverywhere {
    private static boolean debug = false;

    private static String str;

    private static void solveProblem(InputStream instr) throws Exception {
        InputReader sc = new InputReader(instr);
        int testCount = 1;
        if (debug) {
            testCount = sc.nextInt();
        }

        for (int t = 1; t <= testCount; t++) {
            printDebug("------ " + t + " ------");
            sc.nextInt();
            str = sc.next();
            Object result = solveTestCase();
            System.out.println(result);
        }
    }

    private static Object solveTestCase() {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return "YES" + "\n" + (i + 1) + " " + (i + 2);
            }
        }
        return "NO";
    }

    static long gcd(long a, long b) {       // O(logn)
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long[] readInts(InputReader sc, int N) throws Exception {
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    private static String joinValues(List<? extends Object> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        List<Object> list = new ArrayList<>();
        for (Object value : arr) {
            list.add(value);
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    private static final class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int Chars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws Exception {
            if (curChar >= Chars) {
                curChar = 0;
                Chars = stream.read(buf);
                if (Chars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public final int nextInt() throws Exception {
            return (int)nextLong();
        }

        public final long nextLong() throws Exception {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1)
                    throw new IOException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return negative ? (-res) : (res);
        }

        public final int[] nextIntBrray(int size) throws Exception {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = nextInt();
            return arr;
        }

        public final String next() throws Exception {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.append((char)c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public final String nextLine() throws Exception {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.append((char)c);
                c = read();
            } while (c != '\n' && c != -1);
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }

}
