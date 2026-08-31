import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.io.Writer;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author cplayer
 */
public class Main {
    public static void main (String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        FDestroyIt solver = new FDestroyIt();
        solver.solve(1, in, out);
        out.close();
    }

    static class FDestroyIt {
        private int cardType = 3;
        private int ddMod = 10;
        private long dp[][];
        private List<Integer> cards[] = new ArrayList[cardType + 1];
        private int listLen[] = {0, 3, 1, 1};
        private List<IntIntPair> remainCards = new ArrayList<>();
        private IntArrayList permuataion;
        private long infinity = IntegerUtils.power(10L, 18);
        private long minusinfinity = -infinity;

        public void solve (int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            dp = new long[n + 1][ddMod];
            // 填写初值
            ArrayUtils.fill(dp, minusinfinity);
            dp[0][0] = 0;
            for (int i = 1; i <= cardType; ++i) {
                cards[i] = new ArrayList<>();
            }
            for (int turn = 1; turn <= n; ++turn) {
                // 对于每回合，先保留对应的卡片
                int cardNum = in.readInt();
                // 记得清空已读入的卡片
                for (int i = 1; i <= cardType; ++i) {
                    cards[i].clear();
                }
                for (int i = 0; i < cardNum; ++i) {
                    int costCard = in.readInt(), damageCard = in.readInt();
                    cards[costCard].add(damageCard);
                }
                for (int i = 1; i <= cardType; ++i) {
                    cards[i].sort(Comparator.reverseOrder());
                }
                // 把卡片整合起来
                remainCards.clear();
                for (int i = 1; i <= cardType; ++i) {
                    for (int j = 0; j < Math.min(cards[i].size(), listLen[i]); ++j) {
                        remainCards.add(new IntIntPair(i, cards[i].get(j)));
                    }
                }
                // 然后计算所有的可能性
                permuataion = new IntArrayList(remainCards.size());
                for (int i = 0; i < remainCards.size(); ++i) {
                    permuataion.add(i);
                }
                // 辅助dp，计算cost = i的时候的最大damage
                long dpSup[][] = new long[cardType + 1][2];
                ArrayUtils.fill(dpSup, minusinfinity);
                dpSup[0][0] = 0;
                do {
                    // 全排列前缀覆盖了所有可能取的卡片集合
                    int mxCost = 3;
                    long score = 0;
                    long mx = 0;
                    for (int i = 0; i < permuataion.size(); ++i) {
                        IntIntPair currentCard = remainCards.get(permuataion.get(i));
                        if (mxCost >= currentCard.first) {
                            mxCost -= currentCard.first;
                            mx = Math.max(mx, currentCard.second);
                            score += currentCard.second;
                            dpSup[i + 1][0] = Math.max(dpSup[i + 1][0], score);
                            // 加倍当前卡片
                            dpSup[i + 1][1] = Math.max(dpSup[i + 1][1], score + mx);
                        } else {
                            break;
                        }
                    }
                } while (permuataion.nextPermutation());

                // 状态转移
                for (int i = 0; i < ddMod; ++i) {
                    for (int j = 0; j <= cardType; ++j) {
                        int nxt = (i + j) % 10;
                        int flag = (i + j >= 10 ? 1 : 0);
                        dp[turn][nxt] =
                                Math.max(dp[turn][nxt],
                                        dp[turn - 1][i] + dpSup[j][flag]);
                        // 最后的flag部分不对
                        // dp[turn][(i + j) % ddMod] = Math.max(dp[turn][(i + j) % ddMod],
                        //         dp[turn - 1][i] + dpSup[j][(i + j) == 0 ? 1 : 0]);
                    }
                }
            }
            long maxValue = minusinfinity;
            for (int i = 0; i < ddMod; ++i) {
                maxValue = Math.max(dp[n][i], maxValue);
            }
            out.println(maxValue);
        }

    }

    static class IntIntPair implements Comparable<IntIntPair> {
        public int first;
        public int second;

