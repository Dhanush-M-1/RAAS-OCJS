import java.util.*;
import java.io.*;

public class CF730J_2{ 
  public static Node dp[][];
  public static int [] a, b;
  public static void main(String[] args)throws Exception {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    
    dp = new Node[105][20005];
    int n = in.nextInt(), sum = 0;
    
    a = new int[n+1];
    b = new int[n+1];
    
    for(int i = 1; i <= n; i++){
      a[i] = in.nextInt();
      sum += a[i];
    }
    
    
    for(int i = 1; i <= n; i++){
      b[i] = in.nextInt();
    }
    
    pw.println(solve(n, 0, sum));
    pw.close();
  }
  
  static Node solve(int n, int x, int sum){
    //System.err.println(p+"   "+q+"   " +x+" "+sum+"   "+a[x]+" "+b[x]);
    if(x > n){
      if(sum <= 0) return new Node(0, 0);
      else return new Node((int)2e4, (int)2e4);
    }
    
    if(dp[x][sum+105] != null) return dp[x][sum+105];
    
    Node p = new Node((int)2e4, (int)2e4), q = new Node((int)2e4, (int)2e4);
    
    if(sum > 0){
      int curS = Math.min(sum, b[x]);
      int curZ = curS - a[x];
      p = add(new Node(1, curZ) , solve(n, x+1, sum - b[x]));   
    }
    
    q = solve(n, x+1, sum);
    
    return dp[x][sum+105] = min(p, q);
  }
  

  static Node min(Node p, Node q){
    if(p.x == q.x){
      if(p.y < q.y) return p;
      else return q;
    }
    else if(p.x < q.x) return p;
    else return q;
  }
  
  
  static Node add(Node a, Node b){
    return new Node(a.x+ b.x , a.y + b.y);
  }
  
  static class Node{
    public int x,y;
    public Node(int xx, int yy){
      x = xx; y = yy;
    }
    public Node clone(){
      return new Node(this.x, this.y);
    }
    public String toString(){
      return x+" "+y;
    }
  }
  
  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;
    
    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream));
      tokenizer = null;
    }
    
    public String next()throws Exception {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new StringTokenizer(reader.readLine());
      return tokenizer.nextToken();
    }
    
    public String nextLine()throws Exception {
      String line = null;
      tokenizer = null;
      line =  reader.readLine();
      return line;
    }
    
    public int nextInt()throws Exception {
      return Integer.parseInt(next());
    }
    
    public double nextDouble() throws Exception{
      return Double.parseDouble(next());
    }
    
    public long nextLong()throws Exception {
      return Long.parseLong(next());
    }
    
  }
}