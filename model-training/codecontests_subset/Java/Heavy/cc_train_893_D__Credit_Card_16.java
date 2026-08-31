/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    
    public static long BFS(int cur, ArrayList<ArrayList<Integer>> con, boolean[] vis, long[] arr){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(cur);
        long MIN = arr[cur];
        vis[cur] = true;
        while (!q.isEmpty()){
            int u = q.poll();
            MIN = Math.min(MIN, arr[u]);
            vis[u] = true;
            ArrayList<Integer> co = con.get(u);
            
            for (int v : co){
                if (!vis[v]){
                    q.add(v);
                }
            }
        }
        return MIN;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        long d = sc.nextLong();
        long[] arr = new long[n];
        
        long minPrev = 0L;
        long maxPrev = 0L;
        int cnt = 0;
        for (int i = 0; i < n; ++i){
            arr[i] = sc.nextLong();
            // System.out.println(i + " minPrev: " + minPrev + " maxPrev: " + maxPrev);
            if (arr[i] != 0){
                minPrev += arr[i];
                if (minPrev > d){
                    System.out.println(-1);
                    return;
                }
                maxPrev += arr[i];
                if (maxPrev > d)
                    maxPrev = d;
            }else{
                if (maxPrev < 0L){
                    cnt++;
                    maxPrev = d;
                    minPrev = Math.max(0L, arr[i-1]);
                }
                if (minPrev < 0L){
                    minPrev = 0L;
                }
            }
        }
        System.out.println(cnt);
	}
	
	public static int GCD(int a, int b){
	    while (b > 0){
	        int tmp = b;
	        b = a % b;
	        a = tmp;
	    }
	    return a;
	}
	

	//-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
      }

   }
}
