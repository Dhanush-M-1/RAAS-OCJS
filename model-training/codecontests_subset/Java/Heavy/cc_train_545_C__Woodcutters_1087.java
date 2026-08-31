/**
 * Created by ankeet on 12/28/16.
 */
import java.io.*;
import java.util.*;

public class C545 {

    static FastReader in = null;
    static PrintWriter out = null;

    public static void solve()
    {
        int n = in.nextInt();
        long[] x = new long[n];
        long[] h = new long[n];
        for(int i=0; i<n; i++){
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        if(n == 1){
            out.println(1);
            return;
        }
        // dp[i][0] = max # of trees falling using trees up to i, such that ith tree did not fall to right
        // dp[i][1] = max # of trees falling, ith tree did fall to right
        int[][] dp = new int[n][2];

        dp[0][0] = 1;
        dp[0][1] = x[0] + h[0] < x[1] ? 1 : 0;

        for(int i=1; i<n; i++){

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            if(x[i] - h[i] > x[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][0] + 1);
            if(x[i] - h[i] > x[i-1] + h[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][1] + 1);

            if(i == n-1){
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + 1;
            }
            else{
                dp[i][1] = (x[i] + h[i] < x[i+1]) ? Math.max(dp[i-1][0], dp[i-1][1]) + 1 : 0;
            }
        }

        out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }

    public static void main(String[] args)
    {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();

    }

    static class FastReader {

        BufferedReader read;
        StringTokenizer tokenizer;

        public FastReader(InputStream in)
        {
            read = new BufferedReader(new InputStreamReader(in));
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try{
                    tokenizer = new StringTokenizer(read.readLine());
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public String nextLine(){

            try
            {
                return read.readLine();
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n)
        {
            int[] a = new int[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArr(int n)
        {
            long[] a = new long[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nextLong();
            }
            return a;
        }
    }


}


