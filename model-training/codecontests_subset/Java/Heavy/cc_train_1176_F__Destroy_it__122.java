/*
Roses are red
Memes are neat
All my test cases are wrong
Lmao yeet
*/
import java.util.*;
import java.io.*;

   public class F
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         long[][] dp = new long[N+1][10];
         for(int i=0; i <= N; i++)
            Arrays.fill(dp[i], -1L);
         ArrayList<Long> ones;
         long max2;
         long max3;
         dp[0][0] = 0L;
         for(int t=0; t < N; t++)
         {
            int K = Integer.parseInt(infile.readLine());
            ones = new ArrayList<Long>();
            max2 = 0L;
            max3 = 0L;
            for(int a=0; a < K; a++)
            {
               st = new StringTokenizer(infile.readLine());
               int c = Integer.parseInt(st.nextToken());
               long d = Long.parseLong(st.nextToken());
               if(c == 1)
                  ones.add(-1*d);
               else if(c == 2)
                  max2 = Math.max(max2, d);
               else if(c == 3)
                  max3 = Math.max(max3, d);
            }
            Collections.sort(ones);
            for(int i=0; i < ones.size(); i++)
               ones.set(i, -1*ones.get(i));
            //play no cards
            for(int i=0; i < 10; i++)
                  dp[t+1][i] = Math.max(dp[t+1][i], dp[t][i]);
            //play only one card
            long best = Math.max(max2, max3);
            if(ones.size() > 0)
               best = Math.max(best, ones.get(0));
            if(best > 0)
            {
               for(int i=0; i < 10; i++)
               {
                  if(dp[t][i] > -1 && i < 9)
                     dp[t+1][i+1] = Math.max(dp[t+1][i+1], dp[t][i]+best);
                  else if(dp[t][i] > -1 && i == 9)
                     dp[t+1][0] = Math.max(dp[t+1][0], dp[t][i]+2*best);
               }
            }
            //1, 2
            if(ones.size() > 0 && max2 > 0)
            {
               best = Math.max(max2, ones.get(0));
               for(int i=0; i < 10; i++)
               {
                  if(dp[t][i] > -1 && i < 8)
                     dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i]+max2+ones.get(0));
                  else if(dp[t][i] > -1 && i >= 8)
                     dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], dp[t][i]+max2+ones.get(0)+best);
               }
            }
            //1, 1
            if(ones.size() > 1)
            {
               best = ones.get(0);
               for(int i=0; i < 10; i++)
               {
                  if(dp[t][i] > -1 && i < 8)
                     dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i]+ones.get(1)+ones.get(0));
                  else if(dp[t][i] > -1 && i >= 8)
                     dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], dp[t][i]+ones.get(1)+ones.get(0)+best);
               }
            }
            //1, 1, 1
            if(ones.size() > 2)
            {
               best = ones.get(0);
               long sum = ones.get(0)+ones.get(1)+ones.get(2);
               for(int i=0; i < 10; i++)
               {
                  if(dp[t][i] > -1 && i < 7)
                     dp[t+1][i+3] = Math.max(dp[t+1][i+3], dp[t][i]+sum);
                  else if(dp[t][i] > -1 && i >= 7)
                     dp[t+1][(i+3)%10] = Math.max(dp[t+1][(i+3)%10], dp[t][i]+sum+best);
               }
            }
         }
         //find best result
         long res = 0L;
         for(int i=0; i < 10; i++)
            res = Math.max(res, dp[N][i]);
         System.out.println(res);
      }
   }