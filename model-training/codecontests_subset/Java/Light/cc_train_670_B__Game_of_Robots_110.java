import java.util.*;

public class B670 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int k = scan.nextInt();
		
		long sum = 0;
		long i = 0;
		for (i = 0; i <=n; i++) {
		    if ((long) i * i + i >= 2 * (long) k) {
		        break;
		    }
		}
		
		long ind = k - (i - 1) * i / 2;
		
		for (int t = 1; t <= n; t++) {
		    int cur = scan.nextInt();
		    if (t == ind) {
		        System.out.print(cur);
		    }
		}
	}
}