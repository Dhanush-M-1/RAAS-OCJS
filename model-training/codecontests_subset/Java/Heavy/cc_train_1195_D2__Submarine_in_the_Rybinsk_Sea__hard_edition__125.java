import java.io.*; 
import java.util.*;
  
public class Main {
    static class FastScanner
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
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
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
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
  
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner();
        int N = sc.nextInt();
        String[] nums = new String[N];
        int[] digits = new int[11];
        for (int i = 0; i < N; i++) {
        	nums[i] = sc.next();
        	digits[nums[i].length()] += 1;
        }
        long[] remainders = new long[20];
        remainders[0] = 1;
        for (int i = 1; i < 20; i++)
        	remainders[i] = (10*remainders[i-1])%998244353;
        
        
        long ans = 0;
        for (String num: nums) {
        	int D = num.length();
        	for (int j = D-1; j >= 0; j--) {
        		int digit = (int)num.charAt(D-j-1) - 48;
        		long weight1 = 0;
        		for (int i = 1; i <= 10; i++) {
        			weight1 += digit*(digits[i] * remainders[2*j - Math.max(j-i,0)]);
        			weight1 = weight1 % 998244353;
        		}
        		long weight2 = 0;
        		for (int i = 1; i <= 10; i++) {
        			weight2 += digit*(digits[i] * remainders[2*j+1 - Math.max(j+1-i,0)]);
        			weight2 = weight2 % 998244353;
        		}
        		ans += (weight1 + weight2);
        		ans = ans % 998244353;
        	}
        }
        System.out.println(ans);
    }
}