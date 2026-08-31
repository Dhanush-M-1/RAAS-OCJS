import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    void solve() throws IOException {
        int n = ni();
        int m = ni();

        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = ni(), r = ni();
            list.add(new Pair(l, r));
        }
        Collections.sort(list);

        BIT bit = new BIT(m);
        int idx = 0;
        for (int i = 1; i <= m; i++) {
            while (idx < n && list.get(idx).y - list.get(idx).x < i) {
                bit.add(list.get(idx).x, 1);
                bit.add(list.get(idx).y + 1, -1);
                idx++;
            }

            int ans = n - idx;
            for (int j = i; j <= m; j += i) {
                ans += bit.sum(j);
            }
            out.println(ans);
        }
    }

    class BIT {
        int n;
        int[] bit;

        BIT(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += bit[i];
                i -= i & -i;
            }
            return s;
        }

        void add(int i, int x) {
            while (i <= n) {
                bit[i] += x;
                i += i & -i;
            }
        }
    }

    public class Pair implements Comparable<Pair> {
    	int x, y;

    	Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}

    	public int compareTo(Pair p) {
    		return (y - x) - (p.y - p.x);
    	}
    }

    String ns() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " ");
        }
        return tok.nextToken();
    }

    int ni() throws IOException {
        return Integer.parseInt(ns());
    }

    long nl() throws IOException {
        return Long.parseLong(ns());
    }

    double nd() throws IOException {
        return Double.parseDouble(ns());
    }

    String[] nsa(int n) throws IOException {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = ns();
        }
        return res;
    }

    int[] nia(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ni();
        }
        return res;
    }

    long[] nla(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
        Main main = new Main();
        main.solve();
        out.close();
    }
}