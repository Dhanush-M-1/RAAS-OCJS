
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream;
        if (args.length > 0 && args[0].equals("devTesting")) {
            try {
                inputStream = new FileInputStream(args[1]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            inputStream = System.in;
        }
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {

        int sz;
        int n, m;
        int[] l, r;

        class TripleIII implements Comparable<TripleIII> {

            int a, b, c;

            TripleIII(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }

            public int compareTo(TripleIII other) {
                if (this.a != other.a) {
                    return this.a - other.a;
                }
                if (this.b != other.b) {
                    return this.b - other.b;
                }
                return this.c - other.c;
            }

            public String toString() {
                return "(" + a + ", " + b + ", " + c + ")";
            }
        }

        void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            sz = m + 1;
            l = new int[n];
            r = new int[n];
            TripleIII[] a = new TripleIII[n];
            for (int i = 0; i < n; ++i) {
                l[i] = in.nextInt();
                r[i] = in.nextInt();
                a[i] = new TripleIII(r[i] - l[i] + 1, l[i], r[i]);
            }
            Arrays.sort(a);
            int[] tree = new int[sz + 1];
            int[] cnttree = new int[sz + 1];
            for (int i = 0; i < n; ++i) {
                add(tree, l[i] + 1, 1);
                add(tree, r[i] + 2, -1);
            }
            int ptr = n - 1;
            for (int d = m; d >= 1; --d) {
                while (ptr >= 0 && a[ptr].a >= d) {
                    add(tree, a[ptr].b + 1, -1);
                    add(tree, a[ptr].c + 2, 1);
                    add(cnttree, 1, 1);
                    add(cnttree, d + 2, -1);
                    --ptr;
                }
                for (int i = 1; i <= m + 1; i += d) {
                    add(cnttree, d + 1, sum(tree, i));
                    add(cnttree, d + 2, -sum(tree, i));
                }
            }
            for (int i = 2; i <= m + 1; ++i) {
                out.println(sum(cnttree, i));
            }
        }

        void add(int[] tree, int x, int v) {
            while (x <= sz) {
                tree[x] += v;
                x += (x & -x);
            }
        }

        int sum(int[] tree, int x) {
            int ret = 0;
            while (x != 0) {
                ret += tree[x];
                x -= (x & -x);
            }
            return ret;
        }

        int i(long x) {
            return (int) x;
        }

        <T> void heapsort(T[] a, int s, int e) {
            Queue<T> queue = new PriorityQueue<>();
            for (int i = s; i <= e; ++i) {
                queue.add(a[i]);
            }
            for (int i = s; i <= e; ++i) {
                a[i] = queue.poll();
            }
        }

    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public boolean hasInput() {
            try {
                if (tokenizer != null && tokenizer.hasMoreTokens()) {
                    return true;
                }
                reader.mark(1);
                int ch = reader.read();
                if (ch != -1) {
                    reader.reset();
                    return true;
                }
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
