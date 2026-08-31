import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			maxSum += sc.nextInt() - 1;
		}

		System.out.println(maxSum);

		sc.close();
	}
}
