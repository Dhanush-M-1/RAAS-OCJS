import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zakhar Voit(zakharvoit@gmail.com)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        x = in.nextInt();

        int[] a = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] != 0) {
                p[a[i] - 1] = i;
            }
        }

        c = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                c.add(dfs(i, 1));
        }

        if (xroot == -1) {
            out.println(0);
            return;
        }

        int xlen = c.get(xroot);
        c.remove(xroot);

        n = c.size();
        final int MAXN = 5000;
        boolean[][] dp = new boolean[n + 1][MAXN + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= MAXN; j++) {
                if (dp[i - 1][j])
                    dp[i][j] = true;
                if (dp[i - 1][j] && c.get(i - 1) + j <= MAXN) {
                    dp[i][j + c.get(i - 1)] = true;
                }
            }
        }

        for (int i = 0; i <= MAXN; i++) {
            if (dp[n][i]) {
                out.println(i + xpos);
            }
        }
    }

    int[] p;
    ArrayList<Integer> c = new ArrayList<Integer>();
    int xroot = -1;
    int xpos = -1;
    int x;

    int dfs(int v, int pos) {
        if (v + 1 == x) {
            xroot = c.size();
            xpos = pos;
        }
        if (p[v] == -1)
            return 1;
        return dfs(p[v], pos + 1) + 1;
    }
}

class Scanner {
    BufferedReader in;
    StringTokenizer tok;

    public Scanner(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
        tok = new StringTokenizer("");
    }

    public String nextToken() {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(nextLine());
        }

        return tok.nextToken();
    }

    private String tryReadNextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public String nextLine() {
        String newLine = tryReadNextLine();
        if (newLine == null)
            throw new InputMismatchException();
        return newLine;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    }

