import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zyflair Griffane
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		PandaScanner in = new PandaScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		B solver = new B();
		solver.solve(1, in, out);
		out.close();
	}
}

class B {
    public void solve(int testNumber, PandaScanner in, PrintWriter out) {
        int n = in.nextInt() << 1;
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        long[] ways = new long[100000];
        for (int i = 0; i <= a; i++) {
            ways[i] = 1;
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 1; j <= b; j++) {
                ways[i + j * 2] += ways[i];
            }
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 1; j <= c; j++) {
                ways[i + j * 4] += ways[i];
            }
        }
        out.println(ways[n]);
    }
}

class PandaScanner {
    public BufferedReader br;
    public StringTokenizer st;
    public InputStream in;

    public PandaScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(this.in = in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

    public String next() {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
            return next();
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    }

