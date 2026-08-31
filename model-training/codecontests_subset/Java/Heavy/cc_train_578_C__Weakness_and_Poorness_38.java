
import java.util.*;
import java.io.*;

/**
 *
 * @author usquare
 * 
 */

public class ProblemA {

    public static int mod = (int) (1e9+7);
    public static InputReader in;
    public static PrintWriter out;
    public static double[] arr;
    
    public static double solve(double x){
        double ans=0;
        double sum1=0,sum2=0;
        
        for(int i=0;i<arr.length;i++){
            sum1+=arr[i]-x;
            sum2+=x-arr[i];
            ans=Math.max(sum1, ans);
            ans=Math.max(sum2, ans);
            sum1=Math.max(sum1, 0);
            sum2=Math.max(sum2, 0);
        }
        
        return ans;
    }
    
    public static void main(String[] args){
        
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        
        int n=in.nextInt();
        arr=new double[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int cnt=100;
        double l=-1e5;
        double r=1e5;
        
        while(cnt-->0){
            double m1=l+(r-l)/3;
            double m2=r-(r-l)/3;
            
            if(solve(m1)>solve(m2)) l=m1;
            else r=m2;
        }
        
        out.printf("%.6f",solve(l));
        out.close();
    }
    
    static class Pair implements Comparable<Pair>{

        int x,y;
        
//	Pair (int x,int y,int i){
//		this.x=x;
//		this.y=y;
//		this.i=i;
//	}

	Pair (int x,int y){
		this.x=x;
		this.y=y;
	}
        
	public int compareTo(Pair o) {
                    return Long.compare(this.x,o.x);
		//return 0;
	}

        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair)o;
                return p.x == x && p.y == y ;
            }
            return false;
        }
        public int hashCode() {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode();
        }
    
    } 
    
    static long[] shuffle(long[] a, Random gen){ 
        for(int i = 0, n = a.length;i < n;i++){ 
            int ind = gen.nextInt(n-i)+i; 
            long d = a[i]; 
            a[i] = a[ind]; 
            a[ind] = d; 
        } 
        return a; 
    }

        
    public static long add(long a,long b){
        long x=(a+b);
        while(x>=mod) x-=mod;
        return x;
    }

    public static long sub(long a,long b){
        long x=(a-b);
        while(x<0) x+=mod;
        return x;
    }
    
    public static long mul(long a,long b){
        a%=mod;
        b%=mod;
        long x=(a*b);
        return x%mod;
    }
    
    static boolean isPal(String s){
        for(int i=0, j=s.length()-1;i<=j;i++,j--){
                if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
    static String rev(String s){
            StringBuilder sb=new StringBuilder(s);
            sb.reverse();
            return sb.toString();
    }

    static long gcd(long x,long y){
        if(y==0) return x;
    if(x%y==0)
            return y;
    else
            return gcd(y,x%y);
    }

    static int gcd(int x,int y){
        if(y==0) return x;
    if(x%y==0)
            return y;
    else 
            return gcd(y,x%y);
    }

    static long gcdExtended(long a,long b,long[] x){

        if(a==0){
            x[0]=0;
            x[1]=1;
            return b;
        }
        long[] y=new long[2];
        long gcd=gcdExtended(b%a, a, y);

        x[0]=y[1]-(b/a)*y[0];
        x[1]=y[0];

        return gcd;
    }

    static int abs(int a,int b){
    return (int)Math.abs(a-b);
    }

    static long abs(long a,long b){
    return (long)Math.abs(a-b);
    }

    static int max(int a,int b){
    if(a>b)
            return a;
    else
            return b;
    }

    static int min(int a,int b){
    if(a>b)
            return b;
    else 
            return a;
    }

    static long max(long a,long b){
    if(a>b)
            return a;
    else
            return b;
    }

    static long min(long a,long b){
    if(a>b)
            return b;
    else 
            return a;
    }


    public static long pow(long n,long p,long m){
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
    
    public static long pow(long n,long p){
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
    
     static void debug(Object... o) {
            System.out.println(Arrays.deepToString(o));
    }

    static class InputReader {

            private final InputStream stream;
            private final byte[] buf = new byte[8192];
            private int curChar, snumChars;
            private SpaceCharFilter filter;

            InputReader(InputStream stream) {
                    this.stream = stream;
            }

            int snext() {
                    if (snumChars == -1)
                            throw new InputMismatchException();
                    if (curChar >= snumChars) {
                            curChar = 0;
                            try {
                                    snumChars = stream.read(buf);
                            } catch (IOException e) {
                                    throw new InputMismatchException();
                            }
                            if (snumChars <= 0)
                                    return -1;
                    }
                    return buf[curChar++];
            }

            int nextInt() {
                    int c = snext();
                    while (isSpaceChar(c)) {
                            c = snext();
                    }
                    int sgn = 1;
                    if (c == '-') {
                            sgn = -1;
                            c = snext();
                    }
                    int res = 0;
                    do {
                            if (c < '0' || c > '9')
                                    throw new InputMismatchException();
                            res *= 10;
                            res += c - '0';
                            c = snext();
                    } while (!isSpaceChar(c));
                    return res * sgn;
            }

            long nextLong() {
                    int c = snext();
                    while (isSpaceChar(c)) {
                            c = snext();
                    }
                    int sgn = 1;
                    if (c == '-') {
                            sgn = -1;
                            c = snext();
                    }
                    long res = 0;
                    do {
                            if (c < '0' || c > '9')
                                    throw new InputMismatchException();
                            res *= 10;
                            res += c - '0';
                            c = snext();
                    } while (!isSpaceChar(c));
                    return res * sgn;
            }

            int[] nextIntArray(int n) {
                    int a[] = new int[n];
                    for (int i = 0; i < n; i++) {
                            a[i] = nextInt();
                    }
                    return a;
            }

            long[] nextLongArray(int n) {
                    long a[] = new long[n];
                    for (int i = 0; i < n; i++) {
                            a[i] = nextInt();
                    }
                    return a;
            }

            String readString() {
                    int c = snext();
                    while (isSpaceChar(c)) {
                            c = snext();
                    }
                    StringBuilder res = new StringBuilder();
                    do {
                            res.appendCodePoint(c);
                            c = snext();
                    } while (!isSpaceChar(c));
                    return res.toString();
            }

            String nextLine() {
                    int c = snext();
                    while (isSpaceChar(c))
                            c = snext();
                    StringBuilder res = new StringBuilder();
                    do {
                            res.appendCodePoint(c);
                            c = snext();
                    } while (!isEndOfLine(c));
                    return res.toString();
            }

            boolean isSpaceChar(int c) {
                    if (filter != null)
                            return filter.isSpaceChar(c);
                    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            private boolean isEndOfLine(int c) {
                    return c == '\n' || c == '\r' || c == -1;
            }

            interface SpaceCharFilter {
                    boolean isSpaceChar(int ch);
            }
    }
}    

