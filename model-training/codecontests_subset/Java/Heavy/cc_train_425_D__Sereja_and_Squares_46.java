import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.InputMismatchException;
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
    public static int MAX = 100001;
    public static class Point implements Comparable<Point> {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point o) {
            if (x != o.x) return x - o.x;
            else return y - o.y;
        }
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; ++i) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        Arrays.sort(points);
        int[] ycounts = new int[MAX];
        int[] xcounts = new int[MAX];
        for (int i = 0; i < n; ++i) {
            xcounts[points[i].x]++;
            ycounts[points[i].y]++;
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
            x_lists[points[i].x][xcounts[points[i].x]++] = points[i].y;
            y_lists[points[i].y][ycounts[points[i].y]++] = points[i].x;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int[] col = x_lists[points[i].x];
            int[] row = y_lists[points[i].y];
            int x_pos = Arrays.binarySearch(row, points[i].x);
            int y_pos = Arrays.binarySearch(col, points[i].y);
            if (row.length - x_pos < col.length - y_pos) {
                for (int j = x_pos + 1; j < row.length; ++j) {
                    int delta = row[j] - points[i].x;
                    if (Arrays.binarySearch(col, points[i].y + delta) >= 0 && Arrays.binarySearch(x_lists[row[j]], points[i].y + delta) >= 0) {
                        res++;
                    }
                }
            } else {
                for (int j = y_pos + 1; j < col.length; ++j) {
                    int delta = col[j] - points[i].y;
                    if (Arrays.binarySearch(row, points[i].x + delta) >= 0 && Arrays.binarySearch(y_lists[col[j]], points[i].x + delta) >= 0) {
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

