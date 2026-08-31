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

   public class x1354F2
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int T = Integer.parseInt(st.nextToken());
         StringBuilder sb = new StringBuilder();
         while(T-->0)
         {
            st = new StringTokenizer(infile.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Minion[] arr = new Minion[N];
            for(int i=0; i < N; i++)
            {
               st = new StringTokenizer(infile.readLine());
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               arr[i] = new Minion(a, b, i);
            }
            Arrays.sort(arr);
            Node[][] par = new Node[N][K+1];
            long[][] dp = new long[N][K+1];
            for(int i=0; i < N; i++)
               Arrays.fill(dp[i], -1);
            dp[0][1] = arr[0].a;
            par[0][1] = new Node(-1, 420);
            if(N != K)
            {
               dp[0][0] = arr[0].b*(K-1);
               par[0][0] = new Node(-1, 420);
            }
            for(int i=1; i < N; i++)
               for(int k=0; k <= K; k++)
               {
                  if(i+1 < k)
                     break;
                  int boof = i-k+1;
                  long max = -1L;
                  if(i >= k && dp[i-1][k] != -1)
                     max = dp[i-1][k]+arr[i].b*(K-1);
                  if(k > 0 && dp[i-1][k-1] != -1)
                     max = Math.max(max, dp[i-1][k-1]+arr[i].a+arr[i].b*(k-1));
                  dp[i][k] = max;
                  if(max == dp[i-1][k]+arr[i].b*(K-1) && dp[i-1][k] != -1)
                     par[i][k] = new Node(i-1, k);
                  else if(max != -1)
                     par[i][k] = new Node(i-1, k-1);
               }
            //restore
            ArrayList<Integer> ls = new ArrayList<Integer>();
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i=0; i < N; i++)
               set.add(i);
            Node curr = new Node(N-1, K);
            while(curr.dex > 0)
            {
               int i = curr.dex;
               int k = curr.cnt;
               Node next = par[i][k];
               if(k == next.cnt+1)
               {
                  ls.add(arr[i].dex);
                  set.remove(arr[i].dex);
               }
               curr = next;
            }
            if(curr.cnt == 1)
            {
               ls.add(arr[0].dex);
               set.remove(arr[0].dex);
            }
            Collections.reverse(ls);
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(int i=0; i < ls.size()-1; i++)
               res.add(ls.get(i)+1);
            for(int x: set)
            {
               res.add(x+1);
               res.add(-x-1);
            }
            res.add(ls.get(ls.size()-1)+1);
            sb.append(res.size()+"\n");
            for(int x: res)
               sb.append(x+" ");
            sb.append("\n");
         }
         System.out.print(sb);
      }
   }
   class Minion implements Comparable<Minion>
   {
      public long a;
      public long b;
      public int dex;
      
      public Minion(long x, long y, int d)
      {
         a = x;
         b = y;
         dex = d;
      }
      public int compareTo(Minion oth)
      {
         if(b == oth.b)
            return (int)(oth.a-a);
         return (int)(b-oth.b);
      }
   }
   class Node
   {
      public int dex;
      public int cnt;
      
      public Node(int a, int c)
      {
         dex = a;
         cnt = c;
      }
   }