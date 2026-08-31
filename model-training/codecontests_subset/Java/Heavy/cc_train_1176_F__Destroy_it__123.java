
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class F1 {
    public static void main(String[] args) throws IOException{
        FastReader in = new FastReader();
        long n = in.nextLong();
        //Create DP table
        long[][] dp = new long[(int)n+1][10];

        for(int i=0; i <= n; i++)
            Arrays.fill(dp[i], -1L);
        dp[0][0] = 0L;
        //turns
        for(int t =0; t<n; t++){
            //Number of Cards
            long nc = in.nextLong();
            ArrayList<Long> a = new ArrayList<>();
            long b = 0L;
            long c = 0L;
            while(nc-->0){
                int cost = in.nextInt();
                long val = in.nextLong();

                switch (cost){
                    case 1:
                        a.add(val*-1);
                        break;
                    case 2:
                        if(val>b){
                            b = val;
                        }

                        break;
                    case 3:
                        if(val>c) {
                            c = val;
                        }
                        break;
                }
            }
            Collections.sort(a);
            for(int i = 0; i< a.size(); i++){
                a.set(i, -1*a.get(i));
            }
            //play 0 cards
            for(int i = 0; i<10; i++){
                dp[t+1][i] = Math.max(dp[t+1][i], dp[t][i]);
            }
            //play 1 card
            long best = Math.max(b,c);
            if (a.size() > 0) {
                best = Math.max(best,a.get(0));
            }
            if(best>0){
                for(int i=0; i < 10; i++) {
                    if (dp[t][i] > -1 && i < 9)
                        dp[t + 1][i + 1] = Math.max(dp[t + 1][i + 1], dp[t][i] + best);
                    else if (dp[t][i] > -1 && i == 9)
                        dp[t + 1][0] = Math.max(dp[t + 1][0], dp[t][i] + (2 * best));
                }
            }

            //play 2,1
            if(a.size()>0 && b>0){
                best = Math.max(b, a.get(0));
                for(int i = 0; i< 10; i++){
                    if(dp[t][i]>-1 && i<8){
                        dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i] + b + a.get(0) );
                    }
                    else if(dp[t][i] > -1 && i>=8){
                        dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], dp[t][i] + best + a.get(0) + b);
                    }
                }
            }
            //play 1,1
            if(a.size()> 1){
                best = a.get(0);
                for(int i = 0; i< 10; i++){
                    if(dp[t][i]>-1 && i<8){
                        dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i] + a.get(0) + a.get(1));
                    }
                    else if(dp[t][i]>-1 && i>=8){
                        dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], dp[t][i] + (best*2) + a.get(1));
                    }
                }
            }

            //play 1,1,1
            if(a.size()> 2){
                best = a.get(0);
                for(int i = 0; i< 10; i++){
                    if(dp[t][i]>-1 && i<7){
                        dp[t+1][i+3] = Math.max(dp[t+1][i+3], dp[t][i] + a.get(0) + a.get(1) + a.get(2));
                    }
                    else if(dp[t][i]>-1 && i>=7){
                        dp[t+1][(i+3)%10] = Math.max(dp[t+1][(i+3)%10], dp[t][i] + (best*2) + a.get(1) + a.get(2));
                    }
                }
            }

        }
        long answer = 0;
        for(long i: dp[dp.length-1]){
            answer = Math.max(answer, i);
        }
        System.out.println(answer);

    }


    //#FasterthanScanner (FTS)
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
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
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}

