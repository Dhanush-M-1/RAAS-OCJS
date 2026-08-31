import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class cf242c {
  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);
    Pair start = new Pair(in.nextInt(),in.nextInt());
    Pair end = new Pair(in.nextInt(),in.nextInt());
    TreeSet<Pair> ok = new TreeSet<Pair>();
    int n = in.nextInt();
    for(int i=0; i<n; i++) {
      int x = in.nextInt();
      int y0 = in.nextInt();
      int y1 = in.nextInt();
      if(y1 < y0) {
        int tmp = y0;
        y0 = y1;
        y1 = tmp;
      }
      for(int y=y0; y<=y1; y++)
        ok.add(new Pair(x,y));
    }
    ArrayDeque<Pair> q = new ArrayDeque<Pair>();
    q.add(start);
    Map<Pair,Integer> map = new TreeMap<Pair,Integer>();
    map.put(start,0);
    int[] dx = {-1,-1,-1,0,0,1,1,1},dy = {1,0,-1,1,-1,1,0,-1};
    while(!q.isEmpty()) {
      Pair cur = q.poll();
      for(int i=0; i<dx.length; i++) {
        Pair next = new Pair(cur.x+dx[i],cur.y+dy[i]);
        if(!ok.contains(next)) continue;
        if(map.containsKey(next)) continue;
        q.add(next);
        map.put(next, map.get(cur)+1);
      }
    }
    int ans = -1;
    if(map.containsKey(end)) ans = map.get(end);
    System.out.println(ans);
  }
  static class Pair implements Comparable<Pair> {
    int x,y;
    Pair(int a, int b) {
      x=a;y=b;
    }
    public int compareTo(Pair p) {
      if(x==p.x) return y-p.y;
      return x-p.x;
    }
    public String toString() {
      return x+":"+y;
    }
  }
  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;
    
    public FastScanner(InputStream in) {
      br = new BufferedReader(new InputStreamReader(in));
      scanLine();
    }
    public void scanLine() {
      try {
        st = new StringTokenizer(br.readLine().trim());
      } catch(Exception e) {
        throw new RuntimeException(e.getMessage());
      }
    }
    public int numTokens() {
      if(!st.hasMoreTokens()) {
        scanLine();
        return numTokens();
      }
      return st.countTokens();
    }
    public String next() {
      if(!st.hasMoreTokens()) {
        scanLine();
        return next();
      }
      return st.nextToken();
    }
    public double nextDouble() {
      return Double.parseDouble(next());
    }
    public long nextLong() {
      return Long.parseLong(next());
    }
    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
