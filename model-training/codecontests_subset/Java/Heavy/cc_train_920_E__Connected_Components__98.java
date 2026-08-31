import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Collections;
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
        OutputWriter out = new OutputWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            Vertex[] vertices = new Vertex[n];
            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = new Vertex(i);
            }
            for (int i = 0; i < m; i++) {
                int x = in.readInt() - 1;
                int y = in.readInt() - 1;
                vertices[x].notAdj.add(y);
                vertices[y].notAdj.add(x);
            }
            Arrays.sort(vertices, Comparator.comparing((Vertex vertex) -> vertex.notAdj.size()));
            // vertices[0].notAdj is capped at 500 or less
            TreeMap<Integer, Integer> translate = new TreeMap<>();
            TreeMap<Integer, Integer> reverseTranslate = new TreeMap<>();
            for (int val : vertices[0].notAdj) translate.put(val, 0);
            int ptr = 0;
            for (int val : translate.keySet()) {
                translate.put(val, ptr);
                reverseTranslate.put(ptr, val);
                ptr++;
            }
            TreeSet<Integer> big = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if (!translate.containsKey(i)) {
                    big.add(i);
                }
            }
            Arrays.sort(vertices, Comparator.comparing((Vertex vertex) -> vertex.index));
            boolean[][] adj = new boolean[translate.size()][translate.size()];
            ArrayUtils.fill(adj, true);
            for (int idx : translate.keySet()) {
                for (int other : vertices[idx].notAdj) {
                    if (translate.containsKey(other)) {
                        adj[translate.get(idx)][translate.get(other)] = false;
                        adj[translate.get(other)][translate.get(idx)] = false;
                    }
                }
            }
            RecursiveIndependentSetSystem iss = new RecursiveIndependentSetSystem(n);
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    if (adj[i][j]) {
                        iss.join(i, j);
                    }
                }
            }
            TreeMap<Integer, ArrayList<Integer>> counts = new TreeMap<>();
            for (int i = 0; i < adj.length; i++) {
                int key = iss.get(i);
                if (!counts.containsKey(key)) counts.put(key, new ArrayList<>());
                counts.get(key).add(i);
            }
            ArrayList<Integer> values = new ArrayList<>();
            for (ArrayList<Integer> set : counts.values()) {
                boolean ok = true;
                for (int untrans : set) {
                    int normal = reverseTranslate.get(untrans);
                    int hitCount = 0;
                    for (int act : vertices[normal].notAdj) {
                        if (big.contains(act)) {
                            hitCount++;
                        }
                    }
                    if (hitCount < big.size()) {
                        ok = false;
                    }
                }
                if (!ok) {
                    for (int val : set) {
                        big.add(reverseTranslate.get(val));
                    }
                } else {
                    values.add(set.size());
                }
            }
            values.add(big.size());
            Collections.sort(values);
            out.printLine(values.size());
            for (int val : values) {
                out.print(val + " ");
            }
            out.printLine();
        }

        class Vertex {
            int index;
            ArrayList<Integer> notAdj = new ArrayList<>();

            public Vertex(int index) {
                this.index = index;
            }
        }
    }
    static class ArrayUtils {
        public static void fill(boolean[][] array, boolean value) {
            for (boolean[] row : array) {
                Arrays.fill(row, value);
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

        public int readInt() {
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
    static interface IndependentSetSystem {
        public static interface Listener {
            public void joined(int joinedRoot, int root);
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

        public void printLine() {
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }
    }
    static class RecursiveIndependentSetSystem implements IndependentSetSystem {
        private final int[] color;
        private final int[] rank;
        private int setCount;
        private IndependentSetSystem.Listener listener;

        public RecursiveIndependentSetSystem(int size) {
            color = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                color[i] = i;
            }
            setCount = size;
        }

        public RecursiveIndependentSetSystem(RecursiveIndependentSetSystem other) {
            color = other.color.clone();
            rank = other.rank.clone();
            setCount = other.setCount;
        }

        public boolean join(int first, int second) {
            first = get(first);
            second = get(second);
            if (first == second) {
                return false;
            }
            if (rank[first] < rank[second]) {
                int temp = first;
                first = second;
                second = temp;
            } else if (rank[first] == rank[second]) {
                rank[first]++;
            }
            setCount--;
            color[second] = first;
            if (listener != null) {
                listener.joined(second, first);
            }
            return true;
        }

        public int get(int index) {
            int start = index;
            while (color[index] != index) {
                index = color[index];
            }
            while (start != index) {
                int next = color[start];
                color[start] = index;
                start = next;
            }
            return index;
        }
    }
}

