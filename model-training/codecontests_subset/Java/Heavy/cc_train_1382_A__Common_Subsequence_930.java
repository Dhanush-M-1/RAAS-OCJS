import java.io.*;
import java.util.*;

// Author- Prashant Gupta

public class A {
    public static void main(String[] args) throws IOException {
        // write your code here
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        Scanner sc = new Scanner(System.in);
//        Reader sc = new Reader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
                set.add(a[i]);
            }
            for (int i = 0; i < b.length; i++) {
                b[i] = sc.nextInt();
            }
            boolean flag = false;
            for (int i = 0; i < b.length; i++) {
                if (set.contains(b[i])) {
                    out.println("YES");
                    out.println(1 + " " + b[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                out.println("NO");
            }

        }
        out.close();
    }

    /*-------------------------------------------------------------------------------------*/



    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long power(long x, long y) {
        long res = 1;
        while (x > 0) {
            if (y % 2 == 0) {
                x *= x;
                y /= 2;
            } else {
                res *= x;
                y--;
            }
        }
        return res;
    }

    public static long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }

    public static int lowerBound(Vector<Integer> v, int e) {
        int start = 0, end = v.size() - 1, ind = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (v.get(mid) == e) {
                ind = mid;
                break;
            } else if (v.get(mid) < e) {
                ind = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ind;
    }

    // Fast I/p

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

        public String readLine() throws IOException {
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
            } while ((c = read()) >= '0' && c <= '9');

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
            }
            while ((c = read()) >= '0' && c <= '9');
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
            }
            while ((c = read()) >= '0' && c <= '9');

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
