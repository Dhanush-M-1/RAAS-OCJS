import java.util.*;

public class Codeforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			long a = sc.nextInt();
			long b = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(fib(a, b, n+1));
		}

	}

	public static long fib(long a, long b, long n) {
		if(n%3==0) {
			return a^b;
		}
		else if(n%3==1) {
			return a;
		}
		else {
			return b;
		}
		}

}