        public IntIntPair (int first, int second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals (Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            IntIntPair pair = (IntIntPair) o;

            return first == pair.first && second == pair.second;
        }

        public int hashCode () {
            int result = first;
            result = 31 * result + second;
            return result;
        }

        public String toString () {
            return "(" + first + "," + second + ")";
        }

        public int compareTo (IntIntPair o) {
            int value = Integer.compare(first, o.first);
            if (value != 0) {
                return value;
            }
            return Integer.compare(second, o.second);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter (OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter (Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close () {
            writer.close();
        }

        public void println (long i) {
            writer.println(i);
        }

    }

    static interface IntStream extends Iterable<Integer>, Comparable<IntStream> {
        public IntIterator intIterator ();

        default public Iterator<Integer> iterator () {
            return new Iterator<Integer>() {
                private IntIterator it = intIterator();

                public boolean hasNext () {
                    return it.isValid();
                }

                public Integer next () {
                    int result = it.value();
                    it.advance();
                    return result;
                }
            };
        }

        default public int compareTo (IntStream c) {
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

    static interface IntCollection extends IntStream {
        public int size ();

        default public void add (int value) {
            throw new UnsupportedOperationException();
        }

        default public IntCollection addAll (IntStream values) {
            for (IntIterator it = values.intIterator(); it.isValid(); it.advance()) {
                add(it.value());
            }
            return this;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader (InputStream stream) {
            this.stream = stream;
        }

        public int read () {
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

        public int readInt () {
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

        public boolean isSpaceChar (int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace (int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar (int ch);

        }

    }

    static abstract class IntAbstractStream implements IntStream {
        public String toString () {
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

        public boolean equals (Object o) {
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

        public int hashCode () {
            int result = 0;
            for (IntIterator it = intIterator(); it.isValid(); it.advance()) {
                result *= 31;
                result += it.value();
            }
            return result;
        }

    }

    static class ArrayUtils {
        public static void fill (long[][] array, long value) {
            for (long[] row : array) {
                Arrays.fill(row, value);
            }
        }

    }

    static interface IntReversableCollection extends IntCollection {
    }

    static class IntegerUtils {
        public static long power (long base, long exponent) {
            if (exponent == 0) {
                return 1;
            }
            long result = power(base, exponent >> 1);
            result = result * result;
            if ((exponent & 1) != 0) {
                result = result * base;
            }
            return result;
        }

    }

    static class IntArrayList extends IntAbstractStream implements IntList {
        private int size;
        private int[] data;

        public IntArrayList () {
            this(3);
        }

        public IntArrayList (int capacity) {
            data = new int[capacity];
        }

        public IntArrayList (IntCollection c) {
            this(c.size());
            addAll(c);
        }

        public IntArrayList (IntStream c) {
            this();
            if (c instanceof IntCollection) {
                ensureCapacity(((IntCollection) c).size());
            }
            addAll(c);
        }

        public IntArrayList (IntArrayList c) {
            size = c.size();
            data = c.data.clone();
        }

        public IntArrayList (int[] arr) {
            size = arr.length;
            data = arr.clone();
        }

        public int size () {
            return size;
        }

        public int get (int at) {
            if (at >= size) {
                throw new IndexOutOfBoundsException("at = " + at + ", size = " + size);
            }
            return data[at];
        }

        private void ensureCapacity (int capacity) {
            if (data.length >= capacity) {
                return;
            }
            capacity = Math.max(2 * data.length, capacity);
            data = Arrays.copyOf(data, capacity);
        }

        public void addAt (int index, int value) {
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

        public void removeAt (int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("at = " + index + ", size = " + size);
            }
            if (index != size - 1) {
                System.arraycopy(data, index + 1, data, index, size - index - 1);
            }
            size--;
        }

        public void set (int index, int value) {
            if (index >= size) {
                throw new IndexOutOfBoundsException("at = " + index + ", size = " + size);
            }
            data[index] = value;
        }

    }

    static interface IntIterator {
        public int value () throws NoSuchElementException;

        public boolean advance ();

        public boolean isValid ();

    }

    static interface IntList extends IntReversableCollection {
        public abstract int get (int index);

        public abstract void set (int index, int value);

        public abstract void addAt (int index, int value);

        public abstract void removeAt (int index);

        default public void swap (int first, int second) {
            if (first == second) {
                return;
            }
            int temp = get(first);
            set(first, get(second));
            set(second, temp);
        }

        default public IntIterator intIterator () {
            return new IntIterator() {
                private int at;
                private boolean removed;

                public int value () {
                    if (removed) {
                        throw new IllegalStateException();
                    }
                    return get(at);
                }

                public boolean advance () {
                    at++;
                    removed = false;
                    return isValid();
                }

                public boolean isValid () {
                    return !removed && at < size();
                }

                public void remove () {
                    removeAt(at);
                    at--;
                    removed = true;
                }
            };
        }

        default public void add (int value) {
            addAt(size(), value);
        }

        default public boolean nextPermutation () {
            return nextPermutation(IntComparator.DEFAULT);
        }

        default public boolean nextPermutation (IntComparator comparator) {
            int size = size();
            int last = get(size - 1);
            for (int i = size - 2; i >= 0; i--) {
                int current = get(i);
                if (comparator.compare(last, current) > 0) {
                    for (int j = size - 1; j > i; j--) {
                        if (comparator.compare(get(j), current) > 0) {
                            swap(i, j);
                            subList(i + 1, size).inPlaceReverse();
                            return true;
                        }
                    }
                }
                last = current;
            }
            return false;
        }

        default public void inPlaceReverse () {
            for (int i = 0, j = size() - 1; i < j; i++, j--) {
                swap(i, j);
            }
        }

        default public IntList subList (final int from, final int to) {
            return new IntList() {
                private final int shift;
                private final int size;

                {
                    if (from < 0 || from > to || to > IntList.this.size()) {
                        throw new IndexOutOfBoundsException("from = " + from + ", to = " + to + ", size = " + size());
                    }
                    shift = from;
                    size = to - from;
                }

                public int size () {
                    return size;
                }

                public int get (int at) {
                    if (at < 0 || at >= size) {
                        throw new IndexOutOfBoundsException("at = " + at + ", size = " + size());
                    }
                    return IntList.this.get(at + shift);
                }

                public void addAt (int index, int value) {
                    throw new UnsupportedOperationException();
                }

                public void removeAt (int index) {
                    throw new UnsupportedOperationException();
                }

                public void set (int at, int value) {
                    if (at < 0 || at >= size) {
                        throw new IndexOutOfBoundsException("at = " + at + ", size = " + size());
                    }
                    IntList.this.set(at + shift, value);
                }

                public IntList compute () {
                    return new IntArrayList(this);
                }
            };
        }

    }

    static interface IntComparator {
        public static final IntComparator DEFAULT = (first, second) -> {
            if (first < second) {
                return -1;
            }
            if (first > second) {
                return 1;
            }
            return 0;
        };

        public int compare (int first, int second);

    }
}

