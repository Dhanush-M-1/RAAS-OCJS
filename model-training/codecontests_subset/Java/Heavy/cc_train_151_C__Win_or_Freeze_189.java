
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
public class ProblemC {

    private BufferedReader in = null;
    private PrintWriter out = null;
    private StringTokenizer tok = new StringTokenizer("");

    static {
    }
    
    /**
     * Don't forget to change the name of the file.
     * @throws Exception
     */
    public ProblemC() throws Exception {
        init("%keyboard");
        start();
        in.close();
        out.close();
    }

    /**
     * The main part of the program.
     */
    public void start() throws Exception {
        long q = nextLong();
        long a = 0;
        double sqrt = Math.sqrt(q);
        for (long i = 2; i <= sqrt; i++) {
            while (q % i == 0 && i <= sqrt) {
                if (a == 0) {
                    a = i;
                    q = q / i;
                    sqrt = Math.sqrt(q);
                } else {
                    out.println(1);
                    out.println(a * i);
                    return;
                }
            }
        }
        if (a == 0) {
            out.println(1);
            out.println(0);
        } else {
            out.println(2);
        }
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
        new ProblemC();
    }
}
