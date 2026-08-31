
import java.util.*;
import java.io.*;

public class C
{
   public static void main(String[] args) throws Exception
   {
      PrintWriter out = new PrintWriter(System.out);
      new C(new FastScanner(System.in), out);
      out.close();
   }

   public C(FastScanner in, PrintWriter out)
   {
      ArrayDeque<Integer> stk = new ArrayDeque<>();

      int N = in.nextInt();
      int M = in.nextInt();
      int[] weight = new int[N];
      for (int i=0; i<N; i++)
         weight[i] = in.nextInt();
   
      int[] cmd = new int[M];
      for (int i=0; i<M; i++)
      {
         int v = cmd[i] = in.nextInt()-1;
         if (!stk.contains(v))
            stk.addLast(v);
      }

      int res = 0;
      ArrayDeque<Integer> stk2 = new ArrayDeque<>();
      for (int v : cmd)
      {
         while (stk.peek().intValue() != v)
            stk2.push(stk.pop());
         stk.pop();

         while (stk2.size() > 0)
         {
            int vv = stk2.pop();
            res += weight[vv];
            stk.push(vv);
         }
         stk.push(v);
      }
      out.println(res);
   }
}

class FastScanner{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    
    public FastScanner(InputStream stream)
    {
        this.stream = stream;
    }
    
    int read()
    {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars){
            curChar = 0;
            try{
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
    
    boolean isSpaceChar(int c)
    {
        return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
    }
    
    boolean isEndline(int c)
    {
        return c=='\n'||c=='\r'||c==-1;
    }
    
    int nextInt()
    {
        return Integer.parseInt(next());
    }
    
    long nextLong()
    {
        return Long.parseLong(next());
    }
    
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
    
    String next(){
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do{
            res.appendCodePoint(c);
            c = read();
        }while(!isSpaceChar(c));
        return res.toString();
    }
    
    String nextLine(){
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do{
            res.appendCodePoint(c);
            c = read();
        }while(!isEndline(c));
        return res.toString();
    }
}
