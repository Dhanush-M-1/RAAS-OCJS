import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			int n = sc.nextInt();
			long[] arr = {a, b, a^b};
			System.out.println(arr[n % 3]);
		}
	}
}
