import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.AbstractCollection;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Duy Hung
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
    int []dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    int []dy = {-1, 0, 1, 1, 1, 0, -1, -1};

	public void solve(int testNumber, InputReader in, OutputWriter out) {
        HashMap <Point, Integer> map = new HashMap<Point, Integer>();
        int sx = in.nextInt(), sy = in.nextInt(), tx = in.nextInt(), ty = in.nextInt();
        map.put(new Point(sx, sy), 0);
        map.put(new Point(tx, ty), 0);

        if (sx == tx && sy == ty) {
            out.printLn(0);
            return;
        }

        int n = in.nextInt();
        while (n-- > 0) {
            int r = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            for (int i = a; i <= b; ++i) map.put(new Point(r, i), 0);
        }

        LinkedList <Point> queue = new LinkedList<Point>();
        queue.add(new Point(sx, sy));
        map.put(new Point(sx, sy), 1);

        while (!queue.isEmpty()) {
            Point cur = queue.removeFirst();
            //out.printLn("CUR", cur.x, cur.y, map.get(cur));
            for (int i = 0; i < dx.length; ++i) {
                Point next = new Point(cur.x + dx[i], cur.y + dy[i]);
                if (map.containsKey(next) == false || map.get(next) > 0) continue;
                map.put(next, map.get(cur) + 1);
                //out.printLn(next.x, next.y, map.get(next));
                queue.add(next);
                if (next.equals(new Point(tx, ty))) {
                    out.printLn(map.get(cur));
                    return;
                }
            }
        }

        out.printLn(-1);
	}
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
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

    public void printLn(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}

