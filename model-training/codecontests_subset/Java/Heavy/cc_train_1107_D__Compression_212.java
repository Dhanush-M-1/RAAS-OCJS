import java.io.*;
import java.util.*;
import java.util.function.IntConsumer;

public class Main {

    static int N;
    static int[][] C;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        N = sc.nextInt();
        C = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                char h = s.charAt(j);
                int hi = Integer.parseInt(String.valueOf(h), 16);
                for (int k = 0; k < 4; k++) {
                    if( (hi & 1 << k) > 0 ) {
                        C[i][j*4 + 4-k-1] = 1;
                    }
                }
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        CumulativeSum2D c = new CumulativeSum2D();
        c.init(N, N, C);

        int[] dividors = enumDividors(N);
        lo: for (int i = 0; i < dividors.length - 1; i++) {
            int d = dividors[i];

            for (int h = 0; h < N / d; h++) {
                for (int w = 0; w < N / d; w++) {
                    int cnt = c.get(h*d, w*d, h*d + d-1, w*d + d-1);
                    if( cnt != 0 && cnt != d*d ) {
                        continue lo;
                    }
                }
            }
            return d;
        }
        return 1;
    }

    static int[] enumDividors(int n) {
        int[][] factors = enumFactors2(n);
        int[] cnt = new int[1];
        enumDividorsDfs(0, factors, 1, x -> cnt[0]++ );
        int[] dividors = new int[cnt[0]];
        enumDividorsDfs(0, factors, 1, x -> dividors[--cnt[0]] = x );
        return dividors;
    }

    static class CumulativeSum2D {

        int[][] cs2d;

        void init(int h, int w, int[][] c) {
            this.cs2d = c;
            for (int i = 0; i < h; i++) {
                for (int j = 1; j < w; j++) {
                    c[i][j] += c[i][j-1];
                }
            }
            for (int j = 0; j < w; j++) {
                for (int i = 1; i < h; i++) {
                    c[i][j] += c[i-1][j];
                }
            }
        }

        // 左上が (h1, w1), 左下が(h2, w2), 閉区間
        int get(int h1, int w1, int h2, int w2) {
            // d c
            // b a
            int abcd = cs2d[h2][w2];

            int cd;
            if( h1 > 0 ) {
                cd = cs2d[h1-1][w2];
            } else {
                cd = 0;
            }

            int bd;
            if( w1 > 0 ) {
                bd = cs2d[h2][w1-1];
            } else {
                bd = 0;
            }

            int d;
            if( w1 > 0 && h1 > 0 ) {
                d = cs2d[h1-1][w1-1];
            } else {
                d = 0;
            }

            return abcd - cd - bd + d;
        }
    }

    static void enumDividorsDfs(int idx, int[][] factors, int n, IntConsumer c) {
        if( factors.length == idx || factors[idx] == null ) {
            c.accept(n);
            return;
        }

        int f = factors[idx][0];
        int cnt = factors[idx][1];
        for (int i = 0; i <= cnt; i++) {
            enumDividorsDfs(idx+1, factors, n, c);
            n *= f;
        }
    }

    static int[][] enumFactors2(int n) {
        List<int[]> fs = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int cnt = 0;
            while( n % i == 0 ) {
                n/=i;
                cnt++;
            }
            if( cnt > 0 ) {
                fs.add(new int[]{i, cnt});
            }
        }
        if( n != 1 ) {
            fs.add(new int[]{n, 1});
        }
        int[][] ret = new int[fs.size()][];
        for (int i = 0; i < fs.size(); i++) {
            ret[i] = fs.get(i);
        }
        return ret;
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[] nextIntArray(int n, int delta) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt() + delta;
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }
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

    static void writeSingleLine(int[] as) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < as.length; i++) {
            if (i != 0) pw.print(" ");
            pw.print(as[i]);
        }
        pw.println();
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
            if (arg == null) j.add("null");
            else if (arg instanceof int[]) j.add(Arrays.toString((int[]) arg));
            else if (arg instanceof long[]) j.add(Arrays.toString((long[]) arg));
            else if (arg instanceof double[]) j.add(Arrays.toString((double[]) arg));
            else if (arg instanceof Object[]) j.add(Arrays.toString((Object[]) arg));
            else j.add(arg.toString());
        }
        System.err.println(j.toString());
    }

    static void printSingleLine(int[] array) {
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < array.length; i++) {
            if (i != 0) pw.print(" ");
            pw.print(array[i]);
        }
        pw.println();
        pw.flush();
    }

    static int lowerBound(int[] array, int value) {
        int lo = 0, hi = array.length, mid;
        while (lo < hi) {
            mid = (hi + lo) / 2;
            if (array[mid] < value) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int upperBound(int[] array, int value) {
        int lo = 0, hi = array.length, mid;
        while (lo < hi) {
            mid = (hi + lo) / 2;
            if (array[mid] <= value) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
