
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


 
 
public class Main
{
    static StringTokenizer st;//=new StringTokenizer("");
    static BufferedReader br;
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) throws FileNotFoundException, IOException, Exception
    {
        //Scanner in =new Scanner(new FileReader("input.txt"));
        //PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        //Scanner in=new Scanner(System.in);
        br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        //StringTokenizer st;//=new StringTokenizer(br.readLine());
        //////////////////////////////////////////////////////////////////////////////////////
        
        int p=0;
        int m=0;
        boolean pos=true;
        boolean neg=false;
        int n=0;
        String s[]=br.readLine().split(" ");
        for(int i=0;i<s.length;i++)
        {
            if(s[i].charAt(0)=='?')
            {
                if(pos) p++;
                else m++;
            }
            else if(s[i].charAt(0)=='+')
            {
                pos=true;
                neg=false;
            }
            else if(s[i].charAt(0)=='-')
            {
                pos=false;
                neg=true;
            }
            else if(s[i].charAt(0)=='=')
            {
                i++;
                n=Integer.parseInt(s[i]);
                break;
            }
        }
        if(p*n-m<n || p-n*m>n)
        {
            out.print("Impossible");
            out.close();
            return ;
        }
        else
        {
            out.println("Possible");
            int po[]=new int[p];
            int ne[]=new int[m];
            if(p-m==n)
            {
                for(int i=0;i<p;i++) po[i]=1;
                for(int i=0;i<m;i++) ne[i]=1;
            }
            else if(p-m<n)
            {
                for(int i=0;i<m;i++) ne[i]=1;
                for(int i=0;i<(n-(p-m))%p;i++) po[i]=1;
                for(int i=0;i<p;i++) po[i]+=(n-(p-m))/p+1;
            }
            else
            {
                for(int i=0;i<p;i++) po[i]=1;
                for(int i=0;i<((p-m)-n)%m;i++) ne[i]=1;
                for(int i=0;i<m;i++) ne[i]+=((p-m)-n)/m+1;
            }
            pos=true;
            neg=false;
            int p1=0;
            int n1=0;
            for(int i=0;i<s.length;i++)
            {
                if(s[i].charAt(0)=='?')
                {
                    if(pos) out.print(po[p1++]+" ");
                    else out.print(ne[n1++]+" ");
                }
                else if(s[i].charAt(0)=='-')
                {
                    neg=true;
                    pos=false;
                    out.print(s[i]+" ");
                }
                else if(s[i].charAt(0)=='+')
                {
                    pos=true;
                    neg=false;
                    out.print(s[i]+" ");
                }
                else if(s[i].charAt(0)=='=')
                {
                    out.print(s[i]+" ");
                    i++;
                    out.print(s[i]);
                }
            }
        }
        
        //////////////////////////////////////////////////////////////////////////////////////
        out.flush();
	out.close();
    }
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////
    
    private static long gcd(long a,long b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    private static class pair implements Comparable<pair>
    {
        int first;
        int second;
        pair()
        {
            first=0;
            second=0;
        }
        pair(int f,int s)
        {
            first=f;
            second=s;
        }
 
        public int compareTo(pair o)
        {
            if(second>  o.second)
                return 1;
            else if(second < o.second)
                return -1;
            else
                return 0;
        }
    }
    
    public static Integer ni() throws Exception
    {
        if(!st.hasMoreTokens())
            st=new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    public static BigInteger nb()throws Exception
    {
        if(!st.hasMoreElements())
            st=new StringTokenizer(br.readLine());
        return BigInteger.valueOf(Long.parseLong(st.nextToken()));
    }
    public static Long nl() throws Exception
    {
        if(!st.hasMoreTokens())
            st=new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }
    public static Double nd()throws Exception
    {
        if(!st.hasMoreElements())
            st=new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }
    public static String ns()throws Exception
    {
        if(!st.hasMoreElements())
            st=new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}