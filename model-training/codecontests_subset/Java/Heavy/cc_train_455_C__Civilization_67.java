
//package practice;
import java.util.*;
import java.io.*;


public class Practice {
    

    static int[] p;
    static int[] len;
    static ArrayList<Integer>[] list;
    static int at;
    static int mx;
    
    public static void main(String args[])
    { 
      InputReader in=new InputReader(System.in);
      int n=in.nextInt();
      int m=in.nextInt();
      int q=in.nextInt();
      StringBuilder out=new StringBuilder();
      p=new int[n];
      len=new int[n];
      list=new ArrayList[n];
      for(int i=0;i<n;i++)
      {
          p[i]=i;
          list[i]=new ArrayList<>();
      }
      while(m-->0)
      {
          int p1=in.nextInt()-1;
          int p2=in.nextInt()-1;
          list[p2].add(p1);
          list[p1].add(p2);
                  
          p[find(p1)]=find(p2);      
      }
      
      for(int i=0;i<n;i++)
      {
          if(p[i]==i)
          {
              len[i]=longest(i);
          } 
             
      }
      while(q-->0)
      {
          int ty=in.nextInt();
          if(ty==1)
          {
              int te=in.nextInt();
              out.append(len[find(te-1)]).append("\n");
          }
          else
          {
              int e1=find(in.nextInt()-1);
              int e2=find(in.nextInt()-1);
              if(e1==e2)
                  continue;
              len[e2]=Math.max(Math.max(len[e1],len[e2]),(len[e1]+1)/2+(len[e2]+1)/2+1);
              p[e1]=e2;
              
              
          }
      }
      System.out.println(out);
      
    }
    public static int find(int po)
    {
        if(p[po]==po)
            return po;
        return p[po]=find(p[po]);
    }
    public static int longest(int u)
    {
        at=0;
        mx=-1;
        dfs(-1,0,u);
        dfs(-1,0,at);
        return mx;
    }
    public static void dfs(int p,int cost, int u)
    {
        if(cost>mx)
        {
            mx=cost;
            at=u;
        }
        for(int w:list[u])
        {
            if(w!=p)
            dfs(u,cost+1,w);
        }
        
    }
      
    
    
    
    
 static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
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
 
        public int nextInt() {
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
                res += c & 15;
 
                c = read();
            } while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];
 
            for (int i = 0; i < arraySize; i++)
                array[i] = nextInt();
 
            return array;
        }
 
        public long nextLong() {
            int c = read();
 
            while (isSpaceChar(c))
                c = read();
 
            int sign = 1;
 
            if (c == '-') {
                sign = -1;
 
                c = read();
            }
 
            long result = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
 
                result *= 10;
                result += c & 15;
 
                c = read();
            } while (!isSpaceChar(c));
 
            return result * sign;
        }
 
        public long[] nextLongArray(int arraySize) {
            long array[] = new long[arraySize];
 
            for (int i = 0; i < arraySize; i++)
                array[i] = nextLong();
 
            return array;
        }
 
        public float nextFloat() // problematic
        {
            float result, div;
            byte c;
 
            result = 0;
            div = 1;
            c = (byte) read();
 
            while (c <= ' ')
                c = (byte) read();
 
            boolean isNegative = (c == '-');
 
            if (isNegative)
                c = (byte) read();
 
            do {
                result = result * 10 + c - '0';
            } while ((c = (byte) read()) >= '0' && c <= '9');
 
            if (c == '.')
                while ((c = (byte) read()) >= '0' && c <= '9')
                    result += (c - '0') / (div *= 10);
 
            if (isNegative)
                return -result;
 
            return result;
        }
 
        public double nextDouble() // not completely accurate
        {
            double ret = 0, div = 1;
            byte c = (byte) read();
 
            while (c <= ' ')
                c = (byte) read();
 
            boolean neg = (c == '-');
 
            if (neg)
                c = (byte) read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = (byte) read()) >= '0' && c <= '9');
 
            if (c == '.')
                while ((c = (byte) read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);
 
            if (neg)
                return -ret;
 
            return ret;
        }
 
        public String next() {
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String nextLine() {
            int c = read();
 
            StringBuilder result = new StringBuilder();
 
            do {
                result.appendCodePoint(c);
 
                c = read();
            } while (!isNewLine(c));
 
            return result.toString();
        }
 
        public boolean isNewLine(int c) {
            return c == '\n';
        }
 
        public void close() {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
    }
    
}

