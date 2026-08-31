import java.util.*;
import java.io.*;

public class E
{

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    
    
    static class SegmentTree {
        int st[][];
 
        SegmentTree(int n)  {
            st = new int[4*n][2];
            build(0, n - 1, 1);
        }
        
        int getMid(int s, int e) {
            return (s+e)>>1;
        }

        int[] merge(int[] a,int[] b){
            if(a[0] < b[0])
                return a;
            return b;
        }
        
        void update(int s, int e, int x, int y, int c, int si){
            if(s == x && e == y){
                st[si][0] += c;
            }
            else{
                int mid = getMid(s, e);
                if(y <= mid)    
                    update(s, mid, x, y, c, 2*si);
                else if(x > mid)
                    update(mid + 1, e, x ,y ,c ,2*si + 1);
                else{
                    update(s, mid, x, mid, c, 2*si);
                    update(mid + 1, e, mid + 1, y, c, 2*si + 1);
                }
                st[si] = merge(st[2*si],st[2*si+1]);
            }
        }

        int[] get(int s, int e, int x, int y, int si){

            if(s == x && e == y){
                return st[si];
            }
            int mid = getMid(s, e);
            if(y <= mid)
                return get(s, mid, x, y, 2*si);
            else if(x > mid)
                return get(mid + 1, e, x, y, 2*si + 1);
            return merge(get(s, mid, x, mid, 2*si), get(mid + 1, e, mid + 1, y, 2*si + 1));
        }
        
        void build(int ss, int se, int si){
            if (ss == se) {
                st[si][1] = ss;
                return;
            }

            int mid = getMid(ss, se);
            build(ss, mid, si * 2 );
            build(mid + 1, se, si * 2 + 1);
            st[si] = merge(st[2*si],st[2*si+1]);
        }
        
    }

    
    public static void main(String[] args)
    {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);  
        
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        
        ArrayList<Pair>[] set = new ArrayList[n];
        
        for(int i = 0; i < n; i++)
            set[i] = new ArrayList<>();

        int[] x = new int[m];
        int[] y = new int[m];
        
        for(int i = 0; i < m; i++) {
            x[i] = in.nextInt() - 1;
            y[i] = in.nextInt() - 1;
            set[x[i]].add(new Pair(y[i], i));
            set[y[i]].add(new Pair(x[i], i));
        }
        
        SegmentTree seg = new SegmentTree(n);
        
        for(int i = 0; i < n; i++) {
            seg.update(0, n - 1, i, i, set[i].size(), 1);
        }
        int[] ans = new int[m];
        int j = m;
        int cnt = n;
        boolean[] vis = new boolean[m];
        
        while(j > 0) {
            j--;
            while(true) {
                int[] a = seg.st[1];
                if(a[0] >= k) break;
                cnt--;
                for(Pair p : set[a[1]]) {
                    if(vis[p.y]) continue;
                    seg.update(0, n - 1, p.x, p.x, -1, 1);
                    vis[p.y] = true;
                }
                seg.update(0, n - 1, a[1], a[1], -a[0] + Integer.MAX_VALUE, 1);
            }
//            debug(j,vis);
            ans[j] = cnt;
            if(vis[j]) continue;
            seg.update(0, n - 1, x[j], x[j], -1, 1);
            seg.update(0, n - 1, y[j], y[j], -1, 1);
            vis[j] = true;
        }
        
        for(int i : ans)
            out.println(i);
        
        out.close();

    }
    
    static void debug(Object... o)
    {
            System.out.println(Arrays.deepToString(o));
    }

    static class Pair implements Comparable<Pair>
    {

        int x,y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
	public int compareTo(Pair o)
        {
            if(this.x == o.x)
                return -Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
	}

        public boolean equals(Object o)
        {
            if (o instanceof Pair)
            {
                Pair p = (Pair)o;
                return p.x == x && p.y==y;
            }
            return false;
        }

        @Override
        public String toString()
        {
            return x + " "+ y;
        }
        
        public int hashCode()
        {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }
    
    } 

    static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static long pow(long n, long p, long m) {
        long result = 1;
        if (p == 0) {
            return 1;
        }

        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            if (result >= m) {
                result %= m;
            }
            p >>= 1;
            n *= n;
            if (n >= m) {
                n %= m;
            }
        }
        return result;
    }

    static long pow(long n, long p) {
        long result = 1;
        if (p == 0) {
            return 1;
        }

        while (p != 0) {
            if (p % 2 == 1) {
                result *= n;
            }
            p >>= 1;
            n *= n;
        }
        return result;
    }

    static class InputReader
    {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
                this.stream = stream;
        }

        public int snext()
        {
                if (snumChars == -1)
                        throw new InputMismatchException();
                if (curChar >= snumChars)
                {
                        curChar = 0;
                        try
                        {
                                snumChars = stream.read(buf);
                        } catch (IOException e)
                        {
                                throw new InputMismatchException();
                        }
                        if (snumChars <= 0)
                                return -1;
                }
                return buf[curChar++];
        }

        public int nextInt()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                int res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public long nextLong()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                long res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public int[] nextIntArray(int n)
        {
                int a[] = new int[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextInt();
                }
                return a;
        }

        public long[] nextLongArray(int n)
        {
                long a[] = new long[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextLong();
                }
                return a;
        }

        public String readString()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isSpaceChar(c));
                return res.toString();
        }

        public String nextLine()
        {
                int c = snext();
                while (isSpaceChar(c))
                        c = snext();
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isEndOfLine(c));
                return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
                if (filter != null)
                        return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c)
        {
                return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter
        {
                public boolean isSpaceChar(int ch);
        }

    }
}    
