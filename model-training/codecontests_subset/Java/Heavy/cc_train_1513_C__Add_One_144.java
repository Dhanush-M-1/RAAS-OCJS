import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        long mod=1000000007;
        long dp[]=new long[200001];
        for(int i=0;i<9;i++)
        {
            dp[i]=2;
        }
        dp[9]=3;
        for(int i=10;i<dp.length;i++)
        {
            dp[i]=(dp[i-9]+dp[i-10])%mod;
        }
        int T=input.nextInt();
        while(T-->0)
        {
            int n=input.nextInt();
            int m=input.nextInt();
            long ans=0;
            while(n>0)
            {
                int d=n%10;
                n=n/10;
                if(m+d<10)
                {
                    ans=(ans+1)%mod;
                }
                else
                {
                    ans=(ans+dp[m+d-10])%mod;
                }
            }
            out.println(ans);
        }
        out.close();
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