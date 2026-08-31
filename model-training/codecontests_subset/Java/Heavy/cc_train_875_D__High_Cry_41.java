import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.io.IOException;
import java.util.Deque;
import java.io.UncheckedIOException;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 27);
        thread.start();
        thread.join();
    }

    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            DHighCry solver = new DHighCry();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class DHighCry {
        int[] a;
        int[][] next;
        int[][] prev;
        int n;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            n = in.readInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.readInt();
            }


            next = new int[n][30];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < 30; j++) {
                    if (Bits.bitAt(a[i], j) == 1) {
                        next[i][j] = i;
                    } else {
                        next[i][j] = i == n - 1 ? n : next[i + 1][j];
                    }
                }
            }

            prev = new int[n][30];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 30; j++) {
                    if (Bits.bitAt(a[i], j) == 1) {
                        prev[i][j] = i;
                    } else {
                        prev[i][j] = i == 0 ? -1 : prev[i - 1][j];
                    }
                }
            }

            DescartesTree tree = new DescartesTree(a, 0, n - 1, (x, y) -> -Integer.compare(x, y));
            long ans = dfs(tree.getRoot(), 0, n - 1);
            out.println(ans);
        }

        public long dfs(DescartesTree.Node root, int l, int r) {
            if (root == null) {
                return 0;
            }
            int index = root.index;
            long ans = dfs(root.left, l, index - 1) + dfs(root.right, index + 1, r);
            int lIndex = l - 1;
            int rIndex = r + 1;
            for (int i = 0; i < 30; i++) {
                if (Bits.bitAt(a[index], i) == 0) {
                    lIndex = Math.max(prev[index][i], lIndex);
                    rIndex = Math.min(next[index][i], rIndex);
                }
            }
            int leftBlock = lIndex - l + 1;
            int rightBlock = r - rIndex + 1;
            long local = (long) leftBlock * (r - index + 1) + (long) rightBlock * (index - l + 1) -
                    (long) leftBlock * rightBlock;
            return ans + local;
        }

    }

    static class Bits {
        private Bits() {
        }

        public static int bitAt(int x, int i) {
            return (x >>> i) & 1;
        }

    }

    static class FastInput {
        private final InputStream is;
        private byte[] buf = new byte[1 << 20];
        private int bufLen;
        private int bufOffset;
        private int next;

        public FastInput(InputStream is) {
            this.is = is;
        }

        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }

        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }

        public int readInt() {
            int sign = 1;

            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }

            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }

            return val;
        }

    }

    static class DescartesTree {
        private DescartesTree.Node root;
        private DescartesTree.Node[] nodes;

        public <T> DescartesTree(T[] data, int l, int r, Comparator<T> comp) {
            int len = r - l + 1;
            nodes = new DescartesTree.Node[len];
            for (int i = 0; i < len; i++) {
                nodes[i] = new DescartesTree.Node();
                nodes[i].index = i + l;
            }
            Deque<DescartesTree.Node> deque = new ArrayDeque<>(len);
            for (int i = 0; i < len; i++) {
                while (!deque.isEmpty() && comp.compare(data[deque.peekLast().index], data[nodes[i].index]) > 0) {
                    DescartesTree.Node tail = deque.removeLast();
                    tail.right = nodes[i].left;
                    nodes[i].left = tail;
                }
                deque.addLast(nodes[i]);
            }
            while (deque.size() > 1) {
                DescartesTree.Node tail = deque.removeLast();
                deque.peekLast().right = tail;
            }
            root = deque.removeLast();
        }

        public DescartesTree(int[] data, int l, int r, IntComparator comparator) {
            int len = r - l + 1;
            nodes = new DescartesTree.Node[len];
            for (int i = 0; i < len; i++) {
                nodes[i] = new DescartesTree.Node();
                nodes[i].index = i + l;
            }
            Deque<DescartesTree.Node> deque = new ArrayDeque<>(len);
            for (int i = 0; i < len; i++) {
                while (!deque.isEmpty() && comparator.compare(data[deque.peekLast().index], data[nodes[i].index]) > 0) {
                    DescartesTree.Node tail = deque.removeLast();
                    tail.right = nodes[i].left;
                    nodes[i].left = tail;
                }
                deque.addLast(nodes[i]);
            }
            while (deque.size() > 1) {
                DescartesTree.Node tail = deque.removeLast();
                deque.peekLast().right = tail;
            }
            root = deque.removeLast();
        }

        public DescartesTree.Node getRoot() {
            return root;
        }

        public static class Node {
            public int index;
            public DescartesTree.Node left;
            public DescartesTree.Node right;

            public String toString() {
                return "" + index;
            }

        }

    }

    static interface IntComparator {
        public int compare(int a, int b);

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }

        public FastOutput append(long c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(long c) {
            return append(c).println();
        }

        public FastOutput println() {
            cache.append(System.lineSeparator());
            return this;
        }

        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
        }

    }
}

