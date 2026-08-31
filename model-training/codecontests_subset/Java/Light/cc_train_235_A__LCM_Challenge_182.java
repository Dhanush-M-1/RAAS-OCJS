import java.util.Scanner;
import java.lang.Math;

public class cf235a {
	static final Scanner sc = new Scanner(System.in);
	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
	static long lcmOfNums (long a, long b) {
		long ans = (a / gcd(a, b)) * b;
		return ans;
	}
	static long computeMaxLCM(int uLimit) {
		long maxLCM = 1;
		for (int firstDiff = 0; firstDiff < 11; ++firstDiff) {
			for (int secondDiff = 0; secondDiff < 11; ++secondDiff) {
				for (int thirdDiff = 0; thirdDiff < 11; ++thirdDiff) {
					long LCM = Math.max(uLimit - firstDiff, 1);
					LCM = lcmOfNums(LCM, Math.max(uLimit - secondDiff, 1));
					LCM = lcmOfNums(LCM, Math.max(uLimit - thirdDiff, 1));
					maxLCM = Math.max(LCM, maxLCM);
				}
			}
		}
		return maxLCM;
	}
	public static void main(String[] args) {
		int uLimit = sc.nextInt();
		long maxLCM = computeMaxLCM(uLimit);
		System.out.print(maxLCM);
	}
}
