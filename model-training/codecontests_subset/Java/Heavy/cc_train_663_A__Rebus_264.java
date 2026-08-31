import java.io.*;
import java.util.*;
import java.math.*;

public class Solve7 {
  public static void main(String[] args) {
	MyScanner scanner = new MyScanner();
	PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	String s = scanner.nextLine();
	String t[] = s.split(" ");

	long n = Long.parseLong(t[t.length-1]);
	long plus = 1;
	long minus = 0;
	for(int i = 0; i < t.length; i++)
	  if(t[i].equals("+")) plus++;
	  else if(t[i].equals("-")) minus++;
	long min = plus * 1L - minus * n;
	long max = plus * n - minus * 1L;
	boolean pl = true;
	long sum = 0;
    if(n >= min && n <= max) { 
      out.println("Possible");
	  for(int i = 0; i < t.length; i++) {
	    if(!t[i].equals("?")) {
		  out.print(t[i]+ " ");
		}
        if(t[i].equals("-")) {
		  pl = false;
		} else if(t[i].equals("+")) {
		  pl = true;
		} else if(t[i].equals("?")) {
		  long sign = 1;
		  if (pl) {
		    plus--;
		  } else {
		    minus--;
			sign = -1;
		  }
		  
		  min = plus * 1L - minus * n;
		  max = plus * n - minus * 1L;
		  //System.out.println(min + " " + max);
		  for(int j = 1; j <= n; j++) {
		    if (sum + sign * j + min <= n && sum + sign * j + max >= n) {
			  out.print(j + " ");
			  sum += sign * j;
			  break;
			}
		  }
		}
      }	  
	} else {
	  out.println("Impossible");
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
