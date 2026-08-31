/*
10 100000
31514 7
43285 4660
39669 3899
60022 838
33584 643
78825 16
824 32
51664 31
15433 476
14295 591

-- 44144
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.math.*;
 
public class Main{
    static ArrayList[] a=new ArrayList[200001];
    static boolean visited [];
    static void dfs(int n , int x) {
    	visited[n] = true;
    	for(int i = 0 ;i < a[n] .size() ; i++) {
    		int idx = (int) a[n].get(i);
    		if(!visited[idx] && idx != x) {
    			dfs(idx , x);
    		}
    	}
    }
   
     public void solve () throws FileNotFoundException  {
    	InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t -- >0) {
        	int n = in.nextInt();
        	int m = in.nextInt();
        	int r = in.nextInt();
        	int b = in.nextInt();
        	for(int i = 0 ; i <= n;i++) {
        		a[i] = new  ArrayList<Integer>();
        	}
        	for(int i = 0 ; i < m ;i++) {
        		int x = in.nextInt();
        		int y = in.nextInt();
        		a[x].add(y);
        		a[y].add(x);
        	}
        	visited = new boolean [n + 1];
        	dfs(r,b);
        	long cnt  = 0;
        	for(int i = 1 ; i <= n ;i++) {
        		if(!visited[i]) cnt++;
        		visited[i] = false;
        	}
        	dfs(b,r);
        	long cnt1  = 0;
        	for(int i = 1 ; i <= n ;i++) {
        		if(!visited[i]) cnt1++;
        	}
        	cnt -- ;
        	cnt1 --;
        
        	pw.println(cnt * cnt1);
        	
        }
        pw.flush();
        pw.close();
    }
    public static void main(String[] args) throws Exception {
        
        
        new Thread(null,new Runnable() {
            public void run() {
                    try {
						new Main().solve();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
        },"1",1<<26).start();
        
        
    }
   
    static void debug(Object... o) {
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
        public static long mod = 1000000007;
        public static int d;
        public static int p;
        public static int q;
        public void extended(int a,int b) {
            if(b==0) {
                d=a;
                p=1;
                q=0;
            }
            else
            {
                extended(b,a%b);
                int temp=p;
                p=q;
                q=temp-(a/b)*q;
            }
        }
       
        
        public static long binaryExponentiation(long x,long n)
        {
            long result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=result * x;
                x=x*x;
                n=n/2;
            }
            return result;
        }
        
        public static long[] shuffle(long[] a,Random gen)
        {
            int n = a.length;
            for(int i=0;i<n;i++)
            {
                int ind = gen.nextInt(n-i)+i;
                long temp = a[ind];
                a[ind] = a[i];
                a[i] = temp;
            }
            return a;
        }
        
        public static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        public static HashSet<Integer> primeFactorization(int n)
        {
            HashSet<Integer> a =new HashSet<Integer>();
            for(int i=2;i*i<=n;i++)
            {
                while(n%i==0)
                {
                    a.add(i);
                    n/=i;
                }
            }
            if(n!=1)
                a.add(n);
            return a;
        }
        
        public static void sieve(boolean[] isPrime,int n)
        {
            for(int i=1;i<n;i++)
                isPrime[i] = true;
            
            isPrime[0] = false;
            isPrime[1] = false;
            
            for(int i=2;i*i<n;i++)
            {
                if(isPrime[i] == true)
                {
                    for(int j=(2*i);j<n;j+=i)
                        isPrime[j] = false;
                }
            }
        }
        
        public static long GCD(long n,long m)
        {
            if(m==0)
                return n;
            else
                return GCD(m,n%m);
        }
        public static long LCM (long a,long b) {
            return ((a*b)/(GCD(a,b)));
        }
        
        static class pair implements Comparable<pair>
        {
        	Integer x;
        	Integer y;
            
            pair(int x ,int y)
            {
                this.x=x;
                this.y=y;
            }

           
			public int compareTo(pair o) {
                int result = x.compareTo(o.x);
                if(result==0)
                    result = y.compareTo(o.y);
                
                return result;
            }  
            
            public String toString()
            {
                return x+" "+y;
            }
            
            public boolean equals(Object o)
            {
                if (o instanceof pair)
                {
                    pair p = (pair)o;
                    return p.x == x && p.y == y ;
                }
                return false;
            }
            
            public int hashCode()
            {
                return new Double(x).hashCode()*31 + new Long(y).hashCode();
            }
        }
        public static int binaryExponentiation(int x,int n)
        {
            int result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=result * x;
                x=x*x;
                n=n/2;
            }
            return result;
        }
        
       
        
        public static int modularExponentiation(int x,int n,int M)
        {
            int result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=(result * x)%M;
                x=(x%M*x)%M;
                n=n/2;
            }
            return result;
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
        
    	            
         
}
