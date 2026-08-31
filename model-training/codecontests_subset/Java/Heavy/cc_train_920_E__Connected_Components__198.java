import java.util.*;
import java.io.*;
import java.math.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class Main {
  static Set<Integer> a[] = new Set[250005];
  static BitSet vis = new BitSet(250005);
 // static Set<Integer> a[] = new Set[10];
 // static BitSet vis = new BitSet(10);
  
  static ArrayList<Integer> ans;
  static int n = 0;

  static int dfs(int v)
  {
    int ans = 1;
    vis.clear(v);
    for (int i = vis.nextSetBit(1);i >= 1 && i <= n;i = vis.nextSetBit(i + 1)) {
      if (!a[v].contains(i)) {
        ans += dfs(i);
        //System.out.println("i:"+i + " ans:"+ans);
      }
    }
    return ans;
    
    
    
  }


  
  public static void main(String[] args) {
    try {
      MScanner in = new MScanner(System.in);
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));

      n = in.nextInt();
      int m = in.nextInt();
      
      for (int i = 0;i <= n;++i) {
        a[i] = new TreeSet<Integer>();
      }
      for (int i = 0;i < m;++i) {
        int i1 = in.nextInt();
        int i2 = in.nextInt();
        a[i1].add(i2);
        a[i2].add(i1);
      }
      for (int i = 1;i <= n;++i) {
        vis.set(i);
      }
      
      ArrayList<Integer> ans = new ArrayList<>();
      for (int i = 1;i <= n;++i) {
        if (vis.get(i)) {
          int sz = dfs(i);
          ans.add(sz);
        }
      }
      Collections.sort(ans);
      System.out.println(ans.size());
      for (int i = 0;i < ans.size();++i) {
        System.out.print(ans.get(i) + " ");
      }
      System.out.println();
        
      
      

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  static class MScanner {
    StringTokenizer st;
    BufferedReader br;
    public MScanner(InputStream system) {
      br = new BufferedReader(new InputStreamReader(system));
    }

    public MScanner(String file) throws Exception {
      br = new BufferedReader(new FileReader(file));
    }

    public String next() throws IOException {
      while (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
      return st.nextToken();
    }
    public int[] takearr(int n) throws IOException {
      int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
      return in;
    }
    public long[] takearrl(int n) throws IOException {
      long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
      return in;
    }
    public Integer[] takearrobj(int n) throws IOException {
      Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
      return in;
    }
    public Long[] takearrlobj(int n) throws IOException {
      Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
      return in;
    }
    public String nextLine() throws IOException {
      return br.readLine();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    public double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }

    public char nextChar() throws IOException {
      return next().charAt(0);
    }

    public Long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    public boolean ready() throws IOException {
      return br.ready();
    }

    public void waitForInput() throws InterruptedException {
      Thread.sleep(3000);
    }
  }
}
