import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class A {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        InputReader s = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = s.nextInt();
        int c = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        int max = 0;
        for(int i = 0; i < n- 1; i++){
            int rasp = arr[i];
            if(rasp >= arr[i+1]){
                rasp-=(arr[i+1]+c);
                max = Math.max(max, rasp);
            }
        }
        p.println(max);
        p.flush();
        p.close();
    }

    public static long power(int n , int x){
        if(x==0)
            return 1;
        if(x==1)
            return n;
        long val = power(n, x/2);
        if(x%2==1)
            return val*val*n;
        else
            return val*val;
    }
    public static boolean prime(long n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (long i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static ArrayList Divisors(long n) {
        ArrayList<Long> div = new ArrayList<>();

        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                div.add(i);

                if (n / i != i)
                    div.add(n / i);
            }
        }
        return div;
    }

    public static int BinarySearch(long[] a, long k) {
        int n = a.length;
        int i = 0, j = n - 1;
        int mid = 0;

        if (k < a[0])
            return 0;
        else if (k >= a[n - 1])
            return n;
        else {
            while (j - i > 1) {
                mid = (i + j) / 2;

                if (k >= a[mid])
                    i = mid;
                else
                    j = mid;
            }
        }

        return i + 1;
    }

    public static long GCD(long a, long b) {
        if (b == 0)
            return a;
        else
            return GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return (a * b) / GCD(a, b);
    }

    static class pair implements Comparable<pair> {
        Integer x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(pair o) {
            int result = x.compareTo(o.x);
            if (result == 0)
                result = y.compareTo(o.y);

            return result;
        }

        public String toString() {
            return x + " " + y;
        }

        public boolean equals(Object o) {
            if (o instanceof pair) {
                pair p = (pair) o;
                return p.x - x == 0 && p.y - y == 0;
            }
            return false;
        }

        public int hashCode() {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class CodeX {
        public static void sort(long arr[]) {
            merge_sort(arr, 0, arr.length - 1);
        }

        private static void merge_sort(long A[], long start, long end) {
            if (start < end) {
                long mid = (start + end) / 2;
                merge_sort(A, start, mid);
                merge_sort(A, mid + 1, end);
                merge(A, start, mid, end);
            }

        }

        private static void merge(long A[], long start, long mid, long end) {
            long p = start, q = mid + 1;
            long Arr[] = new long[(int) (end - start + 1)];
            long k = 0;

            for (int i = (int) start; i <= end; i++) {
                if (p > mid)
                    Arr[(int) k++] = A[(int) q++];

                else if (q > end)
                    Arr[(int) k++] = A[(int) p++];

                else if (A[(int) p] < A[(int) q])
                    Arr[(int) k++] = A[(int) p++];

                else
                    Arr[(int) k++] = A[(int) q++];
            }
            for (int i = 0; i < k; i++) {
                A[(int) start++] = Arr[i];
            }

        }

    }

}