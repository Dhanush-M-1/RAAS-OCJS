import java.util.Scanner;

public class BestGift {

	static long calBestGift() {
		Scanner scanner = new Scanner(System.in);
		int numberOfBooks = scanner.nextInt();
		int numberOfGenders = scanner.nextInt();
		int[] arrBook = new int[numberOfGenders];		
		for (int i = 0; i < numberOfBooks; i++) {
			int m = scanner.nextInt();
			arrBook[m - 1] += 1;
		}
		scanner.close();

		long result = (long)(numberOfBooks) * (numberOfBooks - 1);
		result /= 2;
		for (int i = 0; i < numberOfGenders; i++) {
			long temp = (long)arrBook[i] * (arrBook[i] - 1);
			result -= temp / 2;
		}

		return result;
	}

	public static void main( String args[]) {
		System.out.println(calBestGift());
	}
}