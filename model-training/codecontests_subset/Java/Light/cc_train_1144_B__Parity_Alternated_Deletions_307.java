import java.util.Arrays;
import java.util.Scanner;

public class ParityAlternatedDeletions1144B {

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
		int[] oddArr = new int[oddCount];
		int[] evenArr = new int[evenCount];
		int otmp = 0;
		int etmp = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				oddArr[otmp] = arr[i];
				otmp++;
			} else {
				evenArr[etmp] = arr[i];
				etmp++;
			}
		}

		if (oddCount == evenCount || oddCount == evenCount + 1
				|| oddCount == evenCount - 1) {
			System.out.println(0);
			return;
		}

		int nonEmpty = evenCount > oddCount ? evenCount : oddCount;
		int empty = evenCount > oddCount ? oddCount : evenCount;

		int ans = nonEmpty - (empty + 1);
		int minSum = 0;

		if (evenCount < oddCount) {
			Arrays.sort(oddArr);
			for (int i = 0; i < ans; i++) {
				minSum += oddArr[i];
			}
		} else {
			Arrays.sort(evenArr);
			for (int i = 0; i < ans; i++) {
				minSum += evenArr[i];
			}
		}
		System.out.println(minSum);
	}
}
