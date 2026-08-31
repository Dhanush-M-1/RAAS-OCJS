//package codeForcesPractice;

import java.util.Arrays;
import java.util.Scanner;

public class reachMedian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		int center = (n / 2);
		long count = 0;
		if (nums[center] < s)
			for (int i = center; i < n; i++) {
				if (nums[i] >= s)
					break;
				else
					count += (s - nums[i]);
			}
		else if (nums[center] > s)
			for (int i = center; i >= 0; i--) {
				if (nums[i] <= s)
					break;
				else
					count += (nums[i] - s);
			}
		System.out.println(count);
	}
}
