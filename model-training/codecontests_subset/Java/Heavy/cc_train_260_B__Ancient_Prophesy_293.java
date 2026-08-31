import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int[] prefix_function(String s) {
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; ++i) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j))
                ++j;
            pi[i] = j;
        }
        return pi;
    }

    static final ArrayList<Integer> Index = new ArrayList<Integer>();
    static final HashMap<String, Integer> h = new HashMap<String, Integer>();
    static String Input;
    static int m, max = 0;
    static String soln;
    static int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void solve(int idx) {
        String s = Input.substring(idx, idx + m);
        int year = Integer.parseInt(s.substring(6)), month = Integer.parseInt(s
                .substring(3, 5)), day = Integer.parseInt(s.substring(0, 2));
        if (year > 2015 || year < 2013 || month < 1 || month > 12 || day < 1
                || day > months[month - 1])
            return;
        Integer f = h.get(s);
        if (f != null) {
            if (max < f + 1) {
                max = f + 1;
                soln = s;
            }
            h.replace(s, f + 1);
        } else {
            if (max == 0) {
                max = 1;
                soln = s;
            }
            h.put(s, 1);
        }

    }

    public static void numberOfOcurrence(String T, String P) {
        int matched = 0;
        int[] fail = prefix_function(P);
        m = P.length();
        for (int i = 0, n = T.length(); i < n; i++) {
            while (matched > 0 && T.charAt(i) != P.charAt(matched))
                matched = fail[matched - 1];
            if (T.charAt(i) == P.charAt(matched)) {
                matched++;
                if (matched == m) {
                    solve(i - m + 1);
                    matched = fail[matched - 1];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        Input = in.nextLine();
        numberOfOcurrence(Input.replaceAll("[0-9]", "1"), "11-11-1111");
        out.println(soln);
        out.close();
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int[] readIntArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++)
            ret[i] = nextInt();
        return ret;
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

    public BigInteger nextBigInt() {
        return new BigInteger(next());
    }
}

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }

}