import java.util.List;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author coderbd
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB1 {
    public int n, x;
    public int[] a, p, sz;
    public boolean[] b = new boolean[1005];
    List<Integer> list;
    public int findParent(int u) {
        if (p[u] == u)
            return u;
        return p[u] = findParent(p[u]);
    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.readInt();
        x = in.readInt();
        a = new int[n+1];
        p = new int[n+1];
        sz = new int[n+1];
        Arrays.fill(sz, 1);
        for (int i = 1; i <= n; i++)
            a[i] = in.readInt();
        for (int i = 1; i <= n; i++)
            p[i] = i;
        for (int i = 1; i <= n; i++)
            if (a[i] != 0) {
                int pi = findParent(a[i]);
                sz[pi] += sz[i];
                sz[i] = 0;
                p[i] = pi;
            }
        int pos = 1;
        int belong = findParent(x);
        while (a[x] != 0) {
            x = a[x];
            pos++;
        }
        list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            int pi = findParent(i);
            if (pi == i && pi != belong) {
                list.add(sz[i]);
            }
        }
        Collections.sort(list);
        b[0] = true;
        out.printLine(pos);
        for (int d : list)
            for (int i = 1004; i >= d; i--)
                b[i] |= b[i-d];
        for (int i = 1; i <= 1004; i++)
            if (b[i])
                out.printLine(i + pos);
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
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            }
            catch (IOException e) {
                throw new InputMismatchException();
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

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

    }

