import java.util.*;
import java.io.*;
//import javafx.util.Pair;
public class Solution implements Runnable 
{  
    
    class Pair implements Comparable <Pair>
    {
        long x,y;
        Pair(long x,long y)
        {
            this.x=x;
            this.y=y; 
        }
        public int compareTo(Pair p)
        {
            return Long.compare(x,p.x);
        }
    }
    
    public static void main(String[] args)
    {
        new Thread(null, new Solution(), "rev", 1 << 29).start();
    }

    public void run()
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1,in,out);
        out.close();
    }
    
    class Task
    { 
        
        void solve(int testNumber, InputReader in, PrintWriter out)
        { 
            int a=0,b=0,big,a1,b1;
            out.println("? "+a+" "+b);
            out.flush();
            big=in.nextInt();
            for(int i=29;i>=0;i--)
            {
                out.println("? "+(a^(1<<i))+" "+b);
                out.flush();
                a1=in.nextInt();
                out.println("? "+a+" "+(b^(1<<i)));
                out.flush();
                b1=in.nextInt();
                if(a1==b1)
                {
                    if(big==1)
                        a^=(1<<i);
                    else
                        b^=(1<<i);
                    big=a1;
                }
                else if(a1==-1)
                {
                    a^=(1<<i);
                    b^=(1<<i);
                }
            }
            out.println("! "+a+" "+b);
        }
    }
    
}
  class InputReader 
{
    private InputStream stream;
    private byte[] buf = new byte[8192];
    private int curChar, snumChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) 
    {
        this.stream = stream;
    }
 
    public int snext() 
    {
        if(snumChars==-1)
            throw new InputMismatchException();
        if(curChar>=snumChars)
        {
            curChar=0;
            try 
            {
                snumChars = stream.read(buf);                
            } 
            catch(IOException e) 
            {
                throw new InputMismatchException();
            }
            if(snumChars<=0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int nextInt()
    {
        int c = snext();
        while(isSpaceChar(c))
            c=snext();
        int sgn=1;
        if(c=='-')
        {
            sgn = -1;
            c = snext();
        }
        int res=0;
        do
        {
            if(c<'0' || c>'9')
                throw new InputMismatchException();
            res*=10;
            res+=c-'0';
            c=snext();
            }while(!isSpaceChar(c));
        return res * sgn;
    }
 
    public long nextLong()
    {
        int c = snext();
        while(isSpaceChar(c))
            c=snext();
        int sgn=1;
        if(c=='-')
        {
            sgn=-1;
            c=snext();
        }
        long res=0;
        do{
            if (c<'0' || c>'9')
                throw new InputMismatchException();
            res*=10;
            res+=c-'0';
            c=snext();
        }while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public int[] nextIntArray(int n)
    {
        int a[]=new int[n];
        for(int i=0; i<n; i++)
            a[i]=nextInt();
        return a;
    }
 
    public String nextString()
    {
        int c=snext();
        while(isSpaceChar(c))
            c=snext();
        StringBuilder res=new StringBuilder();
        do{
            res.appendCodePoint(c);
            c = snext();
        }while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c)
    {
        if(filter != null)
            return filter.isSpaceChar(c);
        return c==' ' || c=='\n' || c=='\r' || c=='\t' || c==-1;
    }
 
    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
}