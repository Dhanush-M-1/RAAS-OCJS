import java.util.Scanner;


public class Solution {
	private int minimumHours(int n, int k, int[] segments) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < segments.length; i++) {
			if (k % segments[i] == 0) {
				if (min > k / segments[i]) {
					min = k / segments[i];
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Solution garden = new Solution();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] segments = new int[n];
		for (int i = 0; i < segments.length; i++) {
			segments[i] = scanner.nextInt();
		}
		System.out.println(garden.minimumHours(n, k, segments));

	}
}