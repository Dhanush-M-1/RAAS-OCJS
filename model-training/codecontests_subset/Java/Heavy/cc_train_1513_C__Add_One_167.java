import java.io.*;
import java.util.*;

public final class Solution {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader in = new FastReader();
    static long mod = (long) 1e9 + 7;
    static Pair[] moves = new Pair[]{new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1)};

    public static void main(String[] args) {

        int mm = 200000;
        long[][] dp = new long[10][mm + 1];
        for (int i = 0; i <= 9; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= mm; i++) {
            for (int j = 0; j <= 8; j++) {
                dp[j][i] = dp[j + 1][i - 1];
            }
            dp[9][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[9][i] = dp[9][i] % mod;
        }
        int t = i();
        out:
        while (t-- > 0) {
            int n = i();
            int m = i();

            long ans = 0L;
            while (n > 0) {
                int mo = n % 10;
                n = n / 10;
                ans += dp[mo][m];
                ans = ans % mod;
            }
            out.println(ans);
        }
        out.flush();
    }

    static int sd(long i) {
        int d = 0;
        while (i > 0) {
            d += i % 10;
            i = i / 10;
        }
        return d;
    }


    static int lower(long A[], long x) {
        int l = -1, r = A.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (A[m] >= x) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    static int upper(long A[], long x) {
        int l = -1, r = A.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (A[m] <= x) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    static void swap(int A[], int a, int b) {
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    static int lowerBound(int A[], int low, int high, int x) {
        if (low > high) {
            if (x >= A[high]) {
                return A[high];
            }
        }

        int mid = (low + high) / 2;

        if (A[mid] == x) {
            return A[mid];
        }

        if (mid > 0 && A[mid - 1] <= x && x < A[mid]) {
            return A[mid - 1];
        }

        if (x < A[mid]) {
            return lowerBound(A, low, mid - 1, x);
        }

        return lowerBound(A, mid + 1, high, x);
    }


    static long pow(long a, long b) {
        long pow = 1;
        long x = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                pow = (pow * x) % mod;
            }
            x = (x * x) % mod;
            b /= 2;
        }
        return pow;
    }

    static boolean isPrime(long N) {
        if (N <= 1) {
            return false;
        }
        if (N <= 3) {
            return true;
        }
        if (N % 2 == 0 || N % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= N; i = i + 6) {
            if (N % i == 0 || N % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    static void print(char A[]) {
        for (char c : A) {
            out.print(c);
        }
        out.println();
    }

    static void print(boolean A[]) {
        for (boolean c : A) {
            out.print(c + " ");
        }
        out.println();
    }

    static void print(int A[]) {
        for (int c : A) {
            out.print(c + " ");
        }
        out.println();
    }

    static void print(long A[]) {
        for (long i : A) {
            out.print(i + " ");
        }
        out.println();

    }

    static void print(ArrayList<Integer> A) {
        for (int a : A) {
            out.print(a + " ");
        }
        out.println();
    }

    static int i() {
        return in.nextInt();
    }

    static long l() {
        return in.nextLong();
    }

    static String s() {
        return in.nextLine();
    }

    static int[] input(int N) {
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        return A;
    }

    static long[] inputLong(int N) {
        long A[] = new long[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = in.nextLong();
        }
        return A;
    }

    static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

}

class Pair {

    long i, j;

    Pair(long i, long j) {
        this.i = i;
        this.j = j;
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}