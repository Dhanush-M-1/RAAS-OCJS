import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.io.IOException;
import java.util.AbstractSequentialList;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Asgar Javadov
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
        int k;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            k = in.nextInt();

            LinkedList<Integer>[] adj = new LinkedList[n];

            IntPair[] degree = new IntPair[n];
            for (int i = 0; i < n; i++) {
                degree[i] = IntPair.newPair(0, i);
                adj[i] = new LinkedList<>();
            }


            int[] u = new int[m];
            int[] v = new int[m];

            for (int i = 0; i < m; ++i) {
                u[i] = in.nextInt() - 1;
                v[i] = in.nextInt() - 1;

                adj[u[i]].add(i);
                adj[v[i]].add(i);
                degree[u[i]].first++;
                degree[v[i]].first++;
            }

            TreeSet<IntPair> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(degree[i]);
            }

            boolean[] alive = ArrayUtils.createArray(n, true);

            while (!set.isEmpty() && set.first().first < k) {
                IntPair pair = set.first();
                for (Iterator<Integer> it = adj[pair.second].iterator(); it.hasNext(); ) {
                    int edge = it.next();
                    int e = v[edge] == pair.second ? u[edge] : v[edge];
                    set.remove(degree[e]);
                    degree[e].first--;
                    set.add(degree[e]);
                    it.remove();
                }
                set.remove(pair);
                alive[pair.second] = false;
            }

            int[] result = new int[m];
            for (int i = m - 1; i >= 0; --i) {
                result[i] = set.size();
                if (alive[u[i]] && alive[v[i]]) {
                    set.remove(degree[u[i]]);
                    degree[u[i]].first--;
                    set.add(degree[u[i]]);

                    set.remove(degree[v[i]]);
                    degree[v[i]].first--;
                    set.add(degree[v[i]]);

                    while (!set.isEmpty() && set.first().first < k) {
                        IntPair pair = set.first();
//                    for (int e : graph.getEdgesFrom(pair.second)) if (alive[e] && !(e == u[i] && pair.second == v[i]) && !(e == v[i] && pair.second == u[i])) {
                        for (Iterator<Integer> it = adj[pair.second].iterator(); it.hasNext(); ) {
                            int edge = it.next();
                            it.remove();
                            if (edge < i) {
                                int e = v[edge] == pair.second ? u[edge] : v[edge];
                                if (!alive[e]) continue;
                                set.remove(degree[e]);
                                degree[e].first--;
                                set.add(degree[e]);
                            }
                        }
                        set.remove(pair);
                        alive[pair.second] = false;
                    }
                }
            }

            for (int e : result)
                out.println(e);
        }

    }

    static class InputReader extends BufferedReader {
        StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            super(new InputStreamReader(inputStream), 32768);
        }

        public InputReader(String filename) {
            super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }

    }

    static class IntPair implements Comparable<IntPair> {
        public int first;
        public int second;

        public IntPair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        public int compareTo(IntPair o) {
            if (first != o.first)
                return Integer.compare(first, o.first);
            return Integer.compare(second, o.second);
        }

        public static IntPair newPair(int first, int second) {
            return new IntPair(first, second);
        }


        public String toString() {
            return "" + first + " " + second;
            // return String.format("{" + first + ", " + second + '}');
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IntPair)) return false;
            IntPair intPair = (IntPair) o;
            return first == intPair.first &&
                    second == intPair.second;
        }


        public int hashCode() {

            return (31 * first + second);
        }

    }

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream outputStream) {
            super(outputStream);
        }

        public OutputWriter(Writer writer) {
            super(writer);
        }

        public OutputWriter(String filename) throws FileNotFoundException {
            super(filename);
        }

        public void close() {
            super.close();
        }

    }

    static class ArrayUtils {
        public static boolean[] createArray(int count, boolean value) {
            boolean[] array = new boolean[count];
            Arrays.fill(array, value);
            return array;
        }

    }
}

