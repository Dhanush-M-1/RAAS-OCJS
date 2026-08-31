import java.util.*;
public class GFG {
    public static long gcd(long a,long b)
    {
        if(a==0)
        return b;
        return gcd(b%a,a);
    }
    public static long lcm(long a,long b)
    {
        return (a*b)/gcd(a,b);
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		long x=sc.nextLong();
		long a=0,b=0,a1=0,b1=0;
		long min=Long.MAX_VALUE;
		for(long i=1;i<=(long)Math.sqrt(x);i++)
		{
		    if(x%i==0)
		    {
		        if(lcm(i,x/i)==x){
		        a=i;b=x/i;
		        if((long)Math.max(a,b)<min){min=(long)Math.max(a,b);a1=a;b1=b;}
		        }
		    }
		}
		System.out.println(a1+" "+b1);
	}
}