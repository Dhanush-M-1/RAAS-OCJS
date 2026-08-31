import java.io.*;
import java.util.*;
import java.math.*;

public class Exa {
// class Exa {
    // static boolean[] prime = getAllPrime(1000000 + 1);
    static PrintStream out = System.out;
    static Reader sc = new Reader();
    public static void main(String[] args) throws java.lang.Exception {
        int t = sc.nextInt();
        // int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    static void solve() throws java.lang.Exception {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[0] + arr[1] <= arr[n - 1]) {
            out.println(1 + " " + 2 + " " + n);
        } else {
            out.println(-1);
        }
    }

    static int ceil(int m, int k) {
        if (m % k == 0) {
            return (m / k);
        } else {
            return (m / k) + 1;
        }
        // return 0;
    }

    static int floor(int x, int k) {
        if (x % k == 0) {
            return (x / k);
        } else {
            return (x / k) + 1;
        }
        // return 0;
    }

    static void ruffleSort(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        Arrays.sort(a);
    }

    public static long reverseNumber(long n) {
        long ans = 0;
        while (n > 0) {
            long rem = n % 10;
            ans = (ans * 10) + rem;
            n /= 10;
        }
        return ans;
    }

    public static int countDigits(int n) {
        int d = 0;
        d = (int) Math.log10(n) + 1;
        return d;
    }

    public static long countDigits(long n) {
        long d = 0;
        d = (int) Math.log10(n) + 1;
        return d;
    }

    static int countBits(int number) {

        // log function in base 2
        // take only integer part
        return (int)(Math.log(number) /
                     Math.log(2) + 1);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = (res * a) % 1000000007;
            }
            a = (a * a) % 1000000007;
            b = b >> 1;
        }
        return res;
    }

    public static int pow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = (res * a) % 1000000007;
            }
            a = (a * a) % 1000000007;
            b = b >> 1;
        }
        return res;
    }

    static boolean isPowerOfTwo(long n) {
        return (long)(Math.ceil(Math.log(n) / Math.log(2)))
               == (long)(Math.floor(Math.log(n) / Math.log(2)));
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, (a % b) % 1000000007);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        long d = gcd(a, b);
        return (a * b) / d;
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean[] getAllPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 3; i <= n; i += 2) {
            prime[i] = true;
        }
        for (int i = 3; i * i <= n; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        prime[2] = true;
        prime[0] = prime[1] = false;
        return prime;
    }

    static class pair {
        int first;
        int second;
        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}