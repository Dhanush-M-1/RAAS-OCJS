import java.util.Arrays;
import java.util.Scanner;


public class A {

	static int b;
	static int[] memo;
	
	public static int go(int a) {
		if (a == 0)
			return 0;
		if (memo[a] != -1)
			return memo[a];
		int res = 0;
		if (a >= b) {
			res += 1 + go(1 + a - b);
		}
		return memo[a] = res;
	}
	
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		
		int a = r.nextInt();
		b = r.nextInt();
		
		memo = new int[a + 1];
		Arrays.fill(memo, -1);
		
		System.out.println(a + go(a));
	}
}
