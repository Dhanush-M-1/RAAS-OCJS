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
        CShoppingStreet solver = new CShoppingStreet();
        solver.solve(1, in, out);
        out.close();
    }

    static class CShoppingStreet {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            int[][] f = new int[n][10];
            int[][] p = new int[n][11];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    f[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 11; j++) {
                    p[i][j] = sc.nextInt();
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int mask = 1; mask < (1 << 10); mask++) {
                int[] nb = new int[n];
                for (int i = 0; i < 10; i++) {
                    if ((mask & (1 << i)) > 0) {
                        for (int j = 0; j < n; j++) {
                            if (f[j][i] == 1) {
                                nb[j]++;
                            }
                        }
                    }
                }
                int act = 0;
                for (int i = 0; i < n; i++) {
                    act += p[i][nb[i]];
                }
                ans = Math.max(ans, act);
            }
            out.println(ans);
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

    }
}

