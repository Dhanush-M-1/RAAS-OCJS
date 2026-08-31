import java.io.*;
import java.util.*;
 
 
public class Myclass {
    // static ArrayList a[]=new ArrayList[300001];
     static long dis(long a,long b,long c) {
    	 return (Math.abs(a-b)+Math.abs(c-b));
     }
     public static void main(String[] args) throws FileNotFoundException
    {
        InputReader in=new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
       int n=in.nextInt();
       int m=in.nextInt();
       long p=in.nextLong();
       long a[]=new long[n];
       long b[]=new long[m];
       for(int i=0;i<n;i++) {
    	   a[i]=in.nextLong();
       }
       for(int i=0;i<m;i++) {
    	   b[i]=in.nextLong();
       }
       Arrays.sort(a);
       Arrays.sort(b);
       long dp[][]=new long[n+1][m+1];
       for(int i=1;i<=n;i++)
    	   Arrays.fill(dp[i], (long) 1e18);
       for(int i=1;i<=n;i++) {
    	   for(int j=i;j<=m;j++) {
    		   dp[i][j]=Math.min(dp[i][j-1],dp[i][j]);
    		   dp[i][j]=Math.min(dp[i][j], Math.max(dp[i-1][j-1],dis(a[i-1],b[j-1],p)));
    	   }
       }
       pw.println(dp[n][m]);
        pw.flush();
        pw.close();
 
    }
    private static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
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
                } 
                
                catch (IOException e) 
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
        static class tri implements Comparable<tri> {
            int p, c, l;
 
            tri(int p, int c, int l) {
                this.p = p;
                this.c = c;
                this.l = l;
            }
 
            public int compareTo(tri o) {
                return Integer.compare(l, o.l);
            }
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
   public static long modularExponentiation(long x,long n,long M)
   {
       long result=1;
       while(n>0)
       {
           if(n % 2 ==1)
               result=(result%M * x%M)%M;
           x=(x%M * x%M)%M;
           n=n/2;
       }
       return result;
   }
   
   public static long modInverse(int A,int M)
   {
       return modularExponentiation(A,M-2,M);
   }
   
   public static long modInverse(long A,long M)
   {
       return modularExponentiation(A,M-2,M);
   }
    static class pair implements Comparable<pair>{
        Long x;
        Long y;

        pair(long x,long w){
            this.x=x;
            this.y=w;
        }
        
		public int compareTo(pair o) {
                int result = x.compareTo(o.x);
                if(result==0)
                    result = y.compareTo(o.y);
                
            return result;
            }  
         public String toString(){
            return (x+" "+y);
        }
  }
    static class query{
    	Double x;
    	Integer y;
    	query(double x,int y){
    		this.x=x;
    		this.y=y;
    	}
    }
    
}
 