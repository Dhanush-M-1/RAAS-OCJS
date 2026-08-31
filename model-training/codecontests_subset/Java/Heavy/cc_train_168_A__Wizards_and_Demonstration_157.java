import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter w = new PrintWriter(System.out);
    static Reader sc = new Reader();

    public static void main(String args[]) throws IOException {
        int tc = 1;
        while (tc-- > 0) {
            solve();
        }
        w.close();
    }

    //// SOLUTION BEGIN <--------------------------------------->
    public static void solve() {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int req = (int) Math.ceil((((double) y / 100) * n));
        if (req > x)
            w.println(req - x);
        else
            w.println(0);

    }
    //// SOLUTION END <------------------------------------------->

    // Class for Fast I/O------------------------------
    static class Reader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}