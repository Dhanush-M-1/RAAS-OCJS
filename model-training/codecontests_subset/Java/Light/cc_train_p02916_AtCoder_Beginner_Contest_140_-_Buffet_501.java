import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int a[] = new int[n];
		int b[]= new int[n];
		int c[]= new int[n];
		for (int i = 0 ; i < n ; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0 ; i < n ; i++) {
			b[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0 ; i < n - 1 ; i++) {
			c[i] = Integer.parseInt(sc.next());
		}

		int ans = 0;
		
		for (int i = 0 ; i < n ; i++) {
			ans +=  b[a[i] -1];
			
			if(i != 0) {
				if(a[i -1] +1 == a[i]) {
					ans += c[a[i] -2];
				}
			}
			
			
		}
		
		
		System.out.println(ans);
		
	}
}