/*
Roses are red
Memes are neat
All my test cases time out
Lmao yeet
*/
import java.util.*;
import java.io.*;

   public class x1013D
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         int Q = Integer.parseInt(st.nextToken());
         LinkedList<Integer>[] ledges = new LinkedList[Math.max(N, M)+1];
         LinkedList<Integer>[] redges = new LinkedList[Math.max(N, M)+1];
         int K = Math.max(N, M);
         for(int i=1; i<=K; i++)
         {
            ledges[i] = new LinkedList<Integer>();
            redges[i] = new LinkedList<Integer>();
         }
         for(int qw=0; qw < Q; qw++)
         {
            st = new StringTokenizer(infile.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ledges[a].add(b);
            redges[b].add(a);
         }
         boolean[][] seen = new boolean[K+1][2];
         int res = -1;
         for(int i=1; i <= K; i++)
         {
            if(i <= N && !seen[i][0])
            {
               res++;
               dfs(i, 0, seen, ledges, redges);
            }
            if(i <= M && !seen[i][1])
            {
               res++;
               dfs(i, 1, seen, ledges, redges);
            }
         }
         System.out.println(res);
      }
      public static void dfs(int curr, int par, boolean[][] seen, LinkedList<Integer>[] left, LinkedList<Integer>[] right)
      {
         seen[curr][par] = true;
         LinkedList<Integer> neigh = left[curr];
         if(par == 1)
            neigh = right[curr];
         for(int next: neigh)
            if(!seen[next][(par+1)%2])
               dfs(next, (par+1)%2, seen, left, right);
      }
   }