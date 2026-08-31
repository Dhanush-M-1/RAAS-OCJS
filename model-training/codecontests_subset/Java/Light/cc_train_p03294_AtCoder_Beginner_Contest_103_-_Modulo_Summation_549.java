import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			answer += a[i];
		}

		System.out.println(answer - N);
	}

}
