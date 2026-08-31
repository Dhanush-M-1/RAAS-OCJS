/*
 * Author Ayub Subhaniya
 * Institute DA-IICT
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CodeForces {

    InputStream in;
    PrintWriter out;

    long mod = (long) 1e9 + 7;
    int MAX = (int) 1e6 + 7;
    double eps = 1e-6;
    int MAXI = 30;

    void solve() {
        int n=ni();
        int m=ni();
        int k=ni();
        int[] allowed=new int[n];
        int[] rightMostValid=new int[n];
        int[] endPoint=new int[n];
        for (int i=0;i<m;i++)
            allowed[ni()]=-1;

        if (allowed[0]==-1){
            out.println(-1);
            return;
        }

        int maxReq=1;
        long cnt=1;
        for (int i=0;i<n;i++)
            if (allowed[i]==-1)
                cnt++;
            else {
                maxReq= (int) max(maxReq,cnt);
                cnt=1;
            }
        maxReq= (int) max(maxReq,cnt);

        long cost[]=new long[k];
        for (int i=0;i<k;i++)
            cost[i]=nl();
        endPoint[n-1]=(allowed[n-1]==-1?-1:n-1);
        for (int i=n-2;i>=0;i--)
            if (allowed[i]==-1)
                endPoint[i]=endPoint[i+1];
            else
                endPoint[i]=i;

        if (maxReq>k){
            out.println(-1);
            return;
        }
        rightMostValid[0]=allowed[0]==-1?-1:0;
        for (int i=1;i<n;i++)
            if (allowed[i]==-1)
                rightMostValid[i]=rightMostValid[i-1];
            else
                rightMostValid[i]=i;
        long minCost=Long.MAX_VALUE;
        out:for (int l=maxReq;l<=k;l++){
            int cur=n;
            cnt=0;
            while (cur>0){
                int req=cur-l;
                //tr(l,req);
                while (req>=0&&allowed[req]==-1){
                    cnt++;
                    int curPoint=endPoint[req];
                    //tr(l,curPoint);
                    if (curPoint==-1)
                        continue out;
                    else
                        req=curPoint-l;
                }
                cnt++;
                if(req<0){
                    cur=0;
                } else {
                    cur=req;
                }
            }
            //tr(l,cnt);
            minCost=min(minCost,cost[l-1]*cnt);
        }
        out.println(minCost);
    }

    int dx[] = new int[]{1, -1, 0, 0};
    int dy[] = new int[]{0, 0, 1, -1};

    class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return x == other.x && y == other.y;
        }

        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Pair o) {
            if (x == o.x)
                return Integer.compare(y, o.y);
            else
                return Integer.compare(x, o.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    class Point {
        double x;
        double y;
        double z;

        Point(double a, double b, double c) {
            z = c;
            x = a;
            y = b;
        }

        public String toString() {
            return x + " " + y + " " + z;
        }

        double mod() {
            double d = x * x + y * y + z * z;
            return d;
            //return Double.parseDouble(df.format(d));
        }

        Point dot(Point p) {
            return new Point(p.x * x, p.y * y, p.z * z);
        }

        Point substract(Point p) {
            return new Point(x - p.x, y - p.y, z - p.z);
        }

        Point cross(Point p) {
            double uvi, uvj, uvk;
            uvi = y * p.z - p.y * z;
            uvj = p.x * z - x * p.z;
            uvk = x * p.y - p.x * y;
            return new Point(uvi, uvj, uvk);
        }
    }

    long pow(long x, long n, long M) {
        x %= M;
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result = (result * x) % M;
            x = (x * x) % M;
            n = n / 2;
        }
        return result;
    }

    long modInverse(long A, long M) {
        extendedEuclid(A, M);
        return (EEx % M + M) % M;
    }

    long EEd, EEx, EEy;

    void extendedEuclid(long A, long B) {
        if (B == 0) {
            EEd = A;
            EEx = 1;
            EEy = 0;
        } else {
            extendedEuclid(B, A % B);
            long temp = EEx;
            EEx = EEy;
            EEy = temp - (A / B) * EEy;
        }
    }

    int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    int min(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
    }

    long max(long a, long b) {
        if (a > b)
            return a;
        else
            return b;

    }


    long min(long a, long b) {
        if (a > b)
            return b;
        else
            return a;

    }

    long add(long a, long b) {
        long x = (a + b);
        while (x >= mod) x -= mod;
        return x;

    }


    long sub(long a, long b) {
        long x = (a - b);
        while (x < 0) x += mod;
        return x;

    }


    long mul(long a, long b) {
        a %= mod;
        b %= mod;
        long x = (a * b);
        return x % mod;

    }

    void run() throws Exception {
        String INPUT = "/Users/ayubsubhaniya/IdeaProjects/Test/src/input.txt";
        in = oj ? System.in : new FileInputStream(INPUT);
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        tr(System.currentTimeMillis() - s + "ms");

    }

    public static void main(String[] args) throws Exception {

        new CodeForces().run();
    }

    private byte[] inbuf = new byte[1024 * 1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = in.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean inSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && inSpaceChar(b))
            ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(inSpaceChar(b))) { // when nextLine, (inSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(inSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++)
            map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (!oj)
            System.out.println(Arrays.deepToString(o));
    }

}