import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zakhar Voit (zakharvoit@gmail.com)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        boolean[] type = new boolean[m];
        int[] l = new int[m];
        int[] r = new int[m];
        int[] d = new int[m];

        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            if (x == 2)
                type[i] = true;

            l[i] = in.nextInt() - 1;
            r[i] = in.nextInt() - 1;
            d[i] = in.nextInt();
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int minAns = Integer.MAX_VALUE;
            int curAdd = 0;

            for (int j = 0; j < m; j++) {
                if (!(l[j] <= i && i <= r[j]))
                    continue;

                if (type[j]) {
                    minAns = Math.min(minAns, d[j] - curAdd);
                } else {
                    curAdd += d[j];
                }
            }

            res[i] = minAns == Integer.MAX_VALUE ? -1 : minAns;
        }

        boolean ok = true;
        int[] add = new int[n];
        boolean[] isMax = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = l[i]; j <= r[i]; j++) {
                if (type[i]) {
                    if (res[j] + add[j] > d[i]) {
                        ok = false;
                        break;
                    } else if (res[j] + add[j] == d[i]) {
                        isMax[i] = true;
                    }
                } else {
                    add[j] += d[i];
                    isMax[i] = true;
                }
            }

            if (!ok)
                break;
        }

        for (int i = 0; i < m; i++) {
            ok &= isMax[i];
        }

        if (!ok) {
            out.println("NO");
            return;
        }

        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(res[i]);
            out.print(" ");
        }
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
            tok = new StringTokenizer(next());
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

    public String next() {
        String newLine = tryReadNextLine();
        if (newLine == null)
            throw new InputMismatchException();
        return newLine;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    }

