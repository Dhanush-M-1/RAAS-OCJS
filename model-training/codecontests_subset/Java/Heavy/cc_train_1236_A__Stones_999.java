import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public static void main(String[] args)throws Throwable{
        Escanner sc = new Escanner();
        int t = sc.nextInt();

        int a, b, c;
        int ans;
        while(t-- > 0) {
        	a = sc.nextInt();
        	b = sc.nextInt();
        	c = sc.nextInt();
        	ans = 0;

        	while(b >= 1 && c >= 2) {
        		ans += 3;
        		b--;
        		c -= 2;
        	}

        	while(a >= 1 && b >= 2) {
        		ans += 3;
        		a--;
        		b -= 2;
        	}

        	System.out.println(ans);
        }        
    }

    static class Escanner {
        BufferedReader in;
        StringTokenizer st;

        Escanner() throws Throwable {
            in = new BufferedReader(new InputStreamReader(System.in), 32768);
            st = new StringTokenizer("");
        }

        Escanner(String fileName) throws Throwable {
            in = new BufferedReader(new FileReader(fileName),32768);
            st = new StringTokenizer("", ": \t\n");
        }

        boolean isBlank() throws Throwable{
            String l = in.readLine();
            st = new StringTokenizer(l==null?"":l, ": \t\n");
            return !st.hasMoreTokens();
        }

        boolean EOL(){
            return !st.hasMoreTokens();
        }

        String nextStr() throws Throwable {
            while(!st.hasMoreTokens())
                st = new StringTokenizer(in.readLine(), ": \t\n");
            return st.nextToken();
        }

        int nextInt() throws Throwable {
            return Integer.parseInt(nextStr());
        }

        long nextLong() throws Throwable {
            return Long.parseLong(nextStr());
        }

        BigInteger nextBigInt() throws Throwable {
            return new BigInteger(nextStr());
        }

        double nextDouble() throws Throwable {
            return Double.parseDouble(nextStr());
        }
    }
}
