import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
 
 
 
public class st {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader sc = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    int t=sc.nextInt();
    while(t-->0){
      int a=sc.nextInt();
      int b=sc.nextInt();
      int c=sc.nextInt();
      int ans=0;
      while(b>0 && c>1){
        b-=1;
        c-=2;
        ans++;
      }
      while(a>0 && b>1){
        a-=1;
        b-=2;
        ans++;
      }
      System.out.println(ans*3);
    }
  

  }
  
 
 
  
  static class InputReader {
      public BufferedReader reader;
      public StringTokenizer tokenizer;
 
      public InputReader(InputStream stream) {
          reader = new BufferedReader(new InputStreamReader(stream), 32768);
          tokenizer = null;
      }
 
      public String next() {
          while (tokenizer == null || !tokenizer.hasMoreTokens()) {
              try {
                  tokenizer = new StringTokenizer(reader.readLine());
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
          return tokenizer.nextToken();
      }
 
      public int nextInt() {
          return Integer.parseInt(next());
      }
      
      public long nextLong()
      {
        return Long.parseLong(next());
      }
 
  }
 
 
}