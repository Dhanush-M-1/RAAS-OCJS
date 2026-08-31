import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a[] = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += sc.nextInt() - 1;
		}
		System.out.println(ans);
	}
}