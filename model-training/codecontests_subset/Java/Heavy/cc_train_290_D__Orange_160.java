import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class d {
    void do_solve() {
        String a = nextToken();
        int b = nextInt();
        a = a.toLowerCase();
        String tmp = "";
        for(int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            if (x < b + 97) {
                tmp = tmp + Character.toUpperCase(x);
            } else {
                tmp = tmp + Character.toLowerCase(x);
            }
        }
        out.println(tmp);
    }

    void mainProgram() {
        init(null);
        int test = 0;
        long T = System.currentTimeMillis();
        do_solve();
        System.err.println("Time on test " + (test++) + ": "
                + (System.currentTimeMillis() - T) + " ms");
        out.close();
    }

    static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    void init(String filename) {
        Locale.setDefault(Locale.US);
        if (filename != null)
            try {
                in = new BufferedReader(new FileReader(filename + ".in"));
                out = new PrintWriter(filename + ".out");
            } catch (Exception e) {
                e.printStackTrace();
                filename = null;
            }
        if (filename == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        st = new StringTokenizer("");
    }

    static BufferedReader in;
    static StringTokenizer st = new StringTokenizer("");
    static PrintWriter out;
    static long systemTime;

    public static void main(String[] args) {
        try {
            setTime();
            new d().mainProgram();
            printTime();
            printMemory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void setTime() {
        systemTime = System.currentTimeMillis();
    }

    static void printTime() {
        System.err.println("Time consumed: "
                + (System.currentTimeMillis() - systemTime));
    }

    static void printMemory() {
        System.err.println("Memory consumed: "
                + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
                        .freeMemory()) / 1000 + "kb");
    }

    boolean hasMoreTokens() {
        try {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st.hasMoreTokens();
    }

    String nextToken() {
        return hasMoreTokens() ? st.nextToken() : null;
    }

    Integer nextInt() {
        return Integer.parseInt(nextToken());
    }

    Double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    Long nextLong() {
        return Long.parseLong(nextToken());
    }

    BigInteger add(BigInteger A, BigInteger B) {
        return A.add(B);
    }

    BigInteger mult(BigInteger A, BigInteger B) {
        return A.multiply(B);
    }

    BigInteger sub(BigInteger A, BigInteger B) {
        return A.subtract(B);
    }

    BigInteger div(BigInteger A, BigInteger B) {
        return A.divide(B);
    }

    BigInteger mi(BigInteger A) {
        return (BigInteger.ZERO).subtract(A);
    }

    BigInteger sq(BigInteger A) {
        return A.multiply(A);
    }

    BigInteger val(long a) {
        return BigInteger.valueOf(a);
    }

    int cmp(BigInteger a, BigInteger b) {
        return a.compareTo(b);
    }

    BigInteger gcd(BigInteger a, BigInteger b) {
        if (cmp(a, val(0)) < 0)
            a = mi(a);
        if (cmp(b, val(0)) < 0)
            b = mi(b);
        return a.gcd(b);
    }
}
