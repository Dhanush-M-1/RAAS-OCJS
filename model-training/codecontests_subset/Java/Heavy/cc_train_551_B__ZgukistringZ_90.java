import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.io.InputStream;
import java.io.DataInputStream;
 
 
public class Main
{//static{ System.out.println(" hello ");}

   
  public static void main(String[] args) throws IOException
     { 
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader scn = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        String s=scn.ns();
        int len=s.length();
        boolean visited[]=new boolean[200];
        boolean visited1[]=new boolean[200];
        int arr[]=new int[200];
        int reqd1[]=new int[200];
        int reqd2[]=new int[200];
        String a=scn.ns();
        int l1=a.length();
        
        String b=scn.ns();
        int l2=b.length();
        
        for (int i=0;i<len;i++)
        {
            char ch=s.charAt(i);
            arr[ch]++;
            
            
        }   
        
          for (int i=0;i<l1;i++)
        {
            char ch=a.charAt(i);
           reqd1[ch]++;
            
        } 
         
        
        for (int i=0;i<l2;i++)
        {
            char ch=b.charAt(i);
           reqd2[ch]++;
            
        } 
        
       
        int min=10000000;
        for (int i=97;i<=122;i++)
        {
            if (reqd1[i]!=0)
            {
                min=Math.min(min,arr[i]/reqd1[i]);
                
                
            }  
            
            
        }   
        int max=-1;int qqq=-1;int www=-1;
        for (int j=0;j<=min;j++)
        {
            int arr2[]=new int[200];
            for (int i=97;i<=122;i++)
            {arr2[i]=arr[i];
            }
            
            
            for (int i=97;i<=122;i++)
            {
                arr2[i]-=j*reqd1[i];
                
                
            }
            int mini=10000000;
             for (int i=97;i<=122;i++)
             {    if (reqd2[i]!=0)
                 mini=Math.min(mini,arr2[i]/reqd2[i]);
                 
                 
                }    
            
            if (j+mini>max){ max=j+mini; qqq=j; www=mini;}
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }  
        
        for (int i=1;i<=qqq;i++) out.print(a);
         for (int i=1;i<=www;i++) out.print(b);
        
        for (int i=97;i<=122;i++)
        arr[i]=arr[i]-(qqq*reqd1[i]+www*reqd2[i]);
        
        for (int i=97;i<=122;i++)
        {
            for (int j=1;j<=arr[i];j++)
            {
                out.print((char)i);
        
        
        
        
            }
        }    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
          out.close();
     }
    
     
     
  
   }       
  class num implements Comparator<num>
    {
        
        public int start;
        public int end;
        num()
        {
            
        }
        num(int x,int y)
        {
            this.start = x;
            this.end =y;
        }
        public int getstart()
        {
        return start;
        }
        public int getend()
        {
        return end;
        }
      /*  public boolean equals(Object n1)
        {num n=(num)n1;
        if (this.start==n.start && this.end==n.end) return true;
        else return false;
            
            
        }
        
        
         public int hashCode() 
         {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + start;
        result = prime * result+end;
               
        return result;
       }
       
       */
        
       public int compare(num o1, num o2) {
              if (o1.getstart() > o2.getstart())
            return (o1.getstart()-o2.getstart());
            else if (o1.getstart() == o2.getstart())
            return (o1.getend()-o2.getend());
            else 
            return (o1.getstart()-o2.getstart());
            
        }
       
        
        
    }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
class FastReader
{
 
    public InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public FastReader(InputStream stream)
    {
        this.stream = stream;
    }
 
    public int read()
    {
        if (numChars == -1)
        {
            throw new InputMismatchException ();
        }
        if (curChar >= numChars)
        {
            curChar = 0;
            try
            {
                numChars = stream.read (buf);
            } catch (IOException e)
            {
                throw new InputMismatchException ();
            }
            if (numChars <= 0)
            {
                return -1;
            }
        }
        return buf[curChar++];
    }
    
 public char nc()
    {
        int c = read ();
        while (isSpaceChar (c))
            c = read ();
        return (char) c;
    }
    
    public int ni()
    {
        int c = read ();
        while (isSpaceChar (c))
            c = read ();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read ();
        }
        int res = 0;
        do
        {
            if (c < '0' || c > '9')
            {

                
            }
            res *= 10;
            res += c - '0';
            c = read ();
        } while (!isSpaceChar (c));
        return res * sgn;
    }
 
    public long nl()
    {
        int c = read ();
        while (isSpaceChar (c))
            c = read ();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read ();
        }
        long res = 0;
        do
        {
            if (c < '0' || c > '9')
            {
                throw new InputMismatchException ();
            }
            res *= 10;
            res += c - '0';
            c = read ();
        } while (!isSpaceChar (c));
        return res * sgn;
    }
 
    public String ns()
    {
        int c = read ();
        while (isSpaceChar (c))
            c = read ();
        StringBuilder res = new StringBuilder ();
        do
        {
            res.appendCodePoint (c);
            c = read ();
        } while (!isSpaceChar (c));
        return res.toString ();
    }
 
    public boolean isSpaceChar(int c)
    {
        if (filter != null)
        {
            return filter.isSpaceChar (c);
        }
        return isWhitespace (c);
    }
 
    public static boolean isWhitespace(int c)
    {
        return c==' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next()
    {
        return ns ();
    }
 
    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
}   