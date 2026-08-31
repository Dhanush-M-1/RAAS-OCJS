import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Arthur Gazizov - Kazan FU #4.3 [2oo7]
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        private static final long INF = 10000000000000000L;
        TaskD.Node[] graph;
        List<TaskD.Edge> edges;
        private boolean ok = true;

        private void dijkstra(int source, long distance[], boolean includeRemoved, boolean fill, long[] old, long need) {
            Arrays.fill(distance, INF);
            boolean[] used = new boolean[graph.length];
            distance[source] = 0L;
            for (int i = 0; i < graph.length; i++) {
                int from = -1;
                for (int candidate = 0; candidate < graph.length; candidate++) {
                    if (!used[candidate] && (from == -1 || distance[candidate] < distance[from])) {
                        from = candidate;
                    }
                }
                if (from == -1 || distance[from] == INF) {
                    return;
                }
                used[from] = true;
                for (TaskD.Edge edge : graph[from].edges) {
                    if (edge.isRemoved && !includeRemoved) {
                        continue;
                    }
                    int next = edge.next(from);
                    if (edge.isRemoved && fill && distance[next] > distance[from] + edge.cost && distance[from] + edge.cost < old[next] + need) {
                        edge.cost = old[next] + need - distance[from];
                    }
                    if (distance[next] > distance[from] + edge.cost) {
                        distance[next] = distance[from] + edge.cost;
                    }
                }
            }
        }

        private void exit(OutputWriter out) {
            if (ok) {
                out.printLine("YES");
                out.print(edges.stream().map(edge -> String.format("%d %d %d", edge.from, edge.to, edge.cost)).collect(Collectors.joining("\n")));
            } else {
                out.print("NO");
            }
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int vertexCount = in.nextInt();
            int edgesCount = in.nextInt();
            int mustCost = in.nextInt();
            int source = in.nextInt();
            int destination = in.nextInt();
            graph = new TaskD.Node[vertexCount];
            edges = new ArrayList<>();
            for (int i = 0; i < vertexCount; i++) {
                graph[i] = new TaskD.Node();
            }
            for (int i = 0; i < edgesCount; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int cost = in.nextInt();
                TaskD.Edge edge = new TaskD.Edge(i, from, to, Math.max(cost, 1), cost == 0);
                graph[from].addEdge(edge);
                graph[to].addEdge(edge);
                edges.add(edge);
            }
            long[] distance = new long[graph.length];
            dijkstra(source, distance, false, false, null, 0);
            if (distance[destination] < mustCost) {
                ok = false;
                exit(out);
                return;
            }
            dijkstra(source, distance, true, false, null, 0);
            if (distance[destination] > mustCost) {
                ok = false;
                exit(out);
                return;
            }
            dijkstra(source, new long[graph.length], true, true, distance, mustCost - distance[destination]);
            exit(out);
        }

        private static class Edge {
            int id;
            int from;
            int to;
            long cost;
            boolean isRemoved;

            public Edge(int id, int from, int to, long cost, boolean isRemoved) {
                this.id = id;
                this.from = from;
                this.to = to;
                this.cost = cost;
                this.isRemoved = isRemoved;
            }

            public int next(int from) {
                return this.from == from ? to : this.from;
            }

        }

        static class Node {
            List<TaskD.Edge> edges;

            public Node() {
                this.edges = new ArrayList<>();
            }

            public void addEdge(TaskD.Edge edge) {
                this.edges.add(edge);
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

