import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.Vector;

import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class cfa {

    @SuppressWarnings("unused")
    private static final int MOD = (int) (1e9 + 7), MOD_FFT = 998244353;
    private static final Reader r = new Reader();
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final boolean thread = false;
    private static final boolean HAS_TEST_CASES = false;
    private static final int SCAN_LINE_LENGTH = 1000002;

    static int n, a[], e[][];

    static void solve() throws Exception {
        n = ni();
        int k = ni(), k1 = k, k2 = k;
        int[] t = new int[n], a = new int[n], b = new int[n];
        for (int i = 0; i < b.length; i++) {
            t[i] = ni();
            a[i] = ni();
            b[i] = ni();
        }
        Vector<Integer> v = new Vector<>(), v1 = new Vector<>(), v2 = new Vector<>();
        for (int i = 0; i < b.length; i++) {
            if (a[i] == 1 && b[i] == 1)
                v.add(t[i]);
            else if (a[i] == 1) {
                v1.add(t[i]);
            } else if (b[i] == 1)
                v2.add(t[i]);
        }
        sort(v);
        sort(v1);
        sort(v2);
        long ans = 0;
        int i = 0, j = 0;
        while (k1 > 0 || k2 > 0) {
            if (i < v.size() && j < v1.size() && j < v2.size() && v.get(i) <= (v1.get(j) + v2.get(j))) {
                {
                    ans += v.get(i++);
                    k1--;
                    k2--;
                }
            } else if (j < v1.size() && j < v2.size()) {
                {
                    ans += v1.get(j) + v2.get(j++);
                    k1--;
                    k2--;
                }
            }
            if (i == v.size()) {
                while (k1 > 0 || k2 > 0) {
                    ans += v1.get(j) + v2.get(j++);
                    k1--;
                    k2--;
                }
            } else if (j == v1.size() || j == v2.size())
                while (k1 > 0 || k2 > 0) {
                    ans += v.get(i++);
                    k1--;
                    k2--;
                }
        }
        pn(ans);

    }

    private static void dfc(int[] visited, int i, int c) {
        visited[i] = c % 2;
        for (Integer j : adj[i]) {
            if (visited[j] == c % 2)
                visited[i] = 3;
            else if (visited[j] == -1) {
                dfc(visited, j, c + 1);
            }
        }
    }

    static int dfs(int[] v, int i, int d, int k, Vector<Integer> path) {
        if (v[i] != 0) {
            if (d - v[i] <= 2) {
                return 0;
            }
            if (d - v[i] <= k) {
                pn(2);
                pn(d - v[i]);
                for (int j = v[i] - 1; j < path.size(); j++) {
                    p(path.get(j) + " ");
                }
                pn();
                return 1;
            } else {
                pn(1);
                for (int j = v[i] - 1; j < (k + 1) / 2; ++j) {
                    p(path.get(j * 2) + " ");
                }
                pn();
                return 1;
            }
        }
        v[i] = d;
        path.add(i);
        for (Integer j : adj[i]) {
            if (v[j] > 0 && d - v[j] > 1 && dfs(v, j, d + 1, k, path) == 1)
                return 1;
        }
        for (Integer j : adj[i]) {
            if (dfs(v, j, d + 1, k, path) == 1)
                return 1;
        }
        path.remove(path.size() - 1);
        return 0;
    }

    @SuppressWarnings("unused")
    private static Vector<Integer> adj[], v;
    @SuppressWarnings("unused")
    private static HashSet<Integer> set;
    @SuppressWarnings("unused")
    private static PriorityQueue<Integer> pq;

    private static void addEdge(final int u, final int v) {
        adj[u] = (adj[u] == null) ? new Vector<>() : adj[u];
        adj[v] = (adj[v] == null) ? new Vector<>() : adj[v];
        adj[u].add(v);
        adj[v].add(u);
    }

    public static void main(final String[] args) throws Exception {
        if (!thread) {
            final int testcases = HAS_TEST_CASES ? ni() : 1;
            for (int i = 1; i <= testcases; i++) {
                // out.print("Case #" + (i + 1) + ": ");
                try {
                    solve();
                } catch (final Exception e) {
                    pn(-1);
                }
            }
            out.flush();
            r.close();
            out.close();
        }
    }

    @SuppressWarnings("unused")
    private static void swap(final int i, final int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @SuppressWarnings("unused")
    private static int gcd(final int a, final int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    @SuppressWarnings("unused")
    private static class Pair<T, E> implements Comparable<Pair<T, E>> {
        T fir;
        E snd;

        Pair() {
        }

        Pair(final T x, final E y) {
            this.fir = x;
            this.snd = y;
        }

        @Override
        @SuppressWarnings("unchecked")
        public int compareTo(final Pair<T, E> o) {
            final int c = ((Comparable<T>) fir).compareTo(o.fir);
            return c != 0 ? c : ((Comparable<E>) snd).compareTo(o.snd);
        }

    }

    @SuppressWarnings("unused")
    private static class pi implements Comparable<pi> {
        int fir, snd;

        pi() {
        }

        pi(final int a, final int b) {
            fir = a;
            snd = b;
        }

        public int compareTo(final pi o) {
            return fir == o.fir ? snd - o.snd : fir - o.fir;
        }

    }

    @SuppressWarnings("unused")
    private static <T> void checkV(final Vector<T> adj[], final int i) {
        adj[i] = adj[i] == null ? new Vector<>() : adj[i];
    }

    @SuppressWarnings("unused")
    private static int[] na(final int n) throws Exception {
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    @SuppressWarnings("unused")
    private static int[] na1(final int n) throws Exception {
        final int[] a = new int[n + 1];
        for (int i = 1; i < a.length; i++) {
            a[i] = ni();
        }
        return a;
    }

    @SuppressWarnings("unused")
    private static String n() throws IOException {
        return r.readToken();
    }

    @SuppressWarnings("unused")
    private static String nln() throws IOException {
        return r.readLine();
    }

    private static int ni() throws IOException {
        return r.nextInt();
    }

    @SuppressWarnings("unused")
    private static long nl() throws IOException {
        return r.nextLong();
    }

    @SuppressWarnings("unused")
    private static double nd() throws IOException {
        return r.nextDouble();
    }

    @SuppressWarnings("unused")
    private static void p(final Object o) {
        out.print(o);
    }

    @SuppressWarnings("unused")
    private static void pn(final Object o) {
        out.println(o);
    }

    @SuppressWarnings("unused")
    private static void pn() {
        out.println("");
    }

    private static void pni(final Object o) {
        out.println(o);
        out.flush();
    }

    private static class Reader {
        private final int BUFFER_SIZE = 1 << 17;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        // private StringTokenizer st;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        @SuppressWarnings("unused")
        public Reader(final String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        final byte[] buf = new byte[SCAN_LINE_LENGTH];

        public String readLine() throws IOException {
            int cnt = 0;
            int c;
            o: while ((c = read()) != -1) {
                if (c == '\n')
                    if (cnt == 0)
                        continue o;
                    else
                        break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String readToken() throws IOException {
            int cnt = 0;
            int c;
            o: while ((c = read()) != -1) {
                if (!(c >= 33 && c <= 126))
                    if (cnt == 0)
                        continue o;
                    else
                        break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static {
        if (thread)
            new Thread(null, new Runnable() {
                @Override
                public void run() {
                    try {
                        final int testcases = HAS_TEST_CASES ? ni() : 1;
                        for (int i = 1; i <= testcases; i++) {
                            // out.print("Case #" + (i + 1) + ": ");
                            try {
                                solve();
                            } catch (final Exception e) {
                                e.printStackTrace(System.err);
                                System.exit(-1);
                            }
                        }
                        out.flush();
                        r.close();
                        out.close();
                    } catch (final Throwable t) {
                        t.printStackTrace(System.err);
                        System.exit(-1);
                    }
                }
            }, "rec", (1L << 28)).start();
    }

    @SuppressWarnings({ "unchecked", "unused" })
    private static <T> T deepCopy(final T old) {
        try {
            return (T) deepCopyObject(old);
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
        return null;
    }

    private static Object deepCopyObject(final Object oldObj) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream(); // A
            oos = new ObjectOutputStream(bos); // B
            // serialize and pass the object
            oos.writeObject(oldObj); // C
            oos.flush(); // D
            final ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray()); // E
            ois = new ObjectInputStream(bin); // F
            // return the new object
            return ois.readObject(); // G
        } catch (final ClassNotFoundException e) {
            pni("Exception in ObjectCloner = " + e);
            throw (e);
        } finally {
            oos.close();
            ois.close();
        }
    }

}