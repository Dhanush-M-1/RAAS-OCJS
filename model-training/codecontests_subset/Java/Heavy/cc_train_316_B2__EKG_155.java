import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Locale;
import java.io.OutputStream;
import java.util.RandomAccess;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.io.Writer;
import java.util.List;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.math.BigInteger;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Jacob Jiang
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB1 solver = new TaskB1();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB1 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int myIndex = in.nextInt() - 1;
        int[] front = in.nextIntArray(n);
        ArrayUtils.decreaseByOne(front);
        final int[] size = new int[n];
        Arrays.fill(size, 1);
        UnionFindSet unionFindSet = new UnionFindSet(n, new UnionFindSet.ActionListener() {
            public void union(int father, int son) {
                size[father] += size[son];
            }

            public void update(int son, int oldFather, int newFather) {
            }
        });
        for (int i = 0; i < n; i++) {
            if (front[i] != -1) {
                unionFindSet.union(i, front[i]);
            }
        }
        IntArrayBuilder builder = new IntArrayBuilder();
        int myParent = unionFindSet.find(myIndex);
        for (int i = 0; i < n; i++) {
            if (i == unionFindSet.find(i) && i != myParent) {
                builder.append(size[i]);
            }
        }
        int delta = 1;
        while (front[myIndex] != -1) {
            myIndex = front[myIndex];
            delta++;
        }
        solve(out, builder.toIntArray(), delta, n);
    }

    private void solve(OutputWriter out, int[] possible, int delta, int n) {
        boolean[] can = new boolean[n + 1];
        can[0] = true;
        for (int item : possible) {
            for (int i = n; i >= item; i--) {
                can[i] |= can[i - item];
            }
        }
        for (int i = 0; i <= n; i++) {
            if (can[i])
                out.println(i + delta);
        }
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c & 15;
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public int[] nextIntArray(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nextInt();
        }
        return result;
    }

    }

class OutputWriter {
    private PrintWriter writer;

    public OutputWriter(OutputStream stream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void println(int i) {
        writer.println(i);
    }

    public void close() {
        writer.close();
    }

    }

class ArrayUtils {



    public static void decreaseByOne(int[]... arrays) {
        for (int[] array : arrays) {
            for (int i = 0; i < array.length; i++) {
                array[i]--;
            }
        }
    }



    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }
}

class UnionFindSet {
    public int[] parent;
    private int setCount;
    private ActionListener listener;

    public UnionFindSet(int count, ActionListener listener) {
        this(count);
        this.listener = listener;
    }

    public UnionFindSet(int count) {
        if (count < 0)
            throw new IllegalArgumentException();
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
        setCount = count;
    }

    public int find(int item) {
        if (parent[item] == item) {
            return item;
        } else {
            int newFather = find(parent[item]);
            if (listener != null && parent[item] != newFather)
                listener.update(item, parent[item], newFather);
            return parent[item] = newFather;
        }
    }

    public void union(int father, int son) {
        int pa = find(father), pb = find(son);
        if (pa != pb) {
            parent[pb] = pa;
            if (listener != null)
                listener.union(pa, pb);
            setCount--;
        }
    }

    public static interface ActionListener {
        void union(int father, int son);

        void update(int son, int oldFather, int newFather);
    }
}

class IntArrayBuilder {
    int[] data;
    int length;
    int capacity;

    public IntArrayBuilder() {
        this(16);
    }

    public IntArrayBuilder(int initialCapacity) {
        this.capacity = initialCapacity;
        length = 0;
        data = new int[initialCapacity];
    }

    private void ensureCapacity(int neededCapacity) {
        while (neededCapacity > capacity) {
            capacity = (capacity << 1) + 1;
        }
        if (data.length < capacity) {
            data = ArrayUtils.copyOf(data, capacity);
        }
    }

    public IntArrayBuilder append(int item) {
        ensureCapacity(length + 1);
        data[length++] = item;
        return this;
    }

    public int[] toIntArray() {
        return ArrayUtils.copyOf(data, length);
    }


}

