import java.io.*;
import java.util.*;

public class D {

    void solve() {
        int n = in.nextInt();
        int d = in.nextInt();
        long[] a  = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        long balance = 0;
        long ans = 0;
        long previousSaved = 0;
        long canUseFromSaved = d;
        for (int i = 0; i < n; i++) {
//            if (a[i] < 0 && a[i]*(-1) > d) {
//                out.println(-1);
//                return;
//            }
            if (a[i] != 0) {
                balance += (long) a[i];
                if (balance > d) {
                    out.println(-1);
                    return;
                }
                if (balance > 0) {
                    canUseFromSaved = Math.min(canUseFromSaved, d - balance);
                }
            } else {
                if (balance < 0) {
                    canUseFromSaved = Math.min(previousSaved, canUseFromSaved);
                    if (balance + canUseFromSaved < 0){
                        ans++;
                        previousSaved = d;
                    } else {
                        previousSaved = canUseFromSaved + balance;
                    }
                    canUseFromSaved = d;
                    balance = 0;
                }
            }
        }
        out.println(ans);
    }

    Scanner in;
    PrintWriter out;

    void run() {
        try {
            in = new Scanner(new File("A.in"));
            out = new PrintWriter(new File("A.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new Scanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public Scanner(InputStream f) {
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

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = read()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        private int read() {
            int res = -1;
            try {
                res = br.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }

        char[] nextCharArray(int size) {
            char[] buf = new char[size];
            int b = skip(), p = 0;
            while (p < size && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = read();
            }
            return size == p ? buf : Arrays.copyOf(buf, p);
        }

        char[][] nextCharMap(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = nextCharArray(m);
            }
            return map;
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
        new D().runIO();
    }
}