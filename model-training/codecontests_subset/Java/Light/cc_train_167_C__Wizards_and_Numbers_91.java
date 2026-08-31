import java.util.Scanner;

public class Main {
	
	static boolean gcd(long x, long y) {
		long tmp;
		if (x > y) {
			tmp = x;
			x = y;
			y = tmp;
		}
		if (x == 0) {
			return false;
		}
		boolean ret = gcd(x, y%x);
		if (ret) {
			if (x % 2 == 1) {
				return y / x % 2 == 0;
			} else {
				long t = ( y / x  - 1 ) % ( x + 1 );
				if (t == x) {
					return true;
				} else {
					return t % 2 == 1;
				}
			}
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		int Tc;
		Scanner in = new Scanner(System.in);
		Tc = in.nextInt();
		for (int i=0;i<Tc;i++) {
			long x = in.nextLong();
			long y = in.nextLong();
			boolean ret = gcd(x,y);
			if (ret) {
				System.out.println("First");
			} else {
				System.out.println("Second");
			}
		}
	}
}
