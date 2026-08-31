import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = 0;
		int maxA = 0;
		for(int i = 0; i < n; i++) {
			int ai = scan.nextInt();
			sum += ai;
			maxA = Math.max(maxA, ai);
		}
		int s = 2*sum;
		int r = (2*sum)/n + 1;
		int result = Math.max(maxA, r);
		System.out.println(result);
	}
}