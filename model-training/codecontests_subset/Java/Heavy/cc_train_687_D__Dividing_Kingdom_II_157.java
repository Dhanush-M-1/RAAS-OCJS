import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        TaskD.DSU dsu;
        IntArrayList[] tree;
        int[] A;
        int[] B;
        int[] W;
        int answer;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            int q = in.readInt();

            A = new int[m];
            B = new int[m];
            W = new int[m];
            IOUtils.readIntArrays(in, A, B, W);
            MiscUtils.decreaseByOne(A, B);
        /**/

            dsu = new TaskD.DSU(n);
            tree = new IntArrayList[Integer.highestOneBit(m) << 2];
            init(0, 0, m - 1);

            for (int iter = 0; iter < q; iter++) {
                int l = in.readInt() - 1;
                int r = in.readInt() - 1;

                trimw(getAns(l, r, 0, 0, m - 1));
                out.printLine(answer);
            }
        }

        private IntArrayList getAns(int l, int r, int v, int tl, int tr) {
            if (l > r) {
                return null;
            }

            IntArrayList res;
            if (l == tl && r == tr) {
                res = tree[v];
            } else {
                int tm = (tl + tr) / 2;
                res = unit(
                        getAns(l, Math.min(r, tm), 2 * v + 1, tl, tm),
                        getAns(Math.max(l, tm + 1), r, 2 * v + 2, tm + 1, tr));

            }
            return res;
        }

        private void init(int v, int tl, int tr) {
            tree[v] = new IntArrayList();
            if (tl == tr) {
                tree[v].add(tl);
            } else {
                int tm = (tl + tr) / 2;
                init(2 * v + 1, tl, tm);
                init(2 * v + 2, tm + 1, tr);

                tree[v] = unit(tree[2 * v + 1], tree[2 * v + 2]);
            }
        }

        private IntArrayList unit(IntArrayList l, IntArrayList r) {
            if (l == null) {
                return r;
            }
            if (r == null) {
                return l;
            }

            IntArrayList c = new IntArrayList(l.size() + r.size());
            int posL = 0;
            int posR = 0;
            while (posL < l.size() && posR < r.size()) {
                int ll = l.get(posL);
                int rr = r.get(posR);
                if (W[ll] > W[rr]) {
                    c.add(ll);
                    ++posL;
                } else {
                    c.add(rr);
                    ++posR;
                }
            }
            while (posL < l.size()) {
                int ll = l.get(posL);
                c.add(ll);
                ++posL;
            }
            while (posR < r.size()) {
                int rr = r.get(posR);
                c.add(rr);
                ++posR;
            }

            return trimw(c);
        }

        private IntArrayList trimw(IntArrayList c) {
            for (int id : c) {
                dsu.clear(A[id]);
                dsu.clear(B[id]);
            }

            answer = -1;
            IntArrayList res = new IntArrayList();
            for (int i = 0; i < c.size(); i++) {
                int id = c.get(i);
                int unit = dsu.unit(A[id], B[id]);

                if (unit == 0 || unit == 2) {
                    res.add(id);
                }

                if (unit == 0) {
                    answer = W[id];
                    for (int j = c.size() - 1; i + 1 <= j; j--) {
                        c.removeAt(j);
                    }
                    break;
                }
            }
            return res;
        }

        static class DSU {
            int[] parent;
            int[] addToAllChildren;
            int[] size;
            int[] sum = new int[32];
            int[] curV = new int[32];

            DSU(int n) {
                parent = new int[n];
                addToAllChildren = new int[n];
                size = new int[n];

                clear();
            }

            void clear() {
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                    addToAllChildren[i] = 0;
                    size[i] = 1;
                }
            }

            public void clear(int i) {
                parent[i] = i;
                addToAllChildren[i] = 0;
                size[i] = 1;
            }

            int getLeader(int v) {
                int index = 0;
                curV[index] = v;
                int leader;
                for (; ; ) {
                    v = curV[index];
                    if (v == parent[v]) {
                        sum[index] = addToAllChildren[v];
                        leader = v;
                        break;
                    } else {
                        curV[index + 1] = parent[v];
                        ++index;
                    }
                }

                int addToAllChild_leader = addToAllChildren[leader];

                --index;
                for (; 0 <= index; --index) {
                    v = curV[index];
                    parent[v] = leader;
                    addToAllChildren[v] = (sum[index] = sum[index + 1] ^ addToAllChildren[v]) ^ addToAllChild_leader;
                }

                return leader;


//            if (v == parent[v]) {
//                sum[index] = addToAllChildren[v];
//                return v;
//            } else {
////                int leader = parent[v] = getLeader(index + 1, parent[v]);
////                addToAllChildren[v] = (sum[index] = sum[index + 1] ^ addToAllChildren[v]) ^ addToAllChildren[leader];
//
//                int leader = getLeader(index + 1, parent[v]);
//                sum[index] = sum[index + 1] ^ addToAllChildren[v];
//
//                return leader;
//            }
            }

            int unit(int a, int b) {
                int pa = getLeader(a);
                int colorA = sum[0];
                int pb = getLeader(b);
                int colorB = sum[0];

                if (pa == pb) {
                    if (colorA == colorB) {
                        return 0;
                    } else {
                        return 1;
                    }
                }

                if (size[pa] > size[pb]) {
                    int t = pa;
                    pa = pb;
                    pb = t;
                }

                if (colorA == colorB) {
                    addToAllChildren[pa] ^= 1;
                }
                parent[pa] = pb;
                size[pb] += size[pa];
                return 2;
            }

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

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }

    static class IOUtils {
        public static void readIntArrays(InputReader in, int[]... arrays) {
            for (int i = 0; i < arrays[0].length; i++) {
                for (int j = 0; j < arrays.length; j++) {
                    arrays[j][i] = in.readInt();
                }
            }
        }

    }

    static class IntArrayList extends IntAbstractStream implements IntList {
        private int size;
        private int[] data;

        public IntArrayList() {
            this(3);
        }

        public IntArrayList(int capacity) {
            data = new int[capacity];
        }

        public IntArrayList(IntCollection c) {
            this(c.size());
            addAll(c);
        }

        public IntArrayList(IntStream c) {
            this();
            if (c instanceof IntCollection) {
                ensureCapacity(((IntCollection) c).size());
            }
            addAll(c);
        }

        public IntArrayList(IntArrayList c) {
            size = c.size();
            data = c.data.clone();
        }

        public IntArrayList(int[] arr) {
            size = arr.length;
            data = arr.clone();
        }

        public int size() {
            return size;
        }

        public int get(int at) {
            if (at >= size) {
                throw new IndexOutOfBoundsException("at = " + at + ", size = " + size);
            }
            return data[at];
        }

        private void ensureCapacity(int capacity) {
            if (data.length >= capacity) {
                return;
            }
            capacity = Math.max(2 * data.length, capacity);
            data = Arrays.copyOf(data, capacity);
        }

        public void addAt(int index, int value) {
            ensureCapacity(size + 1);
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException("at = " + index + ", size = " + size);
            }
            if (index != size) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            data[index] = value;
            size++;
        }

        public void removeAt(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("at = " + index + ", size = " + size);
            }
            if (index != size - 1) {
                System.arraycopy(data, index + 1, data, index, size - index - 1);
            }
            size--;
        }

    }

    static class MiscUtils {
        public static void decreaseByOne(int[]... arrays) {
            for (int[] array : arrays) {
                for (int i = 0; i < array.length; i++) {
                    array[i]--;
                }
            }
        }

    }

    static abstract class IntAbstractStream implements IntStream {

        public String toString() {
            StringBuilder builder = new StringBuilder();
            boolean first = true;
            for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
                if (first) {
                    first = false;
                } else {
                    builder.append(' ');
                }
                builder.append(it.value());
            }
            return builder.toString();
        }


        public boolean equals(Object o) {
            if (!(o instanceof IntStream)) {
                return false;
            }
            IntStream c = (IntStream) o;
            IntIterator it = intIterator();
            IntIterator jt = c.intIterator();
            while (it.isValid() && jt.isValid()) {
                if (it.value() != jt.value()) {
                    return false;
                }
                it.advance();
                jt.advance();
            }
            return !it.isValid() && !jt.isValid();
        }


        public int hashCode() {
            int result = 0;
            for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
                result *= 31;
                result += it.value();
            }
            return result;
        }

    }

    static interface IntCollection extends IntStream {
        public int size();

        default public void add(int value) {
            throw new UnsupportedOperationException();
        }

        default public IntCollection addAll(IntStream values) {
            for (IntIterator it = values.intIterator(); it.isValid(); it.advance()) {
                add(it.value());
            }
            return this;
        }

    }

    static interface IntReversableCollection extends IntCollection {
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

    static interface IntIterator {
        public int value() throws NoSuchElementException;

        public boolean advance();

        public boolean isValid();

    }

    static interface IntList extends IntReversableCollection {
        public abstract int get(int index);

        public abstract void addAt(int index, int value);

        public abstract void removeAt(int index);

        default public IntIterator intIterator() {
            return new IntIterator() {
                private int at;
                private boolean removed;

                public int value() {
                    if (removed) {
                        throw new IllegalStateException();
                    }
                    return get(at);
                }

                public boolean advance() {
                    at++;
                    removed = false;
                    return isValid();
                }

                public boolean isValid() {
                    return !removed && at < size();
                }

                public void remove() {
                    removeAt(at);
                    at--;
                    removed = true;
                }
            };
        }


        default public void add(int value) {
            addAt(size(), value);
        }

    }

    static interface IntStream extends Iterable<Integer>, Comparable<IntStream> {
        public IntIterator intIterator();

        default public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private IntIterator it = intIterator();

                public boolean hasNext() {
                    return it.isValid();
                }

                public Integer next() {
                    int result = it.value();
                    it.advance();
                    return result;
                }
            };
        }

        default public int compareTo(IntStream c) {
            IntIterator it = intIterator();
            IntIterator jt = c.intIterator();
            while (it.isValid() && jt.isValid()) {
                int i = it.value();
                int j = jt.value();
                if (i < j) {
                    return -1;
                } else if (i > j) {
                    return 1;
                }
                it.advance();
                jt.advance();
            }
            if (it.isValid()) {
                return 1;
            }
            if (jt.isValid()) {
                return -1;
            }
            return 0;
        }

    }
}

