import java.util.*;
public class A235
{
	static long gcd(long a,long b){
		if(a<b) return gcd(b,a);
		if(b==0l) return a;
		return gcd(b,a%b);
	}
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);		
		int n=cin.nextInt();
		long ans=1;
		for(long a=Math.max(n-100,1);a<=n;a++)
			for(long b=Math.max(n-100,1);b<=n;b++)
				for(long c=Math.max(n-100,1);c<=n;c++){
					long p = a * b / gcd(a,b);
					long q = p * c / gcd(p,c);
					ans=Math.max(ans,q);
				}
		System.out.println(ans);
	}
}
