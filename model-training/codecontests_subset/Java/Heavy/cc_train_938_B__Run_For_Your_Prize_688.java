import java.util.Scanner;

public class TaskB_38 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = s.nextInt();

		int po = (int) (Math.pow(10, 6));
		int one = po - a[0], two = a[n - 1] - 1;
		int start = 0, end = n - 1, f = Integer.MAX_VALUE, e = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (a[i] > 500000) {
				break;
			}
			f = a[i] - 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] <= 500000) {
				break;
			}
			e = po - a[i];

		}
		int min = Math.max(f, e);
		min = Math.min(min, one);
		min = Math.min(min, two);
		System.out.println(min);
	}

	public static int binarysearch(int[] a, long key) {
		int low = 0, high = a.length - 1;
		boolean ok = false;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == key) {
				ok = true;
				high = mid;
				break;
			} else if (a[mid] < key)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return ok ? high : high + 1;

	}

}