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

   public class x579E
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         double[] arr = new double[N];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
            arr[i] = Double.parseDouble(st.nextToken());
         double low = -11000.00;
         double high = 11000.00;
         int T = 100;
         while(T-->0)
         {
            double lmid = (2.0*low+high)/3;
            double rmid = (low+2.0*high)/3;
            if(solve(arr, lmid) <= solve(arr, rmid))
               high = rmid;
            else
               low = lmid;
         }
         //System.out.println(Math.min(solve(arr, arr[0]), solve(arr, low)));
         System.out.println(solve(arr, low));
      }
      public static double solve(double[] arr, double K)
      {
         double[] copy = new double[arr.length];
         int N = copy.length;
         for(int i=0; i < N; i++)
            copy[i] = arr[i]-K;
         double max = copy[0];
         double sum = copy[0];
         for(int i=1; i < N; i++)
         {
            if(sum < 0.00)
               sum = 0.0;
            sum += copy[i];
            max = Math.max(max, sum);
         }
         double min = copy[0];
         sum = copy[0];
         for(int i=1; i < N; i++)
         {
            if(sum > 0.0)
               sum = 0.0;
            sum += copy[i];
            min = Math.min(min, sum);
         }
         return Math.max(max, -1*min);
      }
   }