import java.util.*;
import java.io.*;

public class Problem
{

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;

    static int[] logTable;
    static int[][] rmq;

    static void sparseTable(int[] a)
    {
        int n = a.length;

        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++)
            logTable[i] = logTable[i >> 1] + 1;

        rmq = new int[logTable[n] + 1][n];

        for (int i = 0; i < n; ++i)
            rmq[0][i] = a[i];
      
        for (int k = 1; (1 << k) < n; ++k) {
            for (int i = 0; i + (1 << k) <= n; i++) {
                int x = rmq[k - 1][i];
                int y = rmq[k - 1][i + (1 << k - 1)];
                rmq[k][i] = x | y;
            }
        }
    }

    static int get(int i, int j)
    {
        int k = logTable[j - i];
        int x = rmq[k][i];
        int y = rmq[k][j - (1 << k) + 1];
        return x | y;
    }
    
    public static void main(String[] args)
    {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);            
        
        int n = in.nextInt();
        int[] arr = in.nextIntArray(n);
        long ans = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        sparseTable(arr);
        
        for(int i = 0; i < n; i++){
            int l = 0;
            int r = i;
            long idx1 = i;
            if(map.containsKey(arr[i])) l = map.get(arr[i]) + 1;            
            while(r - l >= 0){
                int m = (r + l) >> 1;
                if(get(m, i) == arr[i]){
                    idx1 = m;
                    r = m - 1;
                }
                else l = m + 1;
            }
            l = i;
            r = n - 1;
            long idx2 = i;
            while(r - l >= 0){
                int m = (r + l) >> 1;
                if(get(i, m) == arr[i]){
                    idx2 = m;
                    l = m + 1;
                }
                else r = m - 1;
            }
            ans += (i - idx1 + 1) * (idx2 - i + 1);
            //debug(i,idx1,idx2);
            map.put(arr[i], i);
        }
        ans = (n * 1l * (n + 1)) / 2 - ans;
        out.println(ans);
        
        out.close();
    }

    static int min(int a, int b){
        if(a <= b)
            return a;
        return b;
    }
    
    static void debug(Object... o)
    {
            System.out.println(Arrays.deepToString(o));
    }

    static class Pair implements Comparable<Pair>
    {

        int x,y,i;
        
        Pair (int x, int y, int i)
        {
		this.x = x;
                this.y = y;
                this.i = i;
	}
        
        Pair (int x, int y)
        {
		this.x = x;
                this.y = y;
	}
	
	public int compareTo(Pair o) {
                return Integer.compare(this.y,o.y);
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
            return x + " "+ y + " "+ i;
        }
        
        public int hashCode()
        {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }
    
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
