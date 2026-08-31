import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static Entry[] E;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        T = sc.nextInt();
        E = new Entry[T];
        for (int i = 0; i < T; i++) {
            E[i] = new Entry(sc.nextLong(), sc.nextLong(), sc.nextLong(), sc.nextLong());
        }

        PrintWriter pw = new PrintWriter(System.out);
        for (boolean b : solve()) {
            pw.println( b ? "Yes" : "No");
        }
        pw.flush();
    }

    static boolean[] solve() {
        boolean[] answers = new boolean[T];
        for (int i = 0; i < T; i++) {
            answers[i] = calc(E[i]);
        }
        return answers;
    }

    static boolean calc(Entry e) {
        if( e.a < e.b ) return false;
        if( e.d < e.b ) return false;
        if( e.c+1 >= e.b ) return true;

        if( e.b == e.d ) {
            long r = e.a % e.b;
            return r <= e.c;
        }

        long gcd = gcd(e.b, e.d);
        if( gcd == 1 ) return false;

        // 死ぬ範囲
        // e.b > death > e.c
        if( e.b - e.c - 1 >= gcd ) return false; // 死ぬ

        long r = e.a % e.b % gcd;
        if( r == 0 ) return true;

        long c_gcd = e.c % gcd;
        return r <= c_gcd;
    }

    static long gcd(long a, long b) {
        if( b > a ) {
            long t = a;
            a = b;
            b = t;
        }

        if( b == 0 ) return a;

        else return gcd(b, a%b);
    }


    static class Entry {
        long a;
        long b;
        long c;
        long d;

        public Entry(long a, long b, long c, long d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
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
        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}
