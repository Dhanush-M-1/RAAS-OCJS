import java.util.*;

public class  a{
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		long mx = Long.MIN_VALUE;
		long mn = Long.MAX_VALUE;
		
		for(long i=1;i*i<=X;i++){
			long a = i;
			long b = X/i;
			
			long g = gcd(a,b);
			
			if(X==(a*b)/g){
				mx = Math.max(a,b);
				mn = Math.min(mn,mx);
			}
		}
		System.out.println((X/mn)+" "+mn);
	}
	
	public static long gcd(long a,long b){
		if(b==0L)
			return a;
		return gcd(b,a%b);
	}
}