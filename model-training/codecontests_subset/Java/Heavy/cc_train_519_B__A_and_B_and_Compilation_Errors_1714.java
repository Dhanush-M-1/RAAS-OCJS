import java.io.*;
import java.util.*;

public class SolveContest {
    private BufferedReader in;
    private PrintWriter out;

    public SolveContest() {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"),true);
            solve();
        } catch (Exception e) {
            e.printStackTrace();
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
        } finally {
            try {
                in.close();
            } catch (IOException e) {

            }
            out.close();
        }
    }
    StringTokenizer st;
    String nextToken()
    {
        while (st == null || !st.hasMoreTokens())
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {

            }
        return st.nextToken();
    }
    int nextInt() {
        return Integer.valueOf(nextToken());
    }
    long nextLong() {
        return Long.valueOf(nextToken());
    }

    public void solve() {
        int n = nextInt();
        long all = 0;
        for (int i = 0; i < n; i++) {
            all += nextInt();
        }
        long t = all;
        long tt = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt();
            t -= a;
            tt += a;
        }
        out.println(t);
        t = tt;
        for (int i = 0; i < n - 2; i++) {
            tt -= nextInt();
        }
        out.print(tt);
    }

    public static void main(String[] args) {
        new SolveContest();
    }
}

