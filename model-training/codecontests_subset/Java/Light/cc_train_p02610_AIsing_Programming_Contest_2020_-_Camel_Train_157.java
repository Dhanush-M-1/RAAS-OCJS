import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        int t = nextInt(sc);
        while (t --> 0) {
            int n = nextInt(sc);
            long[][] klr = new long[n][3];
            long a = 0;
            int lc = 0, rc = 0;
            for (int i = 0; i < n; i++) {
                long k = nextInt(sc) - 1;
                long l = nextLong(sc);
                long r = nextLong(sc);
                long m = Math.min(l, r);
                a += m;
                l -= m;
                r -= m;
                if (l == 0) {
                    rc++;
                } else {
                    lc++;
                }
                klr[i][0] = k;
                klr[i][1] = l;
                klr[i][2] = r;
            }
            Arrays.sort(klr, (u, v) -> Long.compare(u[0], v[0]));
            int[] ll = new int[lc];
            int[] rl = new int[rc];
            int li = 0, ri = rc;
            for (int i = 0; i < n; i++) {
                if (klr[i][1] == 0) {
                    rl[--ri] = i;
                } else {
                    ll[li++] = i;
                }
            }
            IntPriorityQueue lpq = new IntPriorityQueue((i, j) -> {
                if (klr[i][1] == klr[j][1]) {
                    return i - j;
                } else {
                    return Long.compare(klr[i][1], klr[j][1]);
                }
            });
            IntPriorityQueue rpq = new IntPriorityQueue((i, j) -> {
                if (klr[i][2] == klr[j][2]) {
                    return i - j;
                } else {
                    return Long.compare(klr[i][2], klr[j][2]);
                }
            });
            int lli = 0, llj = 0;
            int lpc = 0;
            while (lli < lc) {
                llj = (int) klr[ll[lli]][0];
                while (lli < lc && klr[ll[lli]][0] == llj) {
                    lpq.push(ll[lli]);
                    lli++;
                    lpc++;
                }
                if (lpc > llj + 1) {
                    int d = lpc - llj - 1;
                    while (d --> 0) {
                        lpq.pop();
                        lpc--;
                    }
                }
            }
            for (int i = 0; i < rc; i++) {
                klr[rl[i]][0] = n - klr[rl[i]][0] - 2;
            }
            int rli = 0, rlj = 0;
            int rpc = 0;
            while (rli < rc) {
                rlj = (int) klr[rl[rli]][0];
                while (rli < rc && klr[rl[rli]][0] == rlj) {
                    rpq.push(rl[rli]);
                    rli++;
                    rpc++;
                }
                if (rpc > rlj + 1) {
                    int d = rpc - rlj - 1;
                    while (d --> 0) {
                        rpq.pop();
                        rpc--;
                    }
                }
            }
            while (lpq.size() > 0) {
                a += klr[lpq.pop()][1];
            }
            while (rpq.size() > 0) {
                a += klr[rpq.pop()][2];
            }
            sb.append(a).append('\n');
        }
        pw.write(sb.toString());
        pw.flush();
        pw.close();
    }

    public static int nextInt(Scanner sc) {
        return Integer.parseInt(sc.next());
    }
    public static long nextLong(Scanner sc) {
        return Long.parseLong(sc.next());
    }
}

class IntArrayList implements Iterable<Integer> {

    static final int DEFAULT_CAPACITY = 64;

    int[] a;
    int tail = 0;
    
    public IntArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.a = new int[capacity];
    }

    public IntArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(int v) {
        if (tail == a.length) grow();
        a[tail++] = v;
    }

    public int removeLast() {
        if (tail == 0) throw new NoSuchElementException();
        return a[--tail];
    }

    public int get(final int i) {
        if (i < 0 || i >= tail) throw new IndexOutOfBoundsException("Index " + i + " out of bounds for length " + size());
        return a[i];
    }

    public void set(final int i, final int v) {
        if (i < 0 || i >= tail) throw new IndexOutOfBoundsException("Index " + i + " out of bounds for length " + size());
        a[i] = v;
    }

    void grow() {
        int[] b = new int[a.length << 1];
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
    }

    public int size() {
        return tail;
    }

    public void clear() {
        tail = 0;
    }

    public void reverse(int fromIndex, int toIndex) {
        int l = fromIndex, r = toIndex - 1;
        while (l < r) {
            int tmp = a[l]; a[l] = a[r]; a[r] = tmp;
            l++; r--;
        }
    }

    public void reverse() {
        reverse(0, tail);
    }

    public int[] toArray() {
        final int[] ret = new int[tail];
        System.arraycopy(a, 0, ret, 0, tail);
        return ret;
    }

    public void sort() {
        Arrays.sort(a, 0, tail);
    }

    public PrimitiveIterator.OfInt iterator() {
        return new PrimitiveIterator.OfInt(){
            int i = 0;
            public boolean hasNext() {return i < tail;}
            public int nextInt() {return a[i++];}
        };
    }
}

