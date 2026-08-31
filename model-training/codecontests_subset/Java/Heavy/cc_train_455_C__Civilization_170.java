import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Rubanenko
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {


    int[] a, next, last;

    int k = 0;

    void add(int x, int y) {
        k++;
        next[k] = last[x];
        last[x] = k;
        a[k] = y;
    }

    int[] f, rank, diametr, radius;

    int cnt = 0;
    boolean[] used;
    int[] dist;

    int findset(int v) {
        if (f[v] != v) f[v] = findset(f[v]);
        return f[v];
    }

    void union(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) return;
        if (rank[x] < rank[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        f[y] = x;
        if (rank[x] == rank[y]) rank[x]++;
        diametr[x] = Math.max(radius[x] + radius[y] + 1, Math.max(diametr[x], diametr[y]));
        if (radius[x] == radius[y]) radius[x]++;
        else radius[x] = Math.max(radius[x], radius[y]);
    }

    int dfs(int v, int p) {
        union(v, root);
        used[v] = true;
        if (p == 0) dist[v] = 0;
        int resV = v;
        int  j = last[v];
        while (j > 0) {
            if (a[j] == p) {
                j = next[j];
                continue;
            }
            dist[a[j]] = dist[v] + 1;
            int u = dfs(a[j], v);
            if (dist[u] > dist[resV]) {
                resV = u;
            }
            j = next[j];
        }
        return resV;
    }

    int root;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        a = new int[m * 2 + 2];
        next = new int[m * 2 + 2];
        last = new int[n + 2];
        used = new boolean[n + 2];
        f = new int[n + 2];
        rank = new int[n + 2];
        diametr = new int[n + 2];
        radius = new int[n + 2];
        dist = new int[n + 2];
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.nextInt();
            y = in.nextInt();
            add(x, y);
            add(y, x);
        }
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                cnt++;
                root = i;
                int v = dfs(i, 0);
                int u = dfs(v, 0);
                diametr[findset(i)] = dist[u];
                radius[findset(i)] = (dist[u] + 1) / 2;
            }
        }
        for (int i = 1; i <= q; i++) {
            int type = in.nextInt();
            if (type == 1) out.println(diametr[findset(in.nextInt())]);
            else union(in.nextInt(), in.nextInt());
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String nextLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

