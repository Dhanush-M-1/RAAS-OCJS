import java.util.Scanner;

public class Main {

	static boolean[] prime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		prime = new boolean[100000001];
		int count = 0;

		for (int i=2; i<=10000; i++) {
			if (prime[i]) continue;
			for (int j=i*2; j<=100000000; j+=i) {
				prime[j] = true;
			}
		}

		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			int num = sc.nextInt();
			if (!prime[num]) {
				count++;
			}
		}

		System.out.println(count);

		sc.close();
	}

}