import java.util.*;
import java.io.*;

public class TaskA {
    private FastScanner in;
    private PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        for (int i = 1; i < 10 * n; i++) {
            for (int j = 0; j < n; j++) {
                boolean ok = true;
                for (int k = 0; k < 5; k++) {
                    int index = j + k * i;
                    if (index >= n || s[index] != '*') {
                        ok = false;
                    }
                }
                if (ok) {
                    out.println("yes");
                    return;
                }
            }

        }
        out.println("no");

    }

    public void run() {
        try {
            in = new FastScanner();
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

    }

    public static void main(String[] arg) {
        new TaskA().run();
    }
}