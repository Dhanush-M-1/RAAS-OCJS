import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _455C {

    static int n, m, q;
    static int[] father, diameter, next;
    static List<Integer>[] g;

    static int find(int i) {
        if (father[i] != i) father[i] = find(father[i]);
        return father[i];
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);
        if (i != j) {
            father[i] = j;
            int ii = next[i];
            int jj = next[j];
            next[i] = jj;
            next[j] = ii;
        }
    }

    static List<Integer> collect(int i) {
        List<Integer> res = new ArrayList<>(1);
        i = find(i);
        res.add(i);
        for (int j = next[i]; j != i; j = next[j])
            res.add(j);
        return res;
    }

    static void dfs(int u, int parent, int d, int[] dist) {
        dist[u] = d;
        for (int v : g[u])
            if (v != parent) dfs(v, u, d + 1, dist);
    }

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        BufferedWriter cout = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Reader.nextInt();
        m = Reader.nextInt();
        q = Reader.nextInt();
        father = new int[n];
        diameter = new int[n];
        next = new int[n];
        for (int i = 0; i < n; i++) father[i] = next[i] = i;
        g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>(1);
        for (int i = 0; i < m; i++) {
            int u = Reader.nextInt() - 1;
            int v = Reader.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
            union(u, v);
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            if (dist[i] == 0) {
                collect(i);
                dfs(i, -1, 1, dist);
                int maxNode = i;
                for (int node : collect(i))
                    if (dist[node] > dist[maxNode]) maxNode = node;

                dfs(maxNode, -1, 1, dist);
                for (int node : collect(i))
                    if (dist[node] > dist[maxNode]) maxNode = node;

                diameter[find(i)] = dist[maxNode] - 1;
            }

        StringBuilder builder = new StringBuilder();
        for (; q > 0; q--) {
//            System.out.println(Arrays.toString(diameter));
            int type = Reader.nextInt();
            if (type == 1) {
                int x = Reader.nextInt() - 1;
                builder.append(diameter[find(x)]);
                builder.append('\n');
            } else if (type == 2) {
                int u = Reader.nextInt() - 1;
                int v = Reader.nextInt() - 1;
                u = find(u);
                v = find(v);
                if (u != v) {
                    union(u, v);
                    diameter[find(u)] = Math.max(diameter[u], Math.max(diameter[v], (diameter[u] + 1) / 2 + (diameter[v] + 1) / 2 + 1));
                }
            } else assert (false);
        }

        cout.write(builder.toString());
        cout.close();
    }

    static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        final U _1;
        final V _2;

        private Pair(U key, V val) {
            this._1 = key;
            this._2 = val;
        }

        public static <U extends Comparable<U>, V extends Comparable<V>> Pair<U, V> instanceOf(U _1, V _2) {
            return new Pair<U, V>(_1, _2);
        }

        @Override
        public String toString() {
            return _1 + " " + _2;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = res * 31 + _1.hashCode();
            res = res * 31 + _2.hashCode();
            return res;
        }

        @Override
        public int compareTo(Pair<U, V> that) {
            int res = this._1.compareTo(that._1);
            if (res < 0 || res > 0) return res;
            else return this._2.compareTo(that._2);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair<?, ?> that = (Pair<?, ?>) obj;
            return _1.equals(that._1) && _2.equals(that._2);
        }
    }

    /**
     * Class for buffered reading int and double values
     */
    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                // TODO add check for eof if necessary
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static class ArrayUtil {
        static void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(long[] a, int i, int j) {
            long tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(double[] a, int i, int j) {
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(char[] a, int i, int j) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(boolean[] a, int i, int j) {
            boolean tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void reverse(int[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(long[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(double[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(char[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(boolean[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static long sum(int[] a) {
            int sum = 0;
            for (int i : a)
                sum += i;
            return sum;
        }

        static long sum(long[] a) {
            long sum = 0;
            for (long i : a)
                sum += i;
            return sum;
        }

        static double sum(double[] a) {
            double sum = 0;
            for (double i : a)
                sum += i;
            return sum;
        }

        static int max(int[] a) {
            int max = Integer.MIN_VALUE;
            for (int i : a)
                if (i > max) max = i;
            return max;
        }

        static int min(int[] a) {
            int min = Integer.MAX_VALUE;
            for (int i : a)
                if (i < min) min = i;
            return min;
        }

        static long max(long[] a) {
            long max = Long.MIN_VALUE;
            for (long i : a)
                if (i > max) max = i;
            return max;
        }

        static long min(long[] a) {
            long min = Long.MAX_VALUE;
            for (long i : a)
                if (i < min) min = i;
            return min;
        }
    }
}
