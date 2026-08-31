import java.util.*;
import java.io.*;

public class A195 {
    FastScanner in;
    PrintWriter out;

    public boolean check(int a , int b , int c , int t) {
        t *= b;
        for (int i = 0 ; i < c ; i++) {
            t += b;
            t -= a;
            if (t < 0) return false;
        }
        return true;
    }
    public void solve() throws IOException {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        for (int t = 0 ; ; t++) {
            if (check(a , b , c , t)) {
                out.println(t);
                break;
            }
        }
    }

    public void run() {
        try {
            in = new FastScanner(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStreamReader f) {
            try {
                br = new BufferedReader(f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] arg) {
        new A195().run();
    }
}