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
	static boolean isBracketSequence(String s, int a, int b) {
		Stack<Character> ss = new Stack<>();
		boolean hachu = true;
		for(int i = a; i <= b; i++) {
			if(s.charAt(i) == ')' && ss.isEmpty()) {hachu = false; break;}
			if(s.charAt(i) == '(') ss.add('(');
			else ss.pop();
		}
		return ss.empty() && hachu;
	}
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
	static long powermod(long x, long y, long mod){
	    long ans = 1;
	    x = x % mod; 
	    if (x == 0)
	      return 0; 
	    int i = 1;
	    while (y > 0){
	      if ((y & 1) != 0)
	        ans = (ans * x) % mod;
	      y = y >> 1; 
	      x = (x * x) % mod;
	    }
	    return ans;
	  }
	static long power(long x, long y){
	    long ans = 1;
	    if (x == 0)
	      return 0; 
	    int i = 1;
	    while (y > 0){
	      if ((y & 1) != 0)
	        ans = (ans * x);
	      y = y >> 1; 
	      x = (x * x);
	    }
	    return ans;
	  }
	static boolean check(String a) {
		boolean hachu = true;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(0) != a.charAt(i)) {hachu = false; break;}
		}
		return hachu;
	}
	 public static class Pair implements Comparable<Pair> {
	        public final int index;
	        public final int value;
	 
	        public Pair(int index, int value) {
	            this.index = index;
	            this.value = value;
	        }
	        @Override
	        public int compareTo(Pair other) {
	            //multiplied to -1 as the author need descending sort order
	            return  -1 * Integer.valueOf(this.value).compareTo(other.value);
	        }
	 }
	 static boolean equalString(int i, int j, int arr[], String b) {
		 int brr[] = new int[26];
		 for(int k = i; k <= j; k++) brr[b.charAt(k) - 'a']++;
		 for(int k = 0; k < 26; k++) {
			 if(arr[k] != brr[k]) return false;
		 }
		 return true;
	 }
	 static boolean cequalArray(String a, String b) {
		  int count[] = new int[26];
		  int count1[] = new int[26];
		  for(int i = 0; i < a.length(); i++) count[a.charAt(i) - 'a']++;
		  for(int i = 0; i < a.length(); i++) count1[b.charAt(i) - 'a']++;
		  for(int i = 0; i < 26; i++) if(count[i] != count1[i]) return false;
		  return true;
	 }
	 static boolean listEqual(ArrayList<Character> a, ArrayList<Character> b) {
		 for(int i = 0; i < a.size(); i++) {
			 if(a.get(i) != b.get(i)) return false;
		 }
		 return true;
	 }
	 
		public static void main(String[] args) throws Exception{
			FastReader sc = new FastReader();
			PrintWriter out = new PrintWriter(System.out);
             int n = sc.nextInt();
             String s = sc.next();
             boolean hachu = false;
             for(int i = 1; i < s.length(); i++) {
            	 if(s.charAt(i) < s.charAt(i - 1)) {
            		  hachu = true; 
            		 out.println("YES");
            		 out.println(i + " " + (i + 1));
            		 break;
            	 }
             }
             if(!hachu) out.println("NO");
                 out.close();
			}
		}