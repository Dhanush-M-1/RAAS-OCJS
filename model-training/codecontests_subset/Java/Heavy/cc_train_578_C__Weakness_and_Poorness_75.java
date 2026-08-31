/**
 * @author derrick20
 */
import java.io.*;
import java.util.*;

public class WeaknessAndPoorness {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        a = sc.nextDoubles(N);
        double lo = -1e4;
        double hi = 1e4;
        // Concave function.
        for (int it = 0; it < 200; it++) {
            double p1 = (2.0 * lo + hi) / 3.0;
            double p2 = (lo + 2.0 * hi) / 3.0;
            double w1 = weakness(p1);
            double w2 = weakness(p2);
//            System.out.println(p1 + " " + p2 + " " + w1 + " " + w2);
            if (w1 > w2) {
                lo = p1;
            }
            else {
                hi = p2;
            }
        }
        out.println(weakness(lo));
        out.close();
    }

    static double[] a;
    static double oo = 1e9;

    // O(N) evaluation at a point
    static double weakness(double x) {
        // We DP to find the maximum sum ending at each endpoint
        double ansPos = -oo;
        double ansNeg = oo;
        double dpPos = -oo;
        double dpNeg = oo;
        for (int i = 0; i < a.length; i++) {
            double val = a[i] - x;
            // either we extend the old optimum, or start anew!
            dpPos = Math.max(dpPos + val, val);
            dpNeg = Math.min(dpNeg + val, val);
            ansPos = Math.max(ansPos, dpPos);
            ansNeg = Math.min(ansNeg, dpNeg);
        }
        return Math.max(ansPos, -ansNeg);
    }

    static class FastScanner {
        private int BS = 1<<16;
        private char NC = (char)0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            }
            catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar(){
            while(bId==size) {
                try {
                    size = in.read(buf);
                }catch(Exception e) {
                    return NC;
                }
                if(size==-1)return NC;
                bId=0;
            }
            return (char)buf[bId++];
        }

        public int nextInt() {
            return (int)nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt=1;
            boolean neg = false;
            if(c==NC)c=getChar();
            for(;(c<'0' || c>'9'); c = getChar()) {
                if(c=='-')neg=true;
            }
            long res = 0;
            for(; c>='0' && c <='9'; c=getChar()) {
                res = (res<<3)+(res<<1)+c-'0';
                cnt*=10;
            }
            return neg?-res:res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c!='.' ? cur:cur+nextLong()/cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c>32) {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c!='\n') {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if(c>32)return true;
            while(true) {
                c=getChar();
                if(c==NC)return false;
                else if(c>32)return true;
            }
        }
    }
}