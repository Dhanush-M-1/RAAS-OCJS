import java.util.*;

public class Main {
	void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n - 1];
		for(int i = 0; i < n; i++) a[i] = scan.nextInt();
		for(int i = 0; i < n; i++) b[i] = scan.nextInt();
		for(int i = 0; i < n - 1; i++) c[i] = scan.nextInt();
		int out = 0;
		for(int i = 0; i < n - 1; i++) {
			if(a[i + 1] - a[i] == 1) {
				out += c[a[i] - 1];
			}
			out += b[a[i] - 1];
		}
		out += b[a[n - 1] - 1];
		System.out.println(out);
		scan.close();
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
