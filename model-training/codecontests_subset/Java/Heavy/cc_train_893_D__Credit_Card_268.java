/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm working for the day I will surpass you
https://www.a2oj.com/Ladder16.html
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class D
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int D = Integer.parseInt(st.nextToken());
         int[] arr = new int[N];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
         if(triv(N, arr, D))
            System.out.println(-1);
         else
         {
            int[] dp = new int[N];
            dp[N-1] = Math.min(D, D-arr[N-1]);
            for(int i=N-2; i >= 0; i--)
            {
               int curr = arr[i];
               dp[i] = Math.min(D, dp[i+1]-curr);
            }
            int res = 0;
            long balance = 0L;
            for(int i=0; i < N; i++)
            {
               balance += arr[i];
               if(arr[i] == 0 && balance < 0)
               {
                  if(dp[i] < 0)
                  {
                     System.out.println(-1);
                     return;
                  }
                  balance = dp[i];
                  res++;
               }
            }
            System.out.println(res);
         }
      }
      public static boolean triv(int N, int[] arr, int D)
      {
         long curr = 0L;
         for(int x: arr)
         {
            curr += x;
            if(curr > D)
               return true;
         }
         return false;
      }
   }