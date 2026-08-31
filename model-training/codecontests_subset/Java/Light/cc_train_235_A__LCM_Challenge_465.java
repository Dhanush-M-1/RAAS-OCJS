import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if(n==1)
			System.out.println(1);
		else if(n==2)
			System.out.println(2);
		else if(n==3)
			System.out.println(6);
		else
		{
			if(n%2==0 && n%3==0)
				System.out.println((n-3)*(n-1)*(n-2));
			else if(n%2==0)
				System.out.println(Long.max((n-3)*(n-1)*(n-2), n*(n-1)*(n-3)));
			else
				System.out.println(n*(n-1)*(n-2));
		}
		
		

	}
	static long gcd(long a,long b)
	{
		long min = Long.min(a, b);
		long max = Long.max(a, b);
		
		if(max%min==0)
			return min;
		return gcd(max%min,min);
	}

}
