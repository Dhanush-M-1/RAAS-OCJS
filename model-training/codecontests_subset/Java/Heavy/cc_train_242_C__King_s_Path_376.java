import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

/**
 * 242C
 *
 * @author artyom
 */
public class KingsPath implements Runnable {
    private BufferedReader in;
    private PrintStream out;
    private StringTokenizer tok;

    private void solve() throws IOException {
        int sx = nextInt(), sy = nextInt(), dx = nextInt(), dy = nextInt();
        Map<Integer, Set<Integer>> rows = readIntervals();
        out.print(bfs(rows, sx, sy, dx, dy));
    }

    private int bfs(Map<Integer, Set<Integer>> rows, int sx, int sy, int dx, int dy) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> q = new LinkedList<>();
        q.add(new Vertex(sx, sy, 0));
        Vertex target = new Vertex(dx, dy, 0);
        while (!q.isEmpty()) {
            Vertex vertex = q.remove();
            if (vertex.equals(target)) {
                return vertex.len;
            }
            adjVertices(rows, vertex).stream().filter(v -> !visited.contains(v)).forEach(v -> {
                q.add(v);
                visited.add(v);
            });
        }
        return -1;
    }

    private static Collection<Vertex> adjVertices(Map<Integer, ? extends Set<Integer>> rows, Vertex vertex) {
        List<Vertex> vertices = new LinkedList<>();
        Set<Integer> intervals = rows.get(vertex.x);
        if (intervals.contains(vertex.y + 1)) {
            vertices.add(new Vertex(vertex.x, vertex.y + 1, vertex.len + 1));
        }
        if (intervals.contains(vertex.y - 1)) {
            vertices.add(new Vertex(vertex.x, vertex.y - 1, vertex.len + 1));
        }
        harvestVertices(vertex, vertices, rows.get(vertex.x - 1), vertex.x - 1);
        harvestVertices(vertex, vertices, rows.get(vertex.x + 1), vertex.x + 1);
        return vertices;
    }

    private static void harvestVertices(Vertex vertex, List<Vertex> vertices, Set<Integer> intervals, int x) {
        if (intervals != null) {
            if (intervals.contains(vertex.y)) {
                vertices.add(new Vertex(x, vertex.y, vertex.len + 1));
            }
            if (intervals.contains(vertex.y + 1)) {
                vertices.add(new Vertex(x, vertex.y + 1, vertex.len + 1));
            }
            if (intervals.contains(vertex.y - 1)) {
                vertices.add(new Vertex(x, vertex.y - 1, vertex.len + 1));
            }
        }
    }

    private Map<Integer, Set<Integer>> readIntervals() throws IOException {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        for (int i = 0, n = nextInt(); i < n; i++) {
            int r = nextInt(), a = nextInt(), b = nextInt();
            Set<Integer> intervals = rows.get(r);
            if (intervals == null) {
                rows.put(r, intervals = new HashSet<>());
            }
            for (int j = a; j <= b; j++) {
                intervals.add(j);
            }
        }
        return rows;
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new KingsPath().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = System.out;
            tok = null;
            solve();
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    //--------------------------------------------------------------

    private static final class Vertex {
        final int x, y, len;

        Vertex(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Vertex vertex = (Vertex) o;

            return x == vertex.x && y == vertex.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}