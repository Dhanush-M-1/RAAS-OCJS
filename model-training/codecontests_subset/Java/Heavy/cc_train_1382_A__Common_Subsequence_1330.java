import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for(int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			for(int i = 0; i < m; i++) {
				b[i] = in.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b);
			int ans = -1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(a[i] == b[j]) {
						ans = a[i];
					}
				}
			}
			System.out.println(ans == -1? "NO" : "YES\n" + 1 + " " + ans);
		}
	}
}