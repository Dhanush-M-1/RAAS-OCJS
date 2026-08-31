import java.util.*;
// warm-up
public class Cola {

	static void solve() {
		Scanner sc = new Scanner(System.in);
		double n=sc.nextDouble(), a=sc.nextDouble(), b=sc.nextDouble(), c=sc.nextDouble(), t=0;
		for (double i=0; i<=c; i++) {
			double x = n-2*i;
			if (x<0) break;
			double h = Math.min(b,x);
			double l = Math.max(0,x-Math.floor(a/2.0));
			if (h>=l) t+=(h-l+1);
		}
		System.out.println((int)t);
		sc.close();			
	}

	public static void main(String args[]) {
		solve();
	}

}