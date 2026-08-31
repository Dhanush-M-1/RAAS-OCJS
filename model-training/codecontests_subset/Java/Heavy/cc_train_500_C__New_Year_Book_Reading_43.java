import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author shu_mj @ http://shu-mj.com
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    Scanner in;
    PrintWriter out;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
        run();
    }

    void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ws = in.nextIntArray(n);
        int[] bs = in.nextIntArray(m);
        for (int i = 0; i < m; i++) bs[i]--;
        long res = 0;
        for (int i = 0; i < m; ) {
            int j = i + 1;
            while (j < m && bs[j] == bs[i]) j++;
            boolean[] vis = new boolean[n];
            while (j < m && bs[j] != bs[i]) {
                if (!vis[bs[j]]) res += ws[bs[i]];
                vis[bs[j]] = true;
                j++;
            }
            while (i + 1 < m && bs[i + 1] == bs[i]) i++;
            i++;
        }
        out.println(res);
    }
}

class Scanner {
    BufferedReader br;
    StringTokenizer st;

    public Scanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
        eat("");
    }

    private void eat(String s) {
        st = new StringTokenizer(s);
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!st.hasMoreTokens()) {
            String s = nextLine();
            if (s == null)
                return false;
            eat(s);
        }
        return true;
    }

    public String next() {
        hasNext();
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) {
        int[] is = new int[n];
        for (int i = 0; i < n; i++) {
            is[i] = nextInt();
        }
        return is;
    }

}

