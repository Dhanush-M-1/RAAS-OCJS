import java.util.Arrays;
import java.util.Scanner;

public class C300419 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[k];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		int curn = 0;
		int curm = 0;
		int cursum = 0;

		int maxsum = 0;

		for (int i = 0; i <= n; i++) {

			if (sum * i <= m) {
				curn = n - i;
				curm = m - sum * i;
				cursum = (k + 1) * i;

				boolean flag = false;

				for (int j = 0; j < k; j++) {
					for (int j2 = 0; j2 < curn; j2++) {
						curm -= arr[j];
						if (curm < 0) {
							flag = true;
							break;
						} // could be wrong
						cursum++;
					}
					if (flag == true)
						break;
				}

				if (cursum > maxsum)
					maxsum = cursum;
			}

		}
		System.out.println(maxsum);
	}

}
