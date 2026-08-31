import java.io.*;
import java.util.*;

public class Solution {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    void solve() throws IOException {
        //in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "ISO-8859-1"));
        //out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "ISO-8859-1"));

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        Locale.setDefault(Locale.ENGLISH);

        int n = nextInt();
        String s = in.readLine();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j + 4 * i < n; j++) {
                if (s.charAt(j) == '*' && s.charAt(j + i) == '*' &&
                        s.charAt(j + 2 * i) == '*' && s.charAt(j + 3 * i) == '*' &&
                        s.charAt(j + 4 * i) == '*') {
                    out.print("yes");
                    out.close();
                    return;
                }
            }
        }

        out.print("no");

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}