import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static int getNum(int n) { 
		int retVal = 1;
		int upper = (int) Math.min(Math.sqrt(n)+1,n) ;
		for (int i = 2; i < upper; i++) { 
			if ((n % i) == 0)  {
				upper = Math.min(upper, n/i); 
				retVal++;
				if (n/i != i)
					retVal++;
			} 
		}
		if(n!= 1)
			retVal++;
		return retVal; 
	}
	private static long gcd(long a, long b) {
	    return new BigInteger(String.valueOf(a)).gcd(new BigInteger(String.valueOf(b))).intValue();
	}
	private static long lcm(long a, long b) {
	    return a * b / gcd(a, b);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N = Integer.valueOf(reader.readLine());
		if(N==1)
		{
			out.println("1");
			reader.close();
			out.close();
			return;
		}
		
		HashSet<Integer> cands = new HashSet<Integer>();
		int count = 3;
		for(int k=N; k>=1; k--) {
			cands.add(k);
			if(getNum(k) == 2) 
				count--;
			if(count == 0)
				break;
		}
		
		long max = 0;
		for(Integer i : cands) {
			for(Integer j : cands) {
				for(Integer k : cands) {
					long z = lcm(lcm(i,j),k);
					if(z > max)
						max = z;
				}
			}
		}
		
		out.println(max);
		reader.close();
		out.close();
	}
}
