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
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB1 {
    int len;
    int[] size;
    int[] a;
    int[] branch;
    int[] allStart;
    boolean[] start;
    boolean[] ans;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int x = in.nextInt() - 1;
        len = 0;
        a = new int[n];
        size = new int[n];
        branch = new int[n];
        allStart = new int[n];
        start = new boolean[n];
        ans = new boolean[n + 1];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt() - 1;

        for (int i = 0; i < n; ++i)
            if (size[i] == 0) {
                start[i] = true;
                goIn(i);
            }
        for (int i = 0; i < n; ++i)
            if (start[i]) whatBranch(i, i);
        for (int i = 0; i < n; ++i)
            if (start[i] && branch[i] != branch[x])
               allStart[len++] = size[i];

        ans[0] = true;
        for (int i = 0; i < len; ++i) {
            for (int j = n - allStart[i]; j >= 0; --j)
                if (ans[j]) ans[j + allStart[i]] = true;
        }

        for (int i = 0; i <= n; ++i)
            if (ans[i]) out.println(i + size[x]);
    }

    private void whatBranch(int v, int b) {
        branch[v] = b;
        if (a[v] != -1) whatBranch(a[v], b);
    }

    private void goIn(int v) {
        if (a[v] == -1)
            size[v] = 1;
        else {
            start[a[v]] = false;
            if (size[a[v]] == 0) goIn(a[v]);
            size[v] = size[a[v]] + 1;
        }
    }


}

class InputReader {
    BufferedReader in;
    StringTokenizer st;

    public InputReader(InputStream stream) {
        in = new BufferedReader(new InputStreamReader(stream));
        eat("");
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String next() {
        while (!st.hasMoreTokens())
            eat(nextLine());
        return st.nextToken();
    }

    public String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public void eat(String str) {
        if (str == null) throw new InputMismatchException();
        st = new StringTokenizer(str);
    }
}

