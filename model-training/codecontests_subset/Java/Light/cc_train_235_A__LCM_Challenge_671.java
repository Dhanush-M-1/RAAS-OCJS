import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		long ans = 0;
		long lo = Math.max(n-10, 1);
		for(long A=lo; A<=n; A++)
			for(long B=lo; B<=n; B++)
				for(long C=lo; C<=n; C++) {
					long score = lcm(A, lcm(B,C));
					if(score > ans) ans = score;
				}
		System.out.println(ans);
	}
	static long lcm(long x, long y) {
		return x*y/gcd(x,y);
	}
	static long gcd(long x, long y) {
		if(y==0) return x;
		return gcd(y, x%y);
	}
}
