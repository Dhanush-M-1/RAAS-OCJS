import java.util.Scanner;

public class FadiLCM613C {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		long x = s.nextLong();
		long a = Long.MAX_VALUE;
		long b = Long.MAX_VALUE;
		
		for(long i = 1 ; i * i <=x ;i++) {
			
			if( x % i == 0) {
				long ca = i;
				long cb = x / i;
				
				long lcm = (ca * cb) / gcd(ca,cb);
				if(lcm == x) {
					
					if(Math.max(ca, cb) < Math.max(a, b)) {
						a  = ca;
						b = cb;
					}
				}
						
			}
		}
		
		System.out.println(a +" " + b);
		
	}
	
	private static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}

}
