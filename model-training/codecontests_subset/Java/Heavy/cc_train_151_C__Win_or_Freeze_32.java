import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Toni Rajkovski
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        static Map<Long, Long> winMap = new HashMap<>();

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            long n = in.nextLong();
            long winning = isWinning(n);
            if (winning == -1) out.println(2);
            else {
                out.println(1);
                out.println(winning);
            }
        }

        private long isWinning(long n) {
            boolean hasDiv = false;
            for (long div = 2; div * div <= n; div++)
                if (n % div == 0) {
                    if (!winMap.containsKey(div)) winMap.put(div, isWinning(div));
                    if (winMap.get(div) < 0) return div;

                    long d2 = n / div;
                    if (!winMap.containsKey(d2)) winMap.put(d2, isWinning(d2));
                    if (winMap.get(d2) < 0) return d2;

                    hasDiv = true;
                }
            return !hasDiv ? 0 : -1;
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastReader(InputStream is) {
            br = new BufferedReader(new
                    InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

