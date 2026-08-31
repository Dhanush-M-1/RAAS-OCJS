import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.*;
public class Solution {
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e) {
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
        static int fact(int n) {
   		 if(n == 1) {
   			 return 1;
   		 }
   		 return n * fact(n-1);
   	 }
	public int[] readIntArray(int n) {
			int[] arr = new int[n];
			for(int i=0; i<n; ++i)
				arr[i]=nextInt();
			return arr;
		}

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	 static int solve(int a, int b, int c) {
		 int count = 0;
		 int total = 0;
		
		 while(c > 0) {
			 if(total + b < a) {
				 count++;
			 }
			 else {
				 total = total + b - a;
				 c--;
				 continue;
			 }
			 total += b;
		 }
		 return count;
	 }
	public static void main(String args[]) {
        FastReader sc = new FastReader();
        long start = System.currentTimeMillis();
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
       
        	System.out.println(solve(a,b,c));
        	long end = System.currentTimeMillis();
        	NumberFormat formatter = new DecimalFormat("#0.00000");
        	//System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        }
}
