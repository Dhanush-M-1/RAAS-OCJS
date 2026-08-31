import java.util.Arrays;
import java.util.InputMismatchException;
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
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] w = new int[n];
        int[] idBook = new int[n];
        Arrays.fill(idBook, -1);
        for (int i = 0; i < n; ++i)
            w[i] = in.nextInt();
        int[] b = new int[m];
        int curID = 0;
        for (int i = 0; i < m; ++i) {
            b[i] = in.nextInt() - 1;
            if (idBook[b[i]] == -1) idBook[b[i]] = curID++;
        }
        int[] curP = new int[curID];
        for (int i = 0; i < curID; ++i)
            for (int j = 0; j < n; ++j)
                if (idBook[j] == i) {
                    curP[i] = j;
                    break;
                }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            int id = -1;
            for (int j = 0; j < curID; ++j)
                if (curP[j] == b[i]) id = j;
            for (int j = 0; j < id; ++j)
                res += w[curP[j]];
            for (int j = id; j > 0; --j) {
                int tmp = curP[j];
                curP[j] = curP[j - 1];
                curP[j - 1] = tmp;
            }
        }
        out.println(res);
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

