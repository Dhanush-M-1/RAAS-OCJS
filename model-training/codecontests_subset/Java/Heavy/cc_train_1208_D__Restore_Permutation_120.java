import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            long a[]=new long[n+1];
            for(int i=1;i<=n;i++)
            {
                a[i]=input.nextLong();
            }
            int ans[]=new int[n+1];
            long arr[]=new long[n+1];
            for(int i=1;i<=n;i++)
            {
                update(i,i,arr,n);
            }
            for(int i=n;i>=1;i--)
            {
                long s=a[i];
                int x=1,y=n+1;
                while(x<y)
                {
                    int mid=(x+y)/2;
                    long sum=sum(mid,arr);
                    if(sum<=s)
                    {
                        x=mid+1;
                    }
                    else
                    {
                        y=mid;
                    }
                }
                ans[i]=x;
                update(-x,x,arr,n);
            }
            for(int i=1;i<=n;i++)
            {
                out.print(ans[i]+" ");
            }
            out.println();
        }
        out.close();
    }
    public static void update(int d,int k,long arr[],int n)
    {
        while(k<=n)
        {
            arr[k]+=d;
            k+=k&-k;
        }
    }
    public static long sum(int k,long arr[])
    {
        long sum=0;
        while(k>0)
        {
            sum+=arr[k];
            k-=k&-k;
        }
        return sum;
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
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
}