import java.util.*;
import java.io.*;

public class CF691D{ 
  public static int [] parent;
  public static void main(String[] args)throws Exception {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int n = in.nextInt() , m = in.nextInt();
    
    int [] a = new int[n+1];
    
    for(int i = 1; i <= n; i++){
      a[i] = in.nextInt();
    }
    
    parent = new int[n+1];
    for(int i = 1; i <= n; i++){
      parent[i] = i;
    }
    
    for(int i = 0; i < m; i++){
      int u = in.nextInt(), v = in.nextInt();
      u = find(u); v = find(v);
      if(u != v) parent[v] = u;
    }
    
    ArrayList<ArrayList<Integer>> uni = new ArrayList<ArrayList<Integer>>();
    
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    
    for(int i = 0; i <= n; i++){
      list.add(new ArrayList<Integer>());
      uni.add(new ArrayList<Integer>());
    }
    
    for(int i = 1; i <= n; i++){
      int x = find(i);
      list.get(x).add(a[i]);
      uni.get(x).add(i);
    }
    int maxSize = 0;
    for(int i = 0; i <= n; i++){
      Collections.sort(list.get(i), Collections.reverseOrder());
      maxSize = Math.max(list.get(i).size(), maxSize);
    }
    
    int [] ans = new int[n+1];
    
    for(int i = 1; i <= n; i++){
      int sz = list.get(i).size();
      if(list.get(i).size() > 0){
        for(int j = 0; j < sz; j++){
          ans[uni.get(i).get(j)] = list.get(i).get(j);
        }
      }
      
    }
    
    for(int i = 1; i <= n; i++){
      pw.print(ans[i]+" ");
    }
    pw.println();

    
    pw.close();
  }
  
 public static int find(int i) {
    int p = parent[i];
    if (i == p) return i;
    return parent[i] = find(p);
 }
 
  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    
    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream));
      tokenizer = null;
    }
    
    public String next() {
  
      try {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
          tokenizer = new StringTokenizer(reader.readLine());
      } catch (IOException e) {
        return null;
      }
      
      return tokenizer.nextToken();
    }
    
    public String nextLine() {
      String line = null;
      try {
        tokenizer = null;
        line =  reader.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return line;
    }
    
    public int nextInt() {
      return Integer.parseInt(next());
    }
    
    public double nextDouble() {
      return Double.parseDouble(next());
    }
    
    public long nextLong() {
      return Long.parseLong(next());
    }
    public boolean hasNext(){
      try {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
          tokenizer = new StringTokenizer(reader.readLine());
      } 
      catch (Exception e) {
        return false;
      }
     
    return true; 
    
    }
  }
}