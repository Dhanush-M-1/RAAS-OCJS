
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main {

	int INF = 1 << 28;

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] top = new int[n];
		for(int i=0;i<n;i++) top[i] = sc.nextInt();
		sort(top);
		for(int i=n-1;i>=0;i--) {
			if( c * (a+b) < a * (c + top[i]) ) {
				c += top[i];
				a += b;
			}
		}
		System.out.println(c/a);
	}

	public static void main(String[] args) {
		new Main().run();
	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}
}