import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.concurrent.*;

public class Main {
    //---------------------------------------------------------------------------

    static int MAXN = 1000000001;
    static int mod = 1000000007;
    static Pair[] a;
    static int n;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        //-----------------------------------------------------------------------
        n = in.nextInt();
        a = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[i] = new Pair(x, y);
        }
        Arrays.sort(a, new Pair());
        int ans = 2;
        for (int i = 1; i < n - 1; i++) {
            if (a[i].first - a[i].second > a[i - 1].first) {
                ans++;
            } else if (a[i].first + a[i].second < a[i + 1].first) {
                ans++;
                a[i].first += a[i].second;
            }
        }
        if (n < 2) {
            ans = n;
        }
        out.println(ans);
        //-----------------------------------------------------------------------
        out.close();
    }

    //---------------------------------------------------------------------------
    static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static class Pair implements Comparator {

        int first, second;

        public Pair() {

        }

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Pair p1 = (Pair) o1;
            Pair p2 = (Pair) o2;
            int ret = Integer.compare(p1.first, p2.first);
            if (ret == 0) {
                ret = Integer.compare(p1.second, p2.second);
            }
            return ret;
        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] nextCharArray() {
            return next().toCharArray();
        }

        public boolean hasNext() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String s = reader.readLine();
                    if (s == null) {
                        return false;
                    }
                    tokenizer = new StringTokenizer(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return true;
        }

        public void skipLine() {
            try {
                tokenizer = null;
                reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
