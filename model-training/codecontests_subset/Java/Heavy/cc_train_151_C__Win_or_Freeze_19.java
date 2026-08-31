import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_WinOrFreeze {
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(scan.readLine());
		
		long max = (long) ( Math.sqrt(n) );
		
		long ans = getAns(n, max);
		
		if(ans == -1)
			System.out.println(2);
		else {
			System.out.println(1);
			System.out.println(ans);
		}
	}
	
	public static long getAns(long num, long max)
	{
		int factors = 1;
		long ans = 1;
		long temp = num;
		
		long i = 2;
		
		while(i <= max)
		{
			if(temp % i == 0)
			{
				factors++;
				ans *= i;
				temp /= i;
				
				max = (long) Math.sqrt(temp);
				
				if(factors > 2)
					return ans;
				
				continue;
			}
			
			i++;
		}
		
		if(factors == 1) return 0;
		
		
		return -1;
		
	}
}
