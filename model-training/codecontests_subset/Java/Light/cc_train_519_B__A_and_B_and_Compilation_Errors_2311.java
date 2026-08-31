import java.util.Scanner;

public class DataStructures {

	public static void main(String[] args) {
		A_And_B_AndCompilationErrors();
	}

	public static void A_And_B_AndCompilationErrors() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			int internalSum = 0;
			for (int j = 0; j < n - i; j++) {
				internalSum += s.nextInt();
			}
			if (i != 0) {
				System.out.println(sum - internalSum);
			}
			sum = internalSum;
		}

	}
}
