import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.io.IOException;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author palayutm
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ProblemCDataCenterMaintenance solver = new ProblemCDataCenterMaintenance();
        solver.solve(1, in, out);
        out.close();
    }

    static class ProblemCDataCenterMaintenance {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt(), H = in.nextInt();
            Graph g = new Graph(n);
            int[] h = in.nextIntArray(n);
            for (int i = 0; i < m; i++) {
                int c1 = in.nextInt(), c2 = in.nextInt();
                if (h[c1 - 1] == (h[c2 - 1] + 1) % H) {
                    g.addEdge(c2 - 1, c1 - 1);
                }
                if (h[c2 - 1] == (h[c1 - 1] + 1) % H) {
                    g.addEdge(c1 - 1, c2 - 1);
                }
            }
            StronglyConnectedComponent scc = new Kosaraju(g);
            int[] outDegree = new int[scc.getComponentsNumber()];
            for (int i = 0; i < n; i++) {
                for (Edge edge : g.getEdges(i)) {
                    if (scc.getComponentID(i) != scc.getComponentID(edge.to)) {
                        outDegree[scc.getComponentID(i)]++;
                    }
                }
            }
            int[][] components = scc.getComponents();
            int p = -1, mi = n * 3;
            for (int i = 0; i < components.length; i++) {
                if (outDegree[i] == 0 && components[i].length < mi) {
                    mi = components[i].length;
                    p = i;
                }
            }
            out.println(components[p].length);
            for (int i = 0; i < components[p].length; i++) {
                out.print(components[p][i] + 1 + " ");
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0;
        private int ptrbuf = 0;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int readByte() {
            if (lenbuf == -1) throw new UnknownError();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = stream.read(inbuf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

    }

    static class Edge {
        public int to;
        public long weight;

        public Edge(int to) {
            this.to = to;
        }

        public Edge(int to, long weight) {
            this(to);
            this.weight = weight;
        }

    }

    static class Graph {
        MyArrayList<Edge>[] g;

        public Graph(int n) {
            g = new MyArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new MyArrayList();
            }
        }

        public void addEdge(int from, int to) {
            g[from].add(new Edge(to));
        }

        public MyArrayList<Edge> getEdges(int from) {
            return g[from];
        }

        public int getVertexNumber() {
            return g.length;
        }

    }

    static interface StronglyConnectedComponent {
        int getComponentID(int vertexID);

        int getComponentsNumber();

        int[][] getComponents();

    }

    static class IntArrayList {
        private static final int DEFAULT_CAPACITY = 10;
        int[] array;
        int size;

        public IntArrayList() {
            this(DEFAULT_CAPACITY);
        }

        public IntArrayList(int capacity) {
            array = new int[capacity];
            size = 0;
        }

        public IntArrayList(int size, int initialValue) {
            String s;
            array = new int[size];
            Arrays.fill(array, initialValue);
            this.size = size;
        }

        public IntArrayList(int[] src) {
            array = Arrays.copyOf(src, src.length);
            size = array.length;
        }

        public void add(int value) {
            if (size == array.length) {
                enLarge();
            }
            array[size++] = value;
        }

        public int remove() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            return array[--size];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int[] toArray() {
            return Arrays.copyOf(array, size);
        }

        private void enLarge() {
            int[] newArray = new int[(int) (array.length << 1)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

    }

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {
            super(out);
        }

        public OutputWriter(Writer out) {
            super(out);
        }

        public void close() {
            super.close();
        }

    }

    static class Kosaraju implements StronglyConnectedComponent {
        int[] belong;
        boolean[] used;
        int scc;
        int vertexNum;
        IntArrayList stack;

        public Kosaraju(Graph g) {
            vertexNum = g.getVertexNumber();
            belong = new int[vertexNum];
            used = new boolean[vertexNum];
            stack = new IntArrayList();
            for (int i = 0; i < vertexNum; i++) {
                if (!used[i]) dfs(g, i, -1);
            }
            Graph reverseGraph = new Graph(vertexNum);
            for (int i = 0; i < vertexNum; i++) {
                for (Edge e : g.getEdges(i)) {
                    reverseGraph.addEdge(e.to, i);
                }
            }
            Arrays.fill(used, false);
            while (!stack.isEmpty()) {
                int u = stack.remove();
                if (!used[u]) {
                    dfs(reverseGraph, u, scc++);
                }
            }
        }

        void dfs(Graph g, int u, int component_id) {
            used[u] = true;
            for (Edge e : g.getEdges(u)) {
                if (!used[e.to]) {
                    dfs(g, e.to, component_id);
                }
            }
            if (component_id == -1) stack.add(u);
            else belong[u] = component_id;
        }


        public int getComponentID(int vertexID) {
            return belong[vertexID];
        }


        public int getComponentsNumber() {
            return scc;
        }


        public int[][] getComponents() {
            int[][] ret = new int[scc][];
            IntArrayList[] components = new IntArrayList[scc];
            for (int i = 0; i < scc; i++) components[i] = new IntArrayList();
            for (int i = 0; i < vertexNum; i++) components[belong[i]].add(i);
            for (int i = 0; i < scc; i++) {
                ret[i] = components[i].toArray();
            }
            return ret;
        }

    }

    static class MyArrayList<T> implements Iterable<T> {
        private static final int DEFAULT_CAPACITY = 10;
        private static final double ENLARGE_SCALE = 2.0;
        Object[] array;
        int size;

        public MyArrayList() {
            this(DEFAULT_CAPACITY);
        }

        public MyArrayList(int capacity) {
            array = new Object[capacity];
            size = 0;
        }

        public void add(T value) {
            if (size == array.length) {
                enLarge();
            }
            array[size++] = value;
        }

        private void enLarge() {
            Object[] newArray = new Object[(int) (array.length * ENLARGE_SCALE)];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }


        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int currentIndex = 0;


                public boolean hasNext() {
                    return currentIndex < size;
                }


                public T next() {
                    return (T) array[currentIndex++];
                }
            };
        }

    }
}

