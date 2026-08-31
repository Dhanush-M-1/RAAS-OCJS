/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    long MOD = 1000000007L;
    int INF = 1000000001;
    
    public class Obj implements Comparable<Obj>{
        public int start;
        public int end;
        
        public Obj(int start_, int end_){
            this.start = start_;
            this.end = end_;

        }
        
        public int compareTo(Obj other){
            if (other.start == this.start){
                return this.end - other.end;
            }
            return this.start - other.start;
        }

    }
    
    int[] dx = new int[]{-1, 0, 1, 0, -1, 1, 1, -1};
    int[] dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Codechef cf = new Codechef();
        cf.Solve();
	}
	public void Solve(){
        MyScanner sc = new MyScanner();
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        Map<Integer, List<Obj>> map = new HashMap<Integer, List<Obj>>();
        
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i){
            int r = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!map.containsKey(r)){
                List<Obj> arr = new ArrayList<Obj>();
                arr.add(new Obj(a, b));
                map.put(r, arr);
            }else{
                List<Obj> arr = map.get(r);
                arr.add(new Obj(a, b));
                map.put(r, arr);
            }
        }
        
        for (int key : map.keySet()){
            List<Obj> arr = map.get(key);
            Collections.sort(arr);
            map.put(key, arr);
        }
        
        Set<String> vis = new HashSet<String>();
        Queue<Integer> xrr = new LinkedList<Integer>();
        Queue<Integer> yrr = new LinkedList<Integer>();
        Queue<Integer> crr = new LinkedList<Integer>();
        xrr.add(x0);
        yrr.add(y0);
        crr.add(0);
        vis.add(hash(x0, y0));
        while (!xrr.isEmpty()){
            int x = xrr.poll();
            int y = yrr.poll();
            int cur = crr.poll();
            // System.out.println("x: " + x + " y: " + y + " cur: " + cur);
            for (int k = 0; k < 8; ++k){
                int u = x + dx[k];
                int v = y + dy[k];
                if (u == x1 && v == y1){
                    System.out.println((cur+1));
                    return;
                }else{
                    if (inside(x, y)){
                        String h = hash(u, v);
                        if (!vis.contains(h) && ok(u, v, map)){
                            vis.add(h);
                            xrr.add(u);
                            yrr.add(v);
                            crr.add(cur+1);
                        }
                    }
                }
            }
        }
        System.out.println(-1);
	}
	
	public boolean inside(int x, int y){
	    return (x >= 0 && x < INF) && (y >=0 && y < INF);
	}
	
	public boolean ok(int x, int y, Map<Integer, List<Obj>> map){
	   // System.out.println("find x: " + x + " y: " + y + " " + map.get(x));
	    if (!map.containsKey(x)){
	        return false;
	    }
	    List<Obj> arr = map.get(x);
	    int lo = 0;
	    int hi = arr.size() - 1;
	    while (lo <= hi){
	        int mid = lo + (hi - lo) / 2;
	        int st = arr.get(mid).start;
	        int ed = arr.get(mid).end;
	       // System.out.println("--- " + st + " " + ed);
	        if (st <= y && y <= ed){
	            return true;
	        }else if (y > ed){
	            lo = mid + 1;
	        }else{
	            hi = mid - 1;
	        }
	    }
	    return false;
	}
	
	public String hash(int x, int y){
	    return Integer.toString(x) + "-" + Integer.toString(y);
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
