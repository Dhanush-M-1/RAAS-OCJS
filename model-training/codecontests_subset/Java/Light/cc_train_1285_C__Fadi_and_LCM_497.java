import java.util.Scanner;

public class c {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long X = in.nextLong();
		long min = Long.MAX_VALUE;
		for(long a = 1; a*a <= X; a++) {
			long b = X / a;
			if(lcm(a,b) == X) {
				min = Math.min(Math.max(a, b), min);
			}
		}
		
		System.out.println(min+" "+(X/min));
	}
	static long lcm(long a, long b) {
		return a * b / gcd(a,b);
		
	}
	static long gcd(long a, long b) {
		while(b != 0) {
			a = a % b;
			a ^= b; b ^= a; a ^= b;
		}
		return a;
	}
}
