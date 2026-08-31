import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.function.Function;

public class MainD {

    static int N;
    static long[] A;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        N = sc.nextInt();
        A = sc.nextLongArray(N);

        System.out.println(mkString(solve()));
    }

    static String mkString(int[] arr) {
        StringJoiner j = new StringJoiner(" ");
        for (int a : arr) {
            j.add(String.valueOf(a));
        }
        return j.toString();
    }

    static int[] solve() {
        FenwickTree bit = new FenwickTree(N, FenwickTree.SUM);
        for (int i = 0; i < N; i++) {
            bit.add(i, i+1);
        }

        int[] ans = new int[N];
        for (int i = N-1; i >= 0; i--) {
            int idx = bit.lowerBound(A[i]+1);
            ans[i] = idx+1;
            bit.add(ans[i]-1, -ans[i]); // set 0
        }
        return ans;
    }

    static class FenwickTree {

        interface Monoid {
            long identity();
            long apply(long a, long b);
            long inverse(long a);
        }

        static Monoid SUM = new Monoid() {
            public long identity() { return 0; }
            public long apply(long a, long b) { return a+b; }
            public long inverse(long a) { return -a; }
        };

        static Monoid MAX = new Monoid() {
            public long identity() { return 0; }
            public long apply(long a, long b) { return Math.max(a, b); }
            public long inverse(long a) { throw new RuntimeException("no inverse"); }
        };


        int size;
        long[] bit;
        Monoid m;
        long identity;

        FenwickTree(int size, Monoid m) {
            this.size = 1;
            while( this.size < size ) this.size *= 2;
            this.bit = new long[this.size+1];
            this.identity = m.identity();
            if( this.identity != 0 ) {
                Arrays.fill(this.bit, this.identity);
            }
            this.m = m;
        }

        void add(int i, long v) {
            i++; // 0 index -> 1 index

            while( i <= size ) {
                bit[i] = m.apply(bit[i], v);
                i += i & -i;
            }
        }

        // [0, r)
        long query(int r) {
            // 0 index -> 1 index -> -1
            long ret = identity;
            while(r > 0) {
                ret = m.apply(ret, bit[r]);
                r -= r & -r;
            }
            return ret;
        }

        long query(int l, int r) {
            return query(r) + m.inverse(query(l));
        }

        int lowerBound(long v) {
            if( bit[size] < v ) return size;

            int x = 0;
            for (int k = size/2; k > 0; k /= 2 ) {
                if( bit[x + k] < v ) {
                    v -= bit[x+k];
                    x += k;
                }
            }
            return x;
        }
    }

    static int lowerBound(long[] array, long value) {
        int low = 0;
        int high = array.length;
        int mid;
        while( low < high ) {
            mid = ((high - low) >>> 1) + low; // (high + low) / 2
            if( array[mid] < value ) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @SuppressWarnings("unused")
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken("\n");
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        int[] nextIntArray(int n, int delta) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt() + delta;
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static <A> void writeLines(A[] as, Function<A, String> f) {
        PrintWriter pw = new PrintWriter(System.out);
        for (A a : as) {
            pw.println(f.apply(a));
        }
        pw.flush();
    }

    static void writeLines(int[] as) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int a : as) pw.println(a);
        pw.flush();
    }

    static void writeLines(long[] as) {
        PrintWriter pw = new PrintWriter(System.out);
        for (long a : as) pw.println(a);
        pw.flush();
    }

    static int max(int... as) {
        int max = Integer.MIN_VALUE;
        for (int a : as) max = Math.max(a, max);
        return max;
    }

    static int min(int... as) {
        int min = Integer.MAX_VALUE;
        for (int a : as) min = Math.min(a, min);
        return min;
    }

    static void debug(Object... args) {
        StringJoiner j = new StringJoiner(" ");
        for (Object arg : args) {
            if (arg instanceof int[]) j.add(Arrays.toString((int[]) arg));
            else if (arg instanceof long[]) j.add(Arrays.toString((long[]) arg));
            else if (arg instanceof double[]) j.add(Arrays.toString((double[]) arg));
            else if (arg instanceof Object[]) j.add(Arrays.toString((Object[]) arg));
            else j.add(arg.toString());
        }
        System.err.println(j.toString());
    }
}
