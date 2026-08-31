import java.util.*;

public class KingOfTheives {
    // Solution ripped from solved ones.
	static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		for (int i=0; i<n; i++) {
			if (s.charAt(i)=='*') {
				for (int j=1; i+j*4<n; j++) {
					if (s.charAt(i+j)=='*' && s.charAt(i+2*j)=='*' && s.charAt(i+3*j)=='*' && s.charAt(i+4*j)=='*') {
						System.out.println("yes");
						System.exit(0);
					}
				}
			}
		}
		System.out.println("no");
		sc.close();
	}

	public static void main(String[] args) {
		solve();
	}
}