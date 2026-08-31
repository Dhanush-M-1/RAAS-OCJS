import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Comparator;
import java.io.OutputStream;
import java.io.PrintWriter;
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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    int MAX = 100001;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        final int[] xs = new int[n];
        final int[] ys = new int[n];
        for (int i = 0; i < n; ++i) {
            xs[i] = in.readInt();
            ys[i] = in.readInt();
        }
        Integer[] orders = new Integer[n];
        for (int i = 0; i < n; ++i) {
            orders[i] = i;
        }
        Arrays.sort(orders, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (xs[o1] != xs[o2]) {
                    return xs[o1] - xs[o2];
                } else {
                    return ys[o1] - ys[o2];
                }
            }
        });
        {
            int[] xtemp = new int[n];
            int[] ytemp = new int[n];
            for (int i = 0; i < n; ++i) {
                xtemp[i] = xs[orders[i]];
                ytemp[i] = ys[orders[i]];
            }
            System.arraycopy(xtemp, 0, xs, 0, n);
            System.arraycopy(ytemp, 0, ys, 0, n);
        }
        int[] ycounts = new int[MAX];
        int[] xcounts = new int[MAX];
        for (int i = 0; i < n; ++i) {
            xcounts[xs[i]]++;
            ycounts[ys[i]]++;
        }
        int[][] x_lists = new int[MAX][];
        int[][] y_lists = new int[MAX][];
        for (int i = 0; i < MAX; ++i) {
            x_lists[i] = new int[xcounts[i]];
            y_lists[i] = new int[ycounts[i]];
        }
        Arrays.fill(xcounts, 0);
        Arrays.fill(ycounts, 0);
        for (int i = 0; i < n; ++i) {
            x_lists[xs[i]][xcounts[xs[i]]++] = ys[i];
            y_lists[ys[i]][ycounts[ys[i]]++] = xs[i];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int[] col = x_lists[xs[i]];
            int[] row = y_lists[ys[i]];
            int x_pos = Arrays.binarySearch(row, xs[i]);
            int y_pos = Arrays.binarySearch(col, ys[i]);
            if (row.length - x_pos < col.length - y_pos) {
                for (int j = x_pos + 1; j < row.length; ++j) {
                    int delta = row[j] - xs[i];
                    if (Arrays.binarySearch(col, ys[i] + delta) >= 0 && Arrays.binarySearch(x_lists[row[j]], ys[i] + delta) >= 0) {
                        res++;
                    }
                }
            } else {
                for (int j = y_pos + 1; j < col.length; ++j) {
                    int delta = col[j] - ys[i];
                    if (Arrays.binarySearch(row, xs[i] + delta) >= 0 && Arrays.binarySearch(y_lists[col[j]], xs[i] + delta) >= 0) {
                        res++;
                    }
                }
            }
        }
        out.println(res);
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        // InputMismatchException -> UnknownError
        if (numChars == -1)
            throw new UnknownError();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new UnknownError();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        } else if (c == '+') {
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

}

