import java.util.*;
public class Main
{
    public static long gcd(long a,long b)
    {
        return b==0?a:gcd(b,a%b);
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=1;
		while(t-->0)
		{
		    long n=sc.nextLong();
		    long ans=n;
		    long a=1,b=n;
		    for(long i=Long.valueOf(2);i*i<=n;i++)
		    {
		        if(n%i==0)
		        {
		            long x=n/i;
		            long y=i;
		            long g=gcd(x,y);
		            if(g==1)
		            {
		                if(x<ans)
		                {
		                    ans=x;
		                    a=i;b=x;
		                }
		            }
		        }
		    }
		    System.out.println(a+" "+b);
		}
		
	}
}

