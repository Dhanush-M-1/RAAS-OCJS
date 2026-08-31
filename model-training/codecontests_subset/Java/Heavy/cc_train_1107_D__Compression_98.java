import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Codeforces {

    private static byte[] scannerByteBuffer = new byte[1024]; // Buffer of Bytes
    private static int scannerIndex;
    private static InputStream scannerIn;
    private static int scannerTotal;
    private static BufferedWriter printerBW;
    private static boolean DEBUG = false;

    private static int next() throws IOException { // Scan method used to scan buf
        if (scannerTotal < 0)
            throw new InputMismatchException();
        if (scannerIndex >= scannerTotal) {
            scannerIndex = 0;
            scannerTotal = scannerIn.read(scannerByteBuffer);
            if (scannerTotal <= 0)
                return -1;
        }
        return scannerByteBuffer[scannerIndex++];
    }

    static int ni() throws IOException {
        int integer = 0;
        int n = next();
        while (isWhiteSpace(n)) // Removing startPointing whitespaces
            n = next();
        int neg = 1;
        if (n == '-') { // If Negative Sign encounters
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    static long nl() throws IOException {
        long integer = 0;
        int n = next();
        while (isWhiteSpace(n)) // Removing startPointing whitespaces
            n = next();
        int neg = 1;
        if (n == '-') { // If Negative Sign encounters
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    static String line() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        while (!isNewLine(n)) {
            sb.append((char) n);
            n = next();
        }
        return sb.toString();
    }

    private static boolean isNewLine(int n) {
        return n == '\n' || n == '\r' || n == -1;
    }

    private static boolean isWhiteSpace(int n) {
        return n == ' ' || isNewLine(n) || n == '\t';
    }

    static int[] nia(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = ni();
        return array;
    }

    static int[][] n2dia(int r, int c) throws Exception {
        if (r < 0 || c < 0)
            throw new Exception("Array size should be non negative");
        int[][] array = new int[r][c];
        for (int i = 0; i < r; i++)
            array[i] = nia(c);
        return array;
    }

    static long[] nla(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static float[] nfa(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        float[] array = new float[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static double[] nda(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static <T> void print(T str) {
        try {
            printerBW.append(str.toString());
            if (DEBUG)
                flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    static void println() {
        print("\n");
    }

    static <T> void println(T str) {
        print(str + "\n");
    }

    static void flush() throws IOException {
        printerBW.flush();
    }

    static void close() {
        try {
            flush();
            printerBW.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        long startPointTime = System.currentTimeMillis();
        scannerIn = System.in;
        printerBW = new BufferedWriter(new OutputStreamWriter(System.out));
        if (args.length > 0 && args[0].equalsIgnoreCase("debug")
                || args.length > 1 && args[1].equalsIgnoreCase("debug"))
            DEBUG = true;

        main2();
        long endTime = System.currentTimeMillis();
        float totalProgramTime = endTime - startPointTime;
        if (args.length > 0 && args[0].equalsIgnoreCase("time") || args.length > 1 && args[1].equalsIgnoreCase("time"))
            print("Execution time is " + totalProgramTime + " (" + (totalProgramTime / 1000) + "s)");
        close();
        scannerIn.close();
    }

    static class Pair {
        long first;
        long second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object p2) {
            if (p2 instanceof Pair) {
                return ((Pair) p2).first == first && ((Pair) p2).second == second;
            }
            return false;
        }

        public String toString() {
            return "(first=" + first + ",second=" + second + ")";
        }
    }

    static class DisjointSet {
        int[] arr;
        int[] size;

        DisjointSet(int n) {
            arr = new int[n + 1];
            size = new int[n + 1];
            makeSet();
        }

        void makeSet() {
            for (int i = 1; i < arr.length; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        void union(int i, int j) {
            if (i == j)
                return;
            if (i > j) {
                i ^= j;
                j ^= i;
                i ^= j;
            }

            i = find(i);
            j = find(j);

            if (i == j)
                return;
            arr[j] = arr[i];
            size[i] += size[j];
            size[j] = size[i];
        }

        int find(int i) {
            if (arr[i] != i) {
                arr[i] = find(arr[i]);
                size[i] = size[arr[i]];
            }
            return arr[i];
        }

        int getSize(int i) {
            i = find(i);
            return size[i];
        }

        public String toString() {
            return Arrays.toString(arr);
        }
    }

    static long MOD = 1_000_000_007L;

    static void main2() throws Exception {
        int n = ni();
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] in = convert(line());
            for (int j = 0; j < n; j++) {
                t[i] = in;
            }
        }
        long x = n;
        int size = 1;
        a1: for (int i = 0; i < n; i++) {
            size = 1;
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    continue;
                if (x == 1)
                    break a1;
                if (t[i][j] == t[i][j - 1]) {
                    size++;
                } else {
                    x = gcd(x, size);
                    size = 1;
                }
            }
            x = gcd(x, size);
        }
        a2: for (int j = 0; j < n; j++) {
            size = 1;
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    continue;
                if (x == 1)
                    break a2;
                if (t[i][j] == t[i - 1][j]) {
                    size++;
                } else {
                    x = gcd(x, size);
                    size = 1;
                }
            }
            x = gcd(x, size);
        }
        println(x);
    }

    static int[] convert(String input) {
        int[] ans = new int[4 * input.length()];
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            int comp = getInt(input.charAt(i));
            ans[k] = comp & 0b1000; ans[k] >>= 3;
            ans[k + 1] = comp & 0b0100; ans[k+1] >>= 2;
            ans[k + 2] = comp & 0b0010; ans[k+2] >>= 1;
            ans[k + 3] = comp & 0b0001;
            k += 4;
        }
        return ans;
    }

    static int getInt(char c) {
        if (c >= '0' && c <= '9')
            return Integer.parseInt("" + c);
        return 15 - 'F' + c;
    }

    static boolean isSqrt(double a) {
        double sr = Math.sqrt(a);
        return ((sr - Math.floor(sr)) == 0);
    }

    static long abs(long a) {
        return Math.abs(a);
    }

    static int min(int... arr) {
        int min = Integer.MAX_VALUE;
        for (int var : arr)
            min = Math.min(min, var);
        return min;
    }

    static int max(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int var : arr)
            max = Math.max(max, var);
        return max;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}