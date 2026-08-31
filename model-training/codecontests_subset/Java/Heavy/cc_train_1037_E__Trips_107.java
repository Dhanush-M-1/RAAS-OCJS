import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.io.*;
import java.util.*;

public class Main {
    public class pair implements Comparable<pair> {
        int i, w;

        pair(int x, int y) {
            i = x;
            w = y;
        }

        public int compareTo(pair p) {
            if (w == p.w) return i - p.i;
            return w - p.w;
        }
    }

    public class edge {
        int v;
        boolean p;

        edge(int y) {
            v = y;
            p = true;
        }
    }

    public void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        ArrayList<ArrayList<edge>> q = new ArrayList<>();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            q.add(new ArrayList<>());
        }
        pair[] z = new pair[m];
        pair[] f = new pair[m];
        for (int i = 0; i < m; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            d[x]++;
            d[y]++;
            q.get(x).add(new edge(y));
            q.get(y).add(new edge(x));
            f[i] = new pair(q.get(x).size() - 1, q.get(y).size() - 1);
            z[i] = new pair(x, y);
        }
        TreeSet<pair> w = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            w.add(new pair(i, d[i]));
        }
        int res = n;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            while (w.size() > 0 && w.first().w < k) {
                int p = w.pollFirst().i;
                for (int j = 0; j < q.get(p).size(); j++) {
                    int v = q.get(p).get(j).v;
                    if (q.get(p).get(j).p) {
                        q.get(p).get(j).p = false;
                        w.remove(new pair(v, d[v]));
                        d[v]--;
                        w.add(new pair(v, d[v]));
                    }
                }
            }
            ans[i] = w.size();
            int h = m - 1 - i;
            int x1 = z[h].i;
            int y1 = z[h].w;
            if (q.get(x1).get(f[h].i).p && q.get(y1).get(f[h].w).p) {
                q.get(x1).get(f[h].i).p = false;
                q.get(y1).get(f[h].w).p = false;
                if (w.contains(new pair(x1, d[x1]))) {
                    w.remove(new pair(x1, d[x1]));
                    d[x1]--;
                    w.add(new pair(x1, d[x1]));
                }
                if (w.contains(new pair(y1, d[y1]))) {
                    w.remove(new pair(y1, d[y1]));
                    d[y1]--;
                    w.add(new pair(y1, d[y1]));
                }

            }
        }
        for (int i = m - 1; i >= 0; i--) {
            out.println(ans[i]);
        }
    }

    BufferedReader br;
    StringTokenizer sc;
    PrintWriter out;

    String nextToken() throws IOException {
        while (sc == null || !sc.hasMoreTokens()) {
            try {
                sc = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                sc = null;
            }
        }
        return sc.nextToken();
    }

    boolean hasNext() throws IOException {
        while (sc == null || !sc.hasMoreTokens()) {
            try {
                sc = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    Integer nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    Long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Main().run();
    }

    public void run() throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
//            br = new BufferedReader(new FileReader("advent.in"));
//            out = new PrintWriter(new File("advent.out"));
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}