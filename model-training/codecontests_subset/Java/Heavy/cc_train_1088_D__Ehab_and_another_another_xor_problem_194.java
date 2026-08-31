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
    public static long min(long a,long b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    public static int min(int a,int b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    public static long max(long a,long b)
    {
        if(a>b)
        {
            return a;
        }
        return b;
    }
    public static int max(int a,int b)
    {
        if(a>b)
        {
            return a;
        }
        return b;
    }
    static class pair
    {
      long x;
      long y;
      pair(long x,long y)
      {
        this.x = x;
        this.y = y;
      }
      public String toString()
      {
        return x+" "+y;
      }
    }
    public static int gcd(int a,int b)
    {
        if(a==0)
        return b;
        if(b==0)
        return a;
        while((a%=b)!=0&&(b%=a)!=0);
        return a^b;
    }
    static int num = (int)1e6;
    public static int random(int min,int max)
    {
      return min+(int)((max-min)*Math.random());
    }
    float min(float a,float b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
    float dist(float x1,float y1,float x2,float y2)
    {
        return (float)Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
    int mod(int x)
    {
        if(x>0)
        {
            return x;
        }
        return -x;
    }
    public static long pow(long n,int pow)
    {
        long res = 1;
        while(pow!=0)
        {
            if((pow&1)==1)
            {
                res *= n;
            }
            n *= n;
            pow = pow>>1;
        }
        return res;
    }
    public static int get_res(int a,int b,PrintWriter out,InputReader sc)
    {
        out.println("? "+a+" "+b);  
        out.flush();
        return sc.nextInt();
    }
    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(),"Main",1<<26).start();
    }    public void run() {
      InputReader sc  = new InputReader(System.in);
      PrintWriter out = new PrintWriter(System.out);
      int t1 = 1;
      while(t1-->0)
      {
          int cura = 0;
          int curb = 0;
          int gt = get_res(cura, curb,out,sc);
          for(int i=29;i>=0;i--)
          {
              int x = get_res(cura|1<<i,curb,out,sc);
              int y = get_res(cura,curb|1<<i,out,sc);
              if(x==y)
              {
                if(gt==1)
                {
                    cura |= 1<<i;                    
                }
                else
                {
                    curb |= 1<<i;
                }
                gt = x;
              }
              else
              {
                if(x==-1)
                {
                    cura |= 1<<i;
                    curb |= 1<<i;
                }
              }
          }
          out.println("! "+cura+" "+curb);
      }
      out.close();
  }
}