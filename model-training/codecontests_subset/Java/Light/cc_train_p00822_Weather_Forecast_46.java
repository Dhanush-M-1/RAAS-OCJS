import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {

    static int N;
    static int[][] F;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(true) {
            N = sc.nextInt();
            if( N == 0 ) break;

            F = new int[N][];
            for (int i = 0; i < N; i++) {
                F[i] = sc.nextIntArray(16);
            }

            pw.println(solve());
        }
        pw.flush();
    }

    static int solve() {
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            int s = 0;
            s = check(i, s, 0, 1, 2, 5, 6);
            s = check(i, s, 1, 2, 3, 6, 7);
            s = check(i, s, 2, 3, 4, 7, 8);
            s = check(i, s, 3, 5, 6, 9, 10);
            s = check(i, s, 4, 6, 7, 10, 11);
            s = check(i, s, 5, 7, 8, 11, 12);
            s = check(i, s, 6, 9, 10, 13, 14);
            s = check(i, s, 7, 10, 11, 14, 15);
            s = check(i, s, 8, 11, 12, 15, 16);
            S[i] = s;
        }

        boolean ok = dfs(0, 4, 0, 0, 0, 0, S, new HashSet<>());
        return ok ? 1 : 0;
    }

    static boolean canMove(int a, int b) {
        return a / 3 == b / 3 || a % 3 == b % 3;
    }

    static boolean dfs(int i, int curr, int g0, int g2, int g6, int g8, int[] S, Set<Key> memo) {
        if( i == N ) {
            if( g0 == 7 || g2 == 7 || g6 == 7 || g8 == 7 ) {
                return false;
            } else {
                return true;
            }
        }

        Key key = new Key(i, curr, g0, g2, g6, g8);
        if( memo.contains(key) ) {
            return false;
        }

        if( (S[i] & (1 << curr)) != 0 ) {
            memo.add(key);
            return false;
        }

        g0 = curr == 0 ? 0 : g0+1;
        g2 = curr == 2 ? 0 : g2+1;
        g6 = curr == 6 ? 0 : g6+1;
        g8 = curr == 8 ? 0 : g8+1;
        if( g0 == 7 || g2 == 7 || g6 == 7 || g8 == 7 ) {
            memo.add(key);
            return false;
        }

        for (int next = 0; next < 9; next++) {
            if( canMove(curr, next) ) {
                boolean ok = dfs(i+1, next,
                        g0, g2, g6, g8,
                        S, memo);
                if( ok ) return true;
            }
        }
        memo.add(key);
        return false;
    }

    static class Key {
        int i, cur, g0, g2, g6, g8;

        public Key(int i, int cur, int g0, int g2, int g6, int g8) {
            this.i = i;
            this.cur = cur;
            this.g0 = g0;
            this.g2 = g2;
            this.g6 = g6;
            this.g8 = g8;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return i == key.i &&
                    cur == key.cur &&
                    g0 == key.g0 &&
                    g2 == key.g2 &&
                    g6 == key.g6 &&
                    g8 == key.g8;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, cur, g0, g2, g6, g8);
        }
    }

    static int check(int i, int s, int g, int a, int b, int c, int d) {
        if( F[i][a-1] == 1 || F[i][b-1] == 1 || F[i][c-1] == 1 || F[i][d-1] == 1 ) {
            return s | 1 << g;

        } else {
            return s;
        }
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

