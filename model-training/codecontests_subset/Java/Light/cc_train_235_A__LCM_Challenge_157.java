import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		long N = r.nextLong();
		
		rec(N, 1, 0);
		
		System.out.println(ret);
	}

	static long ret = 1;
	
	private static void rec(long x, long lcm, int c) {
		if(x == 0 || c == 3){
			ret = Math.max(ret, lcm);
			return;
		}else{
			long max = lcm;
			for(int i = 0; i < 3 - c; i++)
				max *= x;
			
			if(max <= ret)return;
			
			rec(x, lcm(lcm, x), c + 1);
			rec(x - 1, lcm, c);
		}
	}

	private static long lcm(long x, long y) {
		return x * (y / gcd(x, y));
	}

	private static long gcd(long x, long y) {
		if(y == 0)return x;
		else return gcd(y, x % y);
	}

}
