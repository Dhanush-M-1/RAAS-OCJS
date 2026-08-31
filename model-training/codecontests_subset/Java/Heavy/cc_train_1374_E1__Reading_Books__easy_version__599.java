import java.util.*;
import java.io.*;
import java.math.*;

   public class E1
   {
      public static void main(String hi[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st;
         int T = 1;
         StringBuilder sb = new StringBuilder();
         while(T-->0)
         {
            st = new StringTokenizer(infile.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer>[] buckets = new PriorityQueue[4];
            for(int i=0; i < 4; i++)
               buckets[i] = new PriorityQueue<Integer>();
            for(int i=0; i < N; i++)
            {
               st = new StringTokenizer(infile.readLine());
               int val = Integer.parseInt(st.nextToken());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               int mask = (a<<1)+b;
               if(mask > 0)
                  buckets[mask].add(val);
            }
            //alice, 2
            //bob, 1
            int alice = K;
            int bob = K; long res = 0L;
            while(alice > 0 || bob > 0)
            {
               if(buckets[3].size() > 0 && Math.min(alice,bob) > 0)
               {
                  if(Math.min(buckets[1].size(), buckets[2].size()) > 0)
                  {
                     long temp = buckets[1].peek()+buckets[2].peek();
                     if(temp < buckets[3].peek())
                     {
                        res += temp;
                        buckets[1].poll();
                        buckets[2].poll();
                     }
                     else
                        res += buckets[3].poll();
                  }
                  else
                     res += buckets[3].poll();
                  alice--; bob--;
               }
               else if(buckets[2].size() > 0 && alice > 0)
               {
                  res += buckets[2].poll();
                  alice--;
               }
               else if(buckets[1].size() > 0 && bob > 0)
               {
                  res += buckets[1].poll();
                  bob--;
               }
               else
                  break;
            }
            if(alice > 0 || bob > 0)
               res = -1;
            sb.append(res+"\n");
         }
         System.out.print(sb);
      }
   }