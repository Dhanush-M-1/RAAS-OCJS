import java.util.*;

public class B {
	private static final int [] DIVISORS = {2, 3, 5};
	private static int [] factors(int n){
		final int [] res = new int[DIVISORS.length + 1];
		for (int i = 0; i < DIVISORS.length; ++i){
			while (n%DIVISORS[i] == 0){
				n /= DIVISORS[i];
				res[i]++;
			}
		}
		res[DIVISORS.length] = n;
		return res;
	}
	private static int solve(int a, int b){
		final int [] af = factors(a);
		final int [] bf = factors(b);
		if (af[DIVISORS.length] != bf[DIVISORS.length]){
			return -1;
		}
		int res = 0;
		for (int i = 0; i < DIVISORS.length; ++i){
			res += Math.abs(af[i] - bf[i]);
		}
		return res;
	}
	public static void main(String [] args){
		final Scanner s = new Scanner(System.in);
		final int a = s.nextInt();
		final int b = s.nextInt();
		System.out.println(solve(a, b));
		s.close();
	}
}
