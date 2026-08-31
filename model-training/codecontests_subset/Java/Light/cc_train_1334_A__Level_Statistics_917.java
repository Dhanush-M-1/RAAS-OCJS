import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int p = 0; int c = 0; boolean no = false;
			for (int n = 0; n < N; n++) {
				int tempP = sc.nextInt();
				int tempC = sc.nextInt();
				if (tempP < p || tempC < c) {
					no = true;
				}
				int diffP = tempP - p;
				int diffC = tempC - c;
				if (diffP < diffC) {
					no = true;
				}
				p = tempP;
				c = tempC;
				if (p < c) { no = true; };
			}
			if (no) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
