
/*
                       _oo0oo_
                      o8888888o
                      88" . "88
                      (| -_- |)
                      0\  =  /0
                    ___/`---'\___
                  .' \\|     |// '.
                 / \\|||  :  |||// \
                / _||||| -:- |||||- \
               |   | \\\  -  /// |   |
               | \_|  ''\---/''  |_/ |
               \  .-\__  '-'  ___/-. /
             ___'. .'  /--.--\  `. .'___
          ."" '<  `.___\_<|>_/___.' >' "".
         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
         \  \ `_.   \_ __\ /__ _/   .-` /  /
     =====`-.____`.___ \_____/___.-`___.-'=====
                       `=---='
 
*/
import java.util.function.Consumer;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.*;
import java.lang.Math.*;
 public class KickStart2020{
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br = new BufferedReader(
           new InputStreamReader(System.in));}
        String next(){
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) {e.printStackTrace();}}
            return st.nextToken();}
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next());}
        float nextFloat() {return Float.parseFloat(next());}
        String nextLine() {
            String str = "";
            try {str = br.readLine();}
            catch (IOException e) { e.printStackTrace();}
            return str; }}
	static String reverseOfString(String a) {
		StringBuilder ssd = new StringBuilder();
		for(int i = a.length() - 1; i >= 0; i--) {
			ssd.append(a.charAt(i));
		}
		return ssd.toString();
	}
	static char[] reverseOfChar(char a[]) {
		char b[] = new char[a.length];
		int j = 0;
		for(int i = a.length - 1; i >= 0; i--) {
			b[i] = a[j];
			j++;
		}
		return b;
	}
	static boolean isPalindrome(char a[]) {
		boolean hachu = true;
		for(int i = 0; i <= a.length / 2; i++) {
			if(a[i] != a[a.length - 1 - i]) {
				hachu = false;
				break;
			}
		}
		return hachu;
	} 
	static long gcd(long a, long b)
	{
	    if (b == 0)
	        return a;
	    return gcd(b, a % b);
	     
	}
	static boolean check(String a) {
		boolean hachu = true;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(0) != a.charAt(i)) {hachu = false; break;}
		}
		return hachu;
	}
		public static void main(String[] args) throws Exception{
FastReader sc = new FastReader();
PrintWriter out = new PrintWriter(System.out);
       int t = sc.nextInt();
       while(t-- > 0) {
    	   int n = sc.nextInt();
    	   int arr[] = new int[n];
    	   for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
    	   long sum = arr[0] + arr[1];
    	   int k = 0;
    	   boolean hachu = false;
    	   for(int i = n - 1; i > 1; i--) {
    		   if(arr[i] >= sum) {hachu = true; k = i; break;}
    		
    	   }
    	   
    	   if(hachu) System.out.println(1 + " " + 2  + " " + " " + (k + 1));
    	   else System.out.println(-1);
    	   
       }
}
}