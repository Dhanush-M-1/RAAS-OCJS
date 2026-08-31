import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static final String NO = "NO";
    private static final String YES = "YES";
    public static BufferedWriter bw;
    public static FR sc;
    private static final int LIMIT = (int) Math.pow(10, 6);

    public static void main(String[] args) throws Exception {
        FR sc = new FR();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = 1;
        while (t > 0) {
            t--;
            int n = sc.i();
            Tree[] trees = new Tree[n];
            for (int i = 0; i < n; i++) {
                trees[i] = new Tree();
                trees[i].x = sc.i();
                trees[i].r = trees[i].x;
                trees[i].h = sc.i();
            }
            int ans = solve(n, trees);
            bw.write(ans + "\n");
        }
        bw.close();
    }

    private static int solve(int n, Tree[] trees) {
        if (n < 3) return n;
        int ans = 2;
        for (int i = 1; i < n - 1; i++) {
            if (trees[i].x - trees[i - 1].r > trees[i].h) {
                ans++;
            } else if (trees[i + 1].x - trees[i].x > trees[i].h) {
                ans++;
                trees[i].r = trees[i].x + trees[i].h;
            }
        }

        return ans;
    }


}

class Tree {
    long x;
    long h;
    long r;
}

class FR {
    BufferedReader br;
    StringTokenizer st;

    public FR() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String s() {
        if (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {

            }
        }
        return st.nextToken();
    }

    public int i() {
        return Integer.parseInt(s());
    }

    public int[] ia(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i();
        }
        return a;
    }

    public long[] la(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = l();
        }
        return a;
    }

    public String[] sa(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = s();
        }
        return a;
    }

    public long l() {
        return Long.parseLong(s());
    }
}