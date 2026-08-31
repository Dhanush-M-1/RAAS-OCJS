import java.io.*;
import java.util.*;
import java.math.*;
public class Solve4 {
  public static void main(String[] args) {
	MyScanner scanner = new MyScanner();
	PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	int n = scanner.nextInt();
	int k = scanner.nextInt();
	int a = scanner.nextInt();
	int b = scanner.nextInt();
	int c = scanner.nextInt();
	int d = scanner.nextInt();
    int t[] = new int[n+1];
	t[a] = 1;
	t[b] = 1;
	t[c] = 1;
	t[d] = 1;
	if(k <= n || n == 4) {
	  out.println(-1);
	} else {
	  out.print(a + " ");  
	  out.print(c + " ");
      for(int i	= 1; i <= n; i++)
        if(t[i] == 0) out.print(i + " ");	  
	  out.print(d + " ");  
	  out.println(b + " ");  
	  
	  out.print(c + " ");  
	  out.print(a + " ");
      for(int i	= 1; i <= n; i++)
        if(t[i] == 0) out.print(i+ " ");	  
	  out.print(b + " ");  
	  out.println(d + " ");  
	}
	out.close();
  }


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
