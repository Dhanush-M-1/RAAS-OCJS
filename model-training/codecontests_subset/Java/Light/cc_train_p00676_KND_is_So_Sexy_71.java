import java.util.*;
import static java.lang.System.*;

public class Main {

	Scanner sc = new Scanner(in);
	
	double calc() {
		
		return 0;
	}
	
	void run() {
		while (true) {
			if (!sc.hasNext()) break;
			int a = sc.nextInt(), l = sc.nextInt(), x = sc.nextInt();
			double ans = (double)a/2*Math.sqrt(l*l-(double)a*a/4.0);
			double lower = 0.0, upper = 1000;
			double mid;
			while (upper - lower > 1e-10) {
				mid = (lower+upper)/2;
				double t = Math.sqrt((double)l*l/4 + mid*mid);
				if (t+t < l+x) {
					lower = mid;
				} else {
					upper = mid;
				}
			}
			ans += (double)l*(lower+upper)/2;
			out.printf("%.10f\n", ans);
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}