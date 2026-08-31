import java.io.*;
import java.util.*;


public class Code {

	public static void main (String[] args) {
        MyScanner scanner = new MyScanner();
        
        final int N = scanner.nextInt();
        final int[] array = new int[N];
        
        for (int i=0; i<N; i++) {
            array[i] = scanner.nextInt();
        }
        
        double left = -10_000;
        double right = 10_000;
        
        // while (Math.abs(right - left) >= 1e-12) {
        for (int i = 0; i < 100; i++) {
            double mid1 = left + (right - left) / 3;
            double mid2 = right - (right - left) / 3;
            // System.out.printf("%f %f %f %f\n", left, mid1, mid2, right);
            double f1 = weakness(array, mid1);
            double f2 = weakness(array, mid2);
            if (f1 < f2) {
                right = mid2;
            } else {
                left = mid1;
            }
        }

        System.out.printf("%.10f", weakness(array, left));
	}
    
    private static double weakness(int[] array, double x) {
        double maxSum = 0;
        double sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i] - x;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        
        sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i] - x;
            maxSum = Math.max(maxSum, -sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        
        return maxSum;
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