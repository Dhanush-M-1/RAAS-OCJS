
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.math.*;
import java.lang.*;
import java.util.PriorityQueue;
import static java.lang.Math.*;
@SuppressWarnings("unchecked")
public class Solution implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static int min(int a,int b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    public static int max(int a,int b)
    {
        if(a>b)
        {
            return a;
        }
        return b;
    }
    static class pair implements Comparable<pair>
  	{
  		int x;
  		int y;
  		pair(int x,int y)
  		{
  			this.x = x;
  			this.y = y;
  		}
  		public int compareTo(pair p)
  		{
  			if(this.x>p.x)
  			{
  				return 1;
  			}
  			else if(this.x<p.x)
  			{
  				return -1;
  			}
  			else
  			{
  				return this.y-p.y;
  			}
  		}
  	}
    public static long gcd(long a,long b)
    {
        if(a==0)
        return b;
        if(b==0)
        return a;
        while((a%=b)!=0&&(b%=a)!=0);
        return a^b;
    }
    public static int mod(int a)
    {
      if(a>0)
        return a;
      return -a;
    }
    static int mod = (int)1e9+7;
    public static long expo(long exp,long pow)
    {
      long ans = 1;
      while(pow!=0)
      {
        if((pow&1)==1)
        {
          ans = (ans*exp)%mod;
        }
        exp = (exp*exp)%mod;
        pow = pow>>1;
      }
      return ans;
    }
    static int[] a;
    public static boolean bsearch(int val)
    {
      int l = 0;
      int r = a.length-1;
      while(r>=l)
      {
        int mid = (l+r)/2;
        if(a[mid]>val)
        {
          r = mid-1;
        }
        else if(a[mid]<val)
        {
          l = mid+1;
        }
        else
        {
          return true;
        }
      }
      return false;
    }
    static int max = (int)1e6;
    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(),"Main",1<<26).start();
    }
    public void run() {
        InputReader sc  = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t1 = 1;
		    while(t1-->0)
        {
          int n = sc.nextInt();
          int s = sc.nextInt();
          ArrayList<Integer> lessthans = new ArrayList<>();
          ArrayList<Integer> morethans = new ArrayList<>();
          ArrayList<Integer> equals = new ArrayList<>();
          for(int i=0;i<n;i++)
          {
            int x = sc.nextInt();
            if(x>=s)
            {
              morethans.add(x);
            }
            else if(x<s)
            {
              lessthans.add(x);
            }
          }
          Collections.sort(lessthans);
          Collections.sort(morethans);
          long ans = 0;
          int len1 = lessthans.size();
          int len2 = morethans.size();
          if(len1>len2)
          {
            for(int i=n/2;i<len1;i++)
            {
              ans+=(s-lessthans.get(i));
            }
          }
          else
          {
            for(int i=0;i<len2-n/2;i++)
            {
              ans+=(morethans.get(i)-s);
            }
          }
          out.println(ans);
		    }
		    out.close();
   }
}
