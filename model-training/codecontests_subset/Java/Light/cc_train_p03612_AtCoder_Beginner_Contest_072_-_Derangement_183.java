import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int ans = solve();
		System.out.println(ans);
	}
	
	public static int solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt() - 1;
		}
		sc.close();
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (p[i] == i) {
				count++;
				i++;
			}
		}
		return count;
	}
}