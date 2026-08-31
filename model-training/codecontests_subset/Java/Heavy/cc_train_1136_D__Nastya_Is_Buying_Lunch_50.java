/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
What do you think? What do you think?
1st on Billboard, what do you think of it
Next is a Grammy, what do you think of it
However you think, I’m sorry, but shit, I have no fcking interest
*******************************
I'm standing on top of my Monopoly board
That means I'm on top of my game and it don't stop
til my hip don't hop anymore
https://www.a2oj.com/Ladder16.html
*******************************
300iq as writer = Sad!
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class x1136D
   {
      public static void main(String hi[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         int[] arr = new int[N];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
         HashSet<Integer>[] edges = new HashSet[N+1];
         for(int i=1; i <= N; i++)
            edges[i] = new HashSet<Integer>();
         for(int i=0; i < M; i++)
         {
            st = new StringTokenizer(infile.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
         }
         int res = 0;
         HashSet<Integer> active = new HashSet<Integer>();
         active.add(arr[N-1]);
         for(int i=N-2; i >= 0; i--)
         {
            int v = arr[i];
            int cnt = active.size();
            for(int next: edges[v])
               if(active.contains(next))
                  cnt--;
            if(cnt == 0)
               res++;
            else
               active.add(v);
         }
         System.out.println(res);
      }
   }