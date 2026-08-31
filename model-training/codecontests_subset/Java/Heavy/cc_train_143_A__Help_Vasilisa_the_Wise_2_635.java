
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

/**
 * Change class name, cunstructor name and it's usage in main(String[] args).
 * @author Polyansky Vladilav
 */
public class ProblemA {

    private BufferedReader in = null;
    private PrintWriter out = null;
    private StringTokenizer tok = new StringTokenizer("");

    /**
     * Don't forget to change the name of the file.
     * @throws Exception
     */
    public ProblemA() throws Exception {
        init("%keyboard");
        start();
        in.close();
        out.close();
    }

    /**
     * The main part of the program.
     */
    public void start() throws Exception {
        int r1 = nextInt();
        int r2 = nextInt();
        int c1 = nextInt();
        int c2 = nextInt();
        int d1 = nextInt();
        int d2 = nextInt();
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 1; c < 10; c++) {
                    if (c == a || c == b) {
                        continue;
                    }
                    for (int d = 1; d < 10; d++) {
                        if (d == a || d == b || d == c) {
                            continue;
                        }
                        if (a + b == r1 && c + d == r2 &&
                                a + c == c1 && b + d == c2 &&
                                a + d == d1 && b + c == d2) {
                            out.println(a + " " + b);
                            out.println(c + " " + d);
                            return;
                        }
                    }
                }
            }
        }
        out.println(-1);
    }

    /**
     * Sets the file IO system.
     * @param name Name of the file without .in or .out
     */
    public void init(String name) throws FileNotFoundException {
        if (name.equals("%keyboard")) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            return;
        }
        in = new BufferedReader(new FileReader(name + ".in"));
        out = new PrintWriter(name + ".out");
    }

    public static String format(double num, int col) {
        return new BigDecimal(num).setScale(col, RoundingMode.HALF_UP).toString();
    }

    /**
     * Returns the next integer number of the input file or Integer.MIN_VALUE
     * if there are no more integers.
     * @return
     * @throws IOException
     */
    public int nextInt() throws IOException {
        String res = nextToken();
        int i;
        while (res != null) {
            try {
                i = new Integer(res);
                return i;
            } catch (NumberFormatException e) {
            }
            res = nextToken();
        }
        return Integer.MIN_VALUE;
    }

    public long nextLong() throws IOException {
        String res = nextToken();
        long i;
        while (res != null) {
            try {
                i = new Long(res);
                return i;
            } catch (NumberFormatException e) {
            }
            res = nextToken();
        }
        return Long.MIN_VALUE;
    }

    public String nextToken() throws IOException {
        while (!tok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            tok = new StringTokenizer(s);
        }
        return tok.nextToken();
    }

    public static void swap(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) throws Exception {
        new ProblemA();
    }
}
