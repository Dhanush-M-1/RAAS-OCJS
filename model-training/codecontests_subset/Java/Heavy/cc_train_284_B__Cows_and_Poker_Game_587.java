import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;
import java.io.*;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out); 
	 static void flush() {
 		out.flush();
 	}
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
   		 if(n == 1) return 1;
   		 return n * fact(n-1);
   	 }
	public int[] readIntArray(int n) {
			int[] arr = new int[n];
			for(int i=0; i<n; ++i)
				arr[i]=nextInt();
			return arr;
		}
		static int gcd(int a, int b) { 
	    if (b == 0) return a; 
	    return gcd(b, a % b);  
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
	 static int solve(String str, int n) {
		 int c = 0;
		 for(int j=0;j<n;j++) {
					if(str.charAt(j) == 'I') {
						c++;
					}
			}
		
		int count = 0;
		for(int i=0;i<n;i++) {
			if(str.charAt(i) == 'A' && c == 0) {
				count++;
			}
			else if(str.charAt(i) == 'I') {
				if(c == 1) {
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String args[]) throws Exception {
        FastReader sc = new FastReader();
        	int n = sc.nextInt();
        	String str=  sc.next();
        	
        	out.println(solve(str,n));
        	flush();
        	long end = System.currentTimeMillis();
        	NumberFormat formatter = new DecimalFormat("#0.00000");
        	//System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        }
}
