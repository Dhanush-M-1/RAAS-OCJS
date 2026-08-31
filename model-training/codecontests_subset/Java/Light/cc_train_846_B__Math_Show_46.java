import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int M = scan.nextInt();

		int sum = 0;
		int[] array = new int[k];
		for (int i = 0; i < k; i++) {
			array[i] = scan.nextInt();
			sum += array[i];
		}

		Arrays.sort(array);

		int max = 0;
		for (int i = 0; i <= n; i++) {
			int tempM = M - sum * i;
			if (tempM < 0)
				continue;

			int tempMax = (k + 1) * i;
			for (int j = 0; j < k; j++) {
				if (tempM < array[j])
					break;
				int subJ = Math.min(tempM / array[j], n - i);
				tempM -= subJ * array[j];
				tempMax += subJ;
			}
			max = Math.max(max, tempMax);
		}
		System.out.println(max);
		scan.close();
	}
}
