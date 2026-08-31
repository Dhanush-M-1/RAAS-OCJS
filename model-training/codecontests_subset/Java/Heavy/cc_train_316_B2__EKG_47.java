import java.util.*;
public class cf316b {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt()-1;
    int[] v = new int[n];
    DisjointSet ds = new DisjointSet(n);
    for(int i=0; i<n; i++) {
      v[i] = in.nextInt();
      if(v[i] != 0) 
        ds.union(i, v[i]-1);
    }
    int set = ds.find(k);
    int pos = 0;
    while(v[k] != 0) {
      pos++;
      k = v[k]-1;
    }
    int[] f = new int[n];
    for(int i=0; i<n; i++)
      if(ds.find(i) != set)
        f[ds.find(i)]++;
    boolean[] dp = new boolean[n];
    dp[0] = true;
    for(int x : f)
      for(int i=n-1; i>=x; i--)
        dp[i] |= dp[i-x];
    for(int i=0; i<n; i++)
      if(dp[i])
        System.out.println(i+pos+1);
  }
  static class DisjointSet {
    int[] p, r;
    public DisjointSet(int s) {
      p = new int[s];
      r = new int[s];
      for(int i=0; i<s; i++)
        p[i] = i;
    }
    public void union(int x, int y) {
      int a = find(x);
      int b = find(y);
      if(a==b) return;
      if(r[a] == r[b])
        r[p[b]=a]++;
      else 
        p[a]=p[b]=r[a]<r[b]?b:a;
    }
    public int find(int x) {
      return p[x]=p[x]==x?x:find(p[x]);
    }
  }
}
