import java.util.*;
import java.io.*;

public class Main260B
{
  static PrintWriter out=new PrintWriter(System.out);
  static boolean valid(String s)
  {
    if(!s.substring(3,5).contains("-")&&!s.substring(0,2).contains("-")&&!s.substring(6,10).contains("-")&&s.charAt(2)=='-'&&s.charAt(5)=='-')
    {
      int a=Integer.parseInt(s.substring(0,2));
      int b=Integer.parseInt(s.substring(3,5));
      int c=Integer.parseInt(s.substring(6,10));
      int[] days={0,31,28,31,30,31,30,31,31,30,31,30,31};
      if(1<=b&&b<=12&&a>=1&&days[b]>=a&&c>=2013&&c<=2015)
        return true;
      else
        return false;
    }
    return false;
  }
      
  
  public static void main(String[] args) throws IOException
  {
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    HashMap<String,Long> map=new HashMap<String,Long>();
    for(int i=0;i<=(s.length()-10);i++)
    {
      String t=s.substring(i,i+10);
      if(valid(t))
      {
        if(map.containsKey(t))
          map.put(t,map.get(t)+1);
        else
          map.put(t,(long)1);
      }
    }
    long max=-1;
    String maxVal="";
    for(String key:map.keySet())
    {
      
      if(map.get(key)>max)
      {
        max=map.get(key);
        maxVal=key;
      }
    }
      
    out.println(maxVal);
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

