import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Cyclic_Rnd663 {
	static int n;
	static long mod = (long) (1e9 + 7);
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		n = parse(scan.readLine());
		
		long ans = fact(n) - fastExpo((long)2, n-1);
		
		ans = ((ans % mod) + mod) % mod;
		
		System.out.println(ans);
	}
	
	public static long fact(long num)
	{
		long ans = 1;
		
		while(num > 1)
		{
			ans = (ans * num) % mod;
			num --;
		}
		
		return ans;
	}

	public static int parse(String num)
	{
		return Integer.parseInt(num);
	}
	
	public static long fastExpo(long base, long exp)
	{
		long res = 1;
		
		while(exp > 0)
		{
			if(exp % 2 == 1)
				res = (res * base) % mod;
			
			exp /= 2;
			base = (base * base) % mod;
		}
		
		return res;
	}
}
