import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class Rebus {
    void solve() {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        List<Character> list = new ArrayList<>();
        list.add('+');
        int pos = 1, neg = 0, n = -1;
        while (in.hasNext()) {
            String s = in.next();
            switch (s) {
                case "?":
                case "=":
                    break;
                case "+":
                    list.add(s.charAt(0));
                    pos++;
                    break;
                case "-":
                    list.add(s.charAt(0));
                    neg++;
                    break;
                default:
                    n = Integer.parseInt(s);
                    break;
            }
        }

        int lb = pos - neg * n, ub = pos * n - neg;
        if (n < lb || n > ub) {
            out.println("Impossible");
            return;
        }

        out.println("Possible");

        int m = list.size(), sum = n;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            if (list.get(i) == '+') pos--;
            else neg--;
            for (int j = 1; j <= n; j++) {
                int tar = sum - (list.get(i) == '+' ? j : -j);
                lb = pos - neg * n;
                ub = pos * n - neg;
                if (tar >= lb && tar <= ub) {
                    res[i] = j;
                    sum = tar;
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (i > 0) out.print(" " + list.get(i) + " ");
            out.print(res[i]);
        }
        out.println(" = " + n);
    }

    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new Rebus().solve();
        out.close();
    }

    static FastScanner in;
    static PrintWriter out;

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
