import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.OptionalInt;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "", 1 << 29);
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
            EElectionPromises solver = new EElectionPromises();
            solver.solve(1, in, out);
            out.close();
        }
    }

    static class EElectionPromises {
        IntegerVersionArray iva = new IntegerVersionArray((int) 1e6);

        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.ri();
            int m = in.ri();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
                nodes[i].h = in.ri();
            }
            for (int i = 0; i < m; i++) {
                Node a = nodes[in.ri() - 1];
                Node b = nodes[in.ri() - 1];
                a.adj.add(b);
            }
            int[] sg = new int[n];
            for (int i = 0; i < n; i++) {
                sg[sg(nodes[i])] ^= nodes[i].h;
            }
            int max = Arrays.stream(sg).max().orElse(-1);
            if (max == 0) {
                out.println("LOSE");
                return;
            }
            out.println("WIN");
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (sg[i] > 0) {
                    maxIndex = i;
                }
            }
            Node end = null;
            for (Node node : nodes) {
                if (sg(node) == maxIndex && (node.h ^ sg[maxIndex]) < node.h) {
                    end = node;
                    break;
                }
            }
            end.h ^= sg[maxIndex];
            sg[maxIndex] = 0;
            for (Node node : end.adj) {
                node.h ^= sg[sg(node)];
                sg[sg(node)] = 0;
            }
            for (Node node : nodes) {
                out.append(node.h).append(' ');
            }
        }

        public int sg(Node root) {
            if (root.sg == -1) {
                root.sg = 0;
                for (Node node : root.adj) {
                    sg(node);
                }
                iva.clear();
                for (Node node : root.adj) {
                    iva.set(sg(node), 1);
                }
                while (iva.get(root.sg) == 1) {
                    root.sg++;
                }
            }
            return root.sg;
        }

    }

    static class IntegerVersionArray {
        int[] data;
        int[] version;
        int now;
        int[] def;

        public IntegerVersionArray(int cap) {
            this(cap, null);
        }

        public IntegerVersionArray(int cap, int[] def) {
            data = new int[cap];
            version = new int[cap];
            now = 0;
            this.def = def;
        }

        public void clear() {
            now++;
        }

        public void visit(int i) {
            if (version[i] < now) {
                version[i] = now;
                data[i] = def == null ? 0 : def[i];
            }
        }

        public void set(int i, int v) {
            version[i] = now;
            data[i] = v;
        }

        public int get(int i) {
            visit(i);
            return data[i];
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                if (version[i] < now) {
                    continue;
                }
                builder.append(i).append(':').append(data[i]).append(',');
            }
            if (builder.length() > 0) {
                builder.setLength(builder.length() - 1);
            }
            return builder.toString();
        }

    }

    static class Node {
        List<Node> adj = new ArrayList<>();
        int h;
        int sg = -1;

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

        public int ri() {
            return readInt();
        }

        public int readInt() {
            boolean rev = false;

            skipBlank();
            if (next == '+' || next == '-') {
                rev = next == '-';
                next = read();
            }

            int val = 0;
            while (next >= '0' && next <= '9') {
                val = val * 10 - next + '0';
                next = read();
            }

            return rev ? val : -val;
        }

    }

    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private static final int THRESHOLD = 32 << 10;
        private OutputStream writer;
        private StringBuilder cache = new StringBuilder(THRESHOLD * 2);
        private static Field stringBuilderValueField;
        private char[] charBuf = new char[THRESHOLD * 2];
        private byte[] byteBuf = new byte[THRESHOLD * 2];

        static {
            try {
                stringBuilderValueField = StringBuilder.class.getSuperclass().getDeclaredField("value");
                stringBuilderValueField.setAccessible(true);
            } catch (Exception e) {
                stringBuilderValueField = null;
            }
            stringBuilderValueField = null;
        }

        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }

        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }

        private void afterWrite() {
            if (cache.length() < THRESHOLD) {
                return;
            }
            flush();
        }

        public FastOutput(OutputStream writer) {
            this.writer = writer;
        }

        public FastOutput append(char c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(int c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput append(String c) {
            cache.append(c);
            afterWrite();
            return this;
        }

        public FastOutput println(String c) {
            return append(c).println();
        }

        public FastOutput println() {
            return append('\n');
        }

        public FastOutput flush() {
            try {
                if (stringBuilderValueField != null) {
                    try {
                        byte[] value = (byte[]) stringBuilderValueField.get(cache);
                        writer.write(value, 0, cache.length());
                    } catch (Exception e) {
                        stringBuilderValueField = null;
                    }
                }
                if (stringBuilderValueField == null) {
                    int n = cache.length();
                    if (n > byteBuf.length) {
                        //slow
                        writer.write(cache.toString().getBytes(StandardCharsets.UTF_8));
//                writer.append(cache);
                    } else {
                        cache.getChars(0, n, charBuf, 0);
                        for (int i = 0; i < n; i++) {
                            byteBuf[i] = (byte) charBuf[i];
                        }
                        writer.write(byteBuf, 0, n);
                    }
                }
                writer.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }

        public void close() {
            flush();
            try {
                writer.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        public String toString() {
            return cache.toString();
        }

    }
}

