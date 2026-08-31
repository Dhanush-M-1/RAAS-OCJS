import java.io.*;
import java.util.*;

public class A implements Runnable {
    private MyScanner in;
    private PrintWriter out;

    private void solve() {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        out.println(((a - b) * c + b - 1) / b);
    }

    @Override
    public void run() {
        in = new MyScanner();
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new A().run();
    }

    class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String s = br.readLine();
                    if (s == null) {
                        return false;
                    }
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return st != null && st.hasMoreTokens();
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String s = br.readLine();
                    if (s == null) {
                        return null;
                    }
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            try {
                st = null;
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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
}