// @author Sanzhar
import java.io.*;
import java.util.*;

public class Template {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (Exception e) {
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

    public void run() throws Exception {
        //in = new BufferedReader(new FileReader("input.txt"));
        //out = new PrintWriter(new FileWriter("output.txt"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();
        in.close();
    }

    public void solve() throws Exception {
        String[] s = next().split("-");
        int n = s.length;
        int[] mm = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][][] gg = new int[32][13][3000];
        int max = 0;
        String ans = "";
        for (int i = 0; i < n - 2; i++) {
            if (s[i].length() >= 2 && s[i + 1].length() == 2 && s[i + 2].length() >= 4) {
                int d = Integer.parseInt(s[i].substring(s[i].length() - 2));
                int m = Integer.parseInt(s[i + 1]);
                int y = Integer.parseInt(s[i + 2].substring(0, 4));
                System.err.println(d + "-" + m + "-" + y);
                if (m < 1 || m > 12) {
                    continue;
                }
                if (d < 1 || d > mm[m]) {
                    continue;
                }
                if (y < 2013 || y > 2015) {
                    continue;
                }
                gg[d][m][y]++;
                if (gg[d][m][y] > max) {
                    max = gg[d][m][y];
                    ans = s[i].substring(s[i].length() - 2) + "-" + s[i + 1] + "-" + s[i + 2].substring(0, 4);
                }
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Template().run();
    }
}
