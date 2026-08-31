import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Codeforces2 implements Runnable {

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new Codeforces2()).run();
    }

    public void run() { /*
                         * try { // br = new BufferedReader(new
                         * FileReader("input.txt")); pw = new
                         * PrintWriter("output.txt"); } catch
                         * (FileNotFoundException e) { e.printStackTrace(); }
                         */
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        solver();
        pw.close();

    }

    private void nline() {
        try {
            if (!stk.hasMoreTokens())
                stk = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("KaVaBUnGO!!!", e);
        }
    }

    private String nstr() {
        while (!stk.hasMoreTokens())
            nline();
        return stk.nextToken();
    }

    private int ni() {
        return Integer.valueOf(nstr());
    }

    private long nl() {
        return Long.valueOf(nstr());
    }

    private double nd() {
        return Double.valueOf(nstr());
    }

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    private void solver() {
        int n = ni();
        int c = ni();
        int max = 0;
        int cur = ni();
        for (int i=1; i<n; i++){
            int q = ni();
            if (cur - q - c > max)max = cur - q - c;
            cur = q;
        }
        System.out.println(max);
    }

    public BigInteger nextRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        BigInteger result = new BigInteger(n.bitLength(), rand);
        while (result.compareTo(n) >= 0) {
            result = new BigInteger(n.bitLength(), rand);
        }
        return result;
    }

    private BigInteger nbi() {
        return new BigInteger(nstr());
    }

    void exit() {
        System.exit(0);
    }

}
