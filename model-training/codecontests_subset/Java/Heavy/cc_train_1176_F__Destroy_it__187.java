import java.io.*;
import java.util.*;
import java.util.function.Function;

public class MainF {

    static int N;
    static Card[][] T;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        N = sc.nextInt();
        T = new Card[N][];
        for (int i = 0; i < N; i++) {
            int k = sc.nextInt();
            Card[] C = new Card[k];
            for (int j = 0; j < k; j++) {
                C[j] = new Card(sc.nextInt(), sc.nextInt());
            }
            T[i] = C;
        }

        System.out.println(solve());
    }

    static long solve() {
        long[] curr = new long[10];
        Arrays.fill(curr, -1);
        curr[0] = 0;
        long[] next = new long[10];

        for (int i = 0; i < N; i++) {
            Arrays.fill(next, -1);
            List<Card> q1 = new ArrayList<>();
            List<Card> q2 = new ArrayList<>();
            List<Card> q123 = new ArrayList<>();
            for (Card card : T[i]) {
                if( card.cost == 1 ) {
                    q1.add(card);
                    q123.add(card);
                } else if( card.cost == 2 ) {
                    q2.add(card);
                    q123.add(card);
                } else {
                    q123.add(card);
                }
            }
            q1.sort(Comparator.comparingInt(c -> -c.power));
            q2.sort(Comparator.comparingInt(c -> -c.power));
            q123.sort(Comparator.comparingInt(c -> -c.power));

            Card[] m3 = null;
            if( q1.size() >= 3 ) {
                m3 = new Card[]{q1.get(0), q1.get(1), q1.get(2)};
            }
            Card[] m2_11 = null;
            if( q1.size() >= 2 ) {
                m2_11 = new Card[]{q1.get(0), q1.get(1)};
            }
            Card[] m2_12 = null;
            if( q1.size() >= 1 && q2.size() >= 1 ) {
                Card a = q1.get(0);
                Card b = q2.get(0);
                if( a.power > b.power ) {
                    m2_12 = new Card[]{a, b};
                } else {
                    m2_12 = new Card[]{b, a};
                }
            }
            Card m1 = q123.get(0);

            for (int j = 0; j < 10; j++) {
                if( curr[j] == -1 ) continue;

                next[j] = Math.max(next[j], curr[j]);

                next[(j+1) % 10] = Math.max(next[(j+1) % 10], curr[j] + m1.power*is10ThPower(j, 1));

                if( m2_11 != null ) {
                    int a = m2_11[0].power * is10ThPower(j, 2);
                    int b = m2_11[1].power;
                    next[(j+2) % 10] = Math.max(next[(j+2) % 10], curr[j] + a + b);
                }

                if( m2_12 != null ) {
                    int a = m2_12[0].power * is10ThPower(j, 2);
                    int b = m2_12[1].power;
                    next[(j+2) % 10] = Math.max(next[(j+2) % 10], curr[j] + a + b);
                }

                if( m3 != null ) {
                    int a = m3[0].power * is10ThPower(j, 3);
                    int b = m3[1].power;
                    int c = m3[2].power;
                    next[(j+3) % 10] = Math.max(next[(j+3) % 10], curr[j] + a + b + c);
                }
            }

            // debug(next);

            long[] t = curr;
            curr = next;
            next = t;
        }

        long ans = 0;
        for (long p : curr) {
            ans = Math.max(ans, p);
        }
        return ans;
    }

    static int is10ThPower(int cur, int m) {
        return (cur + m) >= 10 ? 2 : 1;
    }

    static class Card {
        int cost, power;

        public Card(int cost, int power) {
            this.cost = cost;
            this.power = power;
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
