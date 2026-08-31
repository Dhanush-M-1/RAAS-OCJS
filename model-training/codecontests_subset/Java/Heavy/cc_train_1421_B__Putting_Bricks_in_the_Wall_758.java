import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    static FastScanner in = new FastScanner();

    static void solve() {
        int n = in.nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; ++i)
            a[i] = in.next().toCharArray();

        int nr0s = 0, nr0f = 0;
        if (a[0][1] == '0') ++nr0s;
        if (a[1][0] == '0') ++nr0s;
        if (a[n - 1][n - 2] == '0') ++nr0f;
        if (a[n - 2][n - 1] == '0') ++nr0f;
        int nr1s = 2 - nr0s, nr1f = 2 - nr0f;

        char toChange;
        if (Math.min(nr1s + nr0f, nr1f + nr0s) == nr1s + nr0f)
            toChange = '0';
        else
            toChange = '1';

        ArrayList<Pair> ans = new ArrayList<>();
        if (a[0][1] != toChange)
            ans.add(new Pair(1, 2));
        if (a[1][0] != toChange)
            ans.add(new Pair(2, 1));
        if (a[n - 2][n - 1] == toChange)
            ans.add(new Pair(n - 1, n));
        if (a[n - 1][n - 2] == toChange)
            ans.add(new Pair(n, n - 1));

        System.out.println((int)ans.size());
        for (Pair p : ans)
            System.out.println(p.x + " " + p.y);
    }

    public static void main(String[] args) {
        int T = in.nextInt();
        while (T-- > 0)
            solve();
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner()  {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException  e) {
                e.printStackTrace();
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

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
