import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		

		if(n == 1) {
			System.out.println(1);
		}
		else if(n == 2) System.out.println(2);
		
		else if(n%2 == 1) {
			System.out.println( lcm(lcm(n,n-1),n-2) );
		}
		else {
			long max = -1;
			for(int i = Math.max(1, n-50); i <= n; ++i) {
				for(int j = Math.max(1, n-50); j <= n; ++j) {
					for(int k = Math.max(1, n-50); k <= n; ++k) {
						max = Math.max(max, lcm(lcm(i,j),k));
					}				
				}
			}
			System.out.println(max);
		}
	}
	
	
	static long lcm(long a, long b) {
		return (a*b)/(gcd(a,b));
	}
	
	static long gcd(long a, long b) {
		if(b == 0) return a;
		else return gcd(b,a%b);
	}

}
