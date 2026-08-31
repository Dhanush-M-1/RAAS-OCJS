import java.io.BufferedInputStream;
import java.math.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.math.*;
public class Main {
	public static long gcd(long a,long b)
	{
		return b==0?a:gcd(b,a%b);
	}
	public static long lcm(long a,long b)
	{
		return a*b/gcd(a,b);
	}
    public static void main(String[] args) 
    {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNext())
        {
        	long a=cin.nextLong();
        	if(a<3)
        	{
        		System.out.println(a);
        		continue;
        	}
        	else if(a==3)
        	{
        		System.out.println(6);
        		continue;
        	}
        	long max=1;
        	for(long i=a;i>=a-3;i--)
        	{
        		for(long j=a;j>=a-3;j--)
        		{
        			for(long k=a;k>=a-3;k--)
        			{
        				long res=lcm(lcm(i,j),k);
        				if(res>max)
        					max=res;
        			}
        		}
        	}
        	System.out.println(max);
        }
    }
}

		 	 					      	  	 	    	