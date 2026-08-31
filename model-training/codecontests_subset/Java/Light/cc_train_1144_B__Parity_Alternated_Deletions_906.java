import java.util.Arrays;
import java.util.Scanner;

public class ParityAlternatedDeletions1144B2New {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		int oddCount = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
			if (arr[i] % 2 == 1) {
				oddCount++;
			}
		}

		int evenCount = n - oddCount;
		int ans = n - ((2 * Math.min(oddCount, evenCount)) + 1); // n - deletions
		boolean evenIsHigh = evenCount > oddCount;
		int minSum = 0;

		Arrays.sort(arr);
		for (int i = 0; ans > 0; i++) {
			if (arr[i] % 2 == 0 && evenIsHigh) {
				minSum += arr[i];
				ans--;
			} else {
				if (arr[i] % 2 == 1 && !evenIsHigh) {
					minSum += arr[i];
					ans--;
				}
			}
		}
		System.out.println(minSum);
	}
}