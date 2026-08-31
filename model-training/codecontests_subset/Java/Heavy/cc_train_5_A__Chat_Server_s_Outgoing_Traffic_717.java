import java.io.*;
import java.util.*;

public class A {

    private static final long modulo = 1000000007;

    private static void solve() {
        HashSet<String> online = new HashSet<>();
        long traffic = 0;
        try {
            while (true) {
                String s = in.nextLine();
                if (s.startsWith("+")) {
                    online.add(s.substring(1, s.length()));
                } else if (s.startsWith("-")) {
                    online.remove(s.substring(1, s.length()));
                } else {
                    traffic += (s.length() - s.indexOf(":") - 1) * online.size();
                }
            }
        } catch (Exception e) {
            //
        }
        out.print(traffic);

    }


    private static long inverse(long a) {
        long result = 1;
        int n = (int) modulo - 2;
        while (n != 0) {
            if ((n & 1) == 1)
                result = (result * a) % modulo;
            a = (a * a) % modulo;
            n >>= 1;
        }
        return result;
    }

    private static long pow(long a, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            long ans = pow(a, n / 2);
            return ans * ans;
        } else {
            return a * pow(a, n - 1);
        }
    }


    public static void main(String[] args) {
        solve();
        closeStreams();
    }

    private static void closeStreams() {
        in.close();
        out.close();
    }


    private static final FastScanner in = new FastScanner();
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static class FastScanner {

        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}