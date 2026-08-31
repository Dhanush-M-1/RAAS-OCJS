import java.util.*;
import java.io.*;
import java.math.BigInteger;
 
public class MainD
{
    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    static TreeSet<Integer> set;
    static TreeSet<Integer>[] g;
    static int sz;
    
    static void solve(int u){
        set.remove(u);
        boolean ok = true;
        sz++;
        while(ok){  
            ok = false;
            for(int v : set){
                if(g[u].contains(v)) continue;
                solve(v);
                ok = true;
                break;
            }
        }
    }
    
    public static void main(String[] args)
    {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);            
        
        int n = in.nextInt();
        int m = in.nextInt();
        g = new TreeSet[n];
        set = new TreeSet<>();

        for(int i = 0; i < n; i++){
            g[i] = new TreeSet<>();
            set.add(i);
        }
        
        for(int i = 0; i < m; i++){
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(!set.contains(i)) continue;
            sz = 0;
            solve(i);
            list.add(sz);
        }
        out.println(list.size());
        Collections.sort(list);
        for(int i : list)
            out.print(i + " ");
        out.println();
        out.close();
        
    }
    
    static void debug(Object... o)
    {
            System.out.println(Arrays.deepToString(o));
    }
 
    static class Pair implements Comparable<Pair>
    {
 
        int x,y;
        int i;
 
 
        Pair (int x,int y)
        {
                this.x = x;
                this.y = y;
        }
 
        Pair (int x,int y, int i)
        {
                this.x = x;
                this.y = y;
                this.i = i;
        }
 
        public int compareTo(Pair o)
        {
            if(this.x != o.x)
                return -Integer.compare(this.x, o.x);
            return -Integer.compare(this.y,o.y);
                //return 0;
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
            return x + " "+ y + " "+i;
        }
 
        /*public int hashCode()
        {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }*/
 
    } 
 
    static long add(long a,long b){
        long x=(a+b);
        while(x>=mod) x-=mod;
        return x;
    }
 
    static long sub(long a,long b){
        long x=(a-b);
        while(x<0) x+=mod;
        return x;
    }
    
    static long mul(long a,long b){
        long x=(a*b);
        while(x>=mod) x-=mod;
        return x;
    }
    
    static String rev(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    
    static long gcd(long x,long y)
    {
        if(y==0)
                return x;
        else
                return gcd(y,x%y);
    }
 
    static int gcd(int x,int y)
    {
        if(y==0)
                return x;
        else 
                return gcd(y,x%y);
    }
 
    static long pow(long n,long p,long m)
    {
         long  result = 1;
          if(p==0)
            return 1;
 
        while(p!=0)
        {
            if(p%2==1)
                result *= n;
            if(result>=m)
            result%=m;
            p >>=1;
            n*=n;
            if(n>=m)
            n%=m;
        }
        return result;
    }
 
    static long pow(long n,long p)
    {
        long  result = 1;
          if(p==0)
            return 1;
 
        while(p!=0)
        {
            if(p%2==1)
                result *= n;	    
            p >>=1;
            n*=n;	    
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