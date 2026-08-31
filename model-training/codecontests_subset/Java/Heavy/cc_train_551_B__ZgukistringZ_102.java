import java.io.*;
import java.util.StringTokenizer;

public class _551B {

    static int bb, cc;
    static String B, C;

    static int[] get(String a) {
        int[] ans = new int[128];
        for (int i=0; i<a.length(); i++)
            ans[a.charAt(i)]++;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        BufferedWriter cout = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = get(Reader.next());
        B = Reader.next();
        C = Reader.next();
        int[] b = get(B);
        int[] c = get(C);

        for (int i=0; ; i++) {
            boolean ok = true;
            for (int j=0; j<a.length; j++)
                if (a[j] < b[j] * i) {
                    ok = false;
                    break;
                }
            if (!ok) break;

            int min = Integer.MAX_VALUE;
            for (int j=0; j<a.length; j++)
                if (c[j] > 0) {
                    min = Math.min(min, (a[j] - b[j] * i) / c[j]);
                }

            if (i + min > bb + cc) {
                bb = i;
                cc = min;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<bb; i++) builder.append(B);
        for (int i=0; i<cc; i++) builder.append(C);
        for (int i=0; i<128; i++)
            for (int j=0; j<a[i] - bb * b[i] - cc * c[i]; j++)
                builder.append((char)i);

        System.out.println(builder.toString());

        cout.close();
    }

    static class Pair<U extends Comparable<U>, V extends Comparable<V>> implements Comparable<Pair<U, V>> {
        final U _1;
        final V _2;

        private Pair(U key, V val) {
            this._1 = key;
            this._2 = val;
        }

        public static <U extends Comparable<U>, V extends Comparable<V>> Pair<U, V> instanceOf(U _1, V _2) {
            return new Pair<U, V>(_1, _2);
        }

        @Override
        public String toString() {
            return _1 + " " + _2;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = res * 31 + _1.hashCode();
            res = res * 31 + _2.hashCode();
            return res;
        }

        @Override
        public int compareTo(Pair<U, V> that) {
            int res = this._1.compareTo(that._1);
            if (res < 0 || res > 0) return res;
            else return this._2.compareTo(that._2);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair<?, ?> that = (Pair<?, ?>) obj;
            return _1.equals(that._1) && _2.equals(that._2);
        }
    }

    /** Class for buffered reading int and double values */
    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                // TODO add check for eof if necessary
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static class ArrayUtil {
        static void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(long[] a, int i, int j) {
            long tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(double[] a, int i, int j) {
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(char[] a, int i, int j) {
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void swap(boolean[] a, int i, int j) {
            boolean tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        static void reverse(int[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(long[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(double[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(char[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static void reverse(boolean[] a, int i, int j) {
            for (; i < j; i++, j--)
                swap(a, i, j);
        }

        static long sum(int[] a) {
            int sum = 0;
            for (int i : a)
                sum += i;
            return sum;
        }

        static long sum(long[] a) {
            long sum = 0;
            for (long i : a)
                sum += i;
            return sum;
        }

        static double sum(double[] a) {
            double sum = 0;
            for (double i : a)
                sum += i;
            return sum;
        }

        static int max(int[] a) {
            int max = Integer.MIN_VALUE;
            for (int i : a)
                if (i > max) max = i;
            return max;
        }

        static int min(int[] a) {
            int min = Integer.MAX_VALUE;
            for (int i : a)
                if (i < min) min = i;
            return min;
        }

        static long max(long[] a) {
            long max = Long.MIN_VALUE;
            for (long i : a)
                if (i > max) max = i;
            return max;
        }

        static long min(long[] a) {
            long min = Long.MAX_VALUE;
            for (long i : a)
                if (i < min) min = i;
            return min;
        }
    }
}
