import java.util.Scanner;

public class _2_Mafia {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long[] arr = new long[n];
		long sum = 0;
		long left = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLong();
			sum = sum + arr[i];
			left = Math.max(left, arr[i]);
		}
		long right =1000000000000L;
		while (left <= right) {
			if (right - left <= 10) {
				while (left <= right) {
					if ((n * 1L * left) - sum >= left) {
						System.out.println(left);
						return;
					}
					left++;
				}
			}
			long mid = left + (right - left) / 2;
			if ((n * 1L * mid) - sum >= mid && (n * 1L * (mid - 1)) < (mid-1)) {
				System.out.println(mid);
				return;
			}
			if ((n * 1L * mid) - sum >= mid) {
				right=mid;
			} else {
				left=mid+1;
			}
		}

	}

}
