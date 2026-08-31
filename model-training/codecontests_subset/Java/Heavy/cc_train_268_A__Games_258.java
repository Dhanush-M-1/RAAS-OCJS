import java.io.*;
import java.util.*;

public class A {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int n = in.nextInt();
        int[] h = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
            a[i] = in.nextInt();
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j &&
                    h[i] == a[j]) {
                    r++;
                }
            }
        }
        out.println(r);
    }

    void run() {
        try {
            in = new FastScanner(new File("A.in"));
            out = new PrintWriter(new File("A.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // try {
        //     in = new FastScanner(new File("A2.in"));
        //     out = new PrintWriter(new File("A2.out"));

        //     solve();

        //     out.close();
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }

        // try {
        //     in = new FastScanner(new File("A3.in"));
        //     out = new PrintWriter(new File("A3.out"));

        //     solve();

        //     out.close();
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }
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

        public FastScanner(File inCandies) {
            try {
                br = new BufferedReader(new FileReader(inCandies));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream inCandies) {
            br = new BufferedReader(new InputStreamReader(inCandies));
        }

        String nextLine() {
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        new A().runIO();
    }
}
