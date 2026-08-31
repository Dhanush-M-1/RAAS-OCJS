import java.io.*;
import java.util.*;

public class Main {
    public static final boolean DO_LOG = false;

    static class Task {
        Logger log = new Logger();
        PrintWriter out;
        MyScanner in;

        public void solve(MyScanner in, PrintWriter out) {
            int n = in.nextInt();



            int[] d = new int[n + 1];

            for (int i = 0; i < n -1 ; i++) {
                int fr = in.nextInt();
                int to = in.nextInt();

                d[fr]++;
                d[to]++;
            }

            for (int i = 1; i <= n; i++) {
                log.info("d[" + i + "] = " + d[i]);
            }

            for (int i = 1; i <= n; i++) {
                if (d[i] == 2) {
                    out.println("NO");
                    return;
                }
            }

            out.println("YES");

        }
    }

    public static void main(String[] args) {

        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();

        solver.solve(in, out);

        out.close();
    }

    public static class Logger {

        public void info(String s) {
            if (DO_LOG) {
                System.out.println(s);
            }
        }
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}