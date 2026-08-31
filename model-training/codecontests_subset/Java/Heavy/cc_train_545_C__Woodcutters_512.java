import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] x = new int[n];
		int[] height = new int[n];
		int[] stay = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		for(int i = 0; i < n; ++i) {
			x[i] = scn.nextInt();
			height[i] = scn.nextInt();
		}
		stay[0] = 0;
		left[0] = 1;
		right[0] = n == 1 || (x[1] - x[0] > height[0])? 1 : 0;
		for(int i = 1; i < n; ++i) {
			stay[i] = Math.max(stay[i - 1], Math.max(left[i - 1], right[i - 1]));
			left[i] = Math.max(stay[i - 1] + (x[i] - x[i - 1] > height[i]? 1 : 0), Math.max(left[i - 1] + (x[i] - x[i - 1] > height[i]? 1 : 0), right[i - 1] + (x[i] - x[i - 1] > height[i] + height[i - 1]? 1 : 0)));
			right[i] = Math.max(stay[i - 1], Math.max(left[i - 1], right[i - 1])) + (i == n - 1 || (x[i + 1] - x[i] > height[i])? 1 : 0);
		}
		System.out.println(Math.max(stay[n - 1], Math.max(left[n - 1], right[n - 1])));
	}
}