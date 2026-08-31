import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.regex.*;

public class Main{
	 
	public static void main(String[] args)
   {
       InputReader in=new InputReader(System.in);
       PrintWriter pw = new PrintWriter(System.out);
       int n=in.nextInt();
       long d=in.nextLong();
       long a[]=new long [n];
       for(int i=0;i<n;i++) {
    	   a[i]=in.nextLong();
       }
       long val=0;
       long want[]=new long[n];
       for(int i=0;i<n;i++) {
    	   if(a[i]==0) {
    		   if(val<0) {
    			   want[i]=-1L*val;
    			   val=0L;
    		   }
    	   }
    	   else
    	   {
    		   val+=a[i];
    	   }
    	   if(val>d) {
    		   pw.println(-1);
    		   pw.flush();
    		   pw.close();
    		   System.exit(0);
    	   }
    	   a[i]=val;
       }
       int ans=0;
       long have=0;
       for(int i=n-1;i>=0;i--) {
    	   have+=want[i];
    	   if(a[i]+have>d) {
    		   have=0;
    		   ans++;
    	   }
       }
       if(have>0)
    	   ans++;
       pw.println(ans);
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
        public static long mod = 1000000007;
        public static int d;
        public static int p;
        public static int q;
        
        public static int[] suffle(int[] a,Random gen)
        {
            int n = a.length;
            for(int i=0;i<n;i++)
            {
                int ind = gen.nextInt(n-i)+i;
                int temp = a[ind];
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
        
       /* public static long primeFactorization(long n)
        {
             HashSet<Integer> a =new HashSet<Integer>();
        	long cnt=0;
            for(int i=2;i*i<=n;i++)
            {
                while(a%i==0)
                {
                    a.add(i);
                    a/=i;
                }
            }
            if(a!=1)
            	cnt++;
                //a.add(n);
            return cnt;
        }*/
        
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
        
        public static int GCD(int a,int b)
        {
            if(b==0)
                return a;
            else
                return GCD(b,a%b);
        }
        
        public static long GCD(long a,long b)
        {
            if(b==0)
                return a;
            else
                return GCD(b,a%b);
        }
        
        public static void extendedEuclid(int A,int B)
        {
            if(B==0)
            {
                d = A;
                p = 1 ;
                q = 0;
            }
            else
            {
                extendedEuclid(B, A%B);
                int temp = p;
                p = q;
                q = temp - (A/B)*q;
            }
        }
        
        public static long LCM(long a,long b)
        {
            return (a*b)/GCD(a,b);
        }
        
        public static int LCM(int a,int b)
        {
            return (a*b)/GCD(a,b);
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
        
        public static boolean isPrime(int n)
        {
            
            if (n <= 1)  return false;
            if (n <= 3)  return true;
            
            if (n%2 == 0 || n%3 == 0) 
                return false;
         
            for (int i=5; i*i<=n; i=i+6)
            {
                if (n%i == 0 || n%(i+2) == 0)
                   return false;
            }
            
            return true;
        }
        
         public static long[] shuffle(long[] a, Random gen){ 
                for(int i = 0, n = a.length;i < n;i++){ 
                    int ind = gen.nextInt(n-i)+i; 
                    long d = a[i]; 
                    a[i] = a[ind]; 
                    a[ind] = d; 
                } 
                return a; 
            }
         static class pair implements Comparable<pair>{
        	 Long x;
             Long y;
             Integer z;
             pair(long l,long y2,int z){
                 this.x=l;
                 this.y=y2;
                 this.z=z;
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
 
      
}