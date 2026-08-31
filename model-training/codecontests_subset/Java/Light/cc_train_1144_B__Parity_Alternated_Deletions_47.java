import java.util.Arrays;
import java.util.Scanner;

public class ParityAlternatedDeletions1144BAlt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		int oddCount = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
			if (arr[i] % 2 == 1) {
				oddCount++;
			}
		}

		int evenCount = n - oddCount;

		if (oddCount == evenCount || oddCount == evenCount + 1
				|| oddCount == evenCount - 1) {
			System.out.println(0);
			return;
		}

		boolean evenIsHigh = evenCount > oddCount;
		int ans = evenIsHigh ? evenCount - (oddCount + 1) : oddCount - (evenCount + 1);
		int minSum = 0;

		Arrays.sort(arr);
		for (int i = 0; ans != 0; i++) {
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