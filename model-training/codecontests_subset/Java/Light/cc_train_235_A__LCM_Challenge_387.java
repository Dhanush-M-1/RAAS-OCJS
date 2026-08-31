/**
 * 
 */

/**
 * @Author Tanisk Annpurna
 *
 */
import java.util.*;
public class CP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		if(n <= 3)
		{
			if(n == 1)
				System.out.println(1);
			else if(n == 2)
				System.out.println(2);
			else
				System.out.println(6);
		}
		else
		{
			if(n % 2 == 0)
			{
				if(gcd(n,n-3) == 1)
					System.out.println(n * (n-1) * (n-3));
				else
					System.out.println((n-1) * (n-2) * (n-3));
			}
			else
				System.out.println((n) * (n-1) * (n-2));
		}
		s.close();
	}
	
	static long gcd(long a , long b)
	{
		if(a == 0)
			return b;
		return gcd(b%a,a);
	}
	
	static long LCM(long a , long b)
	{
		return (a*b)/gcd(a,b);
	}
}
