import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author George Marcus
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
    int N;
    ArrayList<Integer>[] A;
    boolean[] v;
    ArrayList<Integer> cycle;
    Stack<Integer> st;
    boolean[] inCycle;
    int[][] depths;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        N = in.nextInt();
        A = new ArrayList[N];
        for(int i = 0; i < N; i++)
            A[i] = new ArrayList<Integer>();

        for(int i = 0; i < N; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            A[a].add(b);
            A[b].add(a);
        }

        v = new boolean[N];
        cycle = new ArrayList<Integer>();
        st = new Stack<Integer>();
        findCycle(0, -1);

        inCycle = new boolean[N];
        for(int x : cycle)
            inCycle[x] = true;

        depths = new int[N][];
        double ans = 0;
        for(int x : cycle)
            ans += go(x, -1);

        for(int i = 0; i < cycle.size(); i++)
            for(int j = i + 1; j < cycle.size(); j++) {
                int[] dpi = depths[cycle.get(i)];
                int[] dpj = depths[cycle.get(j)];

                for(int di = 0; di < dpi.length; di++)
                    for(int dj = 0; dj < dpj.length; dj++) {
                        ans += f(j - i, cycle.size() - (j - i), di, dj) * dpi[di] * dpj[dj];

//                        out.println((j - i) + " " + (cycle.size() - (j - i)) + " " + di + " " + dj + " " + dpi[di] + " " + dpj[dj]);
                    }
            }

        ans *= 2;
        ans += N;

        out.println(ans);
    }

    private double f(int c1, int c2, int t1, int t2) {
        return 1.0 / (t1 + c1 + t2 + 1) + 1.0 / (t1 + c2 + t2 + 1) - 1.0 / (t1 + c1 + c2 + t2);
    }

    private double go(int node, int prev) {
        double ret = 0.0;

        int maxDepth = 0;
        for(int x : A[node])
            if(x != prev && !inCycle[x]) {
                ret += go(x, node);
                maxDepth = Math.max(maxDepth, depths[x].length);
            }

        depths[node] = new int[maxDepth + 1];
        depths[node][0] = 1;

        for(int x : A[node])
            if(x != prev && !inCycle[x]) {
                for(int i = 0; i < depths[node].length; i++)
                    if(depths[node][i] > 0)
                        for(int j = 0; j < depths[x].length; j++)
                            if(depths[x][j] > 0)
                                ret += 1.0 / (i + (j + 1) + 1) * depths[node][i] * depths[x][j];

                for(int i = 0; i < depths[x].length; i++)
                    depths[node][i + 1] += depths[x][i];

                depths[x] = null;
            }

        return ret;
    }

    private boolean findCycle(int node, int prev) {
        v[node] = true;
        st.add(node);

        for(int x : A[node])
            if(x != prev) {
                if(!v[x]) {
                    if(findCycle(x, node))
                        return true;
                }
                else {
                    while(st.peek() != x)
                        cycle.add(st.pop());
                    cycle.add(x);
                    return true;
                }
            }

        st.pop();
        return false;
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
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));

        return res.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    }

