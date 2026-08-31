import java.io.*;
import java.math.*;
import java.util.*;

public class Solve {
    FastScanner in;
    PrintWriter out;

    void solve() {
        long n = in.nextLong();
        int[] homeCounts = new int[101];
        int[] away = new int[(int)n];
        for (int i = 0; i < n; i++) {
            homeCounts[in.nextInt()]++;
            away[i] = in.nextInt();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            res += homeCounts[away[i]];
        }

        out.println(res);
    }

    void run() {
        try {
            in = new FastScanner(new File("Solve.in"));
            out = new PrintWriter(new File("Solve.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new Solve().runIO();
    }
}
