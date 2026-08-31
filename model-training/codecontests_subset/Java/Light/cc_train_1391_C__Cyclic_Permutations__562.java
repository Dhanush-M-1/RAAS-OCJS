//package programs;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef
{		
	static final long mod = (int)1e9+7;

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
			
		long f = 1;
		
		for(int i = 1;i<=n;i++)
		{
			f = (f*i)%mod;
		}
		
		long computePow = 1;
		
		for(int i = 1;i<n;i++)
		{
			computePow = (computePow*2)%mod;
		}
		
        System.out.println((f-computePow+mod)%mod);
	}	
}
	


	

