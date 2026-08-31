import java.io.*;
import java.util.*;

public class D {
    static public void main(String[] args){
        MyScanner sc = new MyScanner();
        int a[][] = new int[5201][5201];
        
        int n = sc.nextInt();
        for(int f = 1; f <= n; f ++){
            String s = sc.nextLine();
            for(int ff = 1; ff <= n/4; ff ++){
                int now;
                if (s.charAt(ff -1) >= 'A'){
                    now = s.charAt(ff -1) - 'A' + 10;
                }
                else{
                    now = s.charAt(ff -1) - '0';
                }
                for (int fff = 4; fff >= 1; fff --){
                    a[f][(ff -1)*4 + fff] = now % 2;
                    now /= 2;
                }
            }
        }
        
        for(int f = 1; f <= n; f ++)
            for(int ff = 1; ff <= n; ff ++)
                a[f][ff] = a[f -1][ff] + a[f][ff -1] - a[f -1][ff -1] + a[f][ff];
        
        int best_ans = 1;
        for(int f = 2; f <= n; f ++){
            boolean b = false; 
            if (n % f == 0){
                b = true;
                for(int ff = 1; ff <= n/f; ff ++)
                    for(int fff = 1; fff <= n/f; fff ++){
                        int now = a[ff*f][fff*f] - a[ff*f -f][fff*f] - a[ff*f][fff*f -f] + a[ff*f -f][fff*f -f];
                        if ( !(now == 0 ||  now == f*f) ) 
                            b = false;
                    }
            }
            if (b) best_ans = f;
        }
        
        System.out.print(best_ans);
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