/*
Keep solving problems.
*/

import java.util.*;
import java.io.*;

public class CFE {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000L * 1000L * 1000L + 7;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    private static final String yes = "YES";
    private static final String no = "NO";

    int n;
    int m;
    List<TreeSet<Integer>> graph = new ArrayList<>();
    TreeSet<Integer> whole = new TreeSet<>();
    int cnt = 0;
    void solve() throws IOException {
        n = nextInt();
        m = nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new TreeSet<>());
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            whole.add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (whole.contains(i)) {
                dfs(i);
                res.add(cnt);
            }
        }

        Collections.sort(res);
        outln(res.size());
        for (int i = 0; i < res.size(); i++) {
            out(res.get(i) + " ");
        }
    }

    void dfs(int cur) {
        cnt = 0;
        Deque<Integer> deck = new LinkedList<>();
        deck.add(cur);
        whole.remove(cur);
        while (!deck.isEmpty()) {
            int nxt = deck.removeFirst();
            cnt++;
            List<Integer> filter = new ArrayList<>();
            for (int v : whole) {
                if (!graph.get(nxt).contains(v)) {
                    filter.add(v);
                    deck.add(v);
                }
            }

            for (int v : filter) {
                whole.remove(v);
            }
        }
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
    public CFE() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFE();
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

