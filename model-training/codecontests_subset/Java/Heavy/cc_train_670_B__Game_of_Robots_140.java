import java.util.*;
import java.io.*;

public class CF670B{ 
  public static int index;
  public static void main(String[] args)throws Exception {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int n = in.nextInt(), k = in.nextInt();
    
    long []  a = new long[n+1];
    
    long [] id = new long[n+1];
    
    for(long i = 1; i <= n; i++){
      id[(int)i] = in.nextLong();
      a[(int)i] = i + a[(int)i-1];
    }
    
    int idx = bSearch(k, a, n);
    
    //System.err.println(k+" " +idx+" "+a[idx]);
    
    long x = a[idx-1];
    x = (long)k- x;
    pw.println(id[(int)x]);
    
    pw.close();
  }
  
  static int bSearch(int num, long [] arr, int n){
    int lo  = 1, hi = n, mid = (lo+hi)/2;
    long temp = 0;
    while(lo < hi){
      mid = (lo+hi)/2;
      temp = arr[mid];
      if( temp >= num) hi = mid;
      else lo = mid+1;
    }
    
    return lo; //returns the lowest index where arr[lo] = num;
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