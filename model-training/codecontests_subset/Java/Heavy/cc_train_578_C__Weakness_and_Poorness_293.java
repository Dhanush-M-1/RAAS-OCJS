import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author awh
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] as = new int[n];
            double[] bs = new double[n];
            double mi = Integer.MAX_VALUE;
            double ma = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                as[i] = in.nextInt();
                mi = Math.min(mi, as[i]);
                ma = Math.max(ma, as[i]);
            }
            int iter = 100;
            while (iter-- > 0) {
                double mid = (mi + ma) / 2.0;
                for (int i = 0; i < n; i++) {
                    bs[i] = as[i] - mid;
                }
                double upside = calc(bs);
                for (int i = 0; i < n; i++) {
                    bs[i] = -bs[i];
                }
                double downside = calc(bs);
                if (upside > downside) {
                    mi = mid;
                } else {
                    ma = mid;
                }
            }
            double upside = calc(bs);
            for (int i = 0; i < n; i++) {
                bs[i] = -bs[i];
            }
            double downside = calc(bs);
            out.println(String.format("%.15f", Math.min(upside, downside)));
        }

        private double calc(double[] bs) {
            double max = 0, now = 0;
            for (int i = 0; i < bs.length; i++) {
                now += bs[i];
                if (now > max) max = now;
                if (now < 0) now = 0;
            }
            return max;
        }

    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
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

    }
}
