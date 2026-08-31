import java.util.*;

public class cf236C{

	public static void main(String args[])
	{
	
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long ans;
		if(n>2)
		{
			if((n&1) == 1)
				ans = n*(n-1)*(n-2);
			else
			{
				ans = three(n,0,3,new long[3]);
				
			}
		}
		else
			ans = n;
			
		System.out.println(ans);
	
	}
	
	public static long lcm(long a, long b, long c)
	{
		long g1 = gcd(a,b);
		long g2 = gcd(g1,c);
		a /= g2;
		b /= g2;
		c /= g2;
		
		long g3 = gcd(a,b);
		long g4 = gcd(b,c);
		long g5 = gcd(c,a);
		
		a /= g3;
		b /= g3;
		b /= g4;
		c /= g4;
		c /= g5;
		a /= g5;
		long ans = a*b*c*g2*g3*g4*g5;
		return ans;
		
	
	}
	
	public static long gcd(long a, long b)
	{
		if(a == b || b ==0)
			return a;
		if(a == 0)
			return b;
			
		return gcd(b%a,a);
	
	}
	
	public static long three(long n, long index,int count, long[] arr)
	{
		if(count == 0)
		{
			return lcm(arr[0], arr[1], arr[2]);
		
		}
		long val = Long.MIN_VALUE;
		for(long i=index; i<=50-count && i<=n-count; i++)
		{
			arr[count-1] = n-i;
			long temp = three(n,i+1,count-1,arr);	
			if(temp > val)
				val = temp;
		}
		
		return val;
	
	}


}
