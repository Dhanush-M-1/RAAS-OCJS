import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            String[] tmp;
            String t;
            for (int i = 0; i < n; i++) {
                tmp = sc.nextLine().split("");
                for (int j = 0; j < n / 4; j++) {
                    t = Integer.toBinaryString(Integer.parseInt(tmp[j], 16));
                    while (t.length() < 4) {
                        t = '0' + t;
                    }
                    for (int k = 0; k < 4; k++) {
                        grid[i][j * 4 + k] = t.charAt(k) - '0';
                    }
                }
            }
            int[][] dp = new int[n][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + grid[i][j];
                }
            }

            ArrayList<Integer> divisors = new ArrayList<>();
            divisors.add(1);
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    divisors.add(i);
                    if (i != n / i) {
                        divisors.add(n / i);
                    }
                }
            }
            //divisors.add(n);
            Collections.reverse(divisors);
            int ans = 1;
            long prod;
            long start;
            long other;
            int act;
            boolean oui;
            for (int i = 0; i < divisors.size(); i++) {
                oui = true;
                prod = ((long) n / divisors.get(i)) * (n / divisors.get(i));
                start = dp[n / divisors.get(i) - 1][n / divisors.get(i) - 1];
                if (start == 0 || start == prod) {
                    if (start == prod)
                        other = 0;
                    else
                        other = prod;
                    for (int j = 2 * (n / divisors.get(i)) - 1; j < n; j += (n / divisors.get(i))) {
                        act = dp[n / divisors.get(i) - 1][j] - dp[n / divisors.get(i) - 1][j - n / divisors.get(i)];
                        if (act != start && act != other) {
                            oui = false;
                            break;
                        }
                        act = dp[j][n / divisors.get(i) - 1] - dp[j - n / divisors.get(i)][n / divisors.get(i) - 1];
                        if (act != start && act != other) {
                            oui = false;
                            break;
                        }
                    }
                    if (!oui)
                        continue;
                    loop:
                    for (int j = 2 * (n / divisors.get(i)) - 1; j < n; j += (n / divisors.get(i))) {
                        for (int k = 2 * (n / divisors.get(i)) - 1; k < n; k += (n / divisors.get(i))) {
                            act = dp[j][k] - dp[j][k - n / divisors.get(i)] - dp[j - n / divisors.get(i)][k] + dp[j - n / divisors.get(i)][k - n / divisors.get(i)];
                            if (act != start && act != other) {
                                oui = false;
                                break;
                            }
                        }
                    }
                    if (oui) {
                        ans = Math.max(ans, n / divisors.get(i));
                    }
                }
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

        public String nextLine() {
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

