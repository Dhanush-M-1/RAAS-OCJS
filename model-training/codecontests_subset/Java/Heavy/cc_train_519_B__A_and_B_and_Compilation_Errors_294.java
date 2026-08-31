
import java.util.*;
import java.io.*;

public class B
{
   public static void main(String[] args)
   {
      PrintWriter out = new PrintWriter(System.out);
      new B(new FastScanner(), out);
      out.close();
   }

   int findError(ArrayList<Integer> a, ArrayList<Integer> b)
   {
      for (int i=0; i<b.size(); i++)
         if (!a.get(i).equals(b.get(i)))
            return a.get(i);
      return a.get(a.size()-1);
   }

   public B(FastScanner in, PrintWriter out)
   {
      int N = in.nextInt();
      ArrayList<Integer> cur = new ArrayList<Integer>();
      for (int i=0; i<N; i++)
         cur.add(in.nextInt());
      Collections.sort(cur);
      ArrayList<Integer> nxt = new ArrayList<Integer>();
      for (int i=1; i<N; i++)
         nxt.add(in.nextInt());
      Collections.sort(nxt);
      System.out.println(findError(cur, nxt));
      cur = nxt;
      nxt = new ArrayList<>();
      for (int i=2; i<N; i++)
         nxt.add(in.nextInt());
      Collections.sort(nxt);
      System.out.println(findError(cur, nxt));
   }
}

class FastScanner{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    
    public FastScanner()
    {
        stream = System.in;
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
