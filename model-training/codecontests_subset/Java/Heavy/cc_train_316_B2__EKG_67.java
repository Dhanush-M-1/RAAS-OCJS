import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		TokenizerReader in = new TokenizerReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class DSU {
    int[] p;
    int[] s;
    void reset(int n) {
        p = new int[n];
        s = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            s[i] = 1;
        }
    }
    int getParent(int u) {
        if (u != p[u])
            p[u] = getParent(p[u]);
        return p[u];
    }
    void unite(int u, int v) {
        u = getParent(u);
        v = getParent(v);
        if (u == v)
            return;
        if (s[u] > s[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        p[u] = v;
        s[v] += s[u];
    }
}

class TaskB1 {
    public void solve(@SuppressWarnings("UnusedParameters") int testNumber, TokenizerReader in, PrintWriter out) {
        int n = in.nextInt(), x = in.nextInt() - 1;
        DSU dsu = new DSU();
        dsu.reset(n);
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt() - 1;
            if (a[i] >= 0)
                dsu.unite(i, a[i]);
        }
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        int y = dsu.getParent(x);
        for (int i = 0; i < n; ++i) if (dsu.getParent(i) == i && dsu.getParent(i) != y)
            sizes.add(dsu.s[i]);
        boolean[] ok = new boolean[n];
        ok[0] = true;
        for (int sz: sizes) {
            boolean[] newOk = ok.clone();
            for (int i = sz; i < n; ++i)
                if (ok[i-sz])
                    newOk[i] = true;
            ok = newOk;
        }
        int add = 0;
        while (x >= 0) {
            ++add;
            x = a[x];
        }
        for (int i = 0; i < n; ++i)
            if (ok[i])
                out.println(i + add);
    }
}

class TokenizerReader extends StreamTokenizer {
    public TokenizerReader(InputStream in) {
        super(new BufferedReader(new InputStreamReader(in)));
        defaultConfig();
    }

    public String nextString() {
        try {
            nextToken();
        } catch (IOException e) {
            throw new RuntimeException("nextString: exception in line " + lineno(), e);
        }
        return sval;
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public void defaultConfig() {
        resetSyntax();
        wordChars(33, 126);
        whitespaceChars(0, ' ');
    }

    }