class IntPriorityQueue {
    static final int DEFAULT_CAPACITY = 1 << 6;

    @FunctionalInterface
    public static interface IntComparator {public int compare(int a, int b);}

    int[] que;

    final IntComparator comparator;
    final boolean descending;

    int size = 0;

    public IntPriorityQueue(int capacity, boolean descending) {
        int k = 1;
        while (k < capacity) k <<= 1;
        this.que = new int[k];
        this.comparator = null;
        this.descending = descending;
        this.size = 0;
    }

    public IntPriorityQueue(int capacity) {
        this(capacity, false);
    }

    public IntPriorityQueue(boolean descending) {
        this(DEFAULT_CAPACITY, descending);
    }

    public IntPriorityQueue() {
        this(DEFAULT_CAPACITY, false);
    }

    public IntPriorityQueue(int capacity, IntComparator comparator) {
        int k = 1;
        while (k < capacity) k <<= 1;
        this.que = new int[k];
        this.comparator = comparator;
        this.descending = false;
        this.size = 0;
    }

    public IntPriorityQueue(IntComparator comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public void push(int e) {
        if (++size == que.length) grow();
        if (comparator != null) {
            pushUsingComparator(e);
        } else if (descending) {
            pushDescending(e);
        } else {
            pushAscending(e);
        }
    }

    void grow() {
        int[] newQue = new int[que.length << 1];
        System.arraycopy(que, 0, newQue, 0, que.length);
        que = newQue;
    }

    void pushUsingComparator(int e) {
        int i = size;
        while (i > 1) {
            int p = i >> 1;
            if (comparator.compare(e, que[p]) >= 0) break;
            que[i] = que[i = p];
        }
        que[i] = e;
    }

    void pushDescending(int e) {
        int i = size;
        while (i > 1) {
            int p = i >> 1;
            if (e <= que[p]) break;
            que[i] = que[i = p];
        }
        que[i] = (int) e;
    }

    void pushAscending(int e) {
        int i = size;
        while (i > 1) {
            int p = i >> 1;
            if (e >= que[p]) break;
            que[i] = que[i = p];
        }
        que[i] = (int) e;
    }

    public int pop() {
        if (comparator != null) {
            return popUsingComparator();
        } else if (descending) {
            return popDescending();
        } else {
            return popAscending();
        }
    }

    int popUsingComparator() {
        int ret = que[1];
        int e = que[size--];
        int i = 1;
        int h = size >> 1;
        while (i <= h) {
            int l = i << 1 | 0, r = i << 1 | 1;
            if (r <= size) {
                if (comparator.compare(que[l], que[r]) > 0) {
                    if (comparator.compare(e, que[r]) <= 0) break;
                    que[i] = que[i = r];
                } else {
                    if (comparator.compare(e, que[l]) <= 0) break;
                    que[i] = que[i = l];
                }
            } else {
                if (comparator.compare(e, que[l]) <= 0) break;
                que[i] = que[i = l];
            }
        }
        que[i] = e;
        return ret;
    }

    int popDescending() {
        int ret = que[1];
        int e = que[size--];
        int i = 1;
        int h = size >> 1;
        while (i <= h) {
            int l = i << 1 | 0, r = i << 1 | 1;
            if (r <= size) {
                if (que[l] < que[r]) {
                    if (e >= que[r]) break;
                    que[i] = que[i = r];
                } else {
                    if (e >= que[l]) break;
                    que[i] = que[i = l];
                }
            } else {
                if (e >= que[l]) break;
                que[i] = que[i = l];
            }
        }
        que[i] = (int) e;
        return ret;
    }

    int popAscending() {
        int ret = que[1];
        int e = que[size--];
        int i = 1;
        int h = size >> 1;
        while (i <= h) {
            int l = i << 1 | 0, r = i << 1 | 1;
            if (r <= size) {
                if (que[l] > que[r]) {
                    if (e <= que[r]) break;
                    que[i] = que[i = r];
                } else {
                    if (e <= que[l]) break;
                    que[i] = que[i = l];
                }
            } else {
                if (e <= que[l]) break;
                que[i] = que[i = l];
            }
        }
        que[i] = (int) e;
        return ret;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public static void main(String[] args) {
        IntPriorityQueue pq = new IntPriorityQueue(1, true);
        pq.push(  3); pq.push(  4); pq.push(  1); pq.push(- 1);
        pq.push( 10); pq.push( 14); pq.push( 30); pq.push(- 3);
        pq.push(-13); pq.push( 32); pq.push( 13); pq.push(  7);
        pq.push(- 7); pq.push( 12); pq.push(-29); pq.push(- 2);
        pq.push(  0); pq.push(  1); pq.push( 10);
        while (pq.size() > 0) {
            System.out.print(pq.pop());
            if (pq.size() > 0) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}