import java.util.*;

public class Main {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (i + 1 != arr[i]) {
				continue;
			}
			if (i != n - 1) {
				int t = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = t;
			} else {
				int t = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = t;
			}
			count++;
		}
		System.out.println(count);
	}
}
