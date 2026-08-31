import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.awt.Point;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStreamReader;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int y0 = in.nextInt();
            int x0 = in.nextInt();
            int y1 = in.nextInt();
            int x1 = in.nextInt();
            HashSet<Point> cells = new HashSet<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int r = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                for (int j = a; j <= b; j++) {
                    cells.add(new Point(j, r));
                }
            }
            HashMap<Point, Integer> used = new HashMap<>();
            ArrayDeque<Point> bfs = new ArrayDeque<>();
            bfs.add(new Point(x0, y0));
            used.put(new Point(x0, y0), 0);
            Point end = new Point(x1, y1);
            while (!bfs.isEmpty()) {
                Point cur = bfs.removeFirst();
                Integer steps = used.get(cur);
                if (cur.equals(end)) break;
                Point next = new Point(cur.x - 1, cur.y - 1);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x, cur.y - 1);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x + 1, cur.y - 1);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x - 1, cur.y);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x + 1, cur.y);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x - 1, cur.y + 1);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x, cur.y + 1);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
                next = new Point(cur.x + 1, cur.y + 1);
                if (cells.contains(next) && !used.containsKey(next)) {
                    used.put(next, steps + 1);
                    bfs.addLast(next);
                }
            }
            if (used.containsKey(end)) {
                out.println(used.get(end));
            } else {
                out.println(-1);
            }
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (stt == null || !stt.hasMoreTokens()) {
                stt = new StringTokenizer(nextLine());
            }
            return stt.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

