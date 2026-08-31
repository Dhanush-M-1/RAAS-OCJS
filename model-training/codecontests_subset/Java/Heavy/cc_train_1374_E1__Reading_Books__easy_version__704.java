import java.util.*;
import java.io.*;

public class CFA {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    void solve() throws IOException {
        int T = 1;
        for (int i = 0; i < T; i++) {
            helper();
        }
    }

    void helper() throws IOException {
        int n = nextInt();
        int k = nextInt();
        List<Integer> l11 = new ArrayList<>();
        List<Integer> l01 = new ArrayList<>();
        List<Integer> l10 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (a == 1 && b == 1) {
                l11.add(t);
            } else if (a == 1 && b == 0) {
                l10.add(t);
            } else if (a == 0 && b == 1) {
                l01.add(t);
            }
        }
        long res = Long.MAX_VALUE;
        long[] pref11 = pref(l11);
        long[] pref10 = pref(l10);
        long[] pref01 = pref(l01);
        for (int i = 0; i <= l11.size(); i++) {
            long tmp = pref11[i];
            int need = k - i;
            if (need >= 0 && need <= l10.size() && need <= l01.size()) {
                tmp += pref01[need];
                tmp += pref10[need];
                res = Math.min(res, tmp);
            }
        }
        outln(res == Long.MAX_VALUE ? -1 : res);
    }

    long[] pref(List<Integer> ls) {
        int sz = ls.size();
        Collections.sort(ls);
        long[] res = new long[1 + ls.size()];
        for (int i = 1; i <= sz; i++) {
            res[i] = res[i - 1] + ls.get(i - 1);
        }
        return res;
    }

    void shuffle(long[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            long tmp = a[i];
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
    public CFA() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFA();
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