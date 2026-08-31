import java.util.*;
import java.io.*;

public class Main143A
{
  static PrintWriter out=new PrintWriter(System.out);
  public static boolean check(int x,int y,int z,int p)
  {
    return x!=y&&z!=p&&x!=p&&y!=z&&x!=z&&y!=p;
  }
    
  
  public static void main(String[] args) throws IOException
  {
    Scanner sc=new Scanner(System.in);
    int r1=sc.nextInt();
    int r2=sc.nextInt();
    int c1=sc.nextInt();
    int c2=sc.nextInt();
    int d1=sc.nextInt();
    int d2=sc.nextInt();
    int x=0,y=0,z=0,p=0;
    boolean flag=false;
    for(x=1;x<=9;x++)
    {
      for(y=1;y<=9;y++)
      {
        for(z=1;z<=9;z++)
        {
          for(p=1;p<=9;p++)
          {
            if((x+y)==r1&&(x+z)==c1&&(y+p)==c2&&(z+p)==r2&&(x+p)==d1&&(y+z)==d2&&check(x,y,z,p))
            {
              flag=true;
              break;
            }
          }
          if(flag) break;
        }
        if(flag) break;
      }
      if(flag) break;
    }
    if(flag)
    {
      out.println(x+" "+y);
      out.println(z+" "+p);
    }
    else
      out.println(-1);
    out.flush();
      
                
        
    
  }
  static class Scanner
  {
    BufferedReader br;
    StringTokenizer tk=new StringTokenizer("");
    public Scanner(InputStream is) 
        {
      br=new BufferedReader(new InputStreamReader(is));
    }
        public int nextInt() throws IOException
        {
          if(tk.hasMoreTokens())
                return Integer.parseInt(tk.nextToken());
          tk=new StringTokenizer(br.readLine());
          return nextInt();
        }
        public long nextLong() throws IOException
        {
            if(tk.hasMoreTokens())
              return Long.parseLong(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextLong();
        }
        public String next() throws IOException
        {
          if(tk.hasMoreTokens())
            return (tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return next();
        }
        public String nextLine() throws IOException
        {
          tk=new StringTokenizer("");
          return br.readLine();
        }
        public double nextDouble() throws IOException
        {
            if(tk.hasMoreTokens())
              return Double.parseDouble(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return nextDouble();
        }
        public char nextChar() throws IOException
        {
            if(tk.hasMoreTokens())
              return (tk.nextToken().charAt(0));
            tk=new StringTokenizer(br.readLine());
            return nextChar();
        }
        public int[] nextIntArray(int n) throws IOException
        {
            int a[]=new int[n];
            for(int i=0;i<n;i++)
              a[i]=nextInt();
            return a;
        }
        public long[] nextLongArray(int n) throws IOException
        {
          long a[]=new long[n];
            for(int i=0;i<n;i++)
              a[i]=nextLong();
            return a;
        }
        public int[] nextIntArrayOneBased(int n) throws IOException
        {
          int a[]=new int[n+1];
            for(int i=1;i<=n;i++)
              a[i]=nextInt();
            return a;
        }
        public long[] nextLongArrayOneBased(int n) throws IOException
        {
          long a[]=new long[n+1];
          for(int i=1;i<=n;i++)
                a[i]=nextLong();
          return a;
        }
  }
}

