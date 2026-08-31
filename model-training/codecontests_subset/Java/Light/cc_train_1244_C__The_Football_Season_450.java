import java.util.*;

public class Main {
	long x=0;
	long y=0;
	long gcd=0;
	long gcd(long a, long b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
		
	}
	
	void extendexuclid(long a, long b) {
		if(b==0) {
			x=1;
			y=0;
			gcd=a;
			return ;
		}
		extendexuclid(b, a%b);
		long cx=y;
		long cy=x-(a/b)*y;
		x=cx;
		y=cy;
	}
	
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long p=sc.nextLong();
		long w=sc.nextLong();
		long d=sc.nextLong();
		Main obj=new Main();
		long g=obj.gcd(w,d);
		if(p%g!=0 || n*w<p) {
			System.out.println(-1);
		}
		else {
			
			long w1=w/g;
			long d1=d/g;
			long p1=p/g;
			
			long y=0;
			for(long i=0;i<=n;i++) {
				if((d1*i)%w1==p1%w1) {
					y=i;
					break;
				}
			}
			long x=(p1-d1*y)/w1;
			long z=n-x-y;
			if(x+y>n) {
				System.out.println(-1);
			}
			else if(x<0)
				System.out.println(-1);
			else
				System.out.println(x+" "+y+" "+z);
			
		}
		
		
		
    }
}