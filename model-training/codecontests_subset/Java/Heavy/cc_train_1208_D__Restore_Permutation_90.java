import java.io.*;
import java.util.*;
 
public class CP {
    public static void main(String[] args) throws Exception {
            /*new Thread(null, new Runnable() {
                @Override
                public void run() {
                    try {
                        new Solver().solve();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            }, "Solver", 1l << 30).start();*/
 
        new Solver().solve();
    }
}
 
class Solver {
    IO io = new IO(System.in, System.out);
 
    int N;
    long[] S;
    SegmentTree segT;
    BitSet added;
 
    void solve() throws Exception {
        int i, j, k, l;
 
        N = io.nextInt();
        S = new long[N];
        for (i = 0; i < N; ++i) S[i] = io.nextLong();
 
        segT = new SegmentTree(N + 7);
        added = new BitSet();
        added.set(0, N + 3);
 
        int[] A = new int[N];
        for (i = N - 1; i >= 0; --i) {
            int ele = bs(i);
            segT.update(ele, ele);
            added.clear(ele);
 
            A[i] = ele;
            //System.out.println(Arrays.toString(A));
        }
 
        for (long ele : A) io.printsp(ele);
        io.println();
 
        io.flush();
    }
 
    int bs(int i) {
        int l = 1, r = N;
        while (true) {
            int mid = l + r >> 1;
            //mid = added.nextSetBit(mid);
            //if (mid == r) mid = added.previousSetBit(mid - 1);
            //System.out.println(l + " " + r + " = " + mid + " " + (S[i] + segT.query(0, mid)));
 
            if (l + 1 >= r) {
                //System.out.println(l + " " + r);
 
                if (calc(r) == S[i] + segT.query(0, r)) return r;
                else if (calc(l) == S[i] + segT.query(0, l)) return l;
                else return 7 / 0;
            } else if (S[i] + segT.query(0, mid) < calc(mid)) r = mid;
            else l = mid;
        }
    }
 
    long calc(long ele) {
        return ele * (ele - 1) >> 1;
    }
}
 
class SegmentTree {
    int N;
    long[] tree;
 
    SegmentTree(int n) {
        N = 1; while (N < n) N <<= 1;
        tree = new long[N * 2 - 1];
    }
 
    void update(int i, long val) {
        i += N - 1;
        while (i >= 0) {
            tree[i] += val;
            i = i - 1 >> 1;
        }
    }
 
    long query(int i, int l, int r, int ql, int qr) {
        int mid = l + r >> 1, i2 = i << 1;
        if (l > qr || r < ql) return 0;
        else if (l >= ql && r <= qr) return tree[i];
        else return query(i2 + 1, l, mid, ql, qr) + query(i2 + 2, mid + 1, r, ql, qr);
    }
 
    long query(int l, int r) {
        return query(0, 0, N - 1, l, r - 1);
    }
}
 
class IO {
    static byte[] buf = new byte[2048];
    static int index, total;
    static InputStream in;
    static BufferedWriter bw;
 
 
    IO(InputStream is, OutputStream os) {
        try {
            in = is;
            bw = new BufferedWriter(new OutputStreamWriter(os));
        } catch (Exception e) {
        }
    }
 
    IO(String inputFile, String outputFile) {
        try {
            in = new FileInputStream(inputFile);
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFile)));
        } catch (Exception e) {
        }
    }
 
    int scan() throws Exception {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }
 
    String next() throws Exception {
        int c;
        for (c = scan(); c <= 32; c = scan()) ;
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan())
            sb.append((char) c);
        return sb.toString();
    }
 
    int nextInt() throws Exception {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+')
            c = scan();
        for (; c >= '0' && c <= '9'; c = scan())
            val = (val << 3) + (val << 1) + (c & 15);
        return neg ? -val : val;
    }
 
    long nextLong() throws Exception {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan()) ;
        boolean neg = c == '-';
        if (c == '-' || c == '+')
            c = scan();
        for (; c >= '0' && c <= '9'; c = scan())
            val = (val << 3) + (val << 1) + (c & 15);
        return neg ? -val : val;
    }
 
    void print(Object a) throws Exception {
        bw.write(a.toString());
    }
 
    void printsp(Object a) throws Exception {
        print(a);
        bw.write(" ");
    }
 
    void println() throws Exception {
        bw.write("\n");
    }
 
    void println(Object a) throws Exception {
        print(a);
        println();
    }
 
    void flush() throws Exception {
        bw.flush();
        bw.close();
    }
}