import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
            EJamesAndTheChase solver = new EJamesAndTheChase();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();
        }
    }

    static class EJamesAndTheChase {
        RandomWrapper rw = new RandomWrapper();
        Comparator<Node> sortByDepth = (a, b) -> -Integer.compare(a.depth, b.depth);
        boolean valid;

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int m = in.readInt();

            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
                nodes[i].id = i;
            }

            for (int i = 0; i < m; i++) {
                Node a = nodes[in.readInt() - 1];
                Node b = nodes[in.readInt() - 1];
                a.adj.add(b);
            }

            Node root = null;

            for (int i = 0; i < 50; i++) {
                Node randRoot = nodes[rw.nextInt(0, n - 1)];
                valid = true;
                for (Node node : nodes) {
                    node.visited = false;
                    node.instk = false;
                }

                dfs(randRoot, 0);
                for (Node node : nodes) {
                    valid = valid && node.visited;
                }

                if (!valid) {
                    continue;
                } else {
                    root = randRoot;
                    break;
                }
            }

            if (root == null) {
                out.println(-1);
                return;
            }

            //dfs and find root
            dpOnTree(root);
            root.ok = true;
            countOnTree(root);

            List<Node> interestingNodes = new ArrayList<>(n);
            for (Node node : nodes) {
                if (node.ok) {
                    interestingNodes.add(node);
                }
            }

            if (interestingNodes.size() * 5 < n) {
                out.println(-1);
                return;
            }

            //out.println(interestingNodes.size());
            for (Node node : interestingNodes) {
                out.append(node.id + 1).append(' ');
            }
            out.println();
        }

        public void countOnTree(Node root) {
            if (root.size == 1 && root.top.ok) {
                root.ok = true;
            }
            for (Node node : root.adj) {
                if (node.depth != root.depth + 1) {
                    continue;
                }
                countOnTree(node);
            }
        }

        public void dpOnTree(Node root) {
            for (Node node : root.adj) {
                if (node.depth != root.depth + 1) {
                    //to ancestor
                    root.lt = LeftistTree.merge(root.lt, new LeftistTree<>(node), sortByDepth);
                    root.size++;
                } else {
                    dpOnTree(node);
                    root.lt = LeftistTree.merge(root.lt, node.lt, sortByDepth);
                    root.size += node.size;
                }
            }

            while (!root.lt.isEmpty() && root.lt.peek().depth >= root.depth) {
                root.lt = LeftistTree.pop(root.lt, sortByDepth);
                root.size--;
            }

            if (root.size == 1) {
                root.top = root.lt.peek();
            }
        }

        public void dfs(Node root, int depth) {
            if (root.visited) {
                valid = valid && root.instk;
                return;
            }

            root.visited = true;
            root.instk = true;
            root.depth = depth;

            for (Node node : root.adj) {
                dfs(node, depth + 1);
            }

            root.instk = false;
        }

    }

    static class FastInput {
        private final InputStream is;
        private StringBuilder defaultStringBuf = new StringBuilder(1 << 13);
        private byte[] buf = new byte[1 << 13];
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

        public String next() {
            return readString();
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

        public String readString(StringBuilder builder) {
            skipBlank();

            while (next > 32) {
                builder.append((char) next);
                next = read();
            }

            return builder.toString();
        }

        public String readString() {
            defaultStringBuf.setLength(0);
            return readString(defaultStringBuf);
        }

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

        public FastOutput append(int c) {
            cache.append(c);
            return this;
        }

        public FastOutput println(int c) {
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

    static class RandomWrapper {
        private Random random;

        public RandomWrapper() {
            this(new Random());
        }

        public RandomWrapper(Random random) {
            this.random = random;
        }

        public int nextInt(int l, int r) {
            return random.nextInt(r - l + 1) + l;
        }

    }

    static class LeftistTree<K> {
        public static final LeftistTree NIL = new LeftistTree<>(null);
        LeftistTree<K> left = NIL;
        LeftistTree<K> right = NIL;
        int dist;
        K key;

        static {
            NIL.left = NIL;
            NIL.right = NIL;
            NIL.dist = -1;
        }

        public LeftistTree(K key) {
            this.key = key;
        }

        public static <K> LeftistTree<K> merge(LeftistTree<K> a, LeftistTree<K> b, Comparator<K> cmp) {
            if (a == NIL) {
                return b;
            } else if (b == NIL) {
                return a;
            }
            if (cmp.compare(a.key, b.key) > 0) {
                LeftistTree<K> tmp = a;
                a = b;
                b = tmp;
            }
            a.right = merge(a.right, b, cmp);
            if (a.left.dist < a.right.dist) {
                LeftistTree<K> tmp = a.left;
                a.left = a.right;
                a.right = tmp;
            }
            a.dist = a.right.dist + 1;
            return a;
        }

        public boolean isEmpty() {
            return this == NIL;
        }

        public K peek() {
            return key;
        }

        public static <K> LeftistTree<K> pop(LeftistTree<K> root, Comparator<K> cmp) {
            LeftistTree<K> ans = merge(root.left, root.right, cmp);
            root.left = root.right = NIL;
            return ans;
        }

        private void toStringDfs(StringBuilder builder) {
            if (this == NIL) {
                return;
            }
            builder.append(key).append(' ');
            left.toStringDfs(builder);
            right.toStringDfs(builder);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            toStringDfs(builder);
            return builder.toString();
        }

    }

    static class Node {
        List<Node> adj = new ArrayList<>();
        int id;
        boolean visited;
        boolean instk;
        int depth;
        int size;
        Node top;
        LeftistTree<Node> lt = LeftistTree.NIL;
        boolean ok;

        public String toString() {
            return "" + (id + 1);
        }

    }
}

