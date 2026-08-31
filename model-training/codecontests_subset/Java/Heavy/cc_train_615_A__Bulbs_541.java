import java.io.*;
import java.util.*;

public class A {

    void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                ts.add(in.nextInt());
            }
        }
        if (ts.size() == m){
            out.print("YES");
        } else {
            out.print("NO");
        }
    }

    InputReader in;
    PrintWriter out;

    void runIO() {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream f) {
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