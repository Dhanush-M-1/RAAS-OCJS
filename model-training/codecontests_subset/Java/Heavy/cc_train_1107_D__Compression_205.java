import java.io.*;
import java.util.*;

public class CFD {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    int n;
    char[][] mat;

    List<List<Integer>> all = new ArrayList<>();
    boolean[] vis;
    void solve() throws IOException {
        n = nextInt();
        mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] tmp = nextString().toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                char cur = tmp[j];
                int val = cur > '9' ? cur - 'A' + 10 : cur - '0';
                for (int k = 0; k < 4; k++) {
                    if ((val & (1 << (3 - k))) != 0) {
                        mat[i][j * 4 + k] = '1';
                    }
                    else {
                        mat[i][j * 4 + k] = '0';
                    }
                }
            }
        }

        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                List<Integer> ls = new ArrayList<>();
                for (int j = 1; j * i <= n; j *= 2) {
                    if (!vis[i * j]) {
                        if (n % (i * j) == 0) {
                            ls.add(i * j);
                            vis[i * j] = true;
                        }
                    }
                }

                if (!ls.isEmpty()) {
                    all.add(ls);
                }
            }
        }

        int res = 0;
        for (List<Integer> ls : all) {
            Collections.sort(ls);
            int l = 0;
            int h = ls.size();
            while (l < h) {
                int mid = (l + h) / 2;
                if (check(ls.get(mid))) {
                    l = mid + 1;
                }
                else {
                    h = mid;
                }
            }

            if (l >= 1) {
                res = Math.max(res, ls.get(l - 1));
            }
        }

        outln(res);
    }

    boolean check(int div) {
        int num = n / div;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!valid(i, j, div)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean valid(int col, int rol, int div) {
        char c = mat[div * rol][div * col];
        for (int i = 0; i < div; i++) {
            for (int j = 0; j < div; j++) {
                if (mat[rol * div + i][col * div + j] != c) {
                    return false;
                }
            }
        }

        return true;
    }

    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    long gcd(long a, long b) {
        while(a != 0 && b != 0) {
            long c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    private void formatPrint(double val) {
        outln(String.format("%.9f%n", val));
    }
    public CFD() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFD();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
