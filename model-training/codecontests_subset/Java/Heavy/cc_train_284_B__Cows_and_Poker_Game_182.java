import java.io.*;
import java.util.*;



public class second
{
	static long fast_power(long a,long n,long m)
	{
		if(n==1)
		{
			return a%m;
		}
		if(n%2==1)
		{
		
			long power = fast_power(a,(n-1)/2,m)%m;
			return ((a%m) * ((power*power)%m))%m; 	
		}
		long power = fast_power(a,n/2,m)%m;
		return (power*power)%m;
	}
	public static void main(String arr[])
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		String k = sc.next();
		int numA=0;
		int numI=0;
		for(int i =0;i<k.length();i++)
		{
			if(k.charAt(i)=='A')numA++;
			if(k.charAt(i)=='I')numI++;
			
		}	
		if(numI==1)System.out.println(1);
		else if(numI==0)System.out.println(numA);
		else System.out.println(0);
	}
}
