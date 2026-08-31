import java.util.*;
import java.io.*;

public class TaskA {
    private FastScanner in;

    public void solve() throws IOException {
        int n = in.nextInt();
        long maxNumber = -1;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long cur = in.nextInt();
            maxNumber = Math.max(cur, maxNumber);
            sum += cur;
        }
        System.out.print(Math.max(maxNumber, (int) Math.ceil((double) sum / (n - 1))));
    }

    public void run() {
        try {
            in = new FastScanner(new File("input.txt"));
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(File f) {
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
    }

    public static void main(String[] arg) {
        new TaskA().run();
    }
}