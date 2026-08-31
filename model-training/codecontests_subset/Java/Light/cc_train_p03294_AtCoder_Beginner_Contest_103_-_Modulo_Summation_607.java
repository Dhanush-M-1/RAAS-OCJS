import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().execute();
	}
	
	private void execute() {
		Scanner sc = new Scanner(System.in);
		final int N = sc.nextInt();
		int[] a = new int[N];
		long f = 0;
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			f += a[i] -1;
		}
		System.out.println(f);
		sc.close();
	}
	
}
