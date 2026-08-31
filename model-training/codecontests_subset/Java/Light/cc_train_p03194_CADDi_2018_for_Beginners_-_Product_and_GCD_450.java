import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	void doIt() {
		long n = sc.nextLong();
		long p = sc.nextLong();
		long max = (long)Math.pow(p, 1.0 / n) + 1;
		System.out.println(getAns(n, p, max));
	}
	long getAns(long n, long p, long max) {
		for(long i = max; i >= 1; i--) {
			if(p % (long)Math.pow(i, n) == 0)return i;
		}
		return 1;
	}
	public static void main(String[] args) {
		new Main().doIt();
	}
}
