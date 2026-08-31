import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javafx.util.Pair;

public class Solve5 {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        new Solve5().solve(pw);
        pw.flush();
        pw.close();
    }

    public void solve(PrintWriter pw) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        Pair<Integer, Integer>[] a = new Pair[n + 2];
        a[0] = new Pair(Integer.MIN_VALUE, 0);
        a[n + 1] = new Pair(Integer.MAX_VALUE, 0);
        for (int i = 1; i <= n; i++) {
            a[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        int l = a[0].getKey(), ans = 0;
        for (int r = 1; r <= n; r++) {
            if (a[r].getKey() - a[r].getValue() > l) {
                l = a[r].getKey();
                ++ans;
            } else if (a[r].getKey() + a[r].getValue() < a[r + 1].getKey()) {
                l = a[r].getKey() + a[r].getValue();
                ++ans;
            } else {
                l = a[r].getKey();
            }
        }
        pw.println(ans);
    }

    static class FastReader {

        StringTokenizer st;
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (Exception e) {
            }
        }

        public String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
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

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean hasNext() throws IOException {
            if (st != null && st.hasMoreTokens()) {
                return true;
            }
            String s = br.readLine();
            if (s == null) {
                return false;
            }
            st = new StringTokenizer(s);
            return true;
        }
    }
}
