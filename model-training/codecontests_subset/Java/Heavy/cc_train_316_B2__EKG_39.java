import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.Arrays;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Abrackadabra
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

class TaskB1 extends AbstractChelperSolution {
    public void solve(int testNumber) {
        int n = in.nextInt();
        int k = in.nextInt() - 1;

        int[] parent = new int[n];
        int[] child = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(child, -1);

        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t != 0) {
                t--;
                parent[t] = i;
                child[i] = t;
            }
        }

        int prefix = -1;

        List<Integer> a = new ArrayList<Integer>();

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int size = 0;

            boolean haveSmart = false;

            int t = i;
            while (child[t] != -1) {
                t = child[t];
            }

            while (t != -1) {
                visited[t] = true;
                size++;
                if (t == k) {
                    prefix = size;
                    haveSmart = true;
                }
                t = parent[t];
            }

            if (!haveSmart) {
                a.add(size);
            }
        }

        log.println(prefix);
        log.println(a);

        boolean[] ok = new boolean[n + 1];
        ok[prefix] = true;

        for (int x : a) {
            for (int i = n; i >= 1; i--) {
                if (ok[i] && i + x <= n) {
                    ok[i + x] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (ok[i]) {
                out.println(i);
            }
        }
    }
}

abstract class AbstractChelperSolution {
    protected InputReader in;
    protected OutputWriter out;
    protected OutputWriter log;
    //protected boolean localMachine = System.getenv().containsKey("USER") && System.getenv("USER").equals("abra");
    protected boolean localMachine = Package.getPackage("chelper") != null;

    {
        if (localMachine) {
            log = new OutputWriter(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    System.err.write(b);
                }
            });
        } else {
            log = new OutputWriter(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                }
            });
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        this.in = in;
        this.out = out;

        if (testNumber == 1) {
            precalc();
        }
        testStarts(testNumber);

        solve(testNumber);

        testEnds(testNumber);
        log.flush();
    }

    public abstract void solve(int testNumber);

    public void testStarts(int testNumber) {}

    public void testEnds(int testNumber) {}

    public void precalc() {}
}

class InputReader implements Iterable<String> {
    BufferedReader br;
    StringTokenizer in;

    public InputReader(String fileName) {
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputReader(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    String lastLine = null;

    boolean hasMoreTokens() {
        while (in == null || !in.hasMoreTokens()) {
            lastLine = nextLine();
            if (lastLine == null) {
                return false;
            }
            in = new StringTokenizer(lastLine);
        }
        return true;
    }

    public String nextString() {
        return hasMoreTokens() ? in.nextToken() : null;
    }

    public String nextLine() {
        boolean somethingLeft = in != null && in.hasMoreTokens();
        in = null;
        if (somethingLeft) {
            return lastLine;
        }
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return hasMoreTokens();
            }

            @Override
            public String next() {
                return nextString();
            }

            @Override
            public void remove() {
                throw new RuntimeException();
            }
        };
    }
}

class OutputWriter extends PrintWriter {

    public OutputWriter(String fileName) {
        super(createFileWriter(fileName));
    }

    private static Writer createFileWriter(String s) {
        Writer writer;

        try {
            writer = new FileWriter(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return writer;
    }

    public OutputWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public OutputWriter(Writer writer) {
        super(writer);
    }

    }

