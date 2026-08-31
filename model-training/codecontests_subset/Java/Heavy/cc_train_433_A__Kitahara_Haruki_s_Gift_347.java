import java.io.*;
import java.util.*;
import java.math.*;
import java.math.BigInteger;
public final class codeforces
{    
    static StringBuilder ans=new StringBuilder();;
    static FastReader in=new FastReader();
    static ArrayList<ArrayList<Integer>> g=new ArrayList<ArrayList<Integer>>();
    static long mod=1000000007;
    static boolean set[];
    //main method
    //main method
    //main method
    //main method
    public static void main(String args[])
    {
        int N=in.nextInt();
        int A[]=new int[N];
        int s=0;
        int hun=0,two=0;
        for(int i=0; i<N; i++)
        {
            A[i]=in.nextInt();
            s+=A[i];
            if(A[i]==100)hun++;
        }
        two=N-hun;
        if(s%200==0)
        {
            s=s>>1; 
           // System.out.println(s+" "+hun);
            if(s%200==0)
            {
                System.out.println("YES");
            }
            else
            {
                if(hun>=2)System.out.println("YES");
                else System.out.println("NO");
            }
        }
        else
        System.out.println("NO");
          
    }

    static boolean lucky(long a)
    {
        String X=a+"";
        for(int i=0; i<X.length(); i++)
        {
            char ch=X.charAt(i);
            if(ch!='4' && ch!='7')return false;

        }
        return true;
    }

    static long nextLucky(long x)
    {
        String X=x+"";
        String y="";
        boolean f=true;
        for(int i=X.length()-1; i>=0; i--)
        {
            char ch=X.charAt(i);
            if(ch=='4' && f)
            {
                y=7+y; f=false;
            }
            else if(f) y=4+y;
            else y=ch+y;
        }

        if(f)
        {
            if(X.charAt(0)=='7')
                y=4+y;
            else y=4+X.substring(1);
        }
        return Long.parseLong(y);
    }

    static void setGraph(int N)//intialize graph here
    {
        for(int i=0; i<=N; i++)
            g.add(new ArrayList<Integer>());
    }

    static void DFS(int N,int d)
    {
        set[N]=true;
        d++;
        //max=Math.max(max,d);
        for(int i=0; i<g.get(N).size(); i++)
        {
            int c=g.get(N).get(i);
            if(set[c]==false)
            {
                DFS(c,d);
            }
        }
    }

    static int countBits(long a)
    {
        return (int)(Math.log(a)/Math.log(2)+1);
    }
    //fucntions
    //fucntions
    //fucntions
    //fucntions
    static int[] input(int A[]) //input of Int Array
    {
        int N=A.length;
        for(int i=0; i<N; i++)
        {
            A[i]=in.nextInt();
        }
        return A;
    }

    static long[] inputLong(int N) //Input of long Array
    {
        long A[]=new long[N];
        for(int i=0; i<A.length; i++)A[i]=in.nextLong();
        return A;
    }

    static int GCD(int a,int b) //wrong output if a ||b are intially zero
    {
        if(b==0)
        {
            return a;
        }
        else return GCD(b,a%b );
    }

    static boolean isPrime(int N)
    {
        for(int i=2; i*i<N; i++)
            if(N%i==0)return false;
        return true;
    }

}
//Code For FastReader
//Code For FastReader
//Code For FastReader
//Code For FastReader
class FastReader
{
    BufferedReader br;
    StringTokenizer st;
    public FastReader()
    {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    String next()
    {
        while(st==null || !st.hasMoreElements())
        {
            try
            {
                st=new StringTokenizer(br.readLine());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
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

    String nextLine()
    {
        String str="";
        try
        {
            str=br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }

}