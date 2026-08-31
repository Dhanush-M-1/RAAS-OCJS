import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.Deque;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
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
            TaskF solver = new TaskF();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class TaskF {
        Deque<Node> deque = new ArrayDeque<>(200000);
        Query[] buf = new Query[1000000];

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int m = in.readInt();
            int k = in.readInt();
            int q = in.readInt();

            Node[] nodes = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new Node();
                nodes[i].id = i;
            }

            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                edges[i] = new Edge();
                edges[i].a = nodes[in.readInt()];
                edges[i].b = nodes[in.readInt()];
                edges[i].w = in.readInt();
                edges[i].a.next.add(edges[i]);
                edges[i].b.next.add(edges[i]);
            }

            for (int i = k + 1; i <= n; i++) {
                nodes[i].dist = (long) 1e18;
            }

            TreeSet<Node> set = new TreeSet<>((a, b) -> a.dist == b.dist ? a.id - b.id : Long.compare(a.dist, b.dist));
            for (int i = 1; i <= k; i++) {
                nodes[i].dist = 0;
                set.add(nodes[i]);
            }

            while (!set.isEmpty()) {
                Node head = set.pollFirst();
                for (Edge e : head.next) {
                    Node node = e.other(head);
                    if (head.dist + e.w >= node.dist) {
                        continue;
                    }
                    set.remove(node);
                    node.dist = head.dist + e.w;
                    set.add(node);
                }
            }

            for (Edge e : edges) {
                e.w += e.a.dist + e.b.dist;
            }
            Arrays.sort(edges, (a, b) -> Long.compare(a.w, b.w));

            Query[] qs = new Query[q];
            for (int i = 0; i < q; i++) {
                qs[i] = new Query();
                qs[i].a = nodes[in.readInt()];
                qs[i].b = nodes[in.readInt()];
            }

            dac(edges, 0, m - 1, qs.clone(), 0, q - 1);
            for (int i = 0; i < q; i++) {
                out.println(qs[i].ans);
            }
        }

        public void dac(Edge[] es, int el, int er, Query[] qs, int ql, int qr) {
            if (ql > qr) {
                return;
            }
            if (el == er) {
                for (int i = ql; i <= qr; i++) {
                    qs[i].ans = es[el].w;
                }
                return;
            }
            int sp = deque.size();
            int m = (el + er) / 2;
            for (int i = el; i <= m; i++) {
                Node.merge(es[i].a, es[i].b, deque);
            }

            int lpos = ql;
            for (int i = ql; i <= qr; i++) {
                if (qs[i].a.find() == qs[i].b.find()) {
                    buf[lpos++] = qs[i];
                }
            }
            int rpos = lpos;
            for (int i = ql; i <= qr; i++) {
                if (qs[i].a.find() != qs[i].b.find()) {
                    buf[rpos++] = qs[i];
                }
            }
            System.arraycopy(buf, ql, qs, ql, qr - ql + 1);

            dac(es, m + 1, er, qs, lpos, qr);
            while (deque.size() > sp) {
                Node.split(deque.removeLast());
            }
            dac(es, el, m, qs, ql, lpos - 1);
        }

    }

    static class FastOutput implements AutoCloseable, Closeable {
        private StringBuilder cache = new StringBuilder(10 << 20);
        private final Writer os;

        public FastOutput(Writer os) {
            this.os = os;
        }

        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }

        public FastOutput println(long c) {
            cache.append(c).append('\n');
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

    static class Node {
        List<Edge> next = new ArrayList<>();
        long dist;
        int id;
        Node p = null;
        int rank = 1;

        public Node find() {
            return p == null ? this : p.find();
        }

        public static void split(Node x) {
            for (Node trace = x.p; trace != null; trace = trace.p) {
                trace.rank -= x.rank;
            }
            x.p = null;
        }

        public static void merge(Node a, Node b, Deque<Node> deque) {
            a = a.find();
            b = b.find();
            if (a == b) {
                return;
            }
            if (a.rank > b.rank) {
                Node tmp = a;
                a = b;
                b = tmp;
            }
            a.p = b;
            b.rank += a.rank;
            deque.addLast(a);
        }

    }

    static class Query {
        Node a;
        Node b;
        long ans;

    }

    static class FastInput {
        private final InputStream is;
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

    static class Edge {
        Node a;
        Node b;
        long w;

        Node other(Node x) {
            return a == x ? b : a;
        }

    }
}

