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
 * @author Washoum
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DMinimumEulerCycle solver = new DMinimumEulerCycle();
        solver.solve(1, in, out);
        out.close();
    }

    static class DMinimumEulerCycle {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int t = sc.nextInt();
            while (t > 0) {
                t--;
                int n = sc.nextInt();
                long l = sc.nextLong();
                long r = sc.nextLong();
                int min = 1;
                long nagazt = 1;
                while (nagazt < l) {
                    nagazt += 2 * (n - min);
                    min++;
                }
                min--;
                nagazt -= 2 * (n - min);
                loop:
                for (; min <= n; min++) {
                    for (int i = min + 1; i <= n; i++) {
                        if (nagazt >= l) {
                            out.print(min + " ");
                        }
                        nagazt++;
                        if (nagazt > r) {
                            break loop;
                        }
                        if (nagazt >= l) {
                            out.print(i + " ");
                        }
                        nagazt++;
                        if (nagazt > r) {
                            break loop;
                        }
                    }
                    if (nagazt > r) {
                        break;
                    }
                }
                if (nagazt == r) {
                    out.println(1);
                } else {
                    out.println();
                }
            }

        }

    }

    static class inputClass {
        BufferedReader br;
        StringTokenizer st;

        public inputClass(InputStream in) {

            br = new BufferedReader(new InputStreamReader(in));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

