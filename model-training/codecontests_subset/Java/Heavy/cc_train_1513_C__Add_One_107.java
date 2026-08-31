//package clipse;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.*;
import java.math.*;


public class A
{
	static StringBuilder sb;
	static dsu dsu;
	static int dp[];
	static int mod=(int)(1e9+7);
	
	static void solve()
   {
		char c[]=s().toCharArray();
		int m=i();
		long v=0;
		//System.out.println(Arrays.toString(c)+"ooo"+m);
		
		for(int i=0;i<c.length;i++)
		{
			v=(v%mod+dp[c[i]-'0'+m]%mod)%mod;
		}
		sb.append(v+"\n");
	
	
	}
	
	
	
	
	 public static void main(String[] args)
	    {
	         int max=2*(int)(1e5);
		 dp=new int[max+10];
		 for(int i=0;i<=9;i++)
			 dp[i]=1;
		 
		 for(int i=10;i<dp.length;i++)
			 dp[i]=(dp[i-9]%mod+dp[i-10]%mod)%mod;
		 
		 
		 
		 
		 
		 
		 
	         sb=new StringBuilder();
	        int test=i();
	        while(test-->0) 
	        {
	        	 solve();
	        }
	        
	         System.out.println(sb);
	      
	      
	         
	    }
	 
	 //*********************************Disjoint set union*************************//
	 static class dsu
	 {
		 int parent[];
		 int size[];
		 dsu(int n)
		 {
			 parent=new int[n];
			 size=new int[n];
			 Arrays.fill(size,-1);
			 for(int i=0;i<n;i++)
				 parent[i]=-1;
		 }
		 int find(int a)
		 {
			 if(parent[a]<0)
				 return a;
			 else
			 {
				 int x=find(parent[a]);
				 parent[a]=x;
				 return x;
			 }
		 }
		 void merge(int a,int b)
		 {
			 a=find(a);
			 b=find(b);
			 if(a==b)
				 return;
			 parent[b]=a;
			 size[a]+=size[b];
		 }
	 }
	 
	 
	 
//*******************************************PRIME FACTORIZE *****************************************************************************************************//
	 static TreeMap<Integer,Integer> prime(long n)
	 {
		 TreeMap<Integer,Integer>h=new TreeMap<>();
		 long num=n;
		 for(int i=2;i<=Math.sqrt(num);i++)
		 {
			 if(n%i==0)
			 {
				 int nt=0;
				 while(n%i==0) {
					 n=n/i;
					 nt++;
				 }
				 h.put(i, nt);
			 }
		 }
		 if(n!=1)
			 h.put((int)n, 1);
		 return h;
		 
	 }
	 
	
	
//*************CLASS PAIR ***********************************************************************************************************************************************
	    static class pair implements Comparable<pair>
	    {
	        int x;
	        int y;

	        pair(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	        public int compareTo(pair o)
	        {
	        	return x-o.x==0?y-o.y:x-o.x;
	        	
	        }
			
	       
	    }
//*************CLASS PAIR *****************************************************************************************************************************************************
	
	
	

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int Int() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String String() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return String();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);
    static int modulus = (int) 1e7;

    public static int[] sort(int[] a) {
        int n = a.length;
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++)
            a[i] = l.get(i);
        return a;
    }

    public static long pow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0) {
                res = (res * x) % modulus;
                y--;

            }
            x = (x * x) % modulus;
            y = y / 2;
        }
        return res;
    }
//GCD___+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static long gcd(long x, long y) {
        if (x == 0)
            return y;
        else
            return gcd(y % x, x);
    }
    //****************LOWEST COMMON MULTIPLE   *************************************************************************************************************************************

    public static long lcm(long x, long y) {
        return (x * (y / gcd(x, y)));
    }
//INPUT PATTERN******************************************************************************************************************************************************************
    public static int i() {
        return in.Int();
    }

    public static long l() {
        String s = in.String();
        return Long.parseLong(s);
    }

    public static String s() {
        return in.String();
    }

    public static int[] readArray(int n) {
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i();
        }
        return A;
    }

    public static long[] readArray(long n) {
        long A[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
            A[i] = l();
        }
        return A;
    }

}






	