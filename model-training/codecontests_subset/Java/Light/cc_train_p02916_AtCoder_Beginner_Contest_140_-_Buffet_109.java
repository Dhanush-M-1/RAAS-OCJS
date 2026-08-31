import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		int c[] = new int[n - 1];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < n - 1; i++) {
			c[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				ans += b[a[i] - 1];;
			}
			else if(a[i - 1] == a[i] - 1) {
				ans += b[a[i] - 1] + c[a[i] - 2];
			}
			else {
				ans += b[a[i] - 1];
			}
		}
		
		System.out.print(ans);
	}
	
}