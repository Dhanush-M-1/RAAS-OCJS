import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

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
        int cnt = 1;
        Pair[] ps = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int h = nextInt();
            Pair p = new Pair(x,h);
            ps[i] = p;
        }
        for (int i = 1; i < n; i++) {
            int x = ps[i].x;
            int h = ps[i].h;
            if (i == n-1) {
                cnt++;
                continue;
            }
            if (ps[i-1].x < (x-h)) {
                cnt++;
            } else if(ps[i+1].x > x+h) {
                ps[i].x = x+h;
                cnt++;
            }
        }
        out.print(cnt);
    }

    public static void main(String[] args) {
        new SolveContest();
    }
}

class Pair {
    int x;
    int h;

    public Pair(int x, int h) {
        this.x = x;
        this.h = h;
    }
}