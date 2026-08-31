import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();

		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = scan.nextInt();
		}

		int b[] = new int[N];
		for (int i = 0; i < N; i++) {
			b[i] = scan.nextInt();
		}

		int c[] = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			c[i] = scan.nextInt();
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += b[i];
		}

		for(int i = 1; i < N; i++) {
			if(a[i - 1] + 1 == a[i]){
				ans += c[a[i -1] - 1];
			}
		}
		System.out.println(ans);

	}
}