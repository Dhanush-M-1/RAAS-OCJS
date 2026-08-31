import java.util.*;
import java.io.*;
//267630EY
public class Main143A
{
  static PrintWriter out=new PrintWriter(System.out);
  static boolean unequal(int[] a)
  {
    for(int i=0;i<a.length;i++)
    {
      for(int j=i+1;j<a.length;j++)
      {
        if(a[i]==a[j]) return false;
      }
    }
    return true;
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
    int p=0;
    int q=0;
    int r=0;
    int s=0;
    boolean flag=false;
    
    for(p=1;p<=9;p++)
    {
      for(q=1;q<=9;q++)
      {
        for(r=1;r<=9;r++)
        {
          for(s=1;s<=9;s++)
          {
            int[] ans={p,q,r,s};
            if(p+q==r1&&p+r==c1&&q+s==c2&&r+s==r2&&p+s==d1&&q+r==d2&&unequal(ans))
            {
              
              
              flag=true;
              break;
            }
          }
          if(flag)
            break;
        }
        if(flag)
          break;
      }
      if(flag)
        break;
    }
    if(!flag) out.println(-1);
    else
    {
      out.println(p+" "+q);
      out.println(r+" "+s);
    }
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

