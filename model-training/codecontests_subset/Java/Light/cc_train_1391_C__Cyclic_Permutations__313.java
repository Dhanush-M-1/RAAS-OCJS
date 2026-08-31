import java.util.*;
//import java.io.*;
public final class Cforces
{
	
	public static void main(String args[])
	{
		try
		{
			final long MOD=1000000007;
			Scanner sc=new Scanner(System.in);
			long n=sc.nextLong();
			long ans=1,p=1;
			for(int i=2;i<=n;i++)
			{
				ans=ans*i;
				ans=ans%MOD;
				p=p*2;
				p=p%MOD;
			}

			System.out.println((ans+MOD-p)%MOD);
		}	
		catch(Exception e)
		{
			//e.printStackTrace();
			return;
		}
	}
}