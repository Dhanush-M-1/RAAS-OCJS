import java.util.*;
import java.io.*;
 
public class Main {
  public static void main(String[] args) {
	  FastScanner sc = new FastScanner();
	  int N = sc.nextInt();
	  int X = sc.nextInt();
	  int Y = sc.nextInt();
	  String s = sc.next();
	  int operations = 0;
	  for (int i = 0; i < X; i++) {
		  char digit = s.charAt(N-X+i);
		  if ((X-i-1) != Y && digit != '0')
			  operations++;
		  else if ((X-i-1) == Y && digit != '1')
			  operations++;
	  }
	  System.out.println(operations);
  }
 
 
  static class FastScanner { 
    BufferedReader br; 
    StringTokenizer st; 
  
    public FastScanner() { 
      br = new BufferedReader(new InputStreamReader(System.in)); 
    } 
  
    String next() { 
      while (st == null || !st.hasMoreElements()) { 
        try
        { 
          st = new StringTokenizer(br.readLine()); 
        } 
        catch (IOException  e) 
        { 
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
  
    String nextLine() { 
      String str = ""; 
      try
      { 
        str = br.readLine(); 
      } 
      catch (IOException e) 
      { 
        e.printStackTrace(); 
      } 
      return str; 
    }
  }
}