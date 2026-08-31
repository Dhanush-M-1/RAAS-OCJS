import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
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

            IntList[] adj = new IntList[n];
            int[] result = new int[m];

            int[] degree = new int[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new IntList(3);
            }


            int[] u = new int[m];
            int[] v = new int[m];

            for (int i = 0; i < m; ++i) {
                u[i] = in.nextInt() - 1;
                v[i] = in.nextInt() - 1;

                adj[u[i]].add(i);
                adj[v[i]].add(i);
                degree[u[i]]++;
                degree[v[i]]++;
            }

            IntList que = new IntList(n);

            boolean[] alive = ArrayUtils.createArray(m, true);

            for (int i = 0; i < n; ++i)
                if (degree[i] < k) que.add(i);

            int head = 0;
            for (int day = m - 1; day >= 0; --day) {
                while (head < que.size()) {
                    int id = que.get(head);

                    for (int edgeId : adj[id]) {
                        if (!alive[edgeId]) continue;

                        int other = u[edgeId] == id ? v[edgeId] : u[edgeId];
                        if (degree[other] == k) {
                            que.add(other);
                        }

                        degree[other]--;
                        degree[id]--;
                        alive[edgeId] = false;
                    }

                    ++head;
                }

                result[day] = n - que.size();

                if (alive[day]) {
                    if (degree[u[day]] == k)
                        que.add(u[day]);
                    if (degree[v[day]] == k)
                        que.add(v[day]);

                    degree[u[day]]--;
                    degree[v[day]]--;
                    alive[day] = false;
                }
            }

//        while (!set.isEmpty() && set.first().first < k) {
//            IntPair pair = set.first();
//            for (Iterator<Integer> it = adj[pair.second].iterator(); it.hasNext(); ) {
//                int edge = it.next();
//                int e = v[edge] == pair.second ? u[edge] : v[edge];
//                set.remove(degree[e]);
//                degree[e].first--;
//                set.add(degree[e]);
//                it.remove();
//            }
//            set.remove(pair);
//            alive[pair.second] = false;
//        }
//
//        for (int i = m - 1; i >= 0; --i) {
//            result[i] = set.size();
//            if (alive[u[i]] && alive[v[i]]) {
//                set.remove(degree[u[i]]);
//                degree[u[i]].first--;
//                set.add(degree[u[i]]);
//
//                set.remove(degree[v[i]]);
//                degree[v[i]].first--;
//                set.add(degree[v[i]]);
//
//                while (!set.isEmpty() && set.first().first < k) {
//                    IntPair pair = set.first();
//                    for (Iterator<Integer> it = adj[pair.second].iterator(); it.hasNext(); ) {
//                        int edge = it.next();
//                        it.remove();
//                        if (edge < i) {
//                            int e = v[edge] == pair.second ? u[edge] : v[edge];
//                            if (!alive[e]) continue;
//                            set.remove(degree[e]);
//                            degree[e].first--;
//                            set.add(degree[e]);
//                        }
//                    }
//                    set.remove(pair);
//                    alive[pair.second] = false;
//                }
//            }
//        }

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

    static class IntList implements Iterable<Integer> {
        public static final int INITIAL_CAPACITY = 4;
        private int size;
        private int[] array;

        public IntList() {
            this(INITIAL_CAPACITY);
        }

        public IntList(int initialCapacity) {
            this.array = new int[initialCapacity];
            this.size = 0;
        }

        public IntList(int[] array) {
            this.array = Arrays.copyOf(array, array.length);
            this.size = this.array.length;
        }

        public void add(int value) {
            if (size == array.length) {
                ensureCapacity();
            }

            this.array[this.size++] = value;
        }

        public int get(int index) {
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Expected argument in [0, " + size + "), but found " + index);
            return array[index];
        }

        public int size() {
            return this.size;
        }

        private void ensureCapacity() {
            if (size < array.length)
                return;
            this.array = Arrays.copyOf(array, array.length << 1);
        }

        public IntList clone() {
            IntList cloned = new IntList(Math.max(1, this.size));
            for (int i = 0; i < size; ++i)
                cloned.add(array[i]);
            return cloned;
        }


        public Iterator<Integer> iterator() {
            return new IntListIterator();
        }

        private class IntListIterator implements Iterator<Integer> {
            private int current;

            public IntListIterator() {
                this.current = 0;
            }


            public boolean hasNext() {
                return this.current < size;
            }


            public Integer next() {
                return array[current++];
            }

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

