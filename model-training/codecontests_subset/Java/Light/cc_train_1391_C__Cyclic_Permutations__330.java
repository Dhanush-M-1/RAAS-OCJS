import java.io.*;
import java.util.*;
public class cyclicP
{
	static long mod=1000000007l;
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		
			long x1=sc.nextLong();long f=1l;
			for(int i=1;i<=x1;i++)
			{
				f=f*i%mod;
			}
			long a=calPow(2,x1-1);

			System.out.print((f-a+mod)%mod);
	}
	static long calPow(long a,long b)
	{
		if(b==0)
			return 1l;
		long ans=calPow(a,b/2)%mod;;
		if(b%2==0)
			return ans*ans%mod;
		else
			return ans*ans%mod*a%mod;
	}

	
}

