
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

public class P385A {
    //static long m=1000000007;
    static BigInteger ways(int N,  int K) {
        BigInteger ret = BigInteger.ONE;
        for(int i=N;i>=N-K+1;i--)
        {
             ret = ret.multiply(BigInteger.valueOf(i));
            
        }
        for (int j = 1; j<=K; j++) {
            ret = ret.divide(BigInteger.valueOf(j));
        }
       
            ret=ret.mod(BigInteger.valueOf(1000000007));
        
        return ret;
    }
    public static int prime(int n)
    {
        int f=1;
        if(n==1)
            return 0;
        for(int i=2;i<=(Math.sqrt(n));)
        {
            if(n%i==0)
            {
                f=0;
                break;
            }
            if(i==2)
                i++;
            else
                i+=2;
        }
        if(f==1)
            return 1;
        else 
            return 0;
    }
/*public static long gcd(long x,long y)
{
    if(x%y==0)
        return y;
    else return gcd(y,x%y);
}*/
    public static BigInteger fact(int n)
    {
        BigInteger f=BigInteger.ONE;
        for(int i=1;i<=n;i++)
        {
            f=f.multiply(BigInteger.valueOf(i));
        }
        //f=f.mod(BigInteger.valueOf(m));
        return f;
    }
public static int gcd(int x,int y)
{
    if(x%y==0)
        return y;
    else return gcd(y,x%y);
}
public static int max(int a,int b)
{
    if(a>b)
        return a;
    else
        return b;
}
public static int min(int a,int b)
{
    if(a>b)
        return b;
    else 
        return a;
}



    public static void main(String[] args) throws Exception{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder("");
        //int t=Integer.parseInt(br.readLine());
    //  while(t-->0)
        //{
        //int n=Integer.parseInt(br.readLine());
        //long n=Long.parseLong(br.readLine());
        //String l[]=br.readLine().split(" ");
        //int m=Integer.parseInt(l[0]);
        //int k=Integer.parseInt(l[1]);
        //l=br.readLine().split(" ");
        //long m=Long.parseLong(l[0]);
        //long n=Long.parseLong(l[1]);
        //char ch=a.charAt();
    //  char c[]=new char[n];
        //String l[]=br.readLine().split(" ");
        //l=br.readLine().split(" ");
        /*int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(l[i]);
        }*/
        /*long a[]=new long[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Long.parseLong(l[i]);
        }*/
        /*int a[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
        l=br.readLine().split(" ");
            for(int j=0;j<n;j++)
            {
                a[i][j]=Long.parseLong(l[j]);
            }
        }*/
        
        //  String a=br.readLine();
        
        // char a[]=c.toCharArray();
        //char ch=l[0].charAt(0);
        
        //HashMap<Integer,Integer>hm=new HashMap<Integer,Integer>();
        //HashMap<Integer,String>hm=new HashMap<Integer,String>();
        //HashMap<Integer,Long>hm=new HashMap<Integer,Long>();
        //hm.put(1,1);
        //HashSet<Integer>hs=new HashSet<Integer>();
        //HashSet<Long>hs=new HashSet<Long>();
        //HashSet<String>hs=new HashSet<String>();
        //hs.add(x);
        //Stack<Integer>s=new Stack<Integer>();
        //s.push(x);
        //s.pop(x);
        //Queue<Integer>q=new LinkedList<Integer>();
        //q.add(x);
        //q.remove(x);
        //ArrayList<Integer>ar=new ArrayList<Integer>();
        //long x=Long.parseLong(l[0]);
        
        //int min=100000000;
    
        //long c1=(long)Math.ceil(n/(double)a);
        //Arrays.sort(a);
          // int f1[]=new int[26];
           //int f2[]=new int[26];
        /*for(int i=0;i<n;i++)
        {
        int x=a.charAt(0);
            f1[x-97]++;
        }*/
        /*for(int i=0;i<n;i++)
        {
            
        }*/
        /*for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                
            }
        }*/
        /*while(q--)
          {
                l=br.readLine().split(" ");
                int n=Integer.parseInt(l[0]);
                int k=Integer.parseInt(l[1]);
          }
         */
        /*if(f==1)
            System.out.println("Yes");
        else
            System.out.println("No");*/
        //System.out.print("");
        //sb.append("");
        //sb.append("").append("\n");
        String l[]=br.readLine().split(" ");
        int n=Integer.parseInt(l[0]);
        int k=Integer.parseInt(l[1]);
        int c=-k;
        int max=0;
        l=br.readLine().split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(l[i]);
            if(i>0)
            {
                int d=a[i-1]-a[i];
                max=max(max,d);
            }
        }
        c+=max;
        if(c<0)
        System.out.println(0);
        else
            System.out.println(c);
    }
}